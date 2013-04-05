/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.persistence.impl;

/**
 *
 * @author G-AMARO
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import com.pe.manpower.sisplan.persistence.MvmntosCrdtoDAO;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Correntista;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.pe.manpower.sisplan.to.MvmntosCrdtoTO;
import java.sql.ResultSet;

public class MvmntosCrdtoImplDAO extends SqlMapClientTemplate implements MvmntosCrdtoDAO {
    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    Log logger = LogFactory.getLog(this.getClass());

    @Override
     public List getMvmntosByDate(MvmntosCrdtoTO mov){
         List  list=null;
      try{
          Map<String, Object> parmMap = new HashMap<String, Object>();
	  logger.debug("en DAO getMvmntosByDate "+mov.toString());
	  parmMap.put("p_cCia",mov.getNo_cia()); 
          parmMap.put("p_dFecha",mov.getFecha()); 
          parmMap.put("p_cCorrentista",mov.getIdCliente()); 
                                  
          queryForObject("MvmntosCrdto.getMvmntosByDate", parmMap);
          list=(List)parmMap.get("pResult");
          logger.debug("getMvmntosByDate Rows "+ list.size());         
      }catch(Exception e){
	logger.error(e);
      }
       return list;
    }

    @Override
    public List getCompanias() {
        return queryForList("Companias.getCompanias",null);
    }

    @Override
    public List getCorrentistas() {
        return queryForList("Correntista.getCorrentistas",null);
    }

    @Override
    public Compania getCompania(Integer codigo) {
       return ((Compania)queryForObject("Companias.getCompania", codigo));
    }

    @Override
    public Correntista getCorrentista(Integer correntista) {
       return ((Correntista)queryForObject("Correntista.getCorrentista", correntista));
    }

   

}
