/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActividadCasoDao;
import gob.dp.simco.registro.entity.ActividadCaso;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActividadCasoServiceImpl implements ActividadCasoService{
    
    private static final Logger log = Logger.getLogger(ActividadActorServiceImpl.class);
    
    @Autowired
    private ActividadCasoDao actividadCasoDao;

    @Override
    public void actividadCasoInsertar(ActividadCaso actividadCaso) {
        log.debug("METODO : ActividadCasoServiceImpl.actividadCasoInsertar");
        actividadCasoDao.actividadCasoInsertar(actividadCaso);
    }

    @Override
    public void actividadCasoUpdate(ActividadCaso actividadCaso){
        log.debug("METODO : ActividadCasoServiceImpl.actividadCasoUpdate");
        actividadCasoDao.actividadCasoUpdate(actividadCaso);
    }

    @Override
    public void actividadCasoDelete(ActividadCaso actividadCaso){
        log.debug("METODO : ActividadCasoServiceImpl.actividadCasoDelete");
        actividadCasoDao.actividadCasoDelete(actividadCaso);
    }

    @Override
    public int actividadCasoValida(long idActividad) {
        return actividadCasoDao.actividadCasoValida(idActividad);
    }
    
}
