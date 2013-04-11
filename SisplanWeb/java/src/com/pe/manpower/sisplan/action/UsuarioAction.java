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
         LoginForm loginfrm=(LoginForm) form;
         
        if(isValidUser(request,form)) {
          logger.debug("verdadero");
          Usuario usr=new Usuario();
          usr.setLogin(loginfrm.getLogin());
          // Inicialisar variables generales
           HttpSession sesion = request.getSession();
           
         
           List<Menu> listMenu=menuService.mostrarMenu(usr);
         
           sesion.setAttribute("listMenu",listMenu); 
          return mapping.findForward(Constants.SUCCESS);
        }else{
          logger.debug("falso");
          return mapping.findForward(Constants.LOGIN);
        }
    }
    
    private boolean isValidUser(HttpServletRequest req,ActionForm form) {
        logger.debug("isValidUser");
        LoginForm loginfrm=(LoginForm) form;
        boolean result=false;
        ActionMessages errors = new ActionMessages();        
      
      try{
        
        List<Usuario> list=usrService.buscarUsuario(loginfrm.getLogin());
        String encriptado=PasswordService.getInstance().encrypt(loginfrm.getPassword());
        if(list.size()>0){
        
           Usuario usr=list.get(0);
           if(usr.getPassword().equals(encriptado)) { 
               result=true;
               req.getSession().setAttribute("usr",usr);
               
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
          HttpSession ses=request.getSession(false);
          ses.removeAttribute("usr");
          ses.invalidate();
          request.removeAttribute("login");
          request.removeAttribute("password");
          request.removeAttribute("dispatch");

        return mapping.findForward(Constants.SUCCESS);
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
}
