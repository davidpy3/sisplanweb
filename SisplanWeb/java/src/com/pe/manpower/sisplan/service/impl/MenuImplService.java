/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.pe.manpower.sisplan.to.Menu;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.BusinessException;
import com.pe.manpower.sisplan.persistence.MenuDAO;
import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.service.MenuService;

/**
 *
 * @author externo.gamaro
 */
public class MenuImplService implements MenuService{
    private MenuDAO dao;
    Log logger = LogFactory.getLog(this.getClass());
    public MenuImplService(MenuDAO dao){
      this.dao=dao;
    }
    public List<Menu> mostrarMenu(Usuario usuario) throws BusinessException {
       List<Menu> result=null;
        try{
             result=dao.mostrarMenu(usuario);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException(Constants.MESSAGE_ERROR_MENU,e);
        }
        
        return result;
    }
    
     public List getAllMenus() {
        return dao.getAll();
    }

    @Override
    public void updateMenu(Menu menu) {
        dao.update(menu);
    }

    @Override
    public void deleteMenu(Integer id) {
        dao.delete(id);
    }

    @Override
    public Menu getMenu(Integer id) {
        return dao.getMenu(id);
    }

    @Override
    public void insertMenu(Menu menu) {
        dao.insert(menu);
    }

    @Override
    public List getAllMenusParents() {
        return dao.getAllParents();
    }

}
