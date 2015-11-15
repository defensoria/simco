/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroMedioVerificacion;
import gob.dp.simco.registro.dao.MedioVerificacionDao;
import gob.dp.simco.registro.entity.MedioVerificacion;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class MedioVerificacionServiceImpl implements MedioVerificacionService{
    
    private static final Logger log = Logger.getLogger(MedioVerificacionServiceImpl.class);
     
    @Autowired
    private MedioVerificacionDao medioVerificacionDao;

    @Override
    public void medioVerificacionNuevo(MedioVerificacion medioVerificacion) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionNuevo");
        medioVerificacionDao.medioVerificacionInsertar(medioVerificacion);
    }

    @Override
    public void medioVerificacionModificar(MedioVerificacion medioVerificacion) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionModificar");
        medioVerificacionDao.medioVerificacionUpdate(medioVerificacion);
    }

    @Override
    public List<MedioVerificacion> medioVerificacionBuscar(FiltroMedioVerificacion filtroMedioVerificacion) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionBuscar");
        return medioVerificacionDao.medioVerificacionBuscar(filtroMedioVerificacion);
    }

    @Override
    public Integer medioVerificacionTotalBuscar(FiltroMedioVerificacion filtroMedioVerificacion) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionTotalBuscar");
        return medioVerificacionDao.medioVerificacionTotalBuscar(filtroMedioVerificacion);
    }

    @Override
    public List<MedioVerificacion> medioVerificacionxActividadBuscar(long idActividad) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionxActividadBuscar");
        return medioVerificacionDao.medioVerificacionxActividadBuscar(idActividad);
    }

    @Override
    public List<MedioVerificacion> medioVerificacionxActividadBuscarTotal(long idActividad) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionxActividadBuscarTotal");
        return medioVerificacionDao.medioVerificacionxActividadBuscarTotal(idActividad);
    }

    @Override
    public MedioVerificacion medioVerificacionBuscarOne(long idMedioVerificacion) throws Exception {
        log.debug("METODO : MedioVerificacionServiceImpl.medioVerificacionBuscarOne");
        MedioVerificacion medioVerificacion = new MedioVerificacion();
        medioVerificacion.setId(idMedioVerificacion);
        return medioVerificacionDao.medioVerificacionBuscarOne(medioVerificacion);
    }

    @Override
    public Integer medioVerificacionCodigoGenerado() {
        return medioVerificacionDao.medioVerificacionCodigoGenerado();
    }
    
}
