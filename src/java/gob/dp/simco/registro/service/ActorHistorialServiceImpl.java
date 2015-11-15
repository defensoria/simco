/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActorHistorialDao;
import gob.dp.simco.registro.entity.ActorHistorial;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActorHistorialServiceImpl implements ActorHistorialService{
    
    private static final Logger log = Logger.getLogger(ActorHistorialServiceImpl.class);
    
    @Autowired
    private ActorHistorialDao actorHistorialDao;

    @Override
    public void actorHistorialInsertar(ActorHistorial historial) throws Exception {
        log.debug("METODO : ActorHistorialServiceImpl.actorHistorialInsertar");
        actorHistorialDao.actorHistorialInsertar(historial);
    }

    @Override
    public List<ActorHistorial> actorHistorialBuscarList(Long idActor) throws Exception {
        log.debug("METODO : ActorHistorialServiceImpl.actorHistorialBuscarList");
        return actorHistorialDao.actorHistorialBuscarList(idActor);
    }
    
}
