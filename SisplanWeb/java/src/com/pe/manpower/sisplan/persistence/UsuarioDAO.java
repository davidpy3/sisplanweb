/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.pe.manpower.sisplan.persistence;

import java.util.List;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.TransactionException;

/**
 *
 * @author externo.gamaro
 */
public interface UsuarioDAO {
    
     public List<Usuario>  BuscarUsuario(String login) throws TransactionException;
     public String CambiarPassword(Usuario usuario)throws TransactionException;

}
