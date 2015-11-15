/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActividadCaso;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActividadCasoDaoImpl extends SqlSessionDaoSupport implements ActividadCasoDao{
    
    private static final Logger log = Logger.getLogger(ActividadCasoDaoImpl.class);

    @Override
    public void actividadCasoInsertar(ActividadCaso actividadCaso){
        log.debug("METODO : ActividadCasoDaoImpl.actividadCasoInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActividadCasoDao.actividadCasoInsertar", actividadCaso);
    }

    @Override
    public void actividadCasoUpdate(ActividadCaso actividadCaso) {
        log.debug("METODO : ActividadCasoDaoImpl.actividadCasoUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadCasoDao.actividadCasoUpdate", actividadCaso);
    }

    @Override
    public void actividadCasoDelete(ActividadCaso actividadCaso){
        log.debug("METODO : ActividadCasoDaoImpl.actividadCasoDelete");
        getSqlSession().delete("gob.dp.simco.registro.dao.ActividadCasoDao.actividadCasoDelete", actividadCaso);
    }

    @Override
    public int actividadCasoValida(long idActividad) {
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadCasoDao.actividadCasoValida", idActividad);
    }
    
}
