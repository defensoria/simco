/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.investigacion.service;

import gob.dp.simco.investigacion.dao.HistorialActividadDAO;
import gob.dp.simco.investigacion.entity.HistorialActividad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class HistorialActividadServiceImpl implements HistorialActividadService{

    @Autowired
    private HistorialActividadDAO actividadDAO;
    
    @Override
    public void historialActividadInsert(HistorialActividad historialActividad) {
        actividadDAO.historialActividadInsert(historialActividad);
    }

    @Override
    public List<HistorialActividad> historialActividadBuscar(Long idInvestigacion) {
        return actividadDAO.historialActividadBuscar(idInvestigacion);
    }
    
}
