/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.dao;

import gob.dp.simco.analisis.entity.AnalisisActorTema;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class AnalisisActorTemaDaoImpl extends SqlSessionDaoSupport implements AnalisisActorTemaDao {
    
    private static final Logger log = Logger.getLogger(AnalisisActorTemaDaoImpl.class);

    @Override
    public void analisisActorTemaInsertar(AnalisisActorTema analisisActorTema) {
        log.debug("METODO : AnalisisActorTemaDaoImpl.analisisActorTemaInsertar");
        getSqlSession().insert("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorTemaInsertar", analisisActorTema);
    }

    @Override
    public List<AnalisisActorTema> analisisActorTemaXactorBuscar(Long idTema) {
        log.debug("METODO : AnalisisActorTemaDaoImpl.analisisActorTemaXactorBuscar");
        return getSqlSession().selectList("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorTemaXactorBuscar", idTema);
    }

    @Override
    public void analisisActorTemaUpdate(AnalisisActorTema analisisActorTema) {
        log.debug("METODO : AnalisisActorTemaDaoImpl.analisisActorTemaUpdate");
        getSqlSession().update("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorTemaUpdate", analisisActorTema);
    }

    @Override
    public Integer analisisActorTemaXactorValida(AnalisisActorTema analisisActorTema) {
        log.debug("METODO : AnalisisActorTemaDaoImpl.analisisActorTemaXactorValida");
        return getSqlSession().selectOne("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorTemaXactorValida", analisisActorTema);
    }

    @Override
    public Integer analisisActorCasoTemaValida(AnalisisActorTema analisisActorTema) {
        return getSqlSession().selectOne("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorCasoTemaValida", analisisActorTema);
    }

    @Override
    public void analisisActorTemaDelete(AnalisisActorTema analisisActorTema) {
        getSqlSession().insert("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorTemaDelete", analisisActorTema);
    }

    @Override
    public void analisisActorTemaDeletexActor(AnalisisActorTema analisisActorTema) {
        getSqlSession().insert("gob.dp.simco.analisis.dao.AnalisisActorTemaDao.analisisActorTemaDeletexActor", analisisActorTema);
    }
    
}
