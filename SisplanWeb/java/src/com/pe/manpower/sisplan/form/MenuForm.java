/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.form;

/**
 *
 * @author G-AMARO
 */
public class MenuForm extends org.apache.struts.action.ActionForm {
    private String menuid;
    private String tipo;
    private String descripcion;
    private String estado;
    private String posid;
    private String titulo;
    private String parentid;
    private String url;
    private String no_cia;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPosid() {
        return posid;
    }

    public void setPosid(String posid) {
        this.posid = posid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getNo_cia() {
        return no_cia;
    }

    public void setNo_cia(String no_cia) {
        this.no_cia = no_cia;
    }
    
    
}
