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
  private String tipo_doc_id;
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
  private Rol rol;
  private Compania cia;
  private String ruta_impresion;
  private String usuario_db;
  private String password_db;
  private String id_repre_legal;
  private String id_modifica_vac;
  private String ind_not_ven_cont;
  private Integer cod_staff;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Compania getCia() {
        return cia;
    }

    public void setCia(Compania cia) {
        this.cia = cia;
    }
  
  
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

    public String getTipo_doc_id() {
        return tipo_doc_id;
    }

    public void setTipo_doc_id(String tipo_doc_id) {
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

    public String getRuta_impresion() {
        return ruta_impresion;
    }

    public void setRuta_impresion(String ruta_impresion) {
        this.ruta_impresion = ruta_impresion;
    }

    public String getUsuario_db() {
        return usuario_db;
    }

    public void setUsuario_db(String usuario_db) {
        this.usuario_db = usuario_db;
    }

    public String getPassword_db() {
        return password_db;
    }

    public void setPassword_db(String password_db) {
        this.password_db = password_db;
    }

    public String getId_repre_legal() {
        return id_repre_legal;
    }

    public void setId_repre_legal(String id_repre_legal) {
        this.id_repre_legal = id_repre_legal;
    }

    public String getId_modifica_vac() {
        return id_modifica_vac;
    }

    public void setId_modifica_vac(String id_modifica_vac) {
        this.id_modifica_vac = id_modifica_vac;
    }

    public String getInd_not_ven_cont() {
        return ind_not_ven_cont;
    }

    public void setInd_not_ven_cont(String ind_not_ven_cont) {
        this.ind_not_ven_cont = ind_not_ven_cont;
    }

    public Integer getCod_staff() {
        return cod_staff;
    }

    public void setCod_staff(Integer cod_staff) {
        this.cod_staff = cod_staff;
    }


    
   
    
}
