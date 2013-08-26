/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.persistence.impl;

import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.persistence.MenuDAO;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Menu;
import com.pe.manpower.sisplan.to.MenuCia;
import com.pe.manpower.sisplan.to.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 *
 * @author externo.gamaro
 */
public class MenuImplDAO extends SqlMapClientTemplate implements MenuDAO{

    public List<Menu> mostrarMenu(Usuario usuario) throws TransactionException {
         List<Menu> list=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
	  logger.debug("en MenuImplDAO "+usuario.toString());
	  parmMap.put("pLogIn",usuario.getLogin()); 
          parmMap.put("pRol",usuario.getRol().getId()); 
          parmMap.put("pNoCia",usuario.getCia().getCodigo()); 

          queryForObject("Menu.buscarMenuUsuario", parmMap);
          list=(List<Menu>)parmMap.get("pResult");
           logger.debug(list.size());         
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
       return list;
    }

    @Override
    public List getAll() {
        return queryForList("Menu.getAll", null);
    }

    @Override
    public Menu getMenu(Integer id) {
        return ((Menu)queryForObject("Menu.getById", id));
    }

    @Override
    public int update(Menu menu) {
        return update("Menu.update", menu);
    }

    @Override
    public Integer insert(Menu menu) {
       return (Integer)insert("Menu.insert", menu);  
    }

    @Override
    public int delete(Integer id) {
       return delete("Menu.delete", id);
    }

    @Override
    public List getAllParents() {
       return queryForList("Menu.getAllParents", null);
    }

    @Override
    public List getCompaniasSisplan() {
        return queryForList("Companias.getCompaniasSisplan", null);
    }

    @Override
    public List getMenuByCia(String no_cia) {
        return queryForList("Menu.getMenuByCia",no_cia);
    }

    @Override
    public Compania getCompaniaSisplan(Integer codigo) {
        return ((Compania)queryForObject("Companias.getCompaniaSisplan", codigo));
    }

    @Override
    public Integer insertMenuCia(MenuCia menucia) {
         return (Integer)insert("Menu.insertMenuCia",menucia); 
    }

    @Override
    public int deleteMenuCia(MenuCia menucia) {
        return delete("Menu.deleteMenuCia",menucia);
    }

    @Override
    public List findMenus(Menu menu) {
       return queryForList("Menu.findMenus",menu);
    }

}
