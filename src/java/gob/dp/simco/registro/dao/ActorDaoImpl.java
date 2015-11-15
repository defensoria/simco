/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.bean.FiltroActor;
import gob.dp.simco.registro.entity.Actor;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActorDaoImpl extends SqlSessionDaoSupport implements ActorDao {
    
    private static final Logger log = Logger.getLogger(ActorDaoImpl.class);

    @Override
    public void actorInsertar(Actor actor) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActorDao.actorInsertar", actor);
    }

    @Override
    public void actorUpdate(Actor actor) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActorDao.actorUpdate", actor);
    }

    @Override
    public List<Actor> actorBuscar(FiltroActor filtroActor) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorBuscar",filtroActor);
    }

    @Override
    public Integer actorTotalBuscar(FiltroActor filtroActor) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorTotalBuscar");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorTotalBuscar",filtroActor);
    }

    @Override
    public List<Actor> actorxActividadBuscar(Long idActividad) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorxActividadBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxActividadBuscar",idActividad);
    }

    @Override
    public List<Actor> actorxActividadBuscarTotal(Long idActividad) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorxActividadBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxActividadBuscarTotal",idActividad);
    }

    @Override
    public Actor actorBuscarOne(Actor actor) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorBuscarOne");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorBuscarOne",actor);
    }

    @Override
    public List<Actor> actorBuscarPaginado(FiltroActor filtroActor) throws Exception {
        log.debug("METODO : ActorDaoImpl.actorBuscarPaginado");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorBuscarPaginado",filtroActor);
    }

    @Override
    public List<Actor> actorxAcuerdoDetalleBusqueda(Long idAcuerdoDetalle) {
        log.debug("METODO : ActorDaoImpl.actorxAcuerdoDetalleBusqueda");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxAcuerdoDetalleBusqueda",idAcuerdoDetalle);
    }

    @Override
    public List<Actor> actorxCasoBuscar(Long idCaso) {
        log.debug("METODO : ActorDaoImpl.actorxCasoBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxCasoBuscar",idCaso);
    }

    @Override
    public List<Actor> actorxCasoIntensidadBuscar(Long idCaso) {
        log.debug("METODO : ActorDaoImpl.actorxCasoIntensidadBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxCasoIntensidadBuscar",idCaso);
    }

    @Override
    public List<Actor> actorTodosBuscar() {
        log.debug("METODO : ActorDaoImpl.actorTodosBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorTodosBuscar");
    }
    
    @Override
    public List<Actor> actorBuscarEmpresaEntidad() {
        log.debug("METODO : ActorDaoImpl.actorBuscarEmpresaEntidad");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorBuscarEmpresaEntidad");
    }

    @Override
    public List<Actor> actorXactividadSimpleBuscar(Long id) {
        log.debug("METODO : ActorDaoImpl.actorXactividadSimpleBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorXactividadSimpleBuscar",id);
    }

    @Override
    public List<Actor> actorBuscarSimple(Actor actor) {
        log.debug("METODO : ActorDaoImpl.actorBuscarSimple");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorBuscarSimple",actor);
    }

    @Override
    public Actor actorBuscarTotalSimple(Actor actor) {
        log.debug("METODO : ActorDaoImpl.actorBuscarTotalSimple");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorBuscarTotalSimple",actor);
    }

    @Override
    public Integer actorBuscarTotalSimpleCount(Actor actor) {
        log.debug("METODO : ActorDaoImpl.actorBuscarTotalSimpleCount");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorBuscarTotalSimpleCount",actor);
    }
    
    @Override
    public Integer actorBuscarTotalSimpleCountRUC(Actor actor) {
        log.debug("METODO : ActorDaoImpl.actorBuscarTotalSimpleCountRUC");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorBuscarTotalSimpleCountRUC",actor);
    }

    @Override
    public List<Actor> actorxActaAcuerdoBuscar(long idAcuerdoDetalle) {
        log.debug("METODO : ActorDaoImpl.actorxActaAcuerdoBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxActaAcuerdoBuscar",idAcuerdoDetalle);
    }

    @Override
    public List<Actor> actorxAcuerdoDetalleBusquedaFin(Long idAcuerdoDetalle) {
        log.debug("METODO : ActorDaoImpl.actorxAcuerdoDetalleBusquedaFin");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actorxAcuerdoDetalleBusquedaFin",idAcuerdoDetalle);
    }

    @Override
    public int actorValidadDNI(Actor actor) {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorValidadDNI",actor);
    }

    @Override
    public int actorValidadRUC(Actor actor) {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActorDao.actorValidadRUC",actor);
    }

    @Override
    public List<Actor> actoresSigues(String codigoUsuario) {
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorDao.actoresSigues",codigoUsuario);
    }
    
}
