/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroMedioVerificacion;
import gob.dp.simco.registro.entity.MedioVerificacion;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface MedioVerificacionService {
    
   public void medioVerificacionNuevo(MedioVerificacion medioVerificacion) throws Exception;
   
   public void medioVerificacionModificar(MedioVerificacion medioVerificacion) throws Exception;
   
   public List<MedioVerificacion> medioVerificacionBuscar(FiltroMedioVerificacion filtroMedioVerificacion) throws Exception;
   
   public Integer medioVerificacionTotalBuscar(FiltroMedioVerificacion filtroMedioVerificacion) throws Exception;    
   
   public List<MedioVerificacion> medioVerificacionxActividadBuscar(long idActividad) throws Exception;
   
   public List<MedioVerificacion> medioVerificacionxActividadBuscarTotal(long idActividad) throws Exception;

   public MedioVerificacion medioVerificacionBuscarOne(long idMedioVerificacion) throws Exception;
   
   public Integer medioVerificacionCodigoGenerado();
}
