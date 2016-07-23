/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActorHistorialDao;
import gob.dp.simco.registro.entity.ActorHistorial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActorHistorialServiceImpl implements ActorHistorialService{
    
    @Autowired
    private ActorHistorialDao actorHistorialDao;

    @Override
    public void actorHistorialInsertar(ActorHistorial historial) {
        actorHistorialDao.actorHistorialInsertar(historial);
    }

    @Override
    public List<ActorHistorial> actorHistorialBuscarList(Long idActor) {
        return actorHistorialDao.actorHistorialBuscarList(idActor);
    }
    
}
