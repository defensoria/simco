/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActividadActividad;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActividadActividadDaoImpl extends SqlSessionDaoSupport implements ActividadActividadDao{
    
    private static final Logger log = Logger.getLogger(ActividadActividadDaoImpl.class);

    @Override
    public void actividadActividadInsertar(ActividadActividad actividadActividad) throws Exception {
        log.debug("METODO : ActividadActividadDaoImpl.actividadActividadInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActividadActividadDao.actividadActividadInsertar", actividadActividad);
    }

    @Override
    public void actividadActividadUpdate(ActividadActividad actividadActividad) throws Exception {
        log.debug("METODO : ActividadActividadDaoImpl.actividadActividadUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadActividadDao.actividadActividadUpdate", actividadActividad);
    }

    @Override
    public void actividadActividadDelete(ActividadActividad actividadActividad) throws Exception {
        log.debug("METODO : ActividadActividadDaoImpl.actividadActividadDelete");
        getSqlSession().delete("gob.dp.simco.registro.dao.ActividadActividadDao.actividadActividadDelete", actividadActividad);
    }
    
}
