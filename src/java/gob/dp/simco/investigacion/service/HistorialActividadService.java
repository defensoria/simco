/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.investigacion.service;

import gob.dp.simco.investigacion.entity.HistorialActividad;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface HistorialActividadService {
    
    public void historialActividadInsert(HistorialActividad historialActividad);
    
    public List<HistorialActividad> historialActividadBuscar(Long idInvestigacion);
    
}
