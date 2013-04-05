/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.to;

import java.io.Serializable;

/**
 *
 * @author G-AMARO
 */
public class Correntista  implements Serializable  {
    
    private Integer idcorrentista;
    private String nombre;

    public Integer getIdcorrentista() {
        return idcorrentista;
    }

    public void setIdcorrentista(Integer idcorrentista) {
        this.idcorrentista = idcorrentista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
