/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.action;

import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.form.MvmntosCrdtoForm;
import com.pe.manpower.sisplan.service.MvmntosCrdtoService;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Correntista;
import com.pe.manpower.sisplan.to.MvmntosCrdtoTO;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author G-AMARO
 */
public class MvmntosCrdtoAction extends DispatchAction{
    private Log logger = LogFactory.getLog(this.getClass());
    private MvmntosCrdtoService movService;
    
     public MvmntosCrdtoAction(MvmntosCrdtoService movService) {
        super();
        this.movService = movService;
        
    }
     
      public ActionForward getMvmntoCrdtoByDate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getMvmntoCrdtoByDate");
        MvmntosCrdtoForm movForm = (MvmntosCrdtoForm)form;
        MvmntosCrdtoTO mov=new MvmntosCrdtoTO();
        mov.setNo_cia(movForm.getNo_cia());
        mov.setFecha(movForm.getFecha());
        mov.setIdCliente(movForm.getIdCliente());
        List listaMov=movService.getMvmntosByDate(mov);
        request.setAttribute(Constants.MVMNTOSCRDTO,listaMov);
        // Mostrar parametros 
        Compania cia=movService.getCompania(Integer.parseInt(mov.getNo_cia()));
        Correntista corr=movService.getCorrentista(Integer.parseInt(mov.getIdCliente()));
        HashMap params=new HashMap();
        params.put("Compania",cia.getNombre());
        params.put("Fecha",mov.getFecha());
        params.put("Correntista","TODOS");
        if(corr!=null) {
              params.put("Correntista",corr.getNombre());
          }
        request.setAttribute("params",params);
        return mapping.findForward(Constants.SUCCESS);
    }
     
      public ActionForward showMvmntoCrdtoParams(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("showMvmntoCrdtoParam");
        
        List listaCias=movService.getCompanias();
        List listaCorrentistas=movService.getCorrentistas();
        request.setAttribute("cias",listaCias);
        request.setAttribute("correntistas",listaCorrentistas);
               
        return mapping.findForward(Constants.PARAMS);
    }

}
