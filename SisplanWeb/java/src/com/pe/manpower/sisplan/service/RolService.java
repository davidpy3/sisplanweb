/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.service;

import com.pe.manpower.sisplan.to.Rol;
import com.pe.manpower.sisplan.to.RolMenu;
import com.pe.manpower.sisplan.to.UsuarioRol;
import java.util.List;

/**
 *
 * @author G-AMARO
 */
public interface RolService {
    public List getAllRoles();
    public void updateRol(Rol rol);

    public void deleteRol(Integer id);

    public Rol getRol(Integer id);

    public void insertRol(Rol rol); 
    public List getMenuByRol(Integer id);
    public void insertRolMenu(RolMenu rolmenu);
    public void deleteRolMenu(RolMenu rolmenu);
    public List getUsersByRol(Integer id);
    public List getUsersNotInRol(Integer id);
    public void insertUsuarioRol(UsuarioRol usrrol);
    public void deleteUsuarioRol(UsuarioRol usrrol);
    
}
