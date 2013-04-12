/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.persistence;

import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.ObjResumen;
import java.util.List;

/**
 *
 * @author G-AMARO
 */
public interface RepControllerDAO {
    
    public List<ObjResumen> buscarIngresosPorMes(ObjResumen resum) throws TransactionException;
    public List<ObjResumen> buscarCesesPorMes(ObjResumen resum) throws TransactionException;
    public List<ObjResumen> buscarCtaBalancePorMes(ObjResumen resum) throws TransactionException;
    public List<ObjResumen> buscarCtaGastoPorMes(ObjResumen resum) throws TransactionException;
    public List getCompaniasSisplan();
    public List getYears();
    public Compania getCompaniaSisplan(Integer codigo);
    
}
