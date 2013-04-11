/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.service.impl;

import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.exception.BusinessException;
import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.persistence.RepControllerDAO;
import com.pe.manpower.sisplan.service.RepControllerService;
import com.pe.manpower.sisplan.to.ObjResumen;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author G-AMARO
 */
public class RepControllerImplService implements RepControllerService{
    
    private RepControllerDAO dao;
    Log logger = LogFactory.getLog(this.getClass());
    
    public RepControllerImplService(RepControllerDAO dao){
      this.dao=dao;
    }
    
    @Override
    public List<ObjResumen> getIngresosPorMes(ObjResumen resumen) throws BusinessException {
       List<ObjResumen> result=null;
        try{
             result=dao.buscarIngresosPorMes(resumen);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException(Constants.MESSAGE_ERROR_MENU,e);
        }
        
        return result;
    }

     @Override
    public List<ObjResumen> getCesesPorMes(ObjResumen resumen) throws BusinessException {
       List<ObjResumen> result=null;
        try{
             result=dao.buscarCesesPorMes(resumen);
        }catch(Exception e){
          logger.error(e);
	  throw new BusinessException(Constants.MESSAGE_ERROR_MENU,e);
        }
        
        return result;
    }
     
    @Override
    public List getYears() {
    
        return dao.getYears();
      
    }
    
}
