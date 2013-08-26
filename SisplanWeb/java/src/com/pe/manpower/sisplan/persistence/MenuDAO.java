/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.persistence;

import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Menu;
import com.pe.manpower.sisplan.to.MenuCia;
import com.pe.manpower.sisplan.to.Usuario;
import java.util.List;

/**
 *
 * @author externo.gamaro
 */
public interface MenuDAO {
    
    public List<Menu> mostrarMenu(Usuario usuario) throws TransactionException;
    public List getAll();
    public List getAllParents();
    public Menu getMenu(Integer id);
    public int update(Menu menu);
    public Integer insert(Menu menu);
    public int delete(Integer id);
    public List getCompaniasSisplan();
    public List getMenuByCia(String no_cia);
    public Compania getCompaniaSisplan(Integer codigo);
    public Integer insertMenuCia(MenuCia menucia);
    public int deleteMenuCia(MenuCia menucia);
    public List findMenus(Menu menu);
}
