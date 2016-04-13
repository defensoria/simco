/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroActividad;
import gob.dp.simco.registro.dao.ActividadDao;
import gob.dp.simco.registro.entity.Actividad;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActividadServiceImpl implements ActividadService{
    
    private static final Logger log = Logger.getLogger(ActividadServiceImpl.class);
    
    @Autowired
    private ActividadDao actividadDao;

    @Override
    public void actividadNuevo(Actividad actividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadNuevo");
        actividadDao.actividadInsertar(actividad);
    }

    @Override
    public void actividadModificar(Actividad actividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadModificar");
        actividadDao.actividadUpdate(actividad);
    }

    @Override
    public List<Actividad> actividadBuscar(FiltroActividad filtroActividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadBuscar");
        return actividadDao.actividadBuscar(filtroActividad);
    }

    @Override
    public Integer actividadTotalBuscar(FiltroActividad filtroActividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadTotalBuscar");
        return actividadDao.actividadTotalBuscar(filtroActividad);
    }

    @Override
    public Actividad actividadBuscarOne(Long idActividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadBuscarOne");
        Actividad actividad = new Actividad();
        actividad.setId(idActividad);
        return actividadDao.actividadBuscarOne(actividad);
    }

    @Override
    public List<Actividad> actividadxActividadBuscar(Long idActividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxActividadBuscar");
        return actividadDao.actividadxActividadBuscar(idActividad);
    }

    @Override
    public List<Actividad> actividadxActividadBuscarTotal(Long idActividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxActividadBuscarTotal");
        return actividadDao.actividadxActividadBuscarTotal(idActividad);
    }

    @Override
    public List<Actividad> actividadxActorBuscar(Long idActor) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxActorBuscar");
        return actividadDao.actividadxActorBuscar(idActor);
    }

    @Override
    public List<Actividad> actividadxActorBuscarTotal(Long idActor) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxActorBuscarTotal");
        return actividadDao.actividadxActorBuscarTotal(idActor);
    }

    @Override
    public List<Actividad> actividadxCasoBuscar(Long idCaso) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxCasoBuscar");
        return actividadDao.actividadxCasoBuscar(idCaso);
    }

    @Override
    public List<Actividad> actividadxCasoBuscarTotal(Long idCaso) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxCasoBuscarTotal");
        return actividadDao.actividadxCasoBuscarTotal(idCaso);
    }

    @Override
    public List<Actividad> actividadxActaAcuerdoBuscar(Long idActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxActaAcuerdoBuscar");
        return actividadDao.actividadxActaAcuerdoBuscar(idActaAcuerdo);
    }

    @Override
    public List<Actividad> actividadxActaAcuerdoBuscarTotal(Long idActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxActaAcuerdoBuscarTotal");
        return actividadDao.actividadxActaAcuerdoBuscarTotal(idActaAcuerdo);
    }

    @Override
    public List<Actividad> actividadxMedioVerificacionBuscar(Long idMedioVerificacion) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxMedioVerificacionBuscar");
        return actividadDao.actividadxMedioVerificacionBuscar(idMedioVerificacion);
    }

    @Override
    public List<Actividad> actividadxMedioVerificacionBuscarTotal(Long idMedioVerificacion) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadxMedioVerificacionBuscarTotal");
        return actividadDao.actividadxMedioVerificacionBuscarTotal(idMedioVerificacion);
    }

    @Override
    public List<Actividad> actividadBusquedaPaginado(FiltroActividad filtroActividad) throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadBusquedaPaginado");
        return actividadDao.actividadBusquedaPaginado(filtroActividad);
    }

    @Override
    public String actividadBusquedaPaginadoAutocompletar() throws Exception {
        log.debug("METODO : ActividadServiceImpl.actividadBusquedaPaginadoAutocompletar");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var projects2 = [");
        int i = 0;
        FiltroActividad fa = new FiltroActividad();
        for(Actividad a:actividadDao.actividadBusquedaPaginado(fa)){
            if(i > 0)
            stringBuilder.append(",");    
            stringBuilder.append("{value: ").append(a.getId()).append(",");
            stringBuilder.append("label: '").append(a.getNombre()).append("' ,");
            stringBuilder.append("desc: ").append("''").append(",");
            stringBuilder.append("icon: ").append("'' },");
            
        }
        stringBuilder.append("];");
        return stringBuilder.toString();
    }

    @Override
    public List<Actividad> actividadBusquedaSinCaso(int tipo) {
        log.debug("METODO : ActividadServiceImpl.actividadBusquedaSinCaso");
        if(tipo == 1){
            return actividadDao.actividadBusquedaSinCasoAC();
        }else{
            return actividadDao.actividadBusquedaSinCasoAD();
        }
        
    }

    @Override
    public List<Actividad> actividadxCasoBuscarTotalAC(Long idCaso) {
        try {
            return actividadDao.actividadxCasoBuscarTotalAC(idCaso);
        } catch (Exception ex) {
            log.error(ex.getCause());
        }
        return null;
    }

    @Override
    public List<Actividad> actividadxCasoBuscarTotalAD(Long idCaso) {
        try {
            return actividadDao.actividadxCasoBuscarTotalAD(idCaso);
        } catch (Exception ex) {
            log.error(ex.getCause());
        }
        return null;
    }

    @Override
    public Integer actividadADCodigoGenerado() {
        return actividadDao.actividadADCodigoGenerado();
    }

    @Override
    public Actividad actividadxCasoBuscarID(long idActividad) {
        return actividadDao.actividadxCasoBuscarID(idActividad);
    }

    @Override
    public List<Actividad> actividadxCodigoCasoBuscarTotal(String codigo) throws Exception {
        return actividadDao.actividadxCodigoCasoBuscarTotal(codigo);
    }

    @Override
    public List<Actividad> actividadBusquedaPorCasoAC(long idCaso) {
        return actividadDao.actividadBusquedaPorCasoAC(idCaso);
    }

    @Override
    public void actividadUpdateVincular(long idActividad) {
        actividadDao.actividadUpdateVincular(idActividad);
    }

    @Override
    public void actividadUpdateDesVincular(long idActividad) {
        actividadDao.actividadUpdateDesVincular(idActividad);
    }

    @Override
    public void actividadUpdateAcontecimiento(Actividad actividad) {
        actividadDao.actividadUpdateAcontecimiento(actividad);
    }

    @Override
    public void actividadUpdateAcontecimientoQuitar(long idActividad) {
        actividadDao.actividadUpdateAcontecimientoQuitar(idActividad);
    }

    @Override
    public Actividad actividadBusquedaPorAcontecimiento(long idAcontecimiento) {
        return actividadDao.actividadBusquedaPorAcontecimiento(idAcontecimiento);
    }
    
}
