/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.seguimiento.service;

import gob.dp.simco.registro.dao.ActorDao;
import gob.dp.simco.registro.entity.ActaAcuerdoDetalle;
import gob.dp.simco.registro.entity.Actor;
import gob.dp.simco.seguimiento.dao.AlertaDao;
import gob.dp.simco.seguimiento.entity.Alerta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class AlertaServiceImpl implements AlertaService{
    
    private static final Logger log = Logger.getLogger(AlertaServiceImpl.class);
    
    @Autowired
    private AlertaDao alertaDao;
    
    @Autowired
    private ActorDao actorDao;

    @Override
    public void alertaInsertar(Alerta alerta) {
        log.debug("METODO : AlertaServiceImpl.alertaInsertar");
        alertaDao.alertaInsertar(alerta);
    }

    @Override
    public List<Alerta> alertaBuscar(Long idSeguimientoAcuerdo) {
        log.debug("METODO : AlertaServiceImpl.alertaBuscar");
        List<Alerta> list = new ArrayList<>();
        for(Alerta alerta: alertaDao.alertaBuscar(idSeguimientoAcuerdo)){
            alerta.setEsHoy(isToday(alerta.getFecha()));
            list.add(alerta);
        }
        return list;
    }
    
    private static boolean isToday(Date date) {  
        Calendar today = Calendar.getInstance();  
        today.setTime(new Date());  
        Calendar otherday = Calendar.getInstance();  
        otherday.setTime(date);  
        return otherday.get(Calendar.YEAR) == today.get(Calendar.YEAR)  
                && otherday.get(Calendar.MONTH) == today.get(Calendar.MONTH)  
                && otherday.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH);  
    } 

    @Override
    public Alerta alertaBuscarDetalle(Long id) {
        Alerta a = alertaDao.alertaBuscarDetalle(id);
        List<Actor> list = actorDao.actorxAcuerdoDetalleBusqueda(a.getActaAcuerdoDetalle().getId());
        a.getActaAcuerdoDetalle().setListaActor(list);
        return a;
    }

    @Override
    public void alertaUpdate(long id) {
        alertaDao.alertaUpdate(id);
    }

    @Override
    public List<Alerta> alertaBuscarUsuario(Long idAcuerdo) {
        return alertaDao.alertaBuscarUsuario(idAcuerdo);
    }
    
}
