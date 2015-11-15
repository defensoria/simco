/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroCasoActor;
import gob.dp.simco.registro.dao.ActividadActorDao;
import gob.dp.simco.registro.entity.ActividadActor;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActividadActorServiceImpl implements ActividadActorService{
    
    private static final Logger log = Logger.getLogger(ActividadActorServiceImpl.class);
    
    @Autowired
    private ActividadActorDao actividadActorDao;

    @Override
    public void actividadActorInsertar(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorServiceImpl.actividadActorInsertar");
        actividadActor.setEstado("ACT");
        actividadActorDao.actividadActorInsertar(actividadActor);
    }

    @Override
    public void actividadActorUpdate(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorServiceImpl.actividadActorUpdate");
        actividadActorDao.actividadActorUpdate(actividadActor);
    }

    @Override
    public void actividadActorDelete(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorServiceImpl.actividadActorDelete");
        actividadActorDao.actividadActorDelete(actividadActor);
    }

    @Override
    public void saveOrUpdate(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorServiceImpl.saveOrUpdate");
        Integer count = actividadActorDao.actividadActorBuscarOne(actividadActor);
        if(count == 0)
            actividadActorInsertar(actividadActor);
        else
            actividadActorUpdate(actividadActor);
    }

    @Override
    public List<ActividadActor> actividadActorXcaso(FiltroCasoActor filtroCasoActor) {
        log.debug("METODO : ActividadActorServiceImpl.actividadActorXcaso");
        return actividadActorDao.actividadActorXcaso(filtroCasoActor);
    }

    @Override
    public List<ActividadActor> actividadActorNivelAD(ActividadActor actividadActor) {
        return actividadActorDao.actividadActorNivelAD(actividadActor);
    }
    
}
