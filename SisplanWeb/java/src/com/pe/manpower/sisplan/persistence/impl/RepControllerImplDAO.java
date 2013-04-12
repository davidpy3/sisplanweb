/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.persistence.impl;

import com.pe.manpower.sisplan.exception.TransactionException;
import com.pe.manpower.sisplan.persistence.RepControllerDAO;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.ObjResumen;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 *
 * @author G-AMARO
 */
public class RepControllerImplDAO extends SqlMapClientTemplate implements RepControllerDAO{

    @Override
    public List<ObjResumen> buscarIngresosPorMes(ObjResumen resum) throws TransactionException {
        
         List<ObjResumen> list=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
	
	  parmMap.put("pNoCia",resum.getNo_cia()); 
          parmMap.put("pAno",resum.getAno()); 
                                  
          queryForObject("RepController.buscarIngresosPorMes", parmMap);
          list=(List<ObjResumen>)parmMap.get("pResult");
           logger.debug(list.size());         
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
       return list;
    }

    @Override
    public List<ObjResumen> buscarCesesPorMes(ObjResumen resum) throws TransactionException {
        
         List<ObjResumen> list=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
	
	  parmMap.put("pNoCia",resum.getNo_cia()); 
          parmMap.put("pAno",resum.getAno()); 
                                  
          queryForObject("RepController.buscarCesesPorMes", parmMap);
          list=(List<ObjResumen>)parmMap.get("pResult");
           logger.debug(list.size());         
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
       return list;
    }
    
    @Override
    public List<ObjResumen> buscarCtaBalancePorMes(ObjResumen resum) throws TransactionException {
        
         List<ObjResumen> list=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
	
	  parmMap.put("pNoCia",resum.getNo_cia()); 
          parmMap.put("pAno",resum.getAno()); 
          parmMap.put("pMes",resum.getMes());
                                  
          queryForObject("RepController.buscarCtaBalancePorMes", parmMap);
          list=(List<ObjResumen>)parmMap.get("pResult");
           logger.debug(list.size());         
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
       return list;
    }
    
    @Override
    public List<ObjResumen> buscarCtaGastoPorMes(ObjResumen resum) throws TransactionException {
        
         List<ObjResumen> list=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
	
	  parmMap.put("pNoCia",resum.getNo_cia()); 
          parmMap.put("pAno",resum.getAno()); 
          parmMap.put("pMes",resum.getMes());
                                  
          queryForObject("RepController.buscarCtaGastoPorMes", parmMap);
          list=(List<ObjResumen>)parmMap.get("pResult");
           logger.debug(list.size());         
      }catch(Exception e){
        e.printStackTrace();
	logger.error(e);
      }
       return list;
    }
    
    @Override
    public List getYears(){
        return queryForList("RepController.getYears", null);
    }
    @Override
    public List getCompaniasSisplan(){
        return queryForList("Companias.getCompaniasSisplan", null);
    }
    
    @Override
    public Compania getCompaniaSisplan(Integer codigo) {
       return ((Compania)queryForObject("Companias.getCompaniaSisplan", codigo));
    }
    
}
