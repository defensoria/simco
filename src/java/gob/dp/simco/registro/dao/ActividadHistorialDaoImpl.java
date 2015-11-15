/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActividadHistorial;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActividadHistorialDaoImpl extends SqlSessionDaoSupport implements ActividadHistorialDao{
    
    private static final Logger log = Logger.getLogger(ActividadHistorialDaoImpl.class);

    @Override
    public void actividadHistorialInsertar(ActividadHistorial historial) throws Exception {
        log.debug("METODO : ActividadHistorialDaoImpl.actividadHistorialInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActividadHistorialDao.actividadHistorialInsertar", historial);
    }

    @Override
    public List<ActividadHistorial> actividadHistorialBuscarList(Long idActividad) throws Exception {
        log.debug("METODO : ActividadHistorialDaoImpl.actividadHistorialBuscarList");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadHistorialDao.actividadHistorialBuscarList",idActividad);
    }
    
}
