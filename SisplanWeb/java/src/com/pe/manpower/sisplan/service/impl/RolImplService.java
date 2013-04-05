/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.service.impl;

import com.pe.manpower.sisplan.persistence.RolDAO;
import com.pe.manpower.sisplan.service.RolService;
import com.pe.manpower.sisplan.to.Rol;
import com.pe.manpower.sisplan.to.RolMenu;
import com.pe.manpower.sisplan.to.UsuarioRol;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author G-AMARO
 */
public class RolImplService implements RolService{
    private RolDAO dao;
    Log logger = LogFactory.getLog(this.getClass());
    public RolImplService(RolDAO dao){
      this.dao=dao;
    }
    @Override
    public List getAllRoles() {
        return dao.getAll();
    }

    @Override
    public void updateRol(Rol rol) {
         dao.update(rol);
    }

    @Override
    public void deleteRol(Integer id) {
        dao.delete(id);
    }

    @Override
    public Rol getRol(Integer id) {
        return dao.getRol(id);
    }

    @Override
    public void insertRol(Rol rol) {
        dao.insert(rol);
    }

    @Override
    public List getMenuByRol(Integer id) {
       return dao.getMenuByRol(id);
    }

    @Override
    public void insertRolMenu(RolMenu rolmenu) {
        dao.insertRolMenu(rolmenu);
    }

    @Override
    public void deleteRolMenu(RolMenu rolmenu) {
        dao.deleteRolMenu(rolmenu);
    }

    @Override
    public List getUsersByRol(Integer id) {
        return dao.getUsersByRol(id);
    }

    @Override
    public List getUsersNotInRol(Integer id) {
        return dao.getUsersNotInRol(id);
    }

    @Override
    public void insertUsuarioRol(UsuarioRol usrrol) {
        dao.insertUsuarioRol(usrrol);
    }

    @Override
    public void deleteUsuarioRol(UsuarioRol usrrol) {
        dao.deleteUsuarioRol(usrrol);
    }
    
}
