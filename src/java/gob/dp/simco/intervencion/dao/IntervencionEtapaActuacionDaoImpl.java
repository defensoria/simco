/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.dao;

import gob.dp.simco.intervencion.entity.IntervencionEtapaActuacion;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class IntervencionEtapaActuacionDaoImpl extends SqlSessionDaoSupport implements IntervencionEtapaActuacionDao{
    
    private static final Logger log = Logger.getLogger(IntervencionEtapaActuacionDaoImpl.class);

    @Override
    public void intervencionEtapaActuacionInsertar(IntervencionEtapaActuacion intervencionEtapaActuacion) {
        log.debug("METODO : IntervencionEtapaActuacionDaoImpl.intervencionEtapaActuacionInsertar");
        getSqlSession().insert("gob.dp.simco.intervencion.dao.IntervencionEtapaActuacionDao.intervencionEtapaActuacionInsertar", intervencionEtapaActuacion);
    }

    @Override
    public List<IntervencionEtapaActuacion> intervencionEtapaActuacionBuscar(Long idEtapa) {
        log.debug("METODO : IntervencionEtapaActuacionDaoImpl.intervencionEtapaActuacionBuscar");
        return getSqlSession().selectList("gob.dp.simco.intervencion.dao.IntervencionEtapaActuacionDao.intervencionEtapaActuacionBuscar",idEtapa); 
    }

    @Override
    public void intervencionEtapaActuacionUpdate(IntervencionEtapaActuacion intervencionEtapaActuacion) {
        log.debug("METODO : IntervencionEtapaActuacionDaoImpl.intervencionEtapaActuacionUpdate");
        getSqlSession().update("gob.dp.simco.intervencion.dao.IntervencionEtapaActuacionDao.intervencionEtapaActuacionUpdate", intervencionEtapaActuacion);
    }

    @Override
    public void intervencionEtapaActuacionEliminar(long id) {
        log.debug("METODO : IntervencionEtapaActuacionDaoImpl.intervencionEtapaActuacionEliminar");
        getSqlSession().delete("gob.dp.simco.intervencion.dao.IntervencionEtapaActuacionDao.intervencionEtapaActuacionEliminar", id);
    }

    @Override
    public List<IntervencionEtapaActuacion> intervencionEtapaActuacionBuscarActividad(Long idEtapa) {
        return getSqlSession().selectList("gob.dp.simco.intervencion.dao.IntervencionEtapaActuacionDao.intervencionEtapaActuacionBuscarActividad",idEtapa); 
    }
    
}
