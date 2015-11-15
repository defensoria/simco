/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.entity.ActividadActaAcuerdo;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ActividadActaAcuerdoDaoIml extends SqlSessionDaoSupport implements ActividadActaAcuerdoDao{
    
    private static final Logger log = Logger.getLogger(ActividadActaAcuerdoDaoIml.class);

    @Override
    public void actividadActaAcuerdoInsertar(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadActaAcuerdoDaoIml.actividadActaAcuerdoInsertar");
        getSqlSession().insert("gob.dp.simco.registro.dao.ActividadActaAcuerdoDao.actividadActaAcuerdoInsertar", actividadActaAcuerdo);
    }

    @Override
    public void actividadActaAcuerdoUpdate(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadActaAcuerdoDaoIml.actividadActaAcuerdoUpdate");
        getSqlSession().update("gob.dp.simco.registro.dao.ActividadActaAcuerdoDao.actividadActaAcuerdoUpdate", actividadActaAcuerdo);
    }

    @Override
    public void actividadActaAcuerdoDelete(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadActaAcuerdoDaoIml.actividadActaAcuerdoDelete");
        getSqlSession().delete("gob.dp.simco.registro.dao.ActividadActaAcuerdoDao.actividadActaAcuerdoDelete", actividadActaAcuerdo);
    }

    @Override
    public int actividadActaAcuerdoValida(ActividadActaAcuerdo actividadActaAcuerdo) {
        log.debug("METODO : ActividadActaAcuerdoDaoIml.actividadActaAcuerdoDelete");
        return getSqlSession().selectOne("gob.dp.simco.registro.dao.ActividadActaAcuerdoDao.actividadActaAcuerdoValida",actividadActaAcuerdo);
    }
    
}
