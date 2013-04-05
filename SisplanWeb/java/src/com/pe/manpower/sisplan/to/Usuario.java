/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.to;

import java.util.ArrayList;

/**
 *
 * @author G-AMARO
 */
public class Usuario {
    
private long   id;
  private String login;
  private String nombre;
  private String ap_pat;
  private String ap_mat;
  private long tipo_doc_id;
  private String num_doc_id;
  private String password;
  private String email;
  private long rol_id;
  private String session;
  private ArrayList menu=new ArrayList();   
  private String usuario_crea;
  private String usuario_mod;
  private String sfecha_crea;
  private String sfecha_mod;
  private String estado;

  private long cliente_id;

    
    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public long getRol_id() {
        return rol_id;
    }

    public void setRol_id(long rol_id) {
        this.rol_id = rol_id;
    }

    public long getTipo_doc_id() {
        return tipo_doc_id;
    }

    public void setTipo_doc_id(long tipo_doc_id) {
        this.tipo_doc_id = tipo_doc_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSfecha_crea() {
        return sfecha_crea;
    }

    public void setSfecha_crea(String sfecha_crea) {
        this.sfecha_crea = sfecha_crea;
    }

    public String getSfecha_mod() {
        return sfecha_mod;
    }

    public void setSfecha_mod(String sfecha_mod) {
        this.sfecha_mod = sfecha_mod;
    }

    public String getUsuario_crea() {
        return usuario_crea;
    }

    public void setUsuario_crea(String usuario_crea) {
        this.usuario_crea = usuario_crea;
    }

    public String getUsuario_mod() {
        return usuario_mod;
    }

    public void setUsuario_mod(String usuario_mod) {
        this.usuario_mod = usuario_mod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ArrayList getMenu() {
        return menu;
    }

    public void setMenu(ArrayList menu) {
        this.menu = menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_doc_id() {
        return num_doc_id;
    }

    public void setNum_doc_id(String num_doc_id) {
        this.num_doc_id = num_doc_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }


    
   
    
}
