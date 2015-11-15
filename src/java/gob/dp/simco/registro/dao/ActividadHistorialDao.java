/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActividadHistorial;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ActividadHistorialDao {
    
    public void actividadHistorialInsertar(ActividadHistorial historial) throws Exception;
    
    public List<ActividadHistorial> actividadHistorialBuscarList(Long idActividad) throws Exception;
    
}
