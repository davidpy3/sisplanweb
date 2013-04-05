/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.form;

/**
 *
 * @author G-AMARO
 */
public class MvmntosCrdtoForm extends org.apache.struts.action.ActionForm {
       
  private String  no_cia;
  private String  fecha;
  private String  idCliente;

    public String getNo_cia() {
        return no_cia;
    }

    public void setNo_cia(String no_cia) {
        this.no_cia = no_cia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
  
  
}
