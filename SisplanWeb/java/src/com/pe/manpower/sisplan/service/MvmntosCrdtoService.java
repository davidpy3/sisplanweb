/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.service;

import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Correntista;
import com.pe.manpower.sisplan.to.MvmntosCrdtoTO;
import java.util.List;

/**
 *
 * @author G-AMARO
 */
public interface MvmntosCrdtoService {
    
    public List getMvmntosByDate(MvmntosCrdtoTO mov);
    public List getCompanias();
    public List getCorrentistas();
    public Correntista getCorrentista(Integer correntista);
    public Compania getCompania(Integer codigo);
    
}
