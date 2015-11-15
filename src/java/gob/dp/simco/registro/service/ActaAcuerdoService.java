/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroActaAcuerdo;
import gob.dp.simco.registro.entity.ActaAcuerdo;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ActaAcuerdoService {
    
   public void actaAcuerdoNuevo(ActaAcuerdo actaAcuerdo) throws Exception;
   
   public void actaAcuerdoModificar(ActaAcuerdo actaAcuerdo) throws Exception;
   
   public List<ActaAcuerdo> actaAcuerdoBuscar(FiltroActaAcuerdo filtroActaAcuerdo) throws Exception;
   
   public Integer actaAcuerdoTotalBuscar(FiltroActaAcuerdo filtroActaAcuerdo) throws Exception;
   
   public List<ActaAcuerdo> actaAcuerdoxActividadBuscar(long idActividad) throws Exception;
   
   public List<ActaAcuerdo> actaAcuerdoxActividadBuscarTotal(long idActividad) throws Exception;

   public ActaAcuerdo actaAcuerdoBuscarOne(Long idActaAcuerdo) throws Exception;
    
   public ActaAcuerdo actaAcuerdoxActividadBuscarOne(long idActividad) throws Exception;
   
   public Integer actaAcuerdoCodigoGenerado();
}
