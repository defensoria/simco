/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.entity.ActividadActaAcuerdo;

/**
 *
 * @author carlos
 */
public interface ActividadActaAcuerdoService {
    
   public void actividadActaAcuerdoInsertarUpdate(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception;
   
   public void actividadActaAcuerdoUpdate(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception;
   
   public void actividadActaAcuerdoDelete(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception;
    
}
