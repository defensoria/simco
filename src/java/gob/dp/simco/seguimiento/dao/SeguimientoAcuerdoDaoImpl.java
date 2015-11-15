/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.seguimiento.dao;

import gob.dp.simco.seguimiento.entity.SeguimientoAcuerdo;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class SeguimientoAcuerdoDaoImpl extends SqlSessionDaoSupport implements SeguimientoAcuerdoDao{
    
    private static final Logger log = Logger.getLogger(SeguimientoAcuerdoDaoImpl.class);

    @Override
    public void seguimientoAcuerdoInsertar(SeguimientoAcuerdo seguimientoAcuerdo) {
        log.debug("METODO : SeguimientoAcuerdoDaoImpl.seguimientoAcuerdoInsertar");
        getSqlSession().insert("gob.dp.simco.seguimiento.dao.SeguimientoAcuerdoDao.seguimientoAcuerdoInsertar", seguimientoAcuerdo);
    }

    @Override
    public SeguimientoAcuerdo seguimientoAcuerdoBuscar(Long idActaAcuerdoDetalle) {
        log.debug("METODO : SeguimientoAcuerdoDaoImpl.seguimientoAcuerdoBuscar");
        return getSqlSession().selectOne("gob.dp.simco.seguimiento.dao.SeguimientoAcuerdoDao.seguimientoAcuerdoBuscar",idActaAcuerdoDetalle);
    }

    @Override
    public void seguimientoAcuerdoUpdate(SeguimientoAcuerdo seguimientoAcuerdo) {
        log.debug("METODO : SeguimientoAcuerdoDaoImpl.seguimientoAcuerdoUpdate");
        getSqlSession().update("gob.dp.simco.seguimiento.dao.SeguimientoAcuerdoDao.seguimientoAcuerdoUpdate", seguimientoAcuerdo);
    }

    @Override
    public void seguimientoAcuerdoDelete(Long id) {
        log.debug("METODO : SeguimientoAcuerdoDaoImpl.seguimientoAcuerdoDelete");
        getSqlSession().delete("gob.dp.simco.seguimiento.dao.SeguimientoAcuerdoDao.seguimientoAcuerdoDelete", id);
    }

    @Override
    public SeguimientoAcuerdo seguimientoAcuerdoBuscarAcuerdo(Long idAcuerdo) {
        return getSqlSession().selectOne("gob.dp.simco.seguimiento.dao.SeguimientoAcuerdoDao.seguimientoAcuerdoBuscarAcuerdo",idAcuerdo);
    }

}
