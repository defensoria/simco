/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.dao;

import gob.dp.simco.reporte.entity.ReporteSimco;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class ReporteSimcoDaoImpl extends SqlSessionDaoSupport implements ReporteSimcoDao {

    @Override
    public List<ReporteSimco> reporteCasos(ReporteSimco reporteSimco) {
        return getSqlSession().selectList("gob.dp.simco.reporte.dao.ReporteSimcoDao.reporteCasos",reporteSimco);
    }
    
}
