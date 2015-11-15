/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.service;

import gob.dp.simco.analisis.dao.TemaDao;
import gob.dp.simco.analisis.entity.Tema;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class TemaServiceImpl implements TemaService{
    
    private static final Logger log = Logger.getLogger(TemaServiceImpl.class);
    
    @Autowired
    private TemaDao temaDao;

    @Override
    public void temaInsertar(Tema tema) {
        log.debug("METODO : TemaServiceImpl.temaInsertar");
        temaDao.temaInsertar(tema);
    }

    @Override
    public List<Tema> temaBuscar(Long idCaso) {
        log.debug("METODO : TemaServiceImpl.temaBuscar");
        return temaDao.temaBuscar(idCaso);
    }

    @Override
    public Tema temaxidBuscar(Long idTema) {
        log.debug("METODO : TemaServiceImpl.temaxidBuscar");
        return temaDao.temaxidBuscar(idTema);
    }

    @Override
    public List<Tema> temasxActor(Tema tema) {
        return temaDao.temaxcasoxactorBuscar(tema);
    }
    
}
