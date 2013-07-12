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
import com.pe.manpower.sisplan.form.RolForm;
import com.pe.manpower.sisplan.form.UsuarioForm;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Rol;
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
         ActionMessages errors = new ActionMessages(); 
         
        if(isValidUser(request,form,usr)) {
          logger.debug("verdadero");
          logger.debug("usuario "+usr.toString());
          
          usr=usrService.buscarUsuario(loginfrm.getLogin()).get(0);
          request.getSession().setAttribute("usr",usr);
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
        populateUsers(request,errors);
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
    
    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpForInsertOrUpdate");
        UsuarioForm userForm = (UsuarioForm)form;
        if (isUpdate(request, userForm)) {
            String id = userForm.getUsuario();
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
        String id = userForm.getUsuario();
        if (id == null || id.trim().length() == 0) {
            updateFlag = false;
        }
        return updateFlag;
    }
     
    private void prep(HttpServletRequest request) {
        //request.setAttribute(Constants.PARENTS, menuService.getAllMenusParents());
    } 
}
