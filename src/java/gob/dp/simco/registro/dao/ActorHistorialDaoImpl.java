/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActorHistorial;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActorHistorialDaoImpl extends SqlSessionDaoSupport implements ActorHistorialDao{
    
    private static final Logger log = Logger.getLogger(ActorHistorialDaoImpl.class);

    @Override
    public void actorHistorialInsertar(ActorHistorial historial) throws Exception {
        log.debug("METODO : ActorHistorialDaoImpl.actorHistorialInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActorHistorialDao.actorHistorialInsertar", historial);
    }

    @Override
    public List<ActorHistorial> actorHistorialBuscarList(Long idActor) throws Exception {
        log.debug("METODO : ActorHistorialDaoImpl.actorHistorialBuscarList");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorHistorialDao.actorHistorialBuscarList",idActor);
    }
    
}
