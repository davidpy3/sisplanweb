/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.persistence.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.persistence.UsuarioDAO;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Rol;

/**
 *
 * @author externo.gamaro
 */
public class UsuarioImplDAO extends SqlMapClientTemplate implements UsuarioDAO {
  Log logger = LogFactory.getLog(this.getClass());
   
  public List<Usuario>  BuscarUsuario(String login) throws TransactionException{
     
      List<Usuario> result=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
			
	  parmMap.put("pLogIn",login); 
          
          queryForObject("Usuario.buscarUsuarioLogin", parmMap);
          result=(List<Usuario>)parmMap.get("pResult");
          
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
      return result;
   }

    public String CambiarPassword(Usuario usuario) throws TransactionException {
       String result="ERROR";
      try{
          logger.debug(usuario.getPassword());
          logger.debug(usuario.getLogin());
          update("Usuario.updatePWD",usuario);
          result="OK";
          logger.debug("paso ");
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
      return result;
    }

    @Override
    public List<Compania> getCiasByRol(Rol rol) throws TransactionException {
      return queryForList("Companias.getCiasByRol", rol.getId());  
    }

    @Override
    public List<Rol> getRolesByUser(Usuario usuario) throws TransactionException {
        
      return queryForList("Rol.getUsersRoles",usuario.getLogin()); 
    }

    @Override
    public Rol getRol(Integer id){
        return ((Rol)queryForObject("Rol.getById", id));
    }

    @Override
    public Compania getCompania(Integer codigo) {
        return ((Compania)queryForObject("Companias.getCompania", codigo));
    }

    @Override
    public List getAll() {
        return queryForList("Usuario.getAll", null);
    }

    @Override
    public Usuario getUser(String codigo) {
       return ((Usuario)queryForObject("Usuario.getById", codigo));
    }

    @Override
    public int update(Usuario user) {
        return update("Usuario.update",user);
    }

    @Override
    public Integer insert(Usuario user) {
       return (Integer)insert("Usuario.insert",user);
    }

    @Override
    public int delete(String codigo) {
        return delete("Usuario.delete",codigo);
    }

   
}
