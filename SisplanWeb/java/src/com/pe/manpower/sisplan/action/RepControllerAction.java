/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.action;

import com.pe.manpower.sisplan.Constants;
import com.pe.manpower.sisplan.Util;
import com.pe.manpower.sisplan.form.RepControllerForm;
import com.pe.manpower.sisplan.service.MvmntosCrdtoService;
import com.pe.manpower.sisplan.service.RepControllerService;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.ObjResumen;
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
public class RepControllerAction extends DispatchAction{
    private Log logger = LogFactory.getLog(this.getClass());
    private RepControllerService repService;
    private MvmntosCrdtoService movService;

    public RepControllerAction(RepControllerService repService,MvmntosCrdtoService movService) {
        super();
        this.repService = repService;
        this.movService=movService;
    }
    
    public ActionForward getIngresosPorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getIngresosPorMes");
        RepControllerForm repForm=(RepControllerForm) form;
        ObjResumen resumen=new ObjResumen();
        resumen.setNo_cia(repForm.getNo_cia());
        resumen.setAno(Integer.parseInt(repForm.getAno()));
        logger.debug("getIngresosPorMes-> no_cia :"+resumen.getNo_cia());
        logger.debug("getIngresosPorMes-> Ano :"+resumen.getAno());
        List listaresumen=repService.getIngresosPorMes(resumen);
        request.setAttribute("IngresosPorMes",listaresumen);
        // Mostrar parametros 
        Compania cia=movService.getCompania(Integer.parseInt(resumen.getNo_cia()));
        HashMap params=new HashMap();
        params.put("Compania",cia.getNombre());
        params.put("Ano",resumen.getAno());
        
        request.setAttribute("params",params);
        return mapping.findForward(Constants.SUCCESS);
        
     }
    
    public ActionForward showParamsIngresosPorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("showParamsIngresosPorMes");
        
        List listaCias=movService.getCompanias();
        List years=repService.getYears();
        
        request.setAttribute("cias",listaCias);
        request.setAttribute("years",years);
   
     return mapping.findForward(Constants.PARAMS);
    }
    
      public ActionForward getCesesPorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getCesesPorMes");
        RepControllerForm repForm=(RepControllerForm) form;
        ObjResumen resumen=new ObjResumen();
        resumen.setNo_cia(repForm.getNo_cia());
        resumen.setAno(Integer.parseInt(repForm.getAno()));
        logger.debug("getCesesPorMes-> no_cia :"+resumen.getNo_cia());
        logger.debug("getCesesPorMes-> Ano :"+resumen.getAno());
        List listaresumen=repService.getCesesPorMes(resumen);
        request.setAttribute("CesesPorMes",listaresumen);
        // Mostrar parametros 
        Compania cia=movService.getCompania(Integer.parseInt(resumen.getNo_cia()));
        HashMap params=new HashMap();
        params.put("Compania",cia.getNombre());
        params.put("Ano",resumen.getAno());
        
        request.setAttribute("params",params);
        return mapping.findForward("CesesxMes");
        
     }
    
     public ActionForward showParamsCesesPorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("showParamsCesesPorMes");
        
        List listaCias=movService.getCompanias();
        List years=repService.getYears();
        
        request.setAttribute("cias",listaCias);
        request.setAttribute("years",years);
   
     return mapping.findForward("pCesesxMes");
    }
     public ActionForward getCtaBalancePorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getCtaBalancePorMes");
        setDataCta(1,form, request);
        return mapping.findForward("CtaBalancexMes");
        
     }
    
     public ActionForward getCtaGastoPorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getCtaGastoPorMes");
        setDataCta(2,form, request);
        return mapping.findForward("CtaGastoxMes");
        
     }
       
     public ActionForward showParamsCtaBalancePorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("showParamsCtaBalancePorMes");
        
        List listaCias=repService.getCompaniasSisplan();
        List years=repService.getYears();
        
        request.setAttribute("cias",listaCias);
        request.setAttribute("years",years);
   
     return mapping.findForward("pCtaBalancexMes");
    }
         
     public ActionForward showParamsCtaGastoPorMes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("showParamsCtaGastoPorMes");
        
        List listaCias=repService.getCompaniasSisplan();
        List years=repService.getYears();
        
        request.setAttribute("cias",listaCias);
        request.setAttribute("years",years);
   
     return mapping.findForward("pCtaGastoxMes");
    }
     
     public void setDataCta(int tipo,ActionForm form, HttpServletRequest request)throws Exception{
        
        List listaresumen;
        RepControllerForm repForm=(RepControllerForm) form;
        ObjResumen resumen=new ObjResumen();
        resumen.setNo_cia(repForm.getNo_cia());
        resumen.setAno(Integer.parseInt(repForm.getAno()));
        resumen.setMes(Integer.parseInt(repForm.getMes()));
        logger.debug("getCtaTipo "+tipo+" -> no_cia :"+resumen.getNo_cia());
        logger.debug("getCtaTipo "+tipo+" -> Ano :"+resumen.getAno());
        logger.debug("getCtaTipo "+tipo+" -> Mes :"+resumen.getMes());
        if(tipo==1){
          listaresumen=repService.getCtaBalancePorMes(resumen);
          request.setAttribute("CtaBalancePorMes",listaresumen);
        }else{
          listaresumen=repService.getCtaGastoPorMes(resumen);
          request.setAttribute("CtaGastoPorMes",listaresumen);
        }
        
        // Mostrar parametros 
        Compania cia=repService.getCompaniaSisplan(Integer.parseInt(resumen.getNo_cia()));
        HashMap params=new HashMap();
        params.put("Compania",cia.getNombre());
        params.put("Ano",resumen.getAno());
        params.put("Mes",Util.getMesNombre(resumen.getMes()));
        request.setAttribute("params",params); 
              
     }
    
     public ActionForward showParamsIngSctrVleyEss(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("showParamsCtaGastoPorMes");
        
        List listaCias=repService.getCompaniasSisplan();
        List years=repService.getYears();
        
        request.setAttribute("cias",listaCias);
        request.setAttribute("years",years);
   
     return mapping.findForward("pIngSctrVleyEss");
    }
    
     public ActionForward getIngSctrVleyEss(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getIngSctrVleyEss");
        RepControllerForm repForm=(RepControllerForm) form;
        ObjResumen resumen=new ObjResumen();
        resumen.setNo_cia(repForm.getNo_cia());
        resumen.setAno(Integer.parseInt(repForm.getAno()));
        logger.debug("getIngSctrVleyEss-> no_cia :"+resumen.getNo_cia());
        logger.debug("getIngSctrVleyEss-> Ano :"+resumen.getAno());
        List listaresumen=repService.getIngSctrVleyEss(resumen);
        request.setAttribute("IngSctrVleyEss",listaresumen);
        // Mostrar parametros 
        Compania cia=repService.getCompaniaSisplan(Integer.parseInt(resumen.getNo_cia()));
        HashMap params=new HashMap();
        params.put("Compania",cia.getNombre());
        params.put("Ano",resumen.getAno());
        
        request.setAttribute("params",params);
        return mapping.findForward("IngSctrVleyEss");
        
     }
     
      public ActionForward showParamsKardexTrabCCosto(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        logger.debug("showParamsKardexTrabCCosto");
        
        List listaCias=repService.getCompaniasSisplan();
        List years=repService.getYears();
        
        request.setAttribute("cias",listaCias);
        request.setAttribute("years",years);
   
     return mapping.findForward("pKardexTrabCCosto");
    }
    
    public ActionForward getKardexTrabCCosto(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("getKardexTrabCCosto");
        RepControllerForm repForm=(RepControllerForm) form;
        ObjResumen resumen=new ObjResumen();
        resumen.setNo_cia(repForm.getNo_cia());
        resumen.setAno(Integer.parseInt(repForm.getAno()));
        resumen.setMes(Integer.parseInt(repForm.getMes()));
        logger.debug("getKardexTrabCCosto-> no_cia :"+resumen.getNo_cia());
        logger.debug("getKardexTrabCCosto-> Ano :"+resumen.getAno());
        logger.debug("getKardexTrabCCosto-> Mes :"+resumen.getMes());
        List listaresumen=repService.getKardexTrabCCosto(resumen);
        request.setAttribute("KardexTrabCCosto",listaresumen);
        // Mostrar parametros 
        Compania cia=repService.getCompaniaSisplan(Integer.parseInt(resumen.getNo_cia()));
        HashMap params=new HashMap();
        params.put("Compania",cia.getNombre());
        params.put("Ano",resumen.getAno());
        params.put("Mes",Util.getMesNombre(resumen.getMes()));
        params.put("CiaAbrev",Util.toInitCap(cia.getNombre()));
        request.setAttribute("params",params);
        
        return mapping.findForward("KardexTrabCCosto");
        
     }
    
}
