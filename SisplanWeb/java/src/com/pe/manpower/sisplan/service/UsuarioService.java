/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.service;

import java.util.List;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.BusinessException;
import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Rol;

/**
 *
 * @author externo.gamaro
 */
public interface  UsuarioService {
    
    public List<Usuario> buscarUsuario(String login) throws BusinessException;
    public String CambiarPassword(Usuario usuario) throws BusinessException;
    public List<Compania> getCiasByRol(Rol rol)throws BusinessException;
    public List<Rol> getRolesByUser(Usuario usuario)throws BusinessException;
    public Rol getRol(Integer id);
    public Compania getCompania(Integer codigo);
    public List getAllUsers();
    public void updateUser(Usuario usuario);
    public void deleteUser(String codigo);
    public Usuario geUser(String codigo);
    public void insertUser(Usuario usuario); 
    
}
