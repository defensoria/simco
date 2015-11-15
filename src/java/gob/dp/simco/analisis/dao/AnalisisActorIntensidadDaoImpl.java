/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.dao;

import gob.dp.simco.analisis.entity.AnalisisActorIntensidad;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class AnalisisActorIntensidadDaoImpl extends SqlSessionDaoSupport implements AnalisisActorIntensidadDao{
    
    private static final Logger log = Logger.getLogger(AnalisisActorIntensidadDaoImpl.class);

    @Override
    public void analisisActorIntensidadInsertar(AnalisisActorIntensidad analisisActorIntensidad) {
        log.debug("METODO : AnalisisActorIntensidadDaoImpl.analisisActorIntensidadInsertar");
        getSqlSession().insert("gob.dp.simco.analisis.dao.AnalisisActorIntensidadDao.analisisActorIntensidadInsertar", analisisActorIntensidad);
    }

    @Override
    public List<AnalisisActorIntensidad> analisisActorIntensidadBuscar(Long idCaso) {
        log.debug("METODO : AnalisisActorIntensidadDaoImpl.analisisActorIntensidadBuscar");
        return getSqlSession().selectList("gob.dp.simco.analisis.dao.AnalisisActorIntensidadDao.analisisActorIntensidadBuscar", idCaso);
    }

    @Override
    public void analisisActorIntensidadUpdate(AnalisisActorIntensidad analisisActorIntensidad) {
        log.debug("METODO : AnalisisActorIntensidadDaoImpl.analisisActorIntensidadUpdate");
        getSqlSession().update("gob.dp.simco.analisis.dao.AnalisisActorIntensidadDao.analisisActorIntensidadUpdate", analisisActorIntensidad);
    }

    @Override
    public Integer analisisActorIntensidadBuscarUno(AnalisisActorIntensidad analisisActorIntensidad) {
        log.debug("METODO : AnalisisActorIntensidadDaoImpl.analisisActorIntensidadBuscarUno");
        return getSqlSession().selectOne("gob.dp.simco.analisis.dao.AnalisisActorIntensidadDao.analisisActorIntensidadBuscarUno", analisisActorIntensidad);
    }
    
}
