/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.service.impl;

import com.pe.manpower.sisplan.persistence.MvmntosCrdtoDAO;
import com.pe.manpower.sisplan.service.MvmntosCrdtoService;
import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Correntista;
import com.pe.manpower.sisplan.to.MvmntosCrdtoTO;
import java.util.List;

/**
 *
 * @author G-AMARO
 */
public class MvmntosCrdtoImplService implements MvmntosCrdtoService {
     private MvmntosCrdtoDAO dao;

    public MvmntosCrdtoImplService(MvmntosCrdtoDAO dao) {
        this.dao = dao;
    }

    @Override
    public List getMvmntosByDate(MvmntosCrdtoTO mov) {
        return dao.getMvmntosByDate(mov);
    }

    @Override
    public List getCompanias() {
       return dao.getCompanias();
    }

    @Override
    public List getCorrentistas() {
        return dao.getCorrentistas();
    }

    @Override
    public Correntista getCorrentista(Integer correntista) {
        return dao.getCorrentista(correntista);
    }

    @Override
    public Compania getCompania(Integer codigo) {
        return dao.getCompania(codigo);
    }

    
}
