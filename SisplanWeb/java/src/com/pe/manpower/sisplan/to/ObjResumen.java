/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.to;

/**
 *
 * @author G-AMARO
 */
public class ObjResumen {
    private String  no_cia;
    private String  mes_desc;
    private Integer mes;
    private Integer ano;
    private long    total;
    private String  cia_desc;

    public String getCia_desc() {
        return cia_desc;
    }

    public void setCia_desc(String cia_desc) {
        this.cia_desc = cia_desc;
    }

    
    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    
    public String getNo_cia() {
        return no_cia;
    }

    public void setNo_cia(String no_cia) {
        this.no_cia = no_cia;
    }

    public String getMes_desc() {
        return mes_desc;
    }

    public void setMes_desc(String mes_desc) {
        this.mes_desc = mes_desc;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    
    
}
