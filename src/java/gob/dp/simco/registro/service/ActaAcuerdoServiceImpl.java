/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActaAcuerdoDao;
import gob.dp.simco.registro.entity.ActaAcuerdo;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActaAcuerdoServiceImpl implements ActaAcuerdoService{
    
    private static final Logger log = Logger.getLogger(ActaAcuerdoServiceImpl.class);
    
    @Autowired
    private ActaAcuerdoDao actaAcuerdoDao;

    @Override
    public void actaAcuerdoNuevo(ActaAcuerdo actaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoServiceImpl.actaAcuerdoNuevo");
        actaAcuerdoDao.actaAcuerdoInsertar(actaAcuerdo);
    }

    @Override
    public void actaAcuerdoModificar(ActaAcuerdo actaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoServiceImpl.actaAcuerdoModificar");
        actaAcuerdoDao.actaAcuerdoUpdate(actaAcuerdo);
    }

    @Override
    public List<ActaAcuerdo> actaAcuerdoxActividadBuscar(long idActividad) throws Exception {
        log.debug("METODO : ActaAcuerdoServiceImpl.actaAcuerdoxActividadBuscar");
        return actaAcuerdoDao.actaAcuerdoxActividadBuscar(idActividad);
    }

    @Override
    public List<ActaAcuerdo> actaAcuerdoxActividadBuscarTotal(long idActividad) throws Exception {
        log.debug("METODO : ActaAcuerdoServiceImpl.actaAcuerdoxActividadBuscarTotal");
        return actaAcuerdoDao.actaAcuerdoxActividadBuscarTotal(idActividad);
    }

    @Override
    public ActaAcuerdo actaAcuerdoBuscarOne(Long idActaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoServiceImpl.actaAcuerdoBuscarOne");
        ActaAcuerdo actaAcuerdo = new ActaAcuerdo();
        actaAcuerdo.setId(idActaAcuerdo);
        return actaAcuerdoDao.actaAcuerdoBuscarOne(actaAcuerdo);
    }

    @Override
    public ActaAcuerdo actaAcuerdoxActividadBuscarOne(long idActividad) throws Exception {
        return actaAcuerdoDao.actaAcuerdoxActividadBuscarOne(idActividad);
    }

    @Override
    public Integer actaAcuerdoCodigoGenerado() {
        return actaAcuerdoDao.actaAcuerdoCodigoGenerado();
    }
    
}
