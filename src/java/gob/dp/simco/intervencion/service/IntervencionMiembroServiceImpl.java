/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.service;

import gob.dp.simco.intervencion.dao.IntervencionMiembroDao;
import gob.dp.simco.intervencion.entity.IntervencionMiembro;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class IntervencionMiembroServiceImpl implements IntervencionMiembroService{
    
    private static final Logger log = Logger.getLogger(IntervencionMiembroServiceImpl.class);
    
    @Autowired
    private IntervencionMiembroDao intervencionMiembroDao;

    @Override
    public void intervencionMiembroInsertar(IntervencionMiembro intervencionMiembro) {
        log.debug("METODO : IntervencionMiembroServiceImpl.intervencionMiembroInsertar");
        if(intervencionMiembroDao.intervencionMiembroValidaInsert(intervencionMiembro) == 0){
            intervencionMiembroDao.intervencionMiembroInsertar(intervencionMiembro);
        }
    }

    @Override
    public List<IntervencionMiembro> intervencionMiembroBuscar(Long idEtapa) {
        log.debug("METODO : IntervencionMiembroServiceImpl.intervencionMiembroBuscar");
        return intervencionMiembroDao.intervencionMiembroBuscar(idEtapa);
    }

    @Override
    public Integer intervencionMiembroCountEtapa(Long idEtapa) {
        log.debug("METODO : IntervencionMiembroServiceImpl.intervencionMiembroCountEtapa");
        return intervencionMiembroDao.intervencionMiembroCountEtapa(idEtapa);
    }
    
}
