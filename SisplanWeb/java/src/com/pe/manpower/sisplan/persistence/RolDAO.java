/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.persistence;

import com.pe.manpower.sisplan.to.Rol;
import com.pe.manpower.sisplan.to.RolMenu;
import com.pe.manpower.sisplan.to.UsuarioRol;
import java.util.List;

/**
 *
 * @author G-AMARO
 */
public interface RolDAO {
    
    public List getAll();
    public Rol getRol(Integer id);
    public int update(Rol rol);
    public Integer insert(Rol rol);
    public int delete(Integer id);
    public List getMenuByRol(Integer id);
    public Integer insertRolMenu(RolMenu rolmenu);
    public int deleteRolMenu(RolMenu rolmenu);
    public List getUsersByRol(Integer id);
    public List getUsersNotInRol(Integer id);
    public Integer insertUsuarioRol(UsuarioRol usrrol);
    public int deleteUsuarioRol(UsuarioRol usrrol);
}
