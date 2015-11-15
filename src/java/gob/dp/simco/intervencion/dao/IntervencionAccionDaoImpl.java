/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.dao;

import gob.dp.simco.intervencion.entity.IntervencionAccion;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class IntervencionAccionDaoImpl extends SqlSessionDaoSupport implements IntervencionAccionDao{
    
    private static final Logger log = Logger.getLogger(IntervencionAccionDaoImpl.class);

    @Override
    public void intervencionAccionInsertar(IntervencionAccion intervencionAccion) {
        log.debug("METODO : IntervencionAccionDaoImpl.intervencionAccionInsertar");
        getSqlSession().insert("gob.dp.simco.intervencion.dao.IntervencionAccionDao.intervencionAccionInsertar", intervencionAccion);
    }

    @Override
    public IntervencionAccion intervencionAccionBuscar(Long idIntervencionAccion) {
        log.debug("METODO : IntervencionAccionDaoImpl.intervencionAccionBuscar");
        return getSqlSession().selectOne("gob.dp.simco.intervencion.dao.IntervencionAccionDao.intervencionAccionBuscar",idIntervencionAccion);
    }

    @Override
    public List<IntervencionAccion> intervencionAccionBuscarxCaso(Long idIntervencion) {
        log.debug("METODO : IntervencionAccionDaoImpl.intervencionAccionBuscarxCaso");
        return getSqlSession().selectList("gob.dp.simco.intervencion.dao.IntervencionAccionDao.intervencionAccionBuscarxCaso",idIntervencion);
    }

    @Override
    public List<IntervencionAccion> intervencionAccionBuscarxIntervencion(Long idIntervencion) {
        return getSqlSession().selectList("gob.dp.simco.intervencion.dao.IntervencionAccionDao.intervencionAccionBuscarxIntervencion",idIntervencion);
    }
    
}
