/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.dao;

import gob.dp.simco.analisis.entity.AnalisisRelacion;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class AnalisisRelacionDaoImpl extends SqlSessionDaoSupport implements AnalisisRelacionDao{
    
    private static final Logger log = Logger.getLogger(AnalisisRelacionDaoImpl.class);

    @Override
    public void analisisRelacionInsertar(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionDaoImpl.analisisRelacionInsertar");
        getSqlSession().insert("gob.dp.simco.analisis.dao.AnalisisRelacionDao.analisisRelacionInsertar", analisisRelacion);
    }

    @Override
    public List<AnalisisRelacion> analisisRelacionBuscar(Long idCaso) {
        log.debug("METODO : AnalisisRelacionDaoImpl.analisisRelacionBuscar");
        return getSqlSession().selectList("gob.dp.simco.analisis.dao.AnalisisRelacionDao.analisisRelacionBuscar", idCaso);
    }

    @Override
    public void analisisRelacioUpdate(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionDaoImpl.analisisRelacioUpdate");
        getSqlSession().update("gob.dp.simco.analisis.dao.AnalisisRelacionDao.analisisRelacioUpdate", analisisRelacion);
    }

    @Override
    public AnalisisRelacion analisisRelacionBuscarOne(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionDaoImpl.analisisRelacionBuscarOne");
        return getSqlSession().selectOne("gob.dp.simco.analisis.dao.AnalisisRelacionDao.analisisRelacionBuscarOne", analisisRelacion);
    }

    @Override
    public void analisisRelacioEliminar(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionDaoImpl.analisisRelacioEliminar");
        getSqlSession().delete("gob.dp.simco.analisis.dao.AnalisisRelacionDao.analisisRelacioEliminar", analisisRelacion);
    }
    
}
