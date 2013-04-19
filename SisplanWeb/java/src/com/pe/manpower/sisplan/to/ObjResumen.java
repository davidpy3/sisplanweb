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
    private String  cod_concepto;
    private String  desc_concepto;
    private String  cuenta;
    private String  cod_clie;
    private String  desc_clie;
    private String  cod_ccosto;
    private String  desc_ccosto;
    private double  monto;
    private double  tot_ing;
    private double  tot_prov;
    private long    saldo_inicial;
    private long    ingresos;
    private long    ceses;

    public long getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(long saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public long getIngresos() {
        return ingresos;
    }

    public void setIngresos(long ingresos) {
        this.ingresos = ingresos;
    }

    public long getCeses() {
        return ceses;
    }

    public void setCeses(long ceses) {
        this.ceses = ceses;
    }

    
    
    public double getTot_ing() {
        return tot_ing;
    }

    public void setTot_ing(double tot_ing) {
        this.tot_ing = tot_ing;
    }

    public double getTot_prov() {
        return tot_prov;
    }

    public void setTot_prov(double tot_prov) {
        this.tot_prov = tot_prov;
    }
    

    public String getCod_concepto() {
        return cod_concepto;
    }

    public void setCod_concepto(String cod_concepto) {
        this.cod_concepto = cod_concepto;
    }

    public String getDesc_concepto() {
        return desc_concepto;
    }

    public void setDesc_concepto(String desc_concepto) {
        this.desc_concepto = desc_concepto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCod_clie() {
        return cod_clie;
    }

    public void setCod_clie(String cod_clie) {
        this.cod_clie = cod_clie;
    }

    public String getDesc_clie() {
        return desc_clie;
    }

    public void setDesc_clie(String desc_clie) {
        this.desc_clie = desc_clie;
    }

    public String getCod_ccosto() {
        return cod_ccosto;
    }

    public void setCod_ccosto(String cod_ccosto) {
        this.cod_ccosto = cod_ccosto;
    }

    public String getDesc_ccosto() {
        return desc_ccosto;
    }

    public void setDesc_ccosto(String desc_ccosto) {
        this.desc_ccosto = desc_ccosto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
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
