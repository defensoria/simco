/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.service;

import gob.dp.simco.analisis.dao.AnalisisActorTemaDao;
import gob.dp.simco.analisis.entity.AnalisisActorTema;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author carlos
 */
@Repository
public class AnalisisActorTemaServiceImpl implements AnalisisActorTemaService{
    
    private static final Logger log = Logger.getLogger(AnalisisActorTemaServiceImpl.class);
    
    @Autowired
    private AnalisisActorTemaDao analisisActorTemaDao;

    @Override
    public void analisisActorTemaInsertar(AnalisisActorTema analisisActorTema) {
        log.debug("METODO : AnalisisActorTemaServiceImpl.analisisActorTemaInsertar");
        analisisActorTemaDao.analisisActorTemaInsertar(analisisActorTema);
    }

    @Override
    public List<AnalisisActorTema> analisisActorTemaXactorBuscar(Long idTema) {
        log.debug("METODO : AnalisisActorTemaServiceImpl.analisisActorTemaXactorBuscar");
        return analisisActorTemaDao.analisisActorTemaXactorBuscar(idTema);
    }

    @Override
    public void analisisActorTemaUpdate(AnalisisActorTema analisisActorTema) {
        log.debug("METODO : AnalisisActorTemaServiceImpl.analisisActorTemaUpdate");
        analisisActorTemaDao.analisisActorTemaUpdate(analisisActorTema);
    }

    @Override
    public Integer analisisActorTemaXactorValida(AnalisisActorTema analisisActorTema) {
        log.debug("METODO : AnalisisActorTemaServiceImpl.analisisActorTemaXactorValida");
        return analisisActorTemaDao.analisisActorTemaXactorValida(analisisActorTema);
    }

    @Override
    public Integer analisisActorCasoTemaValida(AnalisisActorTema analisisActorTema) {
        return analisisActorTemaDao.analisisActorCasoTemaValida(analisisActorTema);
    }

    @Override
    public void analisisActorTemaDelete(AnalisisActorTema analisisActorTema) {
        analisisActorTemaDao.analisisActorTemaDelete(analisisActorTema);
    }

    @Override
    public void analisisActorTemaDeletexActor(AnalisisActorTema analisisActorTema) {
        analisisActorTemaDao.analisisActorTemaDeletexActor(analisisActorTema);
    }
}
