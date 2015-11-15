/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActividadActividadDao;
import gob.dp.simco.registro.entity.ActividadActividad;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActividadActividadServiceImpl implements ActividadActividadService{
    
    private static final Logger log = Logger.getLogger(ActividadActividadServiceImpl.class);
    
    @Autowired
    private ActividadActividadDao actividadActividadDao;

    @Override
    public void actividadActividadInsertar(ActividadActividad actividadActividad) throws Exception {
        log.debug("METODO : ActividadActividadServiceImpl.actividadActividadInsertar");
        actividadActividadDao.actividadActividadInsertar(actividadActividad);
    }

    @Override
    public void actividadActividadUpdate(ActividadActividad actividadActividad) throws Exception {
        log.debug("METODO : ActividadActividadServiceImpl.actividadActividadUpdate");
        actividadActividadDao.actividadActividadUpdate(actividadActividad);
    }

    @Override
    public void actividadActividadDelete(ActividadActividad actividadActividad) throws Exception {
        log.debug("METODO : ActividadActividadServiceImpl.actividadActividadDelete");
        actividadActividadDao.actividadActividadDelete(actividadActividad);
    }
    
}
