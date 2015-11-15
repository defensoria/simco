/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.dao;

import gob.dp.simco.reporte.entity.ElementoResumenEjecutivo;
import gob.dp.simco.reporte.entity.FiltroReporte;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ReporteEjecutivoDao {
    
    public Integer totalCasosRegistradosMes(FiltroReporte filtroReporte);
    
    public Integer totalCasosActivos(FiltroReporte filtroReporte);
    
    public Integer totalCasosTotales(FiltroReporte filtroReporte);
    
    public Integer totalCasosLatentes(FiltroReporte filtroReporte);
    
    public Integer totalCasosActivosLatentes(FiltroReporte filtroReporte);
            
    public Integer totalCasosLatentesObservacion(FiltroReporte filtroReporte);  
    
    public Integer totalGeneralCasosDialogo(FiltroReporte filtroReporte);  
    
    public Integer totalGeneralCasosActivo(FiltroReporte filtroReporte);  
    
    public Integer totalGeneralCasosDialogoProceso(FiltroReporte filtroReporte);  
    
    public Integer totalGeneralCasosReunionesPreparatorias(FiltroReporte filtroReporte);  
    
    public Integer totalGeneralCasosParticipacionDefensoria(FiltroReporte filtroReporte);  
    
    public Integer totalGeneralCasosEchoViolencia(FiltroReporte filtroReporte); 
    
    public Integer totalCasosRegistrados(FiltroReporte filtroReporte); 
    
    public Integer totalGeneralCasosAccionesProtesta(FiltroReporte filtroReporte); 
    
    public Integer totalGeneralCasosActuacionDefensorial(FiltroReporte filtroReporte); 
    
    public Integer totalGeneralCasosActuacionDefensorialSupervisionPreventiva(FiltroReporte filtroReporte); 
    
    public Integer totalGeneralCasosActuacionDefensorialIntermediaciones(FiltroReporte filtroReporte); 
    
    public Integer totalGeneralCasosActuacionDefensorialAccionHumanitaria(FiltroReporte filtroReporte); 
    
    public Integer totalGeneralCasosActuacionDefensorialDefensaLegal(FiltroReporte filtroReporte);                 
    
    public Integer totalGeneralCasosFaceEscalamiento(FiltroReporte filtroReporte);
    
    public Integer totalGeneralCasosFaceTemprana(FiltroReporte filtroReporte);
    
    public Integer totalGeneralCasosFaceDesescalamiento(FiltroReporte filtroReporte);
    
    public Integer totalGeneralCasosFaceCrisis(FiltroReporte filtroReporte);
    
    public Integer totalCasosResueltos(FiltroReporte filtroReporte);
            
    public Integer totalCasosPropuestos(FiltroReporte filtroReporte);
    
    public List<ElementoResumenEjecutivo> cadenaNombreCasosResueltos(FiltroReporte filtroReporte);
            
    public List<ElementoResumenEjecutivo> cadenaNombreCasosPropuestos(FiltroReporte filtroReporte);
    
    public List<ElementoResumenEjecutivo> totalMensualCasosRegistrados(FiltroReporte filtroReporte);
    
    public List<ElementoResumenEjecutivo> totalMensualCasosActivos(FiltroReporte filtroReporte);
    
    public List<ElementoResumenEjecutivo> totalMensualNivelGobierno(FiltroReporte filtroReporte);
    
}
