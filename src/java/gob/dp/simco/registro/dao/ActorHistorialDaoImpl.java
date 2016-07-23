/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActorHistorial;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActorHistorialDaoImpl extends SqlSessionDaoSupport implements ActorHistorialDao{
    
    @Override
    public void actorHistorialInsertar(ActorHistorial historial) {
        getSqlSession().insert("gob.dp.simco.registro.dao.ActorHistorialDao.actorHistorialInsertar", historial);
    }

    @Override
    public List<ActorHistorial> actorHistorialBuscarList(Long idActor) {
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActorHistorialDao.actorHistorialBuscarList",idActor);
    }
    
}
