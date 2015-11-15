/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroActor;
import gob.dp.simco.registro.entity.Actor;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface ActorService {
    
    public void actorNuevo(Actor actor) throws Exception;
    
    public void actorModificar(Actor actor) throws Exception;
    
    public List<Actor> actorBuscar(FiltroActor filtroActor) throws Exception;
   
    public Integer actorTotalBuscar(FiltroActor filtroActor) throws Exception;
    
    public List<Actor> actorxActividadBuscar(Long idActividad) throws Exception;
    
    public List<Actor> actorxActividadBuscarTotal(Long idActividad) throws Exception;
    
    public Actor actorBuscarOne(Long idActor) throws Exception;
    
    public List<Actor> actorBuscarPaginado(FiltroActor filtroActor) throws Exception;
    
    public List<Actor> actorxAcuerdoDetalleBusqueda(Long idAcuerdoDetalle, int indicador);
    
    public List<Actor> actorxCasoBuscar(Long idCaso);
    
    public List<Actor> actorxCasoIntensidadBuscar(Long idCaso);
    
    public String actorTodosBuscarPaginado();
    
    public String actorEmpresaEntidadBuscarPaginado();
    
    public String actorTodosBuscarCaso(Long idCaso);
    
    public String actorXactividadSimpleBuscar(Long id);
    
    public List<Actor> actorBuscarSimple(Actor actor);
    
    public List<Actor> actorBuscarSimpleXactividad(Long idActividad);
    
    public Actor actorBuscarTotalSimple(Actor actor);
    
    public Integer actorBuscarTotalSimpleCount(Actor actor);
    
    public Integer actorBuscarTotalSimpleCountRUC(Actor actor);
    
    public List<Actor> actorxActaAcuerdoBuscar(long idAcuerdoDetalle);
    
    public int actorValidadDNI(Actor actor);
    
    public int actorValidadRUC(Actor actor);
    
    public List<Actor> actoresSigues(String codigoUsuario);
}
