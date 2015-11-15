/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.intervencion.service;

import gob.dp.simco.intervencion.dao.IntervencionEtapaDao;
import gob.dp.simco.intervencion.entity.IntervencionEtapa;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class IntervencionEtapaServiceImpl implements IntervencionEtapaService{
    
    private static final Logger log = Logger.getLogger(IntervencionEtapaServiceImpl.class);
    
    @Autowired
    private IntervencionEtapaDao intervencionEtapaDao;

    @Override
    public void intervencionEtapaInsertar(IntervencionEtapa intervencionEtapa) {
        log.debug("METODO : IntervencionEtapaServiceImpl.intervencionEtapaInsertar");
        intervencionEtapaDao.intervencionEtapaInsertar(intervencionEtapa);
    }

    @Override
    public IntervencionEtapa intervencionEtapaBuscar(Long id) {
        log.debug("METODO : IntervencionEtapaServiceImpl.intervencionEtapaBuscar");
        return intervencionEtapaDao.intervencionEtapaBuscar(id);
    }

    @Override
    public List<IntervencionEtapa> intervencionEtapaBuscarTipo(IntervencionEtapa intervencionEtapa) {
        log.debug("METODO : IntervencionEtapaServiceImpl.intervencionEtapaBuscarTipo");
        return intervencionEtapaDao.intervencionEtapaBuscarTipo(intervencionEtapa);
    }

    @Override
    public void intervencionEtapaUpdate(IntervencionEtapa intervencionEtapa) {
        log.debug("METODO : IntervencionEtapaServiceImpl.intervencionEtapaUpdate");
        intervencionEtapaDao.intervencionEtapaUpdate(intervencionEtapa);
    }

    @Override
    public void intervencionEtapaUpdateDetalle(IntervencionEtapa intervencionEtapa) {
        log.debug("METODO : IntervencionEtapaServiceImpl.intervencionEtapaUpdateDetalle");
        intervencionEtapaDao.intervencionEtapaUpdateDetalle(intervencionEtapa);
    }

    @Override
    public void intervencionEtapaDetalleDelete(long idIntervencionEtapa) {
        intervencionEtapaDao.intervencionEtapaDetalleDelete(idIntervencionEtapa);
    }

    @Override
    public List<IntervencionEtapa> intervencionEtapaxAccion(long idEtapaAccion) {
        return intervencionEtapaDao.intervencionEtapaxAccion(idEtapaAccion);
    }

   
}
