/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.service;

import gob.dp.simco.reporte.dao.ReporteSimcoActorDao;
import gob.dp.simco.reporte.dao.ReporteSimcoDao;
import gob.dp.simco.reporte.entity.ReporteSimco;
import gob.dp.simco.reporte.entity.ReporteSimcoActor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ReporteSimcoActorServiceImpl implements ReporteSimcoActorService{
    
    @Autowired
    private ReporteSimcoActorDao reporteSimcoActorDao;

    @Override
    public List<ReporteSimcoActor> reporteActor(ReporteSimcoActor reporteSimcoActor) {
        return reporteSimcoActorDao.reporteActor(reporteSimcoActor);
    }
    
}
