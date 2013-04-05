/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.manpower.sisplan.service;

import java.util.List;
import com.pe.manpower.sisplan.to.Usuario;
import com.pe.manpower.sisplan.exception.BusinessException;

/**
 *
 * @author externo.gamaro
 */
public interface  UsuarioService {
    
    public List<Usuario> buscarUsuario(String login) throws BusinessException;
    public String CambiarPassword(Usuario usuario) throws BusinessException;

}
