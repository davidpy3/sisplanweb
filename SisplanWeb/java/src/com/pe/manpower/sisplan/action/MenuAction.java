/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.action;

import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.form.MenuForm;
import com.pe.manpower.sisplan.service.MenuService;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Menu;
import com.pe.manpower.sisplan.to.MenuCia;
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
public class MenuAction extends DispatchAction{
    
     private Log logger = LogFactory.getLog(this.getClass());
     private MenuService menuService;
     
     public MenuAction(MenuService menuService) {
        super();
        this.menuService=menuService;
    }
    
    public ActionForward getMenus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getMenus");
        populateMenus(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpForInsertOrUpdate");
        MenuForm menuForm = (MenuForm)form;
        if (isUpdate(request, menuForm)) {
            Integer id = Integer.valueOf(menuForm.getMenuid());
            Menu menu = menuService.getMenu(id);
            BeanUtils.copyProperties(menuForm, menu);
        }
        prep(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("delete");
        MenuForm menuForm = (MenuForm)form;
        Integer id = Integer.valueOf(menuForm.getMenuid());
        menuService.deleteMenu(id);
        populateMenus(request);
        return mapping.findForward(Constants.SUCCESS);
    }

    public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("insertOrUpdate");
        MenuForm menuForm = (MenuForm)form;
        if (validationSuccessful(request, menuForm)) {
            Menu menu = new Menu();
            BeanUtils.copyProperties(menu, menuForm);
            if (isUpdate(request, menuForm)) {
                logger.debug("update");
                menuService.updateMenu(menu);
            } else {
                logger.debug("insert");
                menuService.insertMenu(menu);
            }
            populateMenus(request);
            return mapping.findForward(Constants.SUCCESS);
        } else {
            prep(request);
            return mapping.findForward(Constants.FAILURE);
        }
    }

    private void populateMenus(HttpServletRequest request) {
        List menus = menuService.getAllMenus();
        request.setAttribute(Constants.MENUS, menus);
    }

    private void prep(HttpServletRequest request) {
        request.setAttribute(Constants.PARENTS, menuService.getAllMenusParents());
    }

    private boolean isUpdate(HttpServletRequest request, MenuForm menuForm) {
        boolean updateFlag = true;
        //if ID is null or 0 we know we are doing an insert. You could check other
        //things to decide, like a dispatch param
        //It's annoying that BeanUtils will convert nulls to 0 so have to do 0 check also,
        //or you could register a converter, which is the preferred way to handle it, but goes
        //beyond this demo
        String id = menuForm.getMenuid();
        if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
        return updateFlag;
    }
    
     public ActionForward showMenuByCia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("showMenuByCia");
        //RolForm rolForm = (RolForm)form;
        //Integer id = Integer.valueOf(rolForm.getId());
        //populateMenuRole(request, id);
        List cias=menuService.getCompaniasSisplan();
        request.setAttribute("cias",cias);
        return mapping.findForward("cias");
    }
       
   public ActionForward getMenuByCia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getMenuByCia");
        MenuForm menuForm = (MenuForm)form;
        String no_cia = menuForm.getNo_cia();
        populateMenuCia(request,no_cia);
        return mapping.findForward(Constants.MENUCIA);
    }
    private void populateMenuCia(HttpServletRequest request,String no_cia) {
        List menucias=menuService.getMenuByCia(no_cia);
        Compania cia=menuService.getCompaniaSisplan(Integer.valueOf(no_cia));
        request.setAttribute(Constants.CIA,cia);
        request.setAttribute(Constants.MENUCIA,menucias);
    }
    public ActionForward setUpMenuToCia(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("setUpMenuToRol");
        String  no_cia = request.getParameter("no_cia");
        Integer menuid = Integer.valueOf(request.getParameter("menuid"));
        String action = request.getParameter("action");
        MenuCia menucia=new MenuCia();
        menucia.setNo_cia(no_cia);
        menucia.setMenuid(menuid);
        //rolmenu.setUsuario(((Usuario)request.getSession().getAttribute("usr")).getLogin());
        if(action.equals("add")) {
          menuService.insertMenuCia(menucia);
        }else{
          menuService.deleteMenuCia(menucia);
        }
        populateMenuCia(request,no_cia);
        return mapping.findForward(Constants.MENUCIA);
    }
    private boolean validationSuccessful(HttpServletRequest request, MenuForm form) {
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
        if (form.getPosid() == null || form.getPosid().trim().length() == 0) {
            errors.add("posid", new ActionMessage("errors.required","Posición"));  
        } else {
            try {
                Integer.parseInt(form.getPosid());
            } catch (NumberFormatException e) {
                errors.add("posid", new ActionMessage("errors.number", "Posición"));
            }
        }
        if (form.getTitulo() == null || form.getTitulo().trim().length() == 0) {
            errors.add("titulo", new ActionMessage("errors.required", "Título"));
        }
        
        if(form.getTipo() != null && form.getTipo().equals("I")) {
            if (form.getUrl() == null || form.getUrl().trim().length() == 0) {
                errors.add("url", new ActionMessage("errors.required", "URL"));
            }
        }
        
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            isOk = false;
        }
        return isOk;
    } 
     
}
