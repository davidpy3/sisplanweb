/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.action;

import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.form.RolForm;
import com.pe.manpower.sisplan.service.RolService;
import com.pe.manpower.sisplan.to.Rol;
import com.pe.manpower.sisplan.to.RolMenu;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.to.UsuarioRol;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author G-AMARO
 */
public class RolAction extends DispatchAction{
      private Log logger = LogFactory.getLog(this.getClass());
     private RolService rolService;
     
     public RolAction(RolService rolService) {
        super();
        this.rolService=rolService;
    }
     
   public ActionForward getRoles(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getRoles");
        populateRoles(request);
        return mapping.findForward(Constants.SUCCESS);
    }

   public ActionForward showUsersByRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("showUsersByRol");
        //RolForm rolForm = (RolForm)form;
        //Integer id = Integer.valueOf(rolForm.getId());
        //populateMenuRole(request, id);
        List roles=rolService.getAllRoles();
        request.setAttribute("pusuariorol", roles);
        return mapping.findForward("pusuariorol");
    }
      
   public ActionForward getUsersByRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getUsersByRol");
        RolForm rolForm = (RolForm)form;
        Integer id = Integer.valueOf(rolForm.getId());
        populateUserRole(request, id);
        return mapping.findForward(Constants.USUARIOROL);
   }
   
   public ActionForward setUpUserToRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpUserToRol");
        Integer rolid = Integer.valueOf(request.getParameter("rolid"));
        String usuario = request.getParameter("usuario");
        String action = request.getParameter("action");
        UsuarioRol usrrol=new UsuarioRol();
        usrrol.setRolid(rolid);
        usrrol.setUsuario(usuario);
        usrrol.setUsuario_crea(((Usuario)request.getSession().getAttribute("usr")).getLogin());
        if(action.equals("add")) {
          rolService.insertUsuarioRol(usrrol);
        }else{
          rolService.deleteUsuarioRol(usrrol);
        }
        populateUserRole(request, rolid);
        return mapping.findForward(Constants.USUARIOROL);
    }
   
   public ActionForward showMenuByRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("showMenuByRol");
        //RolForm rolForm = (RolForm)form;
        //Integer id = Integer.valueOf(rolForm.getId());
        //populateMenuRole(request, id);
        List roles=rolService.getAllRoles();
        request.setAttribute("pmenurol", roles);
        return mapping.findForward("pmenurol");
    }
   
   public ActionForward getMenuByRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getMenuByRol");
        RolForm rolForm = (RolForm)form;
        Integer id = Integer.valueOf(rolForm.getId());
        populateMenuRole(request, id);
        return mapping.findForward(Constants.MENUROL);
    }
    
    public ActionForward setUpMenuToRol(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpMenuToRol");
        Integer rolid = Integer.valueOf(request.getParameter("rolid"));
        Integer menuid = Integer.valueOf(request.getParameter("menuid"));
        String action = request.getParameter("action");
        RolMenu rolmenu=new RolMenu();
        rolmenu.setRolid(rolid);
        rolmenu.setMenuid(menuid);
        rolmenu.setUsuario(((Usuario)request.getSession().getAttribute("usr")).getLogin());
        if(action.equals("add")) {
          rolService.insertRolMenu(rolmenu);
        }else{
          rolService.deleteRolMenu(rolmenu);
        }
        populateMenuRole(request, rolid);
        return mapping.findForward(Constants.MENUROL);
    }
    
  
    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpForInsertOrUpdate");
        RolForm rolForm = (RolForm)form;
        if (isUpdate(request, rolForm)) {
            Integer id = Integer.valueOf(rolForm.getId());
            Rol rol = rolService.getRol(id);
            BeanUtils.copyProperties(rolForm, rol);
        }
        prep(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("delete");
        RolForm rolForm = (RolForm)form;
        Integer id = Integer.valueOf(rolForm.getId());
        rolService.deleteRol(id);
        populateRoles(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("insertOrUpdate");
        RolForm rolForm = (RolForm)form;
        if (validationSuccessful(request, rolForm)) {
            Rol rol = new Rol();
            BeanUtils.copyProperties(rol, rolForm);
            if (isUpdate(request, rolForm)) {
                logger.debug("update");
                rolService.updateRol(rol);
            } else {
                logger.debug("insert");
                rolService.insertRol(rol);
            }
            populateRoles(request);
            return mapping.findForward(Constants.SUCCESS);
        } else {
            prep(request);
            return mapping.findForward(Constants.FAILURE);
        }
    }

    private void populateRoles(HttpServletRequest request) {
        List roles = rolService.getAllRoles();
        request.setAttribute(Constants.ROLES, roles);
    }

    private void populateMenuRole(HttpServletRequest request,Integer rolid) {
        List menurol=rolService.getMenuByRol(rolid);
        Rol rol=rolService.getRol(rolid);
        request.setAttribute(Constants.ROL,rol);
        request.setAttribute(Constants.MENUROL, menurol);
    }
    private void populateUserRole(HttpServletRequest request,Integer rolid) {
        List usuariorol=rolService.getUsersByRol(rolid);
        List usuarionorol=rolService.getUsersNotInRol(rolid);
        Rol rol=rolService.getRol(rolid);
        request.setAttribute(Constants.ROL,rol);
        request.setAttribute(Constants.USUARIOROL, usuariorol);
        request.setAttribute(Constants.USUARIOSNOROL, usuarionorol);
    }
    private void prep(HttpServletRequest request) {
        //request.setAttribute(Constants.PARENTS, menuService.getAllMenusParents());
    }

    private boolean isUpdate(HttpServletRequest request, RolForm rolForm) {
        boolean updateFlag = true;
        //if ID is null or 0 we know we are doing an insert. You could check other
        //things to decide, like a dispatch param
        //It's annoying that BeanUtils will convert nulls to 0 so have to do 0 check also,
        //or you could register a converter, which is the preferred way to handle it, but goes
        //beyond this demo
        String id = rolForm.getId();
        if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
        return updateFlag;
    }

    private boolean validationSuccessful(HttpServletRequest request, RolForm form) {
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
        
        if (form.getNombre() == null || form.getNombre().trim().length() == 0) {
            errors.add("nombre", new ActionMessage("errors.required", "Rol Nombre"));
        }
        
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            isOk = false;
        }
        return isOk;
    }   
    
}
