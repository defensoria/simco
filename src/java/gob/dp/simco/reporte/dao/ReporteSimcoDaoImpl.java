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

    @Override
    public Integer cantidadAcuerdosCaso(long idCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadAcuerdosCaso",idCaso);
    }

    @Override
    public Integer cantidadEmpresaMineraCaso(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadEmpresaMineraCaso",codigoCaso);
    }

    @Override
    public Integer cantidadMuertosPNP(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadMuertosPNP",codigoCaso);
    }

    @Override
    public Integer cantidadMuertosCiviles(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadMuertosCiviles",codigoCaso);
    }

    @Override
    public Integer cantidadMuertosFFAA(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadMuertosFFAA",codigoCaso);
    }

    @Override
    public Integer cantidadHeridosPNP(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadHeridosPNP",codigoCaso);
    }

    @Override
    public Integer cantidadHeridosCiviles(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadHeridosCiviles",codigoCaso);
    }

    @Override
    public Integer cantidadHeridosFFAA(String codigoCaso) {
        return getSqlSession().selectOne("gob.dp.simco.reporte.dao.ReporteSimcoDao.cantidadMuertosPNP",codigoCaso);
    }
    
}
