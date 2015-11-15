/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.seguimiento.dao;

import gob.dp.simco.seguimiento.entity.Alerta;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class AlertaDaoImpl extends SqlSessionDaoSupport implements AlertaDao{
    
    private static final Logger log = Logger.getLogger(AlertaDaoImpl.class);

    @Override
    public void alertaInsertar(Alerta alerta) {
        log.debug("METODO : AlertaDaoImpl.alertaInsertar");
        getSqlSession().insert("gob.dp.simco.seguimiento.dao.AlertaDao.alertaInsertar", alerta);
    }

    @Override
    public List<Alerta> alertaBuscar(Long idSeguimientoAcuerdo) {
        log.debug("METODO : AlertaDaoImpl.alertaBuscar");
        return getSqlSession().selectList("gob.dp.simco.seguimiento.dao.AlertaDao.alertaBuscar",idSeguimientoAcuerdo);
    }

    @Override
    public Alerta alertaBuscarDetalle(Long id) {
        log.debug("METODO : AlertaDaoImpl.alertaBuscarDetalle");
        return getSqlSession().selectOne("gob.dp.simco.seguimiento.dao.AlertaDao.alertaBuscarDetalle",id);
    }

    @Override
    public void alertaUpdate(long id) {
        log.debug("METODO : AlertaDaoImpl.alertaUpdate");
        getSqlSession().update("gob.dp.simco.seguimiento.dao.AlertaDao.alertaUpdate", id);
    }

    @Override
    public List<Alerta> alertaBuscarUsuario(Long idAcuerdo) {
        log.debug("METODO : AlertaDaoImpl.alertaBuscarUsuario");
        return getSqlSession().selectList("gob.dp.simco.seguimiento.dao.AlertaDao.alertaBuscarUsuario",idAcuerdo);
    }
    
}
