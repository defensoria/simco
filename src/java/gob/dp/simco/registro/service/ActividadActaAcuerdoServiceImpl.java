/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.dao.ActividadActaAcuerdoDao;
import gob.dp.simco.registro.entity.ActividadActaAcuerdo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class ActividadActaAcuerdoServiceImpl implements ActividadActaAcuerdoService{
    
    private static final Logger log = Logger.getLogger(ActividadActorServiceImpl.class);
    
    @Autowired
    private ActividadActaAcuerdoDao actividadActaAcuerdoDao;

    @Override
    public void actividadActaAcuerdoInsertarUpdate(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadActaAcuerdoServiceImpl.actividadActaAcuerdoInsertar");
        if(validaActividadActaAcuerdo(actividadActaAcuerdo) == 0){
            actividadActaAcuerdoDao.actividadActaAcuerdoInsertar(actividadActaAcuerdo);
        }else{
            actividadActaAcuerdoUpdate(actividadActaAcuerdo);
        }
        
    }
    
    private int validaActividadActaAcuerdo(ActividadActaAcuerdo actividadActaAcuerdo){
        int val = actividadActaAcuerdoDao.actividadActaAcuerdoValida(actividadActaAcuerdo);
        return val;
    }

    @Override
    public void actividadActaAcuerdoUpdate(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadActaAcuerdoServiceImpl.actividadActaAcuerdoUpdate");
        actividadActaAcuerdoDao.actividadActaAcuerdoUpdate(actividadActaAcuerdo);
    }

    @Override
    public void actividadActaAcuerdoDelete(ActividadActaAcuerdo actividadActaAcuerdo) throws Exception {
        log.debug("METODO : ActividadActaAcuerdoServiceImpl.actividadActaAcuerdoDelete");
        actividadActaAcuerdoDao.actividadActaAcuerdoDelete(actividadActaAcuerdo);
    }
    
}
