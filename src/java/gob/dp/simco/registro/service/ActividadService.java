/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.entity.Actividad;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ActividadService {
    
   public void actividadNuevo(Actividad actividad) throws Exception;
   
   public void actividadModificar(Actividad actividad) throws Exception;
   
   public Actividad actividadBuscarOne(Long idActividad) throws Exception;
   
   public List<Actividad> actividadxActividadBuscar(Long idActividad) throws Exception;
    
   public List<Actividad> actividadxActividadBuscarTotal(Long idActividad) throws Exception;
   
   public List<Actividad> actividadxActorBuscar(Long idActor) throws Exception;
   
   public List<Actividad> actividadxActorBuscarTotal(Long idActor) throws Exception;
   
   public List<Actividad> actividadxCasoBuscar(Long idCaso) throws Exception;
   
   public List<Actividad> actividadxCasoBuscarTotal(Long idCaso) throws Exception;
   
   public List<Actividad> actividadxCodigoCasoBuscarTotal(String codigo) throws Exception;
   
   public List<Actividad> actividadxActaAcuerdoBuscar(Long idActaAcuerdo) throws Exception;
   
   public List<Actividad> actividadxActaAcuerdoBuscarTotal(Long idActaAcuerdo) throws Exception;
   
   public List<Actividad> actividadxMedioVerificacionBuscar(Long idMedioVerificacion) throws Exception;
   
   public List<Actividad> actividadxMedioVerificacionBuscarTotal(Long idMedioVerificacion) throws Exception;
   
   public List<Actividad> actividadBusquedaPaginado() throws Exception;
   
   public String actividadBusquedaPaginadoAutocompletar() throws Exception;
   
   public List<Actividad> actividadBusquedaSinCaso(int tipo);
   
   public List<Actividad> actividadxCasoBuscarTotalAC(Long idCaso);
   
   public List<Actividad> actividadxCasoBuscarTotalAD(Long idCaso);
   
   public Integer actividadADCodigoGenerado();

   public Actividad actividadxCasoBuscarID(long idActividad);
   
   public List<Actividad> actividadBusquedaPorCasoAC(long idCaso);
   
   public void actividadUpdateAcontecimiento(Actividad actividad);
   
   public void actividadUpdateVincular(long idActividad);
   
   public void actividadUpdateDesVincular(long idActividad);
   
   public void actividadUpdateAcontecimientoQuitar(long idActividad);
   
   public Actividad actividadBusquedaPorAcontecimiento(long idAcontecimiento);
}
