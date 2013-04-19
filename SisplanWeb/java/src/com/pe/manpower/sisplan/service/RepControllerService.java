/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.service;

import com.pe.manpower.sisplan.exception.BusinessException;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.ObjResumen;
import java.util.List;

/**
 *
 * @author G-AMARO
 */
public interface RepControllerService {
    
    public List<ObjResumen> getIngresosPorMes(ObjResumen resumen) throws BusinessException;
    public List<ObjResumen> getCesesPorMes(ObjResumen resumen) throws BusinessException;
    public List<ObjResumen> getCtaBalancePorMes(ObjResumen resumen) throws BusinessException;
    public List<ObjResumen> getCtaGastoPorMes(ObjResumen resumen) throws BusinessException;
    public List<ObjResumen> getIngSctrVleyEss(ObjResumen resumen) throws BusinessException;
    public List<ObjResumen> getKardexTrabCCosto(ObjResumen resumen) throws BusinessException;
    public List getCompaniasSisplan();
    public List getYears();
    public Compania getCompaniaSisplan(Integer codigo);
}
