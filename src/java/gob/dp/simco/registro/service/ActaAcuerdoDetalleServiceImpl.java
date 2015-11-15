/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao;
import gob.dp.simco.registro.dao.ActorDao;
import gob.dp.simco.registro.entity.ActaAcuerdoDetalle;
import gob.dp.simco.registro.entity.Actor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActaAcuerdoDetalleServiceImpl implements ActaAcuerdoDetalleService{
    
    private static final Logger log = Logger.getLogger(ActaAcuerdoDetalleServiceImpl.class);
    
    @Autowired
    private ActaAcuerdoDetalleDao actaAcuerdoDetalleDao;
    
    @Autowired
    private ActorDao actorDao;

    @Override
    public void actaAcuerdoDetalleInsertar(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleInsertar");
        actaAcuerdoDetalle.setFechaRegistro(new Date());
        actaAcuerdoDetalleDao.actaAcuerdoDetalleInsertar(actaAcuerdoDetalle);
    }

    @Override
    public void actaAcuerdoDetalleUpdate(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleInsertar");
        actaAcuerdoDetalleDao.actaAcuerdoDetalleUpdate(actaAcuerdoDetalle);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleBuscarxActa(Long idActaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleBuscarxActa");
        return actaAcuerdoDetalleDao.actaAcuerdoDetalleBuscarxActa(idActaAcuerdoDetalle);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleSeguimiento(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleSeguimiento");
        List<ActaAcuerdoDetalle> acuerdoDetalles = actaAcuerdoDetalleDao.actaAcuerdoDetalleSeguimiento(actaAcuerdoDetalle);
        List<ActaAcuerdoDetalle> aads = new ArrayList<>();
        for(ActaAcuerdoDetalle aad : acuerdoDetalles){
            List<Actor> list = actorDao.actorxAcuerdoDetalleBusqueda(aad.getId());
            aad.setListaActor(list);
            aads.add(aad);
        }
        return aads;
    }

    @Override
    public void actaAcuerdoDetalleDelete(long id) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleDelete");
        actaAcuerdoDetalleDao.actaAcuerdoDetalleDelete(id);
    }

    @Override
    public void actaAcuerdoDetalleUpdateColor(ActaAcuerdoDetalle aad) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleUpdateColor");
        actaAcuerdoDetalleDao.actaAcuerdoDetalleUpdateColor(aad);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleListaxActa(Long idActaAcuerdo) {
        log.debug("METODO : ActaAcuerdoDetalleServiceImpl.actaAcuerdoDetalleListaxActa");
        return actaAcuerdoDetalleDao.actaAcuerdoDetalleListaxActa(idActaAcuerdo);
    }

    @Override
    public Integer actaAcuerdoDetalleCodigoGenerado() {
        return actaAcuerdoDetalleDao.actaAcuerdoDetalleCodigoGenerado();
    }

    @Override
    public Integer actaAcuerdoDetalleCount(Long idActividad) {
        return actaAcuerdoDetalleDao.actaAcuerdoDetalleCount(idActividad);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleSeguimientoCaso(long idCaso) {
        List<ActaAcuerdoDetalle> acuerdoDetalles = actaAcuerdoDetalleDao.actaAcuerdoDetalleSeguimientoCaso(idCaso);
        List<ActaAcuerdoDetalle> aads = new ArrayList<>();
        for(ActaAcuerdoDetalle aad : acuerdoDetalles){
            List<Actor> list = actorDao.actorxAcuerdoDetalleBusqueda(aad.getId());
            aad.setListaActor(list);
            aads.add(aad);
        }
        return aads;
    }
}
