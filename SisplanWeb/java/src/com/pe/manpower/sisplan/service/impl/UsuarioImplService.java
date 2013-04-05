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

     
}
