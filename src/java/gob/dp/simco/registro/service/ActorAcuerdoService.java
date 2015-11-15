/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.entity.ActorAcuerdo;

/**
 *
 * @author carlos
 */
public interface ActorAcuerdoService {
    
   public void actorAcuerdoInsertar(ActorAcuerdo actorAcuerdo) throws Exception;
   
   public void actorAcuerdoUpdate(ActorAcuerdo actorAcuerdo) throws Exception;
   
   public Integer actorAcuerdoValida(ActorAcuerdo actorAcuerdo) throws Exception;
   
   public void actorAcuerdoDelete(Long idActaAcuerdoDetalle) throws Exception;
   
   public void actorAcuerdoAnular(Long idActaAcuerdoDetalle);
    
}
