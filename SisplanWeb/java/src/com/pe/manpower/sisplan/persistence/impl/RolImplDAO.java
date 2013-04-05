/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.persistence.impl;

import com.pe.manpower.sisplan.persistence.RolDAO;
import com.pe.manpower.sisplan.to.Rol;
import com.pe.manpower.sisplan.to.RolMenu;
import com.pe.manpower.sisplan.to.UsuarioRol;
import java.util.List;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 *
 * @author G-AMARO
 */
public class RolImplDAO extends SqlMapClientTemplate implements RolDAO{

    @Override
    public List getAll() {
        return queryForList("Rol.getAll", null);
    }

    @Override
    public Rol getRol(Integer id) {
       return ((Rol)queryForObject("Rol.getById", id));
    }

    @Override
    public int update(Rol rol) {
        return update("Rol.update", rol);
    }

    @Override
    public Integer insert(Rol rol) {
        return (Integer)insert("Rol.insert", rol);  
    }

    @Override
    public int delete(Integer id) {
      return delete("Rol.delete", id);
    }

    @Override
    public List getMenuByRol(Integer id) {
        return queryForList("Rol.getMenuByRol", id);
    }

    @Override
    public Integer insertRolMenu(RolMenu rolmenu) {
       return (Integer)insert("Rol.insertRolMenu", rolmenu);  
    }

    @Override
    public int deleteRolMenu(RolMenu rolmenu) {
       return delete("Rol.deleteRolMenu",rolmenu);
    }

    @Override
    public List getUsersByRol(Integer id) {
        return queryForList("Rol.getUsersByRol", id);
    }

    @Override
    public List getUsersNotInRol(Integer id) {
        return queryForList("Rol.getUsersNotInRol", id);
    }

    @Override
    public Integer insertUsuarioRol(UsuarioRol usrrol) {
        return (Integer)insert("Rol.insertUsuarioRol", usrrol);  
    }

    @Override
    public int deleteUsuarioRol(UsuarioRol usrrol) {
       return delete("Rol.deleteUsuarioRol",usrrol);
    }
    
}
