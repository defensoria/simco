/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.registro.controller;

import gob.dp.simco.administracion.seguridad.controller.LoginController;
import gob.dp.simco.comun.MessagesUtil;
import gob.dp.simco.comun.entity.Departamento;
import gob.dp.simco.comun.entity.Distrito;
import gob.dp.simco.comun.entity.Maestro;
import gob.dp.simco.comun.entity.Provincia;
import gob.dp.simco.comun.service.MaestroService;
import gob.dp.simco.comun.service.UbigeoService;
import gob.dp.simco.registro.bean.FiltroActor;
import gob.dp.simco.registro.constantes.ConstantesUtil;
import gob.dp.simco.registro.entity.ActaAcuerdoDetalle;
import gob.dp.simco.registro.entity.Actividad;
import gob.dp.simco.registro.entity.ActividadActor;
import gob.dp.simco.registro.entity.Actor;
import gob.dp.simco.registro.entity.ActorAcuerdo;
import gob.dp.simco.registro.entity.ActorHistorial;
import gob.dp.simco.registro.entity.ActorMiembro;
import gob.dp.simco.registro.entity.Caso;
import gob.dp.simco.registro.service.ActividadActorService;
import gob.dp.simco.registro.service.ActividadService;
import gob.dp.simco.registro.service.ActorHistorialService;
import gob.dp.simco.registro.service.ActorMiembroService;
import gob.dp.simco.registro.service.ActorService;
import gob.dp.simco.registro.service.CasoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author carlos
 */
@Named
@Scope("session")
public class ActorController implements Serializable {

    private static final Logger log = Logger.getLogger(ActorController.class);

    private ActorTemp actorTemp;

    private Actor actor;

    private Actor empresa;

    private Actor entidad;

    private Actor actor2;

    private ActorBusquedaTemp actorBusquedaTemp;

    private ActividadActor actividadActor;

    private ActividadActorTemp actividadActorTemp;

    private ActorMiembro actorMiembro;

    private ActorMiembro actorMiembroEntidad;

    private ActorMiembro actorMiembroPesona;

    private List<ActorHistorial> listaActorHistorial;

    private List<Actividad> listaActividadxActor;

    private List<Actor> listaActorxActorPaginado;

    private List<Actividad> listaActividadxActorTotal;

    private List<Actor> listaActorPaginado;

    private List<Actor> listaActorPaginado2;

    private List<Actor> listaActorSeleccionado;

    private List<Actor> listaActorSeleccionadoFinal;

    private List<Actor> listaActorSeleccionadoAcuerdoIni;

    private List<Actor> listaActorSeleccionadoAcuerdoFin;

    private List<Actor> listaActorBusquedaGeneral;

    private List<Actor> listaActorCasosSigues;

    private List<ActorMiembro> listaMiembros;

    private List<ActorMiembro> listaMiembrosPersona;

    private List<ActorMiembro> listaMiembrosRegistrados;

    private List<ActorMiembro> listaMiembrosEntidad;

    private List<ActorMiembro> listaMiembrosRegistradosEntidad;

    private List<ActorMiembro> listaMiembrosRegistradosPersona;

    private List<SelectItem> listaDepartamento;

    private List<SelectItem> listaProvincia;

    private List<SelectItem> listaDistrito;

    private boolean verVinculosMantenimientoActor = false;

    private boolean verVinculoActividad = false;

    private boolean verBoton = false;

    private boolean verBotonActividad = false;

    private Long nroPagina = 1L;

    private String cadenaAutocomplete;

    private String cadenaAutocompleteEmpresaEntidad;

    private String cadenaAutocomplete3;//PARA LOS CASOS

    private String cadenaAutocomplete4;

    private Boolean tip;

    private String cssDisable = "background: #EEEEEE; pointer-events:none;";

    private int indicadorPersona = 0;

    private MessagesUtil msg;

    private List<SelectItem> listaTipoPoblacion;

    private List<SelectItem> listaSubTipo1Poblacion;

    private List<SelectItem> listaSubTipo2Poblacion;
    
    private List<SelectItem> listaTipoEstado;

    private List<SelectItem> listaSubTipo1Estado;

    private List<SelectItem> listaSubTipo2Estado;
    
    private List<SelectItem> listaTipoEmpresa;

    private List<SelectItem> listaSubTipo1Empresa;

    private List<SelectItem> listaSubTipo2Empresa;
    
    private List<SelectItem> listaSubTipo3Empresa;
    
    private List<SelectItem> listaTipoOrganizacion;

    private List<SelectItem> listaSubTipo1Organizacion;

    private List<SelectItem> listaSubTipo2Organizacion;

    @Autowired
    private ActorService actorService;

    @Autowired
    private CasoService casoService;

    @Autowired
    private ActividadActorService actividadActorService;

    @Autowired
    private ActorHistorialService actorHistorialService;

    @Autowired
    private ActividadService actividadService;

    @Autowired
    private UbigeoService ubigeoService;

    @Autowired
    private ActorMiembroService actorMiembroService;

    @Autowired
    private MaestroService maestroService;

    public ActorController() {
        msg = new MessagesUtil();
    }

    public String cargarPagina() {
        cargarListas();
        actor = new Actor();
        msg = new MessagesUtil();
        cadenaActores();
        bloquearFormularioPersona();
        empresa = new Actor();
        entidad = new Actor();
        listaMiembros = new ArrayList<>();
        listaMiembrosEntidad = new ArrayList<>();
        listaMiembrosPersona = new ArrayList<>();
        listaMiembrosRegistrados = new ArrayList<>();
        listaMiembrosRegistradosEntidad = new ArrayList<>();
        listaMiembrosRegistradosPersona = new ArrayList<>();
        actorMiembro = new ActorMiembro();
        actorMiembroEntidad = new ActorMiembro();
        actorMiembroPesona = new ActorMiembro();
        return "actorNuevo";
    }

    public void initActor() {
        actor = new Actor();
        actor2 = new Actor();
        listaActorSeleccionadoAcuerdoIni = new ArrayList<>();
        listaActorSeleccionadoAcuerdoFin = new ArrayList<>();
    }

    private void cargarListas() {
        limpiarListasClasificacion();
        listaTipoPoblacion = cargarListaSimple(1);
        listaTipoEstado = cargarListaSimple(4);
        listaTipoEmpresa = cargarListaSimple(10);
        listaTipoOrganizacion = cargarListaSimple(7);
        listaSubTipo1Empresa = cargarListaSimple(11);
        listaSubTipo2Empresa = cargarListaSimple(12);
    }
    
    private void limpiarListasClasificacion(){
        listaTipoEstado = null;
        listaSubTipo1Estado = null;
        listaSubTipo2Estado = null;
        
        listaTipoEmpresa = null;
        listaSubTipo1Empresa = null;
        listaSubTipo2Empresa = null;
        listaSubTipo3Empresa = null;
        
        listaTipoPoblacion = null;
        listaSubTipo1Poblacion = null;
        listaSubTipo2Poblacion = null;
        
        listaTipoOrganizacion = null;
        listaSubTipo1Organizacion = null;
        listaSubTipo2Organizacion = null;
        
        
    }

    public void cargarAjaxListaSubTipo1() {
        listaSubTipo1Poblacion = null;
        listaSubTipo2Poblacion = null;
        Integer padre = maestroService.padreParametro(new Maestro(actor.getTipoPoblacion(), 1));
        if(padre != null)
            listaSubTipo1Poblacion = cargarListaCompuesta(2, padre);
    }
    
    public void cargarAjaxListaSubTipo2() {
        listaSubTipo2Poblacion = null;
        Integer padre = maestroService.padreParametro(new Maestro(actor.getSubTipo1Poblacion(), 2));
        if(padre != null)
            listaSubTipo2Poblacion = cargarListaCompuesta(3, padre);
    }
    
    public void cargarAjaxListaSubTipo1Estado() {
        listaSubTipo1Estado = null;
        listaSubTipo2Estado = null;
        Integer padre = maestroService.padreParametro(new Maestro(entidad.getTipoEstado(), 4));
        if(padre != null)
            listaSubTipo1Estado = cargarListaCompuesta(5, padre);  
    }
    
    public void cargarAjaxListaSubTipo2Estado(){
        listaSubTipo2Estado = new ArrayList<>();
        if(entidad.getSubTipo1Estado().equals("01") || entidad.getSubTipo1Estado().equals("02") ||  entidad.getSubTipo1Estado().equals("06") ||  entidad.getSubTipo1Estado().equals("07")){
            Integer padre = maestroService.padreParametro(new Maestro(entidad.getTipoEstado(), 4));
            if(padre != null)
                listaSubTipo2Estado = cargarListaCompuesta(6, padre);
        }else{
            Integer padre = maestroService.padreParametro(new Maestro(entidad.getSubTipo1Estado(), 5));
            if(padre != null)
                listaSubTipo2Estado = cargarListaCompuesta(6, padre);
        }
    }
    
    public void cargarAjaxListaSubTipo1Organizacion() {
        listaSubTipo1Organizacion = null;
        listaSubTipo2Organizacion = null;
        Integer padre = maestroService.padreParametro(new Maestro(empresa.getTipoOrganizacion(), 7));
        if(padre != null)
            listaSubTipo1Organizacion = cargarListaCompuesta(8, padre);
    }
    
    public void cargarAjaxListaSubTipo2Organizacion() {
        listaSubTipo2Organizacion = null;
        if(empresa.getSubTipo1Organizacion().equals("40") || empresa.getSubTipo1Organizacion().equals("41")){
            Integer padre = maestroService.padreParametro(new Maestro(empresa.getTipoOrganizacion(), 7));
            if(padre != null)
                listaSubTipo2Organizacion = cargarListaCompuesta(9, padre);
        }else{
            Integer padre = maestroService.padreParametro(new Maestro(empresa.getSubTipo1Organizacion(), 8));
            if(padre != null)
                listaSubTipo2Organizacion = cargarListaCompuesta(9, padre);
        }
    }
    
    public void cargarAjaxListaSubTipo3Empresa() {
        listaSubTipo3Empresa = null;
        Integer padre = maestroService.padreParametro(new Maestro(empresa.getSubTipo2Empresa(), 12));
        listaSubTipo3Empresa = cargarListaCompuesta(13, padre);
    }
    
    public String cargarPaginaBusqueda() {
        try {
            cadenaAutocomplete3 = casoService.casoBuscarAutocomplete();
            cadenaAutocomplete4 = actividadService.actividadBusquedaPaginadoAutocompletar();
            listaActorBusquedaGeneral = null;
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return "actorBuscar";
    }

    public String cargarPaginaActoresSigues() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            LoginController loginController = (LoginController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "loginController");
            listaActorCasosSigues = actorService.actoresSigues(loginController.getUsuarioSesion().getCodigo());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return "actorCaso";
    }

    public String cargarRegistroAgregarActor(Caso cas) {
        try {
            tip = false;
            actor = new Actor();
            actor2 = new Actor();
            listaActorPaginado = new ArrayList<>();
            listaActorPaginado2 = new ArrayList<>();
            actividadActorTemp = new ActividadActorTemp();
            if (listaActorSeleccionado == null)
                listaActorSeleccionado = new ArrayList<>();
            if (listaActorSeleccionadoFinal == null)
                listaActorSeleccionadoFinal = new ArrayList<>();
            listaActorSeleccionadoAcuerdoIni = new ArrayList<>();
            listaActorSeleccionadoAcuerdoFin = new ArrayList<>();
            cadenaActores();
            if (cas != null) {
                if (cas.getId() != null) {
                    listaActorPaginado2 = actorService.actorxCasoBuscar(cas.getId());
                } else {
                    listaActorPaginado2 = new ArrayList<>();
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }
        return "registroAgregarActor";
    }

    public String cargarRegistroAgregarActor3(Caso cas, long idActividad) {
        try {
            tip = false;
            actor = new Actor();
            actor2 = new Actor();
            listaActorPaginado = new ArrayList<>();
            listaActorPaginado2 = new ArrayList<>();
            actividadActorTemp = new ActividadActorTemp();
            if (listaActorSeleccionado == null)
                listaActorSeleccionado = new ArrayList<>();
            listaActorSeleccionadoFinal = actorService.actorxActividadBuscarTotal(idActividad);
            if (listaActorSeleccionadoFinal == null)
                listaActorSeleccionadoFinal = new ArrayList<>();
            listaActorSeleccionadoAcuerdoIni = new ArrayList<>();
            listaActorSeleccionadoAcuerdoFin = new ArrayList<>();
            cadenaActores();
            if (cas != null) {
                if (cas.getId() != null) {
                    listaActorPaginado2 = actorService.actorxCasoBuscar(cas.getId());
                } else {
                    listaActorPaginado2 = new ArrayList<>();
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }
        return "registroAgregarActor";
    }

    public String cargarRegistroAgregarActor2(Caso cas, Long idActividad) {
        tip = true;
        actor = new Actor();
        actor2 = new Actor();
        listaActorPaginado = new ArrayList<>();
        listaActorPaginado2 = new ArrayList<>();
        actividadActorTemp = new ActividadActorTemp();
        if (listaActorSeleccionado == null) {
            listaActorSeleccionado = new ArrayList<>();
        }
        if (cas.getId() != null) {
            try {
                listaActorSeleccionadoFinal = actorService.actorxActividadBuscarTotal(idActividad);
            } catch (Exception ex) {
                listaActorSeleccionadoFinal = null;
                log.error(ex.getCause());
            }
        }

        if (listaActorSeleccionadoFinal.size() > 0) {
            List<Actor> as = new ArrayList<>();
            for (Actor a : listaActorSeleccionadoFinal) {
                if (a.getActividadActor() == null) {
                    ActividadActor aa = new ActividadActor();
                    a.setActividadActor(aa);
                }
                as.add(a);
            }
            listaActorSeleccionadoFinal.clear();
            listaActorSeleccionadoFinal.addAll(as);
        }
        if (listaActorSeleccionadoFinal == null) {
            listaActorSeleccionadoFinal = new ArrayList<>();
        }

        listaActorSeleccionadoAcuerdoIni = new ArrayList<>();
        listaActorSeleccionadoAcuerdoFin = new ArrayList<>();
        cadenaActores();
        if (cas != null) {
            if (cas.getId() != null) {
                listaActorPaginado2 = actorService.actorxCasoBuscar(cas.getId());
            } else {
                listaActorPaginado2 = new ArrayList<>();
            }
        }
        return "registroAgregarActor";
    }

    private void bloquearFormularioPersona() {
        cssDisable = "background: #EEEEEE; pointer-events:none;";
        actor = new Actor();
    }

    private void habilitarFormularioPersona() {
        setCssDisable("");
    }

    public void habilitaFormDNI() {
        String dni = actor.getDni();
        if (StringUtils.isNotBlank(dni)) {
            if (validaDNI(dni)) {
                habilitarFormularioPersona();
                setIndicadorPersona(0);
                actor = new Actor();
                actor.setDni(dni);
                msg.messageInfo("Ingrese los datos del la nueva persona", null);
            } else {
                bloquearFormularioPersona();
                setIndicadorPersona(0);
                msg.messageAlert("El DNI " + dni + " ya se encuentra registrado", null);
            }
        } else {
            msg.messageAlert("Debe Ingresar el DNI", null);
        }
    }

    private boolean validaDNI(String idDocumento) {
        Actor a = new Actor();
        a.setDni(idDocumento);
        int counta = actorService.actorValidadDNI(a);
        return counta <= 0;
    }

    public boolean addMiembro() {
        for (ActorMiembro am : listaMiembros) {
            if (Objects.equals(am.getIdMiembro(), actorMiembro.getIdMiembro())) {
                actorMiembro = new ActorMiembro();
                return false;
            }
        }
        listaMiembros.add(actorMiembro);
        actorMiembro = new ActorMiembro();
        return true;
    }

    public boolean addMiembroEntidad() {
        for (ActorMiembro am : listaMiembrosEntidad) {
            if (Objects.equals(am.getIdMiembro(), actorMiembroEntidad.getIdMiembro())) {
                actorMiembroEntidad = new ActorMiembro();
                return false;
            }
        }
        listaMiembrosEntidad.add(actorMiembroEntidad);
        actorMiembroEntidad = new ActorMiembro();
        return true;
    }

    public boolean addMiembroPersona() {
        for (ActorMiembro am : listaMiembrosPersona) {
            if (Objects.equals(am.getIdActor(), actorMiembroPesona.getIdActor())) {
                actorMiembroPesona = new ActorMiembro();
                return false;
            }
        }
        listaMiembrosPersona.add(actorMiembroPesona);
        actorMiembroPesona = new ActorMiembro();
        return true;
    }

    public void removeTempMiembro(ActorMiembro am) {
        listaMiembros.remove(am);
    }

    public void removeTempMiembroEntidad(ActorMiembro am) {
        listaMiembrosEntidad.remove(am);
    }

    public void removeTempMiembroPersona(ActorMiembro am) {
        listaMiembrosPersona.remove(am);
    }

    public void removeMiembroRegistrado(ActorMiembro am) {
        actorMiembroService.actorMiembroDelete(am);
        listaMiembrosRegistrados = actorMiembroService.actorMiembroBuscarxActor(empresa.getId());
    }

    public void removeMiembroRegistradoEntidad(ActorMiembro am) {
        actorMiembroService.actorMiembroDelete(am);
        listaMiembrosRegistradosEntidad = actorMiembroService.actorMiembroBuscarxActor(entidad.getId());
    }

    public void removeMiembroRegistradoPersona(ActorMiembro am) {
        actorMiembroService.actorMiembroDelete(am);
        listaMiembrosRegistradosPersona = actorMiembroService.actorMiembroBuscarxMiembro(actor.getId());
    }

    public boolean addMiembroGuardar(ActorMiembro am) {
        try {
            listaMiembrosRegistrados = new ArrayList<>();
            listaMiembrosRegistrados = actorMiembroService.actorMiembroBuscarxActor(empresa.getId());
            for (ActorMiembro miembro : listaMiembrosRegistrados) {
                if (Objects.equals(miembro.getIdMiembro(), am.getIdMiembro())) {
                    msg.messageAlert("Esta Persona ya ha sido registrada", null);
                    removeTempMiembro(am);
                    return false;
                }
            }
            if (empresa.getId() != null) {
                am.setIdActor(empresa.getId());
                am.setEstado("ACT");
                actorMiembroService.actorMiembroInsertar(am);
                listaMiembrosRegistrados.add(am);
            }
            removeTempMiembro(am);
        } catch (Exception e) {
            log.error(e);
        }
        return true;
    }

    public String regresarBusquedaEdit() {
        listaActorBusquedaGeneral.clear();
        return "actorBuscar";
    }

    public boolean addMiembroGuardarEntidad(ActorMiembro am) {
        try {
            listaMiembrosRegistradosEntidad = new ArrayList<>();
            listaMiembrosRegistradosEntidad = actorMiembroService.actorMiembroBuscarxActor(entidad.getId());
            for (ActorMiembro miembro : listaMiembrosRegistradosEntidad) {
                if (Objects.equals(miembro.getIdMiembro(), am.getIdMiembro())) {
                    msg.messageAlert("Esta persona ya ha sido registrada", null);
                    removeTempMiembroEntidad(am);
                    return false;
                }
            }
            if (entidad.getId() != null) {
                am.setIdActor(entidad.getId());
                am.setEstado("ACT");
                actorMiembroService.actorMiembroInsertar(am);
                listaMiembrosRegistradosEntidad.add(am);
            }
            removeTempMiembroEntidad(am);
        } catch (Exception e) {
            log.error(e);
        }
        return true;
    }

    public boolean addMiembroGuardarPersona(ActorMiembro am) {
        try {
            listaMiembrosRegistradosPersona = new ArrayList<>();
            listaMiembrosRegistradosPersona = actorMiembroService.actorMiembroBuscarxMiembro(actor.getId());
            for (ActorMiembro miembro : listaMiembrosRegistradosPersona) {
                if (Objects.equals(miembro.getIdActor(), am.getIdActor())) {
                    msg.messageAlert("La Persona ya se encuentra vinculada a la empresa", null);
                    removeTempMiembroPersona(am);
                    return false;
                }
            }
            if (actor.getId() != null) {
                am.setIdMiembro(actor.getId());
                am.setEstado("ACT");
                actorMiembroService.actorMiembroInsertar(am);
                listaMiembrosRegistradosPersona.add(am);
            }
            removeTempMiembroPersona(am);
        } catch (Exception e) {
            log.error(e);
        }
        return true;
    }

    public void listarActoresXcaso(Long idActividad) {
        try {
            listaActorSeleccionado = actorService.actorxActividadBuscarTotal(idActividad);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ActorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiarListaActorPaginado() {
        listaActorPaginado = new ArrayList<>();
    }

    public void cadenaActores() {
        cadenaAutocomplete = actorService.actorTodosBuscarPaginado();
        cadenaAutocompleteEmpresaEntidad = actorService.actorEmpresaEntidadBuscarPaginado();
    }

    public void limpiarListasActoresAcuerdos() {
        listaActorSeleccionadoAcuerdoIni = new ArrayList<>();
        listaActorSeleccionadoAcuerdoFin = new ArrayList<>();
    }

    public void validaDni() {
        String dni = actor.getDni();
        if (StringUtils.isNotBlank(dni)) {
            setActor(actorService.actorBuscarTotalSimple(actor));
            if (StringUtils.isBlank(actor.getDni())) {
                actor = new Actor();
                actor.setDni(dni);
            } else {
                if (actor.getIdProvincia() != null && actor.getIdProvincia() != 0) {
                    comboProvincia();
                }
                if (actor.getIdDistrito() != null && actor.getIdDistrito() != 0) {
                    comboDistrito();
                }
            }
        }
    }

    public void buscarActorXnombre() {
        String value = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("nombreActor");
        Actor ac = new Actor();
        ac.setNombre(value);
        listaActorBusquedaGeneral = null;
        listaActorBusquedaGeneral = actorService.actorBuscarSimple(ac);
    }

    public void buscarActorXRegistro() {
        String value = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("actividad-id");
        Long id = Long.parseLong(value);
        listaActorBusquedaGeneral = null;
        listaActorBusquedaGeneral = actorService.actorBuscarSimpleXactividad(id);
    }

    public void buscarActorXCaso() {
        String value = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("caso-id");
        Long id = Long.parseLong(value);
        listaActorBusquedaGeneral = null;
        listaActorBusquedaGeneral = actorService.actorxCasoBuscar(id);
    }

    public String regresarBusqueda() {
        return "actorBuscar";
    }

    public String setearActor(Actor a) {
        actor = new Actor();
        empresa = new Actor();
        entidad = new Actor();
        if (StringUtils.equals(a.getTipoGeneral(), "PE")) {
            setActor(a);
            if (actor.getIdProvincia() != null && actor.getIdProvincia() != 0) {
                comboProvincia();
            }
            if (actor.getIdDistrito() != null && actor.getIdDistrito() != 0) {
                comboDistrito();
            }
            listaMiembros = new ArrayList<>();
            listaMiembrosEntidad = new ArrayList<>();
            listaMiembrosPersona = new ArrayList<>();
            listaMiembrosRegistrados = null;
            listaMiembrosRegistradosEntidad = null;
            listaMiembrosRegistradosPersona = actorMiembroService.actorMiembroBuscarxMiembro(actor.getId());
            if(actor.getTipoPoblacion() != null){
                cargarAjaxListaSubTipo1();
            }
            if(actor.getSubTipo1Poblacion() != null){
                cargarAjaxListaSubTipo2();
            }
        }
        if (StringUtils.equals(a.getTipoGeneral(), "EM")) {
            setEmpresa(a);
            if (empresa.getIdProvincia() != null && empresa.getIdProvincia() != 0) {
                comboProvinciaEmpresa();
            }
            if (empresa.getIdDistrito() != null && empresa.getIdDistrito() != 0) {
                comboDistritoEmpresa();
            }
            listaMiembros = new ArrayList<>();
            listaMiembrosEntidad = new ArrayList<>();
            listaMiembrosPersona = new ArrayList<>();
            listaMiembrosRegistrados = actorMiembroService.actorMiembroBuscarxActor(empresa.getId());
            listaMiembrosRegistradosEntidad = null;
            listaMiembrosRegistradosPersona = null;
            
            if(empresa.getTipoOrganizacion() != null){
                cargarAjaxListaSubTipo1Organizacion();
            }
            if(empresa.getSubTipo1Organizacion()!= null){
                cargarAjaxListaSubTipo2Organizacion();
            }
            
            if(empresa.getSubTipo2Empresa() != null){
                cargarAjaxListaSubTipo3Empresa();
            }
            
        }
        if (StringUtils.equals(a.getTipoGeneral(), "EN")) {
            setEntidad(a);
            if (entidad.getIdProvincia() != null && entidad.getIdProvincia() != 0) {
                comboProvinciaEntidad();
            }
            if (entidad.getIdDistrito() != null && entidad.getIdDistrito() != 0) {
                comboDistritoEntidad();
            }
            listaMiembros = new ArrayList<>();
            listaMiembrosEntidad = new ArrayList<>();
            listaMiembrosPersona = new ArrayList<>();
            listaMiembrosRegistradosEntidad = actorMiembroService.actorMiembroBuscarxActor(entidad.getId());
            listaMiembrosRegistrados = null;
            listaMiembrosRegistradosPersona = null;
            
            if(entidad.getTipoEstado() != null){
                cargarAjaxListaSubTipo1Estado();
            }
            if(entidad.getSubTipo1Estado() != null){
                cargarAjaxListaSubTipo2Estado();
            }
        }
        return "actorEdit";
    }

    public void busquedaGeneralActor(Long idActor) {
        try {
            setearActor(actorService.actorBuscarOne(idActor));
        } catch (Exception ex) {
            log.error(ex.getCause());
        }

    }

    public void agregarActorSeleccionadoAcuerdoIni() {
        try {
            if (actor.getId() != null) {
                Actor a = actorService.actorBuscarOne(actor.getId());
                int va = 0;
                for (Actor a1 : listaActorSeleccionadoAcuerdoIni) {
                    if (Objects.equals(a1.getId(), a.getId())) {
                        va++;
                    }
                }
                if (va == 0) {
                    listaActorSeleccionadoAcuerdoIni.add(a);
                } else {
                    msg.messageAlert("El actor seleccionado ya ha sido agregado", null);
                }
            } else {
                msg.messageAlert("No ha seleccionado ningun actor registrado", null);
            }
            actor = new Actor();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void agregarActorSeleccionadoAcuerdoFin() {
        try {
            if (actor2.getId() != null) {
                Actor a = actorService.actorBuscarOne(actor2.getId());
                int va = 0;
                for (Actor a1 : listaActorSeleccionadoAcuerdoFin) {
                    if (Objects.equals(a1.getId(), a.getId())) {
                        va++;
                    }
                }
                if (va == 0) {
                    listaActorSeleccionadoAcuerdoFin.add(a);
                } else {
                    msg.messageAlert("El actor seleccionado ya ha sido agregado", null);
                }
            } else {
                msg.messageAlert("No ha seleccionado ningun actor registrado", null);
            }
            actor2 = new Actor();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void limpiarListadoActorPaginado() {
        actorBusquedaTemp = new ActorBusquedaTemp();
        listaActorSeleccionado = null;
    }

    public void listarActorSeleccionado(Actor actor) {
        boolean pass = true;
        for (Actor a : listaActorSeleccionadoFinal) {
            if (Objects.equals(a.getId(), actor.getId())) {
                pass = false;
                msg.messageAlert("El actor ya esta agregado", null);
            }
        }
        if (pass) {
            listaActorSeleccionado.add(actor);
            ActividadActor actividadAc = new ActividadActor();
            actor.setActividadActor(actividadAc);
            listaActorSeleccionadoFinal.add(actor);
            msg.messageInfo("El actor se ha agregado", null);
        }
    }

    public void comboProvincia() {
        listaProvincia = new ArrayList<>();
        int id = actor.getIdDepartamento();
        if (id == 0) {
            listaProvincia.clear();
            listaDistrito.clear();
        } else {
            List<Provincia> list = ubigeoService.provinciaLista(id);
            if (list.size() > 0) {
                for (Provincia provincia : list) {
                    listaProvincia.add(new SelectItem(provincia.getId(), provincia.getDescripcion()));
                }
            }
        }
    }

    public void comboProvinciaEmpresa() {
        listaProvincia = new ArrayList<>();
        Integer id = empresa.getIdDepartamento();

        listaProvincia = new ArrayList<>();
        listaDistrito = new ArrayList<>();
        if (id != null) {
            List<Provincia> list = ubigeoService.provinciaLista(id);
            if (list.size() > 0) {
                for (Provincia provincia : list) {
                    listaProvincia.add(new SelectItem(provincia.getId(), provincia.getDescripcion()));
                }
            }
        }
    }

    public void comboProvinciaEntidad() {
        listaProvincia = new ArrayList<>();
        Integer id = entidad.getIdDepartamento();

        listaProvincia = new ArrayList<>();
        listaDistrito = new ArrayList<>();
        if (id != null) {
            List<Provincia> list = ubigeoService.provinciaLista(id);
            if (list.size() > 0) {
                for (Provincia provincia : list) {
                    listaProvincia.add(new SelectItem(provincia.getId(), provincia.getDescripcion()));
                }
            }
        }
    }

    public void comboDistrito() {
        listaDistrito = new ArrayList<>();
        int id = actor.getIdProvincia();
        if (id == 0) {
            listaDistrito.clear();
        } else {
            List<Distrito> list = ubigeoService.distritoLista(id);
            if (list.size() > 0) {
                for (Distrito distrito : list) {
                    listaDistrito.add(new SelectItem(distrito.getId(), distrito.getDescripcion()));
                }
            }
        }
    }

    public void comboDistritoEmpresa() {
        listaDistrito = new ArrayList<>();
        int id = empresa.getIdProvincia();
        if (id == 0) {
            listaDistrito.clear();
        } else {
            List<Distrito> list = ubigeoService.distritoLista(id);
            if (list.size() > 0) {
                for (Distrito distrito : list) {
                    listaDistrito.add(new SelectItem(distrito.getId(), distrito.getDescripcion()));
                }
            }
        }
    }

    public void comboDistritoEntidad() {
        listaDistrito = new ArrayList<>();
        int id = entidad.getIdProvincia();
        if (id == 0) {
            listaDistrito.clear();
        } else {
            List<Distrito> list = ubigeoService.distritoLista(id);
            if (list.size() > 0) {
                for (Distrito distrito : list) {
                    listaDistrito.add(new SelectItem(distrito.getId(), distrito.getDescripcion()));
                }
            }
        }
    }

    public void buscarActorTodos2() {
        try {
            Actor a;
            if (actor2.getId() != null) {
                a = new Actor();
                a = actorService.actorBuscarOne(actor2.getId());
                boolean i = true;
                for (Actor a1 : listaActorPaginado2) {
                    if (Objects.equals(a1.getId(), a.getId())) {
                        i = false;
                    }
                }
                if (i) {
                    listaActorPaginado2.add(a);
                }
            }
            actor2 = new Actor();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void buscarActorTodos() {
        try {
            Actor a;
            if (actor.getId() != null) {
                a = actorService.actorBuscarOne(actor.getId());
                boolean i = true;

                for (Actor a1 : listaActorPaginado) {
                    if (Objects.equals(a1.getId(), a.getId())) {
                        i = false;
                    }
                }
                if (i) {
                    listaActorPaginado.add(a);
                } else {
                    msg.messageAlert("El actor seleccionado ya se encuentra agregado", null);
                }
            } else {
                msg.messageAlert("Debe de seleccionar un actor", null);
            }
            actor = new Actor();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void removeActorSeleccionado(Actor actor) {
        listaActorSeleccionadoFinal.remove(actor);
        listaActorSeleccionado = listaActorSeleccionadoFinal;
        msg.messageInfo("Debe hacer click en el boton \"Guardar\" para confirmar los cambios", null);
    }

    public void removeActorSeleccionadoAcuerdoIni(Actor actor) {
        listaActorSeleccionadoAcuerdoIni.remove(actor);
    }

    public void removeActorSeleccionadoAcuerdoFin(Actor actor) {
        listaActorSeleccionadoAcuerdoFin.remove(actor);
    }

    public void seteaListaActorSeleccionadoAcuerdoIni(List<Actor> list) {
        setListaActorSeleccionadoAcuerdoIni(list);
    }

    public void seteaListaActorSeleccionadoAcuerdoFin(List<Actor> list) {
        setListaActorSeleccionadoAcuerdoFin(list);
    }

    public List<ActorAcuerdo> vincularListaActoresAcuerdoDetalle(Long idDetalle) {
        List<ActorAcuerdo> list = new ArrayList<>();
        list.addAll(vincularListaActoresAcuerdoDetalleIni(idDetalle));
        list.addAll(vincularListaActoresAcuerdoDetalleFin(idDetalle));
        return list;
    }

    public List<Actor> vincularListaActoresInicio() {
        return listaActorSeleccionadoAcuerdoIni;
    }

    public List<Actor> vincularListaActoresFin() {
        return listaActorSeleccionadoAcuerdoFin;
    }

    public List<ActorAcuerdo> vincularListaActoresAcuerdoDetalleIni(Long idDetalle) {
        ArrayList list = new ArrayList<>();
        for (Actor actor1 : listaActorSeleccionadoAcuerdoIni) {
            ActorAcuerdo actorAcuerdo = new ActorAcuerdo();
            ActaAcuerdoDetalle actaAcuerdoDetalle = new ActaAcuerdoDetalle();
            actaAcuerdoDetalle.setId(idDetalle);
            actorAcuerdo.setActaAcuerdoDetalle(actaAcuerdoDetalle);
            actorAcuerdo.setActor(actor1);
            actorAcuerdo.setEstado("ACT");
            actorAcuerdo.setTipo("INI");
            list.add(actorAcuerdo);
        }
        return list;
    }

    public List<ActorAcuerdo> vincularListaActoresAcuerdoDetalleFin(Long idDetalle) {
        ArrayList list = new ArrayList<>();
        for (Actor actor1 : listaActorSeleccionadoAcuerdoFin) {
            ActorAcuerdo actorAcuerdo = new ActorAcuerdo();
            ActaAcuerdoDetalle actaAcuerdoDetalle = new ActaAcuerdoDetalle();
            actaAcuerdoDetalle.setId(idDetalle);
            actorAcuerdo.setActaAcuerdoDetalle(actaAcuerdoDetalle);
            actorAcuerdo.setActor(actor1);
            actorAcuerdo.setEstado("ACT");
            actorAcuerdo.setTipo("FIN");
            list.add(actorAcuerdo);
        }
        return list;
    }

    public void limpiarListas() {
        listaActorPaginado = null;
        listaActorSeleccionado = null;
        listaActorSeleccionadoFinal = null;

    }

    public void limpiarListasActorAcuerdo() {
        listaActorSeleccionadoAcuerdoIni.clear();
        listaActorSeleccionadoAcuerdoFin.clear();
    }

    public String cargarPaginaBusqueda(int tipo) {
        log.debug("METODO : ActorController.cargarPaginaBusqueda");
        actorBusquedaTemp = new ActorBusquedaTemp();
        return "actorBusqueda";
    }

    public String cargarPaginaBusquedaVinculoActividad() {
        log.debug("METODO : ActorController.cargarPaginaBusqueda");
        actorBusquedaTemp = new ActorBusquedaTemp();
        return "actorBusqueda";
    }

    public String cargarPaginaActividadActor() {
        log.debug("METODO : ActorController.cargarPaginaBusqueda");
        actorBusquedaTemp = new ActorBusquedaTemp();
        return "actividadActor";
    }

    public void registrarActor() {
        log.debug("METODO : ActorController.registrarActor");
        try {
            if (validaDNI(actor.getDni())) {
                int cont = actorService.actorBuscarTotalSimpleCount(actor);
                if (cont > 0) {
                    if (actor.getId() != null) {
                        actorService.actorModificar(actor);
                    }
                } else {
                    actor.setTipoGeneral("PE");
                    actorService.actorNuevo(actor);
                }
                //bloquearFormularioPersona();
                msg.messageInfo("El actor se ha registrado correctamente ahora puede añadirlo a alguna Empresa o Entidad", null);
            } else {
                if (actor.getId() != null) {
                        actorService.actorModificar(actor);
                        msg.messageInfo("El actor se ha modificado correctamente", null);
                    }else{
                    msg.messageAlert("El DNI ingresado ya se encuentra registrado en el sistema", null);
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void actualizarActor() {
        log.debug("METODO : ActorController.registrarActor");
        try {
            actorService.actorModificar(actor);
            msg.messageInfo("Se ha actualizado la informacion de la persona", null);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void registrarActorEmpresa() {
        log.debug("METODO : ActorController.registrarActorEmpresa");
        try {
            if (empresa.getRuc() != null && !StringUtils.equals(empresa.getRuc(), "")) {
                int cont = actorService.actorBuscarTotalSimpleCountRUC(empresa);
                if (cont > 0) {
                    if (empresa.getId() != null) {
                        actorService.actorModificar(empresa);
                        msg.messageInfo("Se ha actualizado correctamente la Empresa", null);
                    } else {
                        msg.messageAlert("El RUC " + empresa.getRuc() + " ya se encuentra registrado", null);
                        empresa = new Actor();
                    }
                } else {
                    if (empresa.getId() == null) {
                        empresa.setTipoGeneral("EM");
                        actorService.actorNuevo(empresa);
                        msg.messageInfo("Se ha registrado correctamente la Empresa ahora puede agregar sus miembros", null);
                    }else{
                        msg.messageAlert("El RUC " + empresa.getRuc() + " ya se encuentra registrado", null);
                        empresa = new Actor();
                    }
                }
            } else {
                if (empresa.getId() != null) {
                    actorService.actorModificar(empresa);
                    msg.messageInfo("Se ha actualizado correctamente la Empresa", null);
                } else {
                    empresa.setTipoGeneral("EM");
                    actorService.actorNuevo(empresa);
                    msg.messageInfo("Se ha registrado correctamente la Empresa ahora puede agregar sus miembros", null);
                }
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void registrarActorEntidad() {
        log.debug("METODO : ActorController.registrarActorEntidad");
        try {
            if (entidad.getRuc() != null && !StringUtils.equals(entidad.getRuc(), "")) {
                int cont = actorService.actorBuscarTotalSimpleCountRUC(entidad);

                if (cont > 0) {
                    if (entidad.getId() != null) {
                        entidad.setTipoGeneral("EN");
                        actorService.actorModificar(entidad);
                        msg.messageInfo("Se ha actualizado correctamente la Entidad", null);
                    } else {
                        msg.messageAlert("El RUC " + entidad.getRuc() + " ya se encuentra registrado", null);
                        entidad = new Actor();
                    }
                }else{
                    entidad.setTipoGeneral("EN");
                    actorService.actorNuevo(entidad);
                    msg.messageInfo("Se ha registrado correctamente la Entidad ahora puede agregar sus miembros", null);
                }
            } else {
                if (entidad.getId() != null) {
                    actorService.actorModificar(entidad);
                    msg.messageInfo("Se ha actualizado correctamente la Entidad", null);
                } else {
                    entidad.setTipoGeneral("EM");
                    actorService.actorNuevo(entidad);
                    msg.messageInfo("Se ha registrado correctamente la Entidad ahora puede agregar sus miembros", null);
                }
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public List<Actor> buscarActor() {
        log.debug("METODO : ActorController.buscarActor");
        List<Actor> lst = null;
        try {
            FiltroActor filtro = busquedaActorTempHaciaFiltroActor(actorBusquedaTemp);
        } catch (Exception e) {
            log.error("ERROR : ActorController.buscarActor: " + e.getMessage());
        }
        return lst;
    }

    public void listarPaginado(Long pagina) {
        nroPagina = pagina;
        int paginado = ConstantesUtil.PAGINADO_ACTORES_5;
        Long ini = paginado * (pagina - 1) + 1;
        Long fin = paginado * pagina;
        if (pagina == 0) {
            ini = 1L;
            fin = 5L;
        }
        FiltroActor filtroActor = new FiltroActor();
        filtroActor.setIni(ini);
        filtroActor.setFin(fin);
        try {
            listaActorPaginado = actorService.actorBuscarPaginado(filtroActor);
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarPaginado: " + e.getMessage());
        }
    }

    private FiltroActor busquedaActorTempHaciaFiltroActor(ActorBusquedaTemp bean) {
        FiltroActor filtro = new FiltroActor();
        if (!StringUtils.isBlank(bean.getNombre())) {
            filtro.setNombre(bean.getNombre().trim());
        }
        if (!StringUtils.isBlank(bean.getApellido())) {
            filtro.setApellido(bean.getApellido().trim());
        }
        if (!StringUtils.isBlank(bean.getDni())) {
            filtro.setDni(bean.getDni().trim());
        }
        return filtro;
    }

    public void historialActor(String accion, String entidad, Long idEntidad, Long idActor) {
        FacesContext context = FacesContext.getCurrentInstance();
        LoginController loginController = (LoginController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "loginController");
        ActorHistorial historial = new ActorHistorial();
        historial.setAccion(accion);
        historial.setIdActor(idActor);
        historial.setFechaRegistro(new Date());
        historial.setEntidad(entidad);
        historial.setIdEntidad(idEntidad);
        historial.setUsuarioRegistro(loginController.getUsuarioSesion().getCodigo());
        try {
            actorHistorialService.actorHistorialInsertar(historial);
        } catch (Exception e) {
            log.error("METODO : ActorController.historialActor" + e.getMessage());
        }
    }

    public List<ActorHistorial> listarActorHistorial() {
        List<ActorHistorial> list = null;
        try {
            list = actorHistorialService.actorHistorialBuscarList(actorTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActorController.listarActorHistorial: " + e.getMessage());
        }
        return list;
    }

    public void actividadUnionActorModal(Long idActividad) {
        ActividadActor actividadActor1;
        Actividad actividad = new Actividad();
        actividad.setId(idActividad);
        actividadActor1 = new ActividadActor();
        actividadActor1.setActividad(actividad);
        try {
            actividadActorService.actividadActorDelete(actividadActor1);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        for (Actor a : listaActorPaginado) {
            actividadActor1 = new ActividadActor();
            actividadActor1.setActividad(actividad);

            actividadActor1.setActor(a);
            actividadActor1.setEstado("ACT");
            try {
                actividadActorService.saveOrUpdate(actividadActor1);
            } catch (Exception e) {
                log.error("ERROR : ActividadController.actividadUnionActorModal: " + e.getMessage());
            }
        }
    }

    public String actividadUnionActor(Long idActividad) {
        log.debug("METODO : ActorController.actividadUnionActor");
        ActividadActor actividadActor1;
        Actividad actividad = new Actividad();

        actividad.setId(idActividad);
        actividadActor1 = new ActividadActor();
        actividadActor1.setActividad(actividad);
        try {
            actividadActorService.actividadActorDelete(actividadActor1);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        for (Actor a : listaActorSeleccionadoFinal) {
            actividadActor1 = new ActividadActor();
            actividadActor1.setActividad(actividad);

            actividadActor1.setActor(a);
            actividadActor1.setComentario(a.getActividadActor().getComentario());
            actividadActor1.setDemanda(a.getActividadActor().getDemanda());
            actividadActor1.setPosicion(a.getActividadActor().getPosicion());
            actividadActor1.setTipoRol(a.getActividadActor().getTipoRol());
            actividadActor1.setEstado("ACT");
            if (a.getActividadActor().getNivel() != null) {
                actividadActor1.setNivel(a.getActividadActor().getNivel());
            } else {
                actividadActor1.setNivel(0);
            }
            try {
                actividadActorService.saveOrUpdate(actividadActor1);
                msg.messageInfo("Se han registrado los cambios", null);
            } catch (Exception e) {
                log.error("ERROR : ActividadController.actividadUnionActor: " + e.getMessage());
            }
        }
        return "registroNuevo";
    }

    public String actividadUnionActor2(Long idActividad) {
        log.debug("METODO : ActorController.actividadUnionActor");
        ActividadActor actividadActor1;
        Actividad actividad = new Actividad();

        actividad.setId(idActividad);
        actividadActor1 = new ActividadActor();
        actividadActor1.setActividad(actividad);
        try {
            actividadActorService.actividadActorDelete(actividadActor1);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        for (Actor a : listaActorSeleccionadoFinal) {
            actividadActor1 = new ActividadActor();
            actividadActor1.setActividad(actividad);

            actividadActor1.setActor(a);
            actividadActor1.setComentario(a.getActividadActor().getComentario());
            actividadActor1.setDemanda(a.getActividadActor().getDemanda());
            actividadActor1.setPosicion(a.getActividadActor().getPosicion());
            actividadActor1.setEstado("ACT");
            actividadActor1.setTipoRol(a.getActividadActor().getTipoRol());
            if (a.getActividadActor().getNivel() != null) {
                actividadActor1.setNivel(a.getActividadActor().getNivel());
            } else {
                actividadActor1.setNivel(0);
            }
            try {
                actividadActorService.saveOrUpdate(actividadActor1);
                msg.messageInfo("Se han registrado los cambios", null);
            } catch (Exception e) {
                log.error("ERROR : ActividadController.actividadUnionActor2: " + e.getMessage());
            }
        }
        return "registroEdit";
    }

    private List<Actividad> listarActividadActorTotal() {
        List<Actividad> list = null;
        try {
            list = actividadService.actividadxActorBuscarTotal(actorTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActorController.listarActividadActorTotal: " + e.getMessage());
        }
        return list;
    }

    public void eliminarActividadActor(Long idActividad) {
        log.debug("METODO : ActorController.eliminarActividadActor");
        Actividad actividad = new Actividad();
        Actor actor1 = new Actor();

        actor1.setId(actorTemp.getId());
        actividad.setId(idActividad);
        ActividadActor actividadActor1 = new ActividadActor(actividad, actor1, null);
        try {
            actividadActorService.actividadActorDelete(actividadActor1);
            listaActividadxActorTotal = listarActividadActorTotal();
        } catch (Exception e) {
            log.error("METODO : eliminarActorActividad" + e.getMessage());
        }
    }

    private List<SelectItem> cargarListaCompuesta(int grupo, int padre) {
        List<SelectItem> items = new ArrayList<>();

        try {
            List<Maestro> lista = maestroService.listaCompuesta(new Maestro(grupo, padre));
                for (Maestro tipo : lista) {
                    items.add(new SelectItem(tipo.getValor(), tipo.getNombre()));
                }
        } catch (Exception e) {
            log.error(e);
        }
        return items;
    }

    private List<SelectItem> cargarListaSimple(int grupo) {
        List<SelectItem> items = new ArrayList<>();
        try {
            List<Maestro> lista = maestroService.listaSimple(new Maestro(grupo));
            
                for (Maestro tipo : lista) {
                    items.add(new SelectItem(tipo.getValor(), tipo.getNombre()));
                }
        } catch (Exception e) {
            log.error(e);
        }
        return items;
    }

    /**
     * GETTER AND SETTE
     *
     * @return R
     */
    public ActorTemp getActorTemp() {
        return actorTemp;
    }

    public void setActorTemp(ActorTemp actorTemp) {
        this.actorTemp = actorTemp;
    }

    public ActorBusquedaTemp getActorBusquedaTemp() {
        if (actorBusquedaTemp == null) {
            actorBusquedaTemp = new ActorBusquedaTemp();
        }
        return actorBusquedaTemp;
    }

    public void setActorBusquedaTemp(ActorBusquedaTemp actorBusquedaTemp) {
        this.actorBusquedaTemp = actorBusquedaTemp;
    }

    public List<ActorHistorial> getListaActorHistorial() {
        return listaActorHistorial;
    }

    public void setListaActorHistorial(List<ActorHistorial> listaActorHistorial) {
        this.listaActorHistorial = listaActorHistorial;
    }

    public List<Actividad> getListaActividadxActor() {
        return listaActividadxActor;
    }

    public void setListaActividadxActor(List<Actividad> listaActividadxActor) {
        this.listaActividadxActor = listaActividadxActor;
    }

    public List<Actividad> getListaActividadxActorTotal() {
        return listaActividadxActorTotal;
    }

    public void setListaActividadxActorTotal(List<Actividad> listaActividadxActorTotal) {
        this.listaActividadxActorTotal = listaActividadxActorTotal;
    }

    public boolean isVerVinculoActividad() {
        return verVinculoActividad;
    }

    public void setVerVinculoActividad(boolean verVinculoActividad) {
        this.verVinculoActividad = verVinculoActividad;
    }

    public boolean isVerBoton() {
        return verBoton;
    }

    public void setVerBoton(boolean verBoton) {
        this.verBoton = verBoton;
    }

    public boolean isVerBotonActividad() {
        return verBotonActividad;
    }

    public void setVerBotonActividad(boolean verBotonActividad) {
        this.verBotonActividad = verBotonActividad;
    }

    public boolean isVerVinculosMantenimientoActor() {
        return verVinculosMantenimientoActor;
    }

    public void setVerVinculosMantenimientoActor(boolean verVinculosMantenimientoActor) {
        this.verVinculosMantenimientoActor = verVinculosMantenimientoActor;
    }

    public List<Actor> getListaActorxActorPaginado() {
        return listaActorxActorPaginado;
    }

    public void setListaActorxActorPaginado(List<Actor> listaActorxActorPaginado) {
        this.listaActorxActorPaginado = listaActorxActorPaginado;
    }

    public List<Actor> getListaActorPaginado() {
        return listaActorPaginado;
    }

    public void setListaActorPaginado(List<Actor> listaActorPaginado) {
        this.listaActorPaginado = listaActorPaginado;
    }

    public Long getNroPagina() {
        return nroPagina;
    }

    public void setNroPagina(Long nroPagina) {
        this.nroPagina = nroPagina;
    }

    public List<Actor> getListaActorSeleccionado() {
        return listaActorSeleccionado;
    }

    public void setListaActorSeleccionado(List<Actor> listaActorSeleccionado) {
        this.listaActorSeleccionado = listaActorSeleccionado;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<Actor> getListaActorSeleccionadoFinal() {
        return listaActorSeleccionadoFinal;
    }

    public void setListaActorSeleccionadoFinal(List<Actor> listaActorSeleccionadoFinal) {
        this.listaActorSeleccionadoFinal = listaActorSeleccionadoFinal;
    }

    public ActividadActor getActividadActor() {
        return actividadActor;
    }

    public void setActividadActor(ActividadActor actividadActor) {
        this.actividadActor = actividadActor;
    }

    public ActividadActorTemp getActividadActorTemp() {
        return actividadActorTemp;
    }

    public void setActividadActorTemp(ActividadActorTemp actividadActorTemp) {
        this.actividadActorTemp = actividadActorTemp;
    }

    public List<Actor> getListaActorSeleccionadoAcuerdoIni() {
        return listaActorSeleccionadoAcuerdoIni;
    }

    public void setListaActorSeleccionadoAcuerdoIni(List<Actor> listaActorSeleccionadoAcuerdoIni) {
        this.listaActorSeleccionadoAcuerdoIni = listaActorSeleccionadoAcuerdoIni;
    }

    public List<Actor> getListaActorSeleccionadoAcuerdoFin() {
        return listaActorSeleccionadoAcuerdoFin;
    }

    public void setListaActorSeleccionadoAcuerdoFin(List<Actor> listaActorSeleccionadoAcuerdoFin) {
        this.listaActorSeleccionadoAcuerdoFin = listaActorSeleccionadoAcuerdoFin;
    }

    public String getCadenaAutocomplete() {
        return cadenaAutocomplete;
    }

    public void setCadenaAutocomplete(String cadenaAutocomplete) {
        this.cadenaAutocomplete = cadenaAutocomplete;
    }

    public Actor getActor2() {
        return actor2;
    }

    public void setActor2(Actor actor2) {
        this.actor2 = actor2;
    }

    public List<Actor> getListaActorPaginado2() {
        return listaActorPaginado2;
    }

    public void setListaActorPaginado2(List<Actor> listaActorPaginado2) {
        this.listaActorPaginado2 = listaActorPaginado2;
    }

    public String getCadenaAutocomplete3() {
        return cadenaAutocomplete3;
    }

    public void setCadenaAutocomplete3(String cadenaAutocomplete3) {
        this.cadenaAutocomplete3 = cadenaAutocomplete3;
    }

    public String getCadenaAutocomplete4() {
        return cadenaAutocomplete4;
    }

    public void setCadenaAutocomplete4(String cadenaAutocomplete4) {
        this.cadenaAutocomplete4 = cadenaAutocomplete4;
    }

    public List<Actor> getListaActorBusquedaGeneral() {
        return listaActorBusquedaGeneral;
    }

    public void setListaActorBusquedaGeneral(List<Actor> listaActorBusquedaGeneral) {
        this.listaActorBusquedaGeneral = listaActorBusquedaGeneral;
    }

    public List<Actor> getListaActorCasosSigues() {
        return listaActorCasosSigues;
    }

    public void setListaActorCasosSigues(List<Actor> listaActorCasosSigues) {
        this.listaActorCasosSigues = listaActorCasosSigues;
    }

    public List<SelectItem> getListaDepartamento() {
        listaDepartamento = new ArrayList<>();
        List<Departamento> list = ubigeoService.departamentoLista();
        if (list.size() > 0) {
            for (Departamento departamento : list) {
                listaDepartamento.add(new SelectItem(departamento.getId(), departamento.getDescripcion()));
            }
        }
        return listaDepartamento;
    }

    public void setListaDepartamento(List<SelectItem> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<SelectItem> getListaProvincia() {
        return listaProvincia;
    }

    public void setListaProvincia(List<SelectItem> listaProvincia) {
        this.listaProvincia = listaProvincia;
    }

    public List<SelectItem> getListaDistrito() {
        return listaDistrito;
    }

    public void setListaDistrito(List<SelectItem> listaDistrito) {
        this.listaDistrito = listaDistrito;
    }

    public Boolean getTip() {
        return tip;
    }

    public void setTip(Boolean tip) {
        this.tip = tip;
    }

    public Actor getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Actor empresa) {
        this.empresa = empresa;
    }

    public List<ActorMiembro> getListaMiembros() {
        return listaMiembros;
    }

    public void setListaMiembros(List<ActorMiembro> listaMiembros) {
        this.listaMiembros = listaMiembros;
    }

    public ActorMiembro getActorMiembro() {
        return actorMiembro;
    }

    public void setActorMiembro(ActorMiembro actorMiembro) {
        this.actorMiembro = actorMiembro;
    }

    public List<ActorMiembro> getListaMiembrosRegistrados() {
        return listaMiembrosRegistrados;
    }

    public void setListaMiembrosRegistrados(List<ActorMiembro> listaMiembrosRegistrados) {
        this.listaMiembrosRegistrados = listaMiembrosRegistrados;
    }

    public Actor getEntidad() {
        return entidad;
    }

    public void setEntidad(Actor entidad) {
        this.entidad = entidad;
    }

    public ActorMiembro getActorMiembroEntidad() {
        return actorMiembroEntidad;
    }

    public void setActorMiembroEntidad(ActorMiembro actorMiembroEntidad) {
        this.actorMiembroEntidad = actorMiembroEntidad;
    }

    public List<ActorMiembro> getListaMiembrosEntidad() {
        return listaMiembrosEntidad;
    }

    public void setListaMiembrosEntidad(List<ActorMiembro> listaMiembrosEntidad) {
        this.listaMiembrosEntidad = listaMiembrosEntidad;
    }

    public List<ActorMiembro> getListaMiembrosRegistradosEntidad() {
        return listaMiembrosRegistradosEntidad;
    }

    public void setListaMiembrosRegistradosEntidad(List<ActorMiembro> listaMiembrosRegistradosEntidad) {
        this.listaMiembrosRegistradosEntidad = listaMiembrosRegistradosEntidad;
    }

    public String getCssDisable() {
        return cssDisable;
    }

    public void setCssDisable(String cssDisable) {
        this.cssDisable = cssDisable;
    }

    public int getIndicadorPersona() {
        return indicadorPersona;
    }

    public void setIndicadorPersona(int indicadorPersona) {
        this.indicadorPersona = indicadorPersona;
    }

    public MessagesUtil getMsg() {
        return msg;
    }

    public void setMsg(MessagesUtil msg) {
        this.msg = msg;
    }

    public String getCadenaAutocompleteEmpresaEntidad() {
        return cadenaAutocompleteEmpresaEntidad;
    }

    public void setCadenaAutocompleteEmpresaEntidad(String cadenaAutocompleteEmpresaEntidad) {
        this.cadenaAutocompleteEmpresaEntidad = cadenaAutocompleteEmpresaEntidad;
    }

    public ActorMiembro getActorMiembroPesona() {
        return actorMiembroPesona;
    }

    public void setActorMiembroPesona(ActorMiembro actorMiembroPesona) {
        this.actorMiembroPesona = actorMiembroPesona;
    }

    public List<ActorMiembro> getListaMiembrosPersona() {
        return listaMiembrosPersona;
    }

    public void setListaMiembrosPersona(List<ActorMiembro> listaMiembrosPersona) {
        this.listaMiembrosPersona = listaMiembrosPersona;
    }

    public List<ActorMiembro> getListaMiembrosRegistradosPersona() {
        return listaMiembrosRegistradosPersona;
    }

    public void setListaMiembrosRegistradosPersona(List<ActorMiembro> listaMiembrosRegistradosPersona) {
        this.listaMiembrosRegistradosPersona = listaMiembrosRegistradosPersona;
    }

    public List<SelectItem> getListaTipoPoblacion() {
        return listaTipoPoblacion;
    }

    public void setListaTipoPoblacion(List<SelectItem> listaTipoPoblacion) {
        this.listaTipoPoblacion = listaTipoPoblacion;
    }

    public List<SelectItem> getListaSubTipo1Poblacion() {
        return listaSubTipo1Poblacion;
    }

    public void setListaSubTipo1Poblacion(List<SelectItem> listaSubTipo1Poblacion) {
        this.listaSubTipo1Poblacion = listaSubTipo1Poblacion;
    }

    public List<SelectItem> getListaSubTipo2Poblacion() {
        return listaSubTipo2Poblacion;
    }

    public void setListaSubTipo2Poblacion(List<SelectItem> listaSubTipo2Poblacion) {
        this.listaSubTipo2Poblacion = listaSubTipo2Poblacion;
    }

    public List<SelectItem> getListaTipoEstado() {
        return listaTipoEstado;
    }

    public void setListaTipoEstado(List<SelectItem> listaTipoEstado) {
        this.listaTipoEstado = listaTipoEstado;
    }

    public List<SelectItem> getListaSubTipo1Estado() {
        return listaSubTipo1Estado;
    }

    public void setListaSubTipo1Estado(List<SelectItem> listaSubTipo1Estado) {
        this.listaSubTipo1Estado = listaSubTipo1Estado;
    }

    public List<SelectItem> getListaSubTipo2Estado() {
        return listaSubTipo2Estado;
    }

    public void setListaSubTipo2Estado(List<SelectItem> listaSubTipo2Estado) {
        this.listaSubTipo2Estado = listaSubTipo2Estado;
    }

    public List<SelectItem> getListaTipoEmpresa() {
        return listaTipoEmpresa;
    }

    public void setListaTipoEmpresa(List<SelectItem> listaTipoEmpresa) {
        this.listaTipoEmpresa = listaTipoEmpresa;
    }

    public List<SelectItem> getListaSubTipo1Empresa() {
        return listaSubTipo1Empresa;
    }

    public void setListaSubTipo1Empresa(List<SelectItem> listaSubTipo1Empresa) {
        this.listaSubTipo1Empresa = listaSubTipo1Empresa;
    }

    public List<SelectItem> getListaSubTipo2Empresa() {
        return listaSubTipo2Empresa;
    }

    public void setListaSubTipo2Empresa(List<SelectItem> listaSubTipo2Empresa) {
        this.listaSubTipo2Empresa = listaSubTipo2Empresa;
    }

    public List<SelectItem> getListaTipoOrganizacion() {
        return listaTipoOrganizacion;
    }

    public void setListaTipoOrganizacion(List<SelectItem> listaTipoOrganizacion) {
        this.listaTipoOrganizacion = listaTipoOrganizacion;
    }

    public List<SelectItem> getListaSubTipo1Organizacion() {
        return listaSubTipo1Organizacion;
    }

    public void setListaSubTipo1Organizacion(List<SelectItem> listaSubTipo1Organizacion) {
        this.listaSubTipo1Organizacion = listaSubTipo1Organizacion;
    }

    public List<SelectItem> getListaSubTipo2Organizacion() {
        return listaSubTipo2Organizacion;
    }

    public void setListaSubTipo2Organizacion(List<SelectItem> listaSubTipo2Organizacion) {
        this.listaSubTipo2Organizacion = listaSubTipo2Organizacion;
    }

    public List<SelectItem> getListaSubTipo3Empresa() {
        return listaSubTipo3Empresa;
    }

    public void setListaSubTipo3Empresa(List<SelectItem> listaSubTipo3Empresa) {
        this.listaSubTipo3Empresa = listaSubTipo3Empresa;
    }

    

}
