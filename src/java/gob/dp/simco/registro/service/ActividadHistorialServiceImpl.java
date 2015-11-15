/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActividadHistorialDao;
import gob.dp.simco.registro.entity.ActividadHistorial;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActividadHistorialServiceImpl implements ActividadHistorialService{
    
    private static final Logger log = Logger.getLogger(ActividadHistorialServiceImpl.class);
    
    @Autowired
    private ActividadHistorialDao actividadHistorialDao;

    @Override
    public void actividadHistorialInsertar(ActividadHistorial historial) throws Exception {
        log.debug("METODO : ActividadHistorialServiceImpl.actividadHistorialInsertar");
        actividadHistorialDao.actividadHistorialInsertar(historial);
    }

    @Override
    public List<ActividadHistorial> actividadHistorialBuscarList(Long idActividad) throws Exception {
        log.debug("METODO : ActividadHistorialServiceImpl.actividadHistorialBuscarList");
        return actividadHistorialDao.actividadHistorialBuscarList(idActividad);
    }
    
}
