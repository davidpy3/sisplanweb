/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.service;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.pe.manpower.sisplan.to.Menu;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.BusinessException;

/**
 *
 * @author externo.gamaro
 */
public interface MenuService {
  
  public List<Menu> mostrarMenu(Usuario usuario) throws BusinessException;
   public List getAllMenus();
    public List getAllMenusParents();

    public void updateMenu(Menu menu);

    public void deleteMenu(Integer id);

    public Menu getMenu(Integer id);

    public void insertMenu(Menu menu);
}
