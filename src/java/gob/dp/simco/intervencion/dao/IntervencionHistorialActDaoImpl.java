/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.dao;

import gob.dp.simco.intervencion.entity.IntervencionHistorialAct;
import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class IntervencionHistorialActDaoImpl extends SqlSessionDaoSupport implements IntervencionHistorialActDao{
    
    private static final Logger log = Logger.getLogger(IntervencionMiembroDaoImpl.class);

    @Override
    public void intervencionHistorialActInsertar(IntervencionHistorialAct intervencionHistorialAct) {
        log.debug("METODO : IntervencionHistorialActDaoImpl.intervencionHistorialActInsertar");
        getSqlSession().insert("gob.dp.simco.intervencion.dao.IntervencionHistorialActDao.intervencionHistorialActInsertar", intervencionHistorialAct);
    }

    @Override
    public List<IntervencionHistorialAct> intervencionHistorialActBuscar(long idEtapa) {
        log.debug("METODO : IntervencionHistorialActDaoImpl.intervencionHistorialActBuscar");
        return getSqlSession().selectList("gob.dp.simco.intervencion.dao.IntervencionHistorialActDao.intervencionHistorialActBuscar",idEtapa); 
    }
    
}
