/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.manpower.sisplan.persistence;

import com.pe.manpower.sisplan.to.Compania;
import com.pe.manpower.sisplan.to.Correntista;
import com.pe.manpower.sisplan.to.MvmntosCrdtoTO;
import java.util.List;

public interface MvmntosCrdtoDAO {
    public List getMvmntosByDate(MvmntosCrdtoTO mov);
    public List getCompanias();
    public List getCorrentistas();
    public Compania getCompania(Integer codigo);
    public Correntista getCorrentista(Integer correntista);
    
}
