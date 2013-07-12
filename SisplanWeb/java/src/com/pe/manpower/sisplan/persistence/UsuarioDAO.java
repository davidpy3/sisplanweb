/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.pe.manpower.sisplan.persistence;

import java.util.List;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Rol;

/**
 *
 * @author externo.gamaro
 */
public interface UsuarioDAO {
    
     public List<Usuario>  BuscarUsuario(String login) throws TransactionException;
     public String CambiarPassword(Usuario usuario)throws TransactionException;
     public List<Compania> getCiasByRol(Rol rol)throws TransactionException;
     public List<Rol> getRolesByUser(Usuario usuario)throws TransactionException; 
     public Rol getRol(Integer id); 
     public Compania getCompania(Integer codigo);
     public List getAll();
     public Usuario getUser(String codigo);
     public int update(Usuario user);
     public Integer insert(Usuario user);
     public int delete(String codigo);
}
