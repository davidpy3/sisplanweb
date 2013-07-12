/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.BusinessException;
import com.pe.manpower.sisplan.persistence.UsuarioDAO;
import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.service.UsuarioService;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Rol;

/**
 *
 * @author externo.gamaro
 */
public class UsuarioImplService implements UsuarioService {
    private UsuarioDAO dao;
     Log logger = LogFactory.getLog(this.getClass());
    public UsuarioImplService(UsuarioDAO dao){
      this.dao=dao;
    }
    public List<Usuario> buscarUsuario(String login) throws BusinessException {
        
        List<Usuario> result=null;
        try{
             result=dao.BuscarUsuario(login);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException(Constants.MESSAGE_ERROR_LOGIN,e);
        }
        
        return result;
    }

    public String CambiarPassword(Usuario usuario) throws BusinessException {
       String result=null;
        try{
             result=dao.CambiarPassword(usuario);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException(Constants.MESSAGE_ERROR_LOGIN,e);
        }
        
        return result;
    }

    @Override
    public List<Compania> getCiasByRol(Rol rol) throws BusinessException {
       List<Compania> result=null;
        try{
             result=dao.getCiasByRol(rol);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException("UsuarioImplService getCiasByRol Error",e);
        }
        
        return result;
    }

    @Override
    public List<Rol> getRolesByUser(Usuario usuario) throws BusinessException {
         List<Rol> result=null;
        try{
             result=dao.getRolesByUser(usuario);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException("UsuarioImplService getRolesByUser Error",e);
        }
        
        return result;
    }

    @Override
    public Rol getRol(Integer id) {
       return dao.getRol(id);
    }

    @Override
    public Compania getCompania(Integer codigo) {
         return dao.getCompania(codigo);
    }

    @Override
    public List getAllUsers() {
        return dao.getAll();
    }

    @Override
    public void updateUser(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void deleteUser(String codigo) {
        dao.delete(codigo);
    }

    @Override
    public Usuario geUser(String codigo) {
        return dao.getUser(codigo);
    }

    @Override
    public void insertUser(Usuario usuario) {
        dao.insert(usuario);
    }

     
}
