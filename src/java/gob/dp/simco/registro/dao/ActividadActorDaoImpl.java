/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.bean.FiltroCasoActor;
import gob.dp.simco.registro.entity.ActividadActor;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActividadActorDaoImpl extends SqlSessionDaoSupport implements ActividadActorDao{
    
    private static final Logger log = Logger.getLogger(ActividadActorDaoImpl.class);

    @Override
    public void actividadActorInsertar(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorDaoImpl.actividadActorInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActividadActorDao.actividadActorInsertar", actividadActor);
    }

    @Override
    public void actividadActorUpdate(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorDaoImpl.actividadActorUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadActorDao.actividadActorUpdate", actividadActor);
    }

    @Override
    public void actividadActorDelete(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorDaoImpl.actividadActorDelete");
        getSqlSession().delete("gob.dp.simco.registro.dao.ActividadActorDao.actividadActorDelete", actividadActor);
    }

    @Override
    public Integer actividadActorBuscarOne(ActividadActor actividadActor) throws Exception {
        log.debug("METODO : ActividadActorDaoImpl.actividadActorBuscarOne");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadActorDao.actividadActorBuscarOne",actividadActor);
    }

    @Override
    public List<ActividadActor> actividadActorXcaso(FiltroCasoActor filtroCasoActor) {
        log.debug("METODO : ActividadActorDaoImpl.actividadActorXcaso");
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadActorDao.actividadActorXcaso",filtroCasoActor);
    }

    @Override
    public List<ActividadActor> actividadActorNivelAD(ActividadActor actividadActor) {
        return getSqlSession().selectList("gob.dp.simco.registro.dao.ActividadActorDao.actividadActorNivelAD",actividadActor);
    }
}
