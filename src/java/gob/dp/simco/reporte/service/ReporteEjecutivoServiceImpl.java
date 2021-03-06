/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.service;

import gob.dp.simco.reporte.dao.ReporteEjecutivoDao;
import gob.dp.simco.reporte.entity.ElementoResumenEjecutivo;
import gob.dp.simco.reporte.entity.FiltroReporte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ReporteEjecutivoServiceImpl implements ReporteEjecutivoService{
    
    @Autowired
    private ReporteEjecutivoDao reporteEjecutivoDao;

    @Override
    public Integer totalCasosRegistradosMes(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosRegistradosMes(filtroReporte);
    }

    @Override
    public Integer totalCasosActivos(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosActivos(filtroReporte);
    }

    @Override
    public Integer totalCasosLatentes(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosLatentes(filtroReporte);
    }

    @Override
    public Integer totalCasosActivosLatentes(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosActivosLatentes(filtroReporte);
    }

    @Override
    public Integer totalCasosLatentesObservacion(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosLatentesObservacion(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosDialogo(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosDialogo(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosActivo(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosActivo(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosDialogoProceso(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosDialogoProceso(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosReunionesPreparatorias(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosReunionesPreparatorias(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosParticipacionDefensoria(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosParticipacionDefensoria(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosEchoViolencia(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosEchoViolencia(filtroReporte);
    }

    @Override
    public Integer totalCasosRegistrados(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosRegistrados(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosAccionesProtesta(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosAccionesProtesta(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosActuacionDefensorial(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosActuacionDefensorial(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosActuacionDefensorialSupervisionPreventiva(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosActuacionDefensorialSupervisionPreventiva(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosActuacionDefensorialIntermediaciones(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosActuacionDefensorialIntermediaciones(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosActuacionDefensorialAccionHumanitaria(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosActuacionDefensorialAccionHumanitaria(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosActuacionDefensorialDefensaLegal(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosActuacionDefensorialDefensaLegal(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosFaceEscalamiento(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosFaceEscalamiento(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosFaceTemprana(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosFaceTemprana(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosFaceDesescalamiento(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosFaceDesescalamiento(filtroReporte);
    }

    @Override
    public Integer totalGeneralCasosFaceCrisis(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalGeneralCasosFaceCrisis(filtroReporte);
    }

    @Override
    public Integer totalCasosResueltos(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosResueltos(filtroReporte);
    }

    @Override
    public Integer totalCasosPropuestos(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosPropuestos(filtroReporte);
    }

    @Override
    public String cadenaNombreCasosResueltos(FiltroReporte filtroReporte) {
        List<ElementoResumenEjecutivo> list = reporteEjecutivoDao.cadenaNombreCasosResueltos(filtroReporte);
        StringBuilder cadenaNombre = new StringBuilder();
        for(ElementoResumenEjecutivo ere : list){
            cadenaNombre.append(ere.getCadenaNombreCaso()+", ");
        }
        String cadenaNueva = cadenaNombre.substring(0, cadenaNombre.length()-2); 
        return cadenaNueva.toString();
    }

    @Override
    public String cadenaNombreCasosPropuestos(FiltroReporte filtroReporte) {
        List<ElementoResumenEjecutivo> list =  reporteEjecutivoDao.cadenaNombreCasosPropuestos(filtroReporte);
        StringBuilder cadenaNombre = new StringBuilder();
        for(ElementoResumenEjecutivo ere : list){
            cadenaNombre.append(ere.getCadenaNombreCaso()+", ");
        }
        String cadenaNueva = cadenaNombre.substring(0, cadenaNombre.length()-2); 
        return cadenaNueva.toString();
    }

    @Override
    public List<ElementoResumenEjecutivo> totalMensualCasosRegistrados(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalMensualCasosRegistrados(filtroReporte);
    }

    @Override
    public List<ElementoResumenEjecutivo> totalMensualCasosActivos(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalMensualCasosActivos(filtroReporte);
    }

    @Override
    public Integer totalCasosTotales(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalCasosTotales(filtroReporte);
    }

    @Override
    public List<ElementoResumenEjecutivo> totalMensualNivelGobierno(FiltroReporte filtroReporte) {
        return reporteEjecutivoDao.totalMensualNivelGobierno(filtroReporte);
    }
    
}
