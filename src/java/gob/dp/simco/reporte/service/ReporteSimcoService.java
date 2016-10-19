/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.service;

import gob.dp.simco.reporte.entity.ReporteSimco;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ReporteSimcoService {
    
    public List<ReporteSimco> reporteCasos(ReporteSimco reporteSimco);
    
    public Integer cantidadAcuerdosCaso(long idCaso);
    
    public Integer cantidadEmpresaMineraCaso(String codigoCaso);
    
    public Integer cantidadMuertosHeridos(String codigoCaso, String estado, String estadoTipo);
    
}
