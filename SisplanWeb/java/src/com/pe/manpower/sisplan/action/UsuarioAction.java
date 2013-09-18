/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.pe.manpower.sisplan.to.Menu;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.form.LoginForm;
import com.pe.manpower.sisplan.service.MenuService;
import com.pe.manpower.sisplan.service.UsuarioService;
import com.pe.manpower.sisplan.Constants;
import com.consite.seguridad.PasswordService;
import com.pe.manpower.sisplan.form.MenuForm;
import com.pe.manpower.sisplan.form.RolForm;
import com.pe.manpower.sisplan.form.UsuarioForm;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Rol;
import com.pe.manpower.sisplan.util.Config;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author externo.gamaro
 */
public class UsuarioAction extends DispatchAction {
    
    /* forward name="success" path="" */
    private Log logger = LogFactory.getLog(this.getClass());
    private UsuarioService usrService;
    private MenuService menuService;
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    /*public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        logger.debug("execute");
        return mapping.findForward(SUCCESS);
        
    }*/
    public UsuarioAction(UsuarioService usrService,MenuService menuService) {
        super();
        this.usrService = usrService;
        this.menuService=menuService;
    }
    
    public ActionForward validarUsuario(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("validarUsuario");
         String action="";
         LoginForm loginfrm=(LoginForm) form;
         List<Rol> roles=null;
         List<Compania> cias=null;
         Usuario usr=new Usuario();
         Config config=new Config();
         ActionMessages errors = new ActionMessages(); 
         
         if(!config.IsOk()){
           if (config.loadProperties()){
             logger.debug("Cargados los Parametros Principales");
           }else{
             logger.debug("No se pudieron cargar los Parametros Principales:"+config.getMensaje());
             errors.add("login", new ActionMessage("errors.interno","No se pudieron cargar los Parametros Principales:"));  
             //saveErrors(request,errors);
           }
         }
         
        if(isValidUser(request,form,usr)) {
          logger.debug("verdadero");
          logger.debug("usuario "+usr.toString());
          
          usr=usrService.buscarUsuario(loginfrm.getLogin()).get(0);
          usr.setSession(request.getSession(true).getId());
          usr.setIpaddr(request.getRemoteAddr());
          request.getSession().setAttribute("usr",usr);
          // Grabar la session de SISPLAN
          usrService.GrabarSesion(usr);
          // Obtener los Roles del Usuario
          roles=usrService.getRolesByUser(usr);
           logger.debug("antes de roles");
          if(roles.size()>1){ // Si tiene mas de un rol se elige el rol
             logger.debug("mas de un rol");
              action="setrol";  
              request.setAttribute("roles",roles);
               
          }else{
              
            if(roles.size()>0){
               
              Rol rol=roles.get(0);  
              logger.debug("un solo rol "+rol.getNombre());  
              usr.setRol(rol);
              // Inicialisar variables generales
              cias=usrService.getCiasByRol(rol);
              if(cias.size()>0){
                logger.debug("Si hay cias ");
                 if(cias.size()>1){
                   logger.debug("mas de una cia ");  
                   action="setcia";
                   request.setAttribute("cias",cias);
                 }else{
                   usr.setCia(cias.get(0));
                   logger.debug("una sola cia "+usr.getCia().getNombre());
                   action=Constants.SUCCESS;  
                   HttpSession sesion = request.getSession();
                   List<Menu> listMenu=menuService.mostrarMenu(usr);
                   sesion.setAttribute("listMenu",listMenu); 
                  
                 }  
              
              }else{
                logger.debug("No hay cias ");
                action=Constants.LOGIN;             
                errors.add("login", new ActionMessage("errors.interno","No Existen Empresas para el Rol "+rol.getNombre()));  
                clearSession(request);
              }
             
            }else{
              logger.debug("No hay roles ");
              action=Constants.LOGIN;             
              errors.add("login", new ActionMessage("errors.interno","No Existen Roles Asignados"));  
              clearSession(request);
            }
          }
          
        }else{
          logger.debug("falso");
          return mapping.findForward(Constants.LOGIN);
        }
        //if (!errors.isEmpty()) saveErrors(request, errors);
        logger.debug("action :"+action);
        return mapping.findForward(action);
    }
    
    private boolean isValidUser(HttpServletRequest req,ActionForm form,Usuario usr) {
        logger.debug("isValidUser");
        LoginForm loginfrm=(LoginForm) form;
        boolean result=false;
        ActionMessages errors = new ActionMessages();        
      
      try{
        
        List<Usuario> list=usrService.buscarUsuario(loginfrm.getLogin());
        String encriptado=PasswordService.getInstance().encrypt(loginfrm.getPassword());
        if(list.size()>0){
        
           usr=list.get(0);
           if(usr.getPassword().equals(encriptado)) { 
               result=true;
               //req.getSession().setAttribute("usr",usr);
               
           }else{
              errors.add("password", new ActionMessage("errors.password"));  
           }
        }else{
          errors.add("login", new ActionMessage("errors.login"));  
        }   
        
        
      }catch(Exception e){
        logger.debug(e);  
        errors.add("login", new ActionMessage("errors.interno","validarUsuario"));  
      }
      
       if (!errors.isEmpty()) saveErrors(req, errors);
       return result;
    }
    
    public ActionForward cerrarSesion(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
       logger.debug("cerrarSesion");
       Usuario usr=(Usuario)request.getSession().getAttribute("usr");
       usrService.BorrarSesion(usr);
       clearSession(request);
       return mapping.findForward(Constants.SUCCESS);
    }
    
    private void clearSession(HttpServletRequest req){
       HttpSession ses=req.getSession(false);
       ses.removeAttribute("usr");
       ses.removeAttribute("listMenu");
       ses.invalidate();
       req.removeAttribute("login");
       req.removeAttribute("password");
       req.removeAttribute("dispatch");
       req.removeAttribute("roles");
       req.removeAttribute("cias");
          
    }
     public ActionForward cambiarPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("cambiar password");
         LoginForm loginfrm=(LoginForm) form;
         String result="";
         String forward="";
        if(loginfrm.getPassword1().equals(loginfrm.getPassword2()) ) {
          logger.debug("verdadero");
          Usuario user=new Usuario();
          user.setLogin(loginfrm.getLogin());
          user.setPassword(PasswordService.getInstance().encrypt(loginfrm.getPassword1()));
          result=usrService.CambiarPassword(user);
          if(result.equals("OK")){
              result="Se cambio el password correctamente";
              forward="changepwdok";
          }else{
              result="Error al cambiar el password";
              forward="changepwd";
          }
          request.setAttribute("msg",result);
        }else{
          logger.debug("no coinciden password");
          forward="changepwd";
         }
         return mapping.findForward(forward);
    }
   
    public ActionForward setRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setRol");
        ActionMessages errors = new ActionMessages(); 
        Usuario usr=new Usuario();
        String action="";
        LoginForm loginfrm=(LoginForm) form;
        usr=(Usuario)request.getSession().getAttribute("usr");
        Integer rolid=loginfrm.getRolid();
        Rol rol=usrService.getRol(rolid);
        usr.setRol(rol);
        List<Compania> cias=null;
        cias=usrService.getCiasByRol(rol);
        request.getSession().setAttribute("usr",usr);
        if(cias.size()>0){
          logger.debug("Si hay cias ");
          if(cias.size()>1){
            logger.debug("mas de una cia ");  
            action="setcia";
            request.setAttribute("cias",cias);
          }else{
            usr.setCia(cias.get(0));
            logger.debug("una sola cia "+usr.getCia().getNombre());
            action=Constants.SUCCESS;  
            HttpSession sesion = request.getSession();
            List<Menu> listMenu=menuService.mostrarMenu(usr);
            sesion.setAttribute("listMenu",listMenu); 
          }  
        }else{
          logger.debug("No hay cias ");
          action=Constants.LOGIN;             
          errors.add("login", new ActionMessage("errors.interno","No Existen Empresas para el Rol "+rol.getNombre()));  
          clearSession(request);       
        }
       if (!errors.isEmpty()) saveErrors(request, errors);   
       return mapping.findForward(action);
    }
    
     public ActionForward setCia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setCia");
        Usuario usr=new Usuario();
        String action="";
        LoginForm loginfrm=(LoginForm) form;
        usr=(Usuario)request.getSession().getAttribute("usr");
        String no_cia=loginfrm.getNo_cia();
        Compania cia=usrService.getCompania(Integer.parseInt(no_cia));
        usr.setCia(cia);
        request.getSession().setAttribute("usr",usr);
        action=Constants.SUCCESS;  
        HttpSession sesion = request.getSession();
        List<Menu> listMenu=menuService.mostrarMenu(usr);
        sesion.setAttribute("listMenu",listMenu); 
                  
       return mapping.findForward(action);
    }
    
    public ActionForward getUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getUsers");
        ActionMessages errors = new ActionMessages(); 
        UsuarioForm usrForm=(UsuarioForm) form;
        Usuario user=new Usuario();
        String usuario=usrForm.getUsuario();
        String nombre=usrForm.getSnombre();
        String ape_pat=usrForm.getApe_pat();
        String ape_mat=usrForm.getApe_mat();
        if(usuario!=null||nombre!=null||ape_pat!=null||ape_mat!=null){
          user.setLogin(usuario);
          user.setNombre(nombre);
          user.setAp_pat(ape_pat);
          user.setAp_mat(ape_mat);
          findUsers(request,errors,user);
        }else{
          populateUsers(request,errors);
        }
                
        if (!errors.isEmpty()) saveErrors(request, errors);
        return mapping.findForward(Constants.SUCCESS);
    }
    
    private void populateUsers(HttpServletRequest request,ActionMessages errors) {
       logger.debug("populateUsers");
       try{
          List users = usrService.buscarUsuario("");
          request.setAttribute("users", users);
        }catch(Exception e){
          logger.debug(e);  
          errors.add("login", new ActionMessage("errors.interno","Error en la busqueda de Usuarios"));  
        }
    }
   private void findUsers(HttpServletRequest request,ActionMessages errors,Usuario user) {
       logger.debug("findUsers");
       try{
          List users = usrService.findUsers(user);
          request.setAttribute("users", users);
        }catch(Exception e){
          logger.debug(e);  
          errors.add("login", new ActionMessage("errors.interno","Error en la busqueda de Usuarios"));  
        }
    }
    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpForInsertOrUpdate");
        UsuarioForm userForm = (UsuarioForm)form;
        if (isUpdate(request, userForm)) {
            String id = userForm.getLogin();
            Usuario usuario = usrService.geUser(id);
            BeanUtils.copyProperties(userForm, usuario);
        }
        prep(request);
        return mapping.findForward(Constants.SUCCESS);
    }
    
     private boolean isUpdate(HttpServletRequest request, UsuarioForm userForm) {
        boolean updateFlag = true;
        //if ID is null or 0 we know we are doing an insert. You could check other
        //things to decide, like a dispatch param
        //It's annoying that BeanUtils will convert nulls to 0 so have to do 0 check also,
        //or you could register a converter, which is the preferred way to handle it, but goes
        //beyond this demo
        Usuario usuario=null;
        String id = userForm.getLogin();
        if(id!=null)usuario = usrService.geUser(id);
        
        if (usuario == null) {
            updateFlag = false;
            
        }
        usuario=null;
        return updateFlag;
    }
     
    private void prep(HttpServletRequest request) {
        //request.setAttribute(Constants.PARENTS, menuService.getAllMenusParents());
        logger.debug("prep");
        String ap_pat=request.getParameter("ap_paterno");
        String ap_mat=request.getParameter("ap_materno");
        String nombre=request.getParameter("nombres");
        
        if(ap_pat==null)ap_pat="";
        if(ap_mat==null)ap_pat="";
        if(nombre==null)nombre="";
        
        Usuario user=new Usuario();
        user.setAp_pat(ap_pat);
        user.setAp_mat(ap_mat);
        user.setNombre(nombre);
        
        List usersIntra=usrService.getUsersIntranet(user);
        logger.debug("Usuario Intranet:"+usersIntra.size());
        request.setAttribute("usersIntra", usersIntra);
    } 
     public ActionForward getAllUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getAllUsers");
        ActionMessages errors = new ActionMessages(); 
        populateUsers(request,errors);
        if (!errors.isEmpty()) saveErrors(request, errors);
        return mapping.findForward(Constants.SUCCESS);
    }
    
     public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("insertOrUpdate");
        UsuarioForm usrForm = (UsuarioForm)form;
        ActionMessages errors = new ActionMessages(); 
        if (validationSuccessful(request, usrForm)) {
            Usuario usuario = new Usuario();
            BeanUtils.copyProperties(usuario, usrForm);
            if (isUpdate(request, usrForm)) {
                logger.debug("update");
                usrService.updateUser(usuario);
       
            } else {
                logger.debug("insert");
                usrService.insertUser(usuario);
            }
            populateUsers(request,errors);
            return mapping.findForward(Constants.SUCCESS);
        } else {
            prep(request);
            return mapping.findForward(Constants.FAILURE);
        }
    }
     
    private boolean validationSuccessful(HttpServletRequest request, UsuarioForm form) {
        //if you really like using the validation framework stuff, you can just
        //call  ActionErrors errors = form.validate( mapping, request ); in this method
        //and check for errors being empty, if not save them and you're done.
        //I end up finding the validation framework a bit annoying to work with, so I do it
        //old-Skool way. Inevitably in a more complex app you end up having to perform
        //more complex validation than the validation framework provides, so I just assume
        //keep it all here in one place, versus having some handled by xml configuration and
        //some hardcoded.
        boolean isOk = true;
        ActionMessages errors = new ActionMessages();
        if (form.getLogin()== null || form.getLogin().trim().length() == 0) {
            errors.add("login", new ActionMessage("errors.required","Usuario"));  
        } 
        if (form.getCod_staff() == null || form.getCod_staff() == 0) {
            errors.add("cod_staff", new ActionMessage("errors.required","Cod Staff"));  
        }
        if (form.getNombre() == null || form.getNombre().trim().length() == 0) {
            errors.add("nombre", new ActionMessage("errors.required", "Nombres"));
        }
        if (form.getAp_pat() == null || form.getAp_pat().trim().length() == 0) {
            errors.add("ap_pat", new ActionMessage("errors.required", "Ap. Paterno"));
        }
        if (form.getAp_mat() == null || form.getAp_mat().trim().length() == 0) {
            errors.add("ap_mat", new ActionMessage("errors.required", "Ap. Materno"));
        }
        if (form.getEmail() == null || form.getEmail().trim().length() == 0) {
            errors.add("email", new ActionMessage("errors.required", "Email"));
        }
        
        
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            isOk = false;
        }
        return isOk;
    }
   
    public ActionForward showUsersIntranet(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("showUsersIntranet");
        prep(request);
        return mapping.findForward("usrIntra");
   }
}
