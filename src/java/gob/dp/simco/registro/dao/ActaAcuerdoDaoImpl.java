/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.bean.FiltroActaAcuerdo;
import gob.dp.simco.registro.entity.ActaAcuerdo;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActaAcuerdoDaoImpl extends SqlSessionDaoSupport implements ActaAcuerdoDao {
    
    private static final Logger log = Logger.getLogger(ActaAcuerdoDaoImpl.class);

    @Override
    public void actaAcuerdoInsertar(ActaAcuerdo actaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoInsertar", actaAcuerdo);
    }

    @Override
    public void actaAcuerdoUpdate(ActaAcuerdo actaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoUpdate", actaAcuerdo);
    }

    @Override
    public List<ActaAcuerdo> actaAcuerdoBuscar(FiltroActaAcuerdo filtroActaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoBuscar",filtroActaAcuerdo);
    }

    @Override
    public Integer actaAcuerdoTotalBuscar(FiltroActaAcuerdo filtroActaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoTotalBuscar");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoTotalBuscar",filtroActaAcuerdo);
    }
    
    @Override
    public List<ActaAcuerdo> actaAcuerdoxActividadBuscar(long idActividad) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoxActividadBuscar");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoxActividadBuscar",idActividad);
    }

    @Override
    public List<ActaAcuerdo> actaAcuerdoxActividadBuscarTotal(long idActividad) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoxActividadBuscarTotal");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoxActividadBuscarTotal",idActividad);
    }

    @Override
    public ActaAcuerdo actaAcuerdoBuscarOne(ActaAcuerdo actaAcuerdo) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoBuscarOne");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoBuscarOne",actaAcuerdo);
    }

    @Override
    public ActaAcuerdo actaAcuerdoxActividadBuscarOne(long idActividad) throws Exception {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoxActividadBuscarOne");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoxActividadBuscarOne",idActividad);
    }

    @Override
    public Integer actaAcuerdoCodigoGenerado() {
        log.debug("METODO : ActaAcuerdoDaoImpl.actaAcuerdoCodigoGenerado");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActaAcuerdoDao.actaAcuerdoCodigoGenerado");
    }
    
}
