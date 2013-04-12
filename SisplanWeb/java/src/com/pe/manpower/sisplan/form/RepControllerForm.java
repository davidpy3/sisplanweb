/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.form;

/**
 *
 * @author G-AMARO
 */
public class RepControllerForm extends org.apache.struts.action.ActionForm{
    
    private String no_cia;
    private String ano;
    private String mes;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    
    public String getNo_cia() {
        return no_cia;
    }

    public void setNo_cia(String no_cia) {
        this.no_cia = no_cia;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
    
}
