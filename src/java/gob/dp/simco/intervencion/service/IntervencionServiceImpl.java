/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.service;

import gob.dp.simco.intervencion.dao.IntervencionDao;
import gob.dp.simco.intervencion.entity.Intervencion;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class IntervencionServiceImpl implements IntervencionService{
    
    private static final Logger log = Logger.getLogger(IntervencionServiceImpl.class);
    
    @Autowired
    private IntervencionDao intervencionDao;

    @Override
    public void intervencionInsertar(Intervencion intervencion) {
        log.debug("METODO : IntervencionServiceImpl.intervencionInsertar");
        intervencionDao.intervencionInsertar(intervencion);
    }

    @Override
    public List<Intervencion> intervencionBuscar() {
        log.debug("METODO : IntervencionServiceImpl.intervencionBuscar");
        return intervencionDao.intervencionBuscar();
    }

    @Override
    public void intervencionUpdate(Intervencion intervencion) {
        log.debug("METODO : IntervencionServiceImpl.intervencionUpdate");
        intervencionDao.intervencionUpdate(intervencion);
    }

    @Override
    public List<Intervencion> intervencionBuscarPriorizados() {
        log.debug("METODO : IntervencionServiceImpl.intervencionBuscarPriorizados");
        return intervencionDao.intervencionBuscarPriorizados();
    }

    @Override
    public List<Intervencion> intervencionBuscarArchivados() {
        log.debug("METODO : IntervencionServiceImpl.intervencionBuscarArchivados");
        return intervencionDao.intervencionBuscarArchivados();
    }

    @Override
    public List<Intervencion> intervencionBuscarActivas() {
        log.debug("METODO : IntervencionServiceImpl.intervencionBuscarActivas");
        return intervencionDao.intervencionBuscarActivas();
    }

    @Override
    public Intervencion intervencionBuscarCaso(String codigo) {
        return intervencionDao.intervencionBuscarCaso(codigo);
    }
    
}
