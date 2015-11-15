/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.service;

import gob.dp.simco.intervencion.dao.IntervencionHistorialActDao;
import gob.dp.simco.intervencion.entity.IntervencionHistorialAct;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class IntervencionHistorialActServiceImpl implements IntervencionHistorialActService{
    
    private static final Logger log = Logger.getLogger(IntervencionMiembroServiceImpl.class);
    
    @Autowired
    private IntervencionHistorialActDao intervencionHistorialActDao;

    @Override
    public void intervencionHistorialActInsertar(IntervencionHistorialAct intervencionHistorialAct) {
        log.debug("METODO : IntervencionHistorialActServiceImpl.intervencionHistorialActInsertar");
        intervencionHistorialActDao.intervencionHistorialActInsertar(intervencionHistorialAct);
    }

    @Override
    public List<IntervencionHistorialAct> intervencionHistorialActBuscar(long idEtapa) {
        log.debug("METODO : IntervencionHistorialActServiceImpl.intervencionHistorialActBuscar");
        return intervencionHistorialActDao.intervencionHistorialActBuscar(idEtapa);
    }
    
}
