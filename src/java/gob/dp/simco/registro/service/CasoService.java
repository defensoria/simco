/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroCaso;
import gob.dp.simco.registro.entity.Caso;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface CasoService {
    
   public void casoNuevo(Caso caso) throws Exception;
   
   public void casoModificar(Caso caso) throws Exception;
   
   public List<Caso> casoBuscar(Caso caso) throws Exception;
   
   public Integer casoTotalBuscar(FiltroCaso filtroCaso) throws Exception;
   
   public List<Caso> casoxActividadBuscar(long idActividad) throws Exception;
   
   public List<Caso> casoxActividadBuscarTotal(long idActividad) throws Exception;
   
   public Caso casoBuscarOne(Long idCaso) throws Exception;
   
   public String casoBuscarAutocomplete() throws Exception;
    
   public Integer casoCodigoGenerado();
   
   public String adjuntiaBuscarAutocomplete();
   
   public Caso casoxActaAcuerdoDetalle(long idActaAcuerdoDetalle);
   
   public void casoUpdateIndicador(Caso caso);
}
