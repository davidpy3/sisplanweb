/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.to;

/**
 *
 * @author G-AMARO
 */
public class UsuarioRol {
    
    private String usuario;
    private Integer rolid;
    private String nombre;
    private String usuario_crea;
    private String fec_crea;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getRolid() {
        return rolid;
    }

    public void setRolid(Integer rolid) {
        this.rolid = rolid;
    }

    public String getUsuario_crea() {
        return usuario_crea;
    }

    public void setUsuario_crea(String usuario_crea) {
        this.usuario_crea = usuario_crea;
    }

    public String getFec_crea() {
        return fec_crea;
    }

    public void setFec_crea(String fec_crea) {
        this.fec_crea = fec_crea;
    }
    
    
}
