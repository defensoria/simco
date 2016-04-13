/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.bean.FiltroActividad;
import gob.dp.simco.registro.entity.Actividad;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActividadDaoImpl extends SqlSessionDaoSupport implements ActividadDao{
    
    private static final Logger log = Logger.getLogger(ActividadDaoImpl.class);

    @Override
    public void actividadInsertar(Actividad actividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActividadDao.actividadInsertar", actividad);
    }

    @Override
    public void actividadUpdate(Actividad actividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadDao.actividadUpdate", actividad);
    }

    @Override
    public List<Actividad> actividadBuscar(FiltroActividad filtroActividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadBuscar",filtroActividad);
    }

    @Override
    public Integer actividadTotalBuscar(FiltroActividad filtroActividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadTotalBuscar");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadDao.actividadTotalBuscar",filtroActividad);
    }

    @Override
    public Actividad actividadBuscarOne(Actividad actividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadBuscar");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadDao.actividadBuscarOne",actividad);
    }

    @Override
    public List<Actividad> actividadxActividadBuscar(Long idActividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxActividadBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxActividadBuscar",idActividad);
    }

    @Override
    public List<Actividad> actividadxActividadBuscarTotal(Long idActividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxActividadBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxActividadBuscarTotal",idActividad);
    }
    
    @Override
    public List<Actividad> actividadxActorBuscar(Long idActor) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxActorBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxActorBuscar",idActor);
    }

    @Override
    public List<Actividad> actividadxActorBuscarTotal(Long idActor) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxActorBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxActorBuscarTotal",idActor);
    }

    @Override
    public List<Actividad> actividadxCasoBuscar(Long idCaso) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxCasoBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxCasoBuscar",idCaso);
    }

    @Override
    public List<Actividad> actividadxCasoBuscarTotal(Long idCaso) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxCasoBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxCasoBuscarTotal",idCaso);
    }

    @Override
    public List<Actividad> actividadxActaAcuerdoBuscar(Long idActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxActaAcuerdoBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxActaAcuerdoBuscar",idActaAcuerdo);
    }

    @Override
    public List<Actividad> actividadxActaAcuerdoBuscarTotal(Long idActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxActaAcuerdoBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxActaAcuerdoBuscarTotal",idActaAcuerdo);
    }

    @Override
    public List<Actividad> actividadxMedioVerificacionBuscar(Long idMedioVerificacion) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxMedioVerificacionBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxMedioVerificacionBuscar",idMedioVerificacion);
    }

    @Override
    public List<Actividad> actividadxMedioVerificacionBuscarTotal(Long idMedioVerificacion) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxMedioVerificacionBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxMedioVerificacionBuscarTotal",idMedioVerificacion);
    }

    @Override
    public List<Actividad> actividadBusquedaPaginado(FiltroActividad filtroActividad) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadBusquedaPaginado");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadBusquedaPaginado",filtroActividad);
    }

    @Override
    public List<Actividad> actividadBusquedaSinCasoAC() {
        log.debug("METODO : ActividadDaoImpl.actividadBusquedaSinCasoAC");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadBusquedaSinCasoAC");
    }

    @Override
    public List<Actividad> actividadBusquedaSinCasoAD() {
        log.debug("METODO : ActividadDaoImpl.actividadBusquedaSinCasoAD");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadBusquedaSinCasoAD");
    }

    @Override
    public List<Actividad> actividadxCasoBuscarTotalAC(Long idCaso) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxCasoBuscarTotalAC");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxCasoBuscarTotalAC",idCaso);
    }

    @Override
    public List<Actividad> actividadxCasoBuscarTotalAD(Long idCaso) throws Exception {
        log.debug("METODO : ActividadDaoImpl.actividadxCasoBuscarTotalAD");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxCasoBuscarTotalAD",idCaso);
    }

    @Override
    public int actividadADCodigoGenerado() {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadDao.actividadADCodigoGenerado");
    }

    @Override
    public Actividad actividadxCasoBuscarID(long idActividad) {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadDao.actividadxCasoBuscarID",idActividad);
    }

    @Override
    public List<Actividad> actividadxCodigoCasoBuscarTotal(String codigo) throws Exception {
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadxCodigoCasoBuscarTotal",codigo);
    }

    @Override
    public List<Actividad> actividadBusquedaPorCasoAC(long idCaso) {
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadDao.actividadBusquedaPorCasoAC",idCaso);
    }

    @Override
    public void actividadUpdateAcontecimiento(Actividad actividad) {
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadDao.actividadUpdateAcontecimiento", actividad);
    }

    @Override
    public void actividadUpdateVincular(long idActividad) {
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadDao.actividadUpdateVincular", idActividad);
    }

    @Override
    public void actividadUpdateDesVincular(long idActividad) {
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadDao.actividadUpdateDesVincular", idActividad);
    }

    @Override
    public void actividadUpdateAcontecimientoQuitar(long idActividad) {
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadDao.actividadUpdateAcontecimientoQuitar", idActividad);
    }

    @Override
    public Actividad actividadBusquedaPorAcontecimiento(long idAcontecimiento) {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadDao.actividadBusquedaPorAcontecimiento",idAcontecimiento);
    }
    
}
