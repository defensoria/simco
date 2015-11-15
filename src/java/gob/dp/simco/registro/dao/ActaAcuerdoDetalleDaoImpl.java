/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActaAcuerdoDetalle;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActaAcuerdoDetalleDaoImpl extends SqlSessionDaoSupport implements ActaAcuerdoDetalleDao{
    
    private static final Logger log = Logger.getLogger(ActaAcuerdoDetalleDaoImpl.class);

    @Override
    public void actaAcuerdoDetalleInsertar(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleInsertar", actaAcuerdoDetalle);
    }

    @Override
    public void actaAcuerdoDetalleUpdate(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleUpdate", actaAcuerdoDetalle);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleBuscarxActa(Long idActaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleBuscarxActa");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleBuscarxActa",idActaAcuerdoDetalle);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleSeguimiento(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleSeguimiento");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleSeguimiento",actaAcuerdoDetalle);
    }

    @Override
    public void actaAcuerdoDetalleDelete(long id) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleDelete");
        getSqlSession().delete("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleDelete", id);
    }

    @Override
    public void actaAcuerdoDetalleUpdateColor(ActaAcuerdoDetalle aad) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleUpdateColor");
        getSqlSession().update("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleUpdateColor", aad);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleListaxActa(Long idActaAcuerdo) {
        log.debug("METODO : ActaAcuerdoDetalleDaoImpl.actaAcuerdoDetalleUpdateColor");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleListaxActa",idActaAcuerdo);
    }

    @Override
    public Integer actaAcuerdoDetalleCodigoGenerado() {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleCodigoGenerado");
    }

    @Override
    public Integer actaAcuerdoDetalleCount(Long idActaAcuerdo) {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleCount",idActaAcuerdo);
    }

    @Override
    public List<ActaAcuerdoDetalle> actaAcuerdoDetalleSeguimientoCaso(long idCaso) {
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDetalleDao.actaAcuerdoDetalleSeguimientoCaso",idCaso);
    }
    
}
