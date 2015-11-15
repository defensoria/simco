/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.seguimiento.service;

import gob.dp.simco.seguimiento.dao.SeguimientoAcuerdoDao;
import gob.dp.simco.seguimiento.entity.SeguimientoAcuerdo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class SeguimientoAcuerdoServiceImpl implements SeguimientoAcuerdoService{
    
    private static final Logger log = Logger.getLogger(SeguimientoAcuerdoServiceImpl.class);
    
    @Autowired
    private SeguimientoAcuerdoDao seguimientoAcuerdoDao;

    @Override
    public void seguimientoAcuerdoInsertar(SeguimientoAcuerdo seguimientoAcuerdo) {
        log.debug("METODO : SeguimientoAcuerdoServiceImpl.seguimientoAcuerdoInsertar");
        seguimientoAcuerdoDao.seguimientoAcuerdoInsertar(seguimientoAcuerdo);
    }

    @Override
    public SeguimientoAcuerdo seguimientoAcuerdoBuscar(Long idActaAcuerdoDetalle) {
        log.debug("METODO : SeguimientoAcuerdoServiceImpl.seguimientoAcuerdoBuscar");
        return seguimientoAcuerdoDao.seguimientoAcuerdoBuscar(idActaAcuerdoDetalle);
    }

    @Override
    public void seguimientoAcuerdoUpdate(SeguimientoAcuerdo seguimientoAcuerdo) {
        log.debug("METODO : SeguimientoAcuerdoServiceImpl.seguimientoAcuerdoUpdate");
        seguimientoAcuerdoDao.seguimientoAcuerdoUpdate(seguimientoAcuerdo);
    }

    @Override
    public void seguimientoAcuerdoDelete(Long id) {
        log.debug("METODO : SeguimientoAcuerdoServiceImpl.seguimientoAcuerdoDelete");
        seguimientoAcuerdoDao.seguimientoAcuerdoDelete(id);
    }

    @Override
    public SeguimientoAcuerdo seguimientoAcuerdoBuscarAcuerdo(Long idAcuerdo) {
        return seguimientoAcuerdoDao.seguimientoAcuerdoBuscarAcuerdo(idAcuerdo);
    }

}
