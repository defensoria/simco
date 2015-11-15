/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActorAcuerdoDao;
import gob.dp.simco.registro.entity.ActorAcuerdo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActorAcuerdoServiceImpl implements ActorAcuerdoService{
    
    private static final Logger log = Logger.getLogger(ActividadServiceImpl.class);
    
    @Autowired
    private ActorAcuerdoDao actorAcuerdoDao;

    @Override
    public void actorAcuerdoInsertar(ActorAcuerdo actorAcuerdo) throws Exception {
        log.debug("METODO : ActorAcuerdoServiceImpl.actorAcuerdoInsertar");
        if(actorAcuerdoValida(actorAcuerdo) == 0)
            actorAcuerdoDao.actorAcuerdoInsertar(actorAcuerdo);
    }

    @Override
    public void actorAcuerdoUpdate(ActorAcuerdo actorAcuerdo) throws Exception {
        log.debug("METODO : ActorAcuerdoServiceImpl.actorAcuerdoUpdate");
        actorAcuerdoDao.actorAcuerdoUpdate(actorAcuerdo);
    }

    @Override
    public Integer actorAcuerdoValida(ActorAcuerdo actorAcuerdo) throws Exception {
        log.debug("METODO : ActorAcuerdoServiceImpl.actorAcuerdoValida");
        return actorAcuerdoDao.actorAcuerdoValida(actorAcuerdo);
    }

    @Override
    public void actorAcuerdoDelete(Long idActaAcuerdoDetalle) throws Exception {
        log.debug("METODO : ActorAcuerdoServiceImpl.actorAcuerdoDelete");
        actorAcuerdoDao.actorAcuerdoDelete(idActaAcuerdoDetalle);
    }

    @Override
    public void actorAcuerdoAnular(Long idActaAcuerdoDetalle) {
        log.debug("METODO : ActorAcuerdoServiceImpl.actorAcuerdoAnular");
        actorAcuerdoDao.actorAcuerdoAnular(idActaAcuerdoDetalle);
    }
    
}
