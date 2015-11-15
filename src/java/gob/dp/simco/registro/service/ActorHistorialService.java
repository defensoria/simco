/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.entity.ActorHistorial;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ActorHistorialService {
    
    public void actorHistorialInsertar(ActorHistorial historial) throws Exception;
    
    public List<ActorHistorial> actorHistorialBuscarList(Long idActor) throws Exception;
}
