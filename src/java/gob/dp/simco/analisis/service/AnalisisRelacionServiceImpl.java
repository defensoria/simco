/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.service;

import gob.dp.simco.analisis.dao.AnalisisRelacionDao;
import gob.dp.simco.analisis.entity.AnalisisRelacion;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class AnalisisRelacionServiceImpl implements AnalisisRelacionService{

    private static final Logger log = Logger.getLogger(AnalisisRelacionServiceImpl.class);
    
    @Autowired
    private AnalisisRelacionDao analisisRelacionDao;
    
    @Override
    public void analisisRelacionInsertar(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionServiceImpl.analisisRelacionInsertar");
        analisisRelacionDao.analisisRelacionInsertar(analisisRelacion);
    }

    @Override
    public List<AnalisisRelacion> analisisRelacionBuscar(Long idCaso) {
        log.debug("METODO : AnalisisRelacionServiceImpl.analisisRelacionBuscar");
        return analisisRelacionDao.analisisRelacionBuscar(idCaso);
    }

    @Override
    public void analisisRelacioUpdate(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionServiceImpl.analisisRelacioUpdate");
        analisisRelacionDao.analisisRelacioUpdate(analisisRelacion);
    }

    @Override
    public AnalisisRelacion analisisRelacionBuscarOne(AnalisisRelacion analisisRelacion) {
        log.debug("METODO : AnalisisRelacionServiceImpl.analisisRelacionBuscarOne");
        return analisisRelacionDao.analisisRelacionBuscarOne(analisisRelacion);
    }

    @Override
    public void analisisRelacioEliminar(AnalisisRelacion analisisRelacion) {
        analisisRelacionDao.analisisRelacioEliminar(analisisRelacion);
    }
    
}
