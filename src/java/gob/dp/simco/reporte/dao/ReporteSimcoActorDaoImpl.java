/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.dao;

import gob.dp.simco.reporte.entity.ReporteSimcoActor;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ReporteSimcoActorDaoImpl extends SqlSessionDaoSupport implements ReporteSimcoActorDao {

    @Override
    public List<ReporteSimcoActor> reporteActor(ReporteSimcoActor reporteSimcoActor) {
        return getSqlSession().selectList("gob.dp.simco.reporte.dao.ReporteSimcoActorDao.reporteActor",reporteSimcoActor);
    }
}
