/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.entity.ActividadActividad;

/**
 *
 * @author carlos
 */
public interface ActividadActividadService {
    
   public void actividadActividadInsertar(ActividadActividad actividadActividad) throws Exception;
   
   public void actividadActividadUpdate(ActividadActividad actividadActividad) throws Exception;
   
   public void actividadActividadDelete(ActividadActividad actividadActividad) throws Exception;
    
}
