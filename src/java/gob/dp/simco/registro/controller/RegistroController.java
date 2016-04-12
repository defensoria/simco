/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.registro.controller;

import gob.dp.simco.administracion.seguridad.controller.LoginController;
import gob.dp.simco.administracion.seguridad.entity.Usuario;
import gob.dp.simco.comun.MessagesUtil;
import gob.dp.simco.comun.entity.Departamento;
import gob.dp.simco.comun.entity.Distrito;
import gob.dp.simco.comun.entity.Provincia;
import gob.dp.simco.comun.service.UbigeoService;
import gob.dp.simco.noticia.entity.Noticia;
import gob.dp.simco.noticia.service.NoticiaService;
import gob.dp.simco.registro.bean.FiltroActividad;
import gob.dp.simco.registro.constantes.ConstantesUtil;
import gob.dp.simco.registro.entity.ActaAcuerdo;
import gob.dp.simco.registro.entity.Actividad;
import gob.dp.simco.registro.entity.ActividadActaAcuerdo;
import gob.dp.simco.registro.entity.ActividadActividad;
import gob.dp.simco.registro.entity.ActividadActor;
import gob.dp.simco.registro.entity.ActividadCaso;
import gob.dp.simco.registro.entity.ActividadHistorial;
import gob.dp.simco.registro.entity.ActividadMedioVerificacion;
import gob.dp.simco.registro.entity.Actor;
import gob.dp.simco.registro.entity.Caso;
import gob.dp.simco.registro.entity.MedioVerificacion;
import gob.dp.simco.registro.entity.NoticiaRegistro;
import gob.dp.simco.registro.entity.Parametro;
import gob.dp.simco.registro.service.ActaAcuerdoDetalleService;
import gob.dp.simco.registro.service.ActaAcuerdoService;
import gob.dp.simco.registro.service.ActividadActaAcuerdoService;
import gob.dp.simco.registro.service.ActividadActividadService;
import gob.dp.simco.registro.service.ActividadActorService;
import gob.dp.simco.registro.service.ActividadCasoService;
import gob.dp.simco.registro.service.ActividadHistorialService;
import gob.dp.simco.registro.service.ActividadMedioVerificacionService;
import gob.dp.simco.registro.service.ActividadService;
import gob.dp.simco.registro.service.ActorService;
import gob.dp.simco.registro.service.CasoService;
import gob.dp.simco.registro.service.MedioVerificacionService;
import gob.dp.simco.registro.service.NoticiaRegistroService;
import gob.dp.simco.registro.type.HistorialType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
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
public class RegistroController implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroController.class);

    private ActividadTemp actividadTemp;

    private ActorTemp actorTemp;

    private ActividadBusquedaTemp actividadBusquedaTemp;

    private ActividadActorTemp actividadActorTemp;

    private ActividadCaso actividadCaso;

    private Caso caso;

    private Noticia noticia;

    private List<Actor> listaActoresxActividad;

    private List<Actor> listaActoresxActividadTotal;

    private List<ActaAcuerdo> listaActaAcuerdoxActividad;

    private List<ActaAcuerdo> listaActaAcuerdoxActividadTotal;

    private List<MedioVerificacion> listaMedioVerificacionxActividad;

    private List<MedioVerificacion> listaMedioVerificacionxActividadTotal;

    private List<Caso> listaCasoxActividad;

    private List<Caso> listaCasoxActividadTotal;

    private List<Caso> casos;

    private List<Actividad> listaActividadxActividad;

    private List<Actividad> listaActividadxActividadTotal;

    private List<ActividadHistorial> listaActividadHistorial;

    private List<Noticia> listaNoticias;

    private List<NoticiaRegistro> listaNoticiasRegistros;

    private boolean verVinculosMantenimientoActividad = false;

    private List<SelectItem> listaDepartamento;

    private List<SelectItem> listaProvincia;

    private List<SelectItem> listaDistrito;

    private boolean verBoton = false;

    private boolean verDetalleRegistro = false;

    private Boolean tipoBoton;

    private String nombreCaso = null;

    private String cadenaAutocomplete;

    private int nroActaAcuerdoDetalle = 0;

    private Usuario usuarioSession;

    private ActaAcuerdo actaAcuerdo;

    private Long nroPagina = 1L;

    private String detalleNoticia;

    private boolean verEnlaceNoticia;

    Integer tip = 1;

    private String cordenadax;

    private String cordenaday;

    private Integer zoom;

    private Part file1;

    private MessagesUtil msg;
    
    private List<Actividad> listaActividadesPorCaso;

    @Autowired
    private ActividadService actividadService;

    @Autowired
    private ActividadActorService actividadActorService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private ActividadActaAcuerdoService actividadActaAcuerdoService;

    @Autowired
    private ActaAcuerdoService actaAcuerdoService;

    @Autowired
    private ActividadMedioVerificacionService actividadMedioVerificacionService;

    @Autowired
    private MedioVerificacionService medioVerificacionService;

    @Autowired
    private ActividadCasoService actividadCasoService;

    @Autowired
    private CasoService casoService;

    @Autowired
    private ActividadHistorialService actividadHistorialService;

    @Autowired
    private ActividadActividadService actividadActividadService;

    @Autowired
    private UbigeoService ubigeoService;

    @Autowired
    private ActaAcuerdoDetalleService actaAcuerdoDetalleService;

    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private NoticiaRegistroService noticiaRegistroService;

    public String cargarPagina() {
        msg = new MessagesUtil();
        usuarioSession();
        actividadTemp = new ActividadTemp();
        cambiarPaginaEstado(null);
        limpiarListasActores();
        limpiarActaAcuerdo();
        limpiarMedios();
        limpiarVictimas();
        verDetalleRegistro = false;
        actividadCaso = new ActividadCaso();
        nombreCaso = null;
        generarCadenaCasos();
        caso = new Caso();
        listaNoticiasRegistros = new ArrayList<>();
        return "registroNuevo";
    }

    public String cargarNoticias(int tipo) {
        setTip(tipo);
        noticia = new Noticia();
        listaNoticias = null;
        if (tipo == 1) {
            listaNoticiasRegistro();
        }

        verEnlaceNoticia = true;
        return "noticiaVinculo";
    }

    public String cargarNoticiasCaso() {
        noticia = new Noticia();
        verEnlaceNoticia = false;
        listaNoticias = null;
        return "noticiaVinculo";
    }

    private void usuarioSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        LoginController loginController = (LoginController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "loginController");
        usuarioSession = loginController.getUsuarioSesion();
    }

    private void limpiarMedios() {
        FacesContext context = FacesContext.getCurrentInstance();
        MedioVerificacionController medioVerificacionController = (MedioVerificacionController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "medioVerificacionController");
        medioVerificacionController.limpiarListaMedios();
    }
    
    public void cargarActontecimientoPorCaso(){
        if(caso.getId() != null)
            listaActividadesPorCaso = actividadService.actividadBusquedaPorCasoAC(caso.getId());
    }
    
    public void vincularAcontecimientoActuacion(Actividad acontecimiento){
        Actividad a = new Actividad();
        a.setId(actividadTemp.getId());
        a.setIdAcontecimiento(acontecimiento.getId());
        actividadService.actividadUpdateAcontecimiento(a);
        actividadService.actividadUpdateVincular(acontecimiento.getId());
        msg.messageInfo("Se vinculo el acontecimiento", null);
    }

    public String irModificarRegistro(Actividad acti) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ActorController actorController = (ActorController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "actorController");
            MedioVerificacionController medioVerificacionController = (MedioVerificacionController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "medioVerificacionController");
            actorController.initActor();
            medioVerificacionController.listarMedioVerificacion(acti.getId());
            usuarioSession();
            verDetalleRegistro = true;
            actividadTemp = new ActividadTemp();
            actividadTemp = actividadHaciaActividadTemp(acti);
            generarCadenaCasos();
            caso = new Caso();
            caso.setNombre(acti.getNombreCaso());
            caso.setId(acti.getIdCaso());
            if (acti.getIdDepartamento() != 0) {
                comboProvincia();
            }
            if (acti.getIdProvincia() != 0) {
                comboDistrito();
            }
            actorController.listarActoresXcaso(acti.getId());
            nroActaAcuerdoDetalle = 0;
            nroActaAcuerdoDetalle = actaAcuerdoDetalleService.actaAcuerdoDetalleCount(acti.getId());
            actaAcuerdo = new ActaAcuerdo();
            actaAcuerdo = actaAcuerdoService.actaAcuerdoxActividadBuscarOne(acti.getId());

            listaNoticiasRegistro();
            limpiarActaAcuerdo();
            limpiarVictimas2();
            msg = new MessagesUtil();
            return "registroEdit";
        } catch (Exception ex) {
            log.error(ex.getCause());
            return null;
        }
    }

    public String irModificarRegistro2(Actividad acti) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ActorController actorController = (ActorController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "actorController");
            MedioVerificacionController medioVerificacionController = (MedioVerificacionController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "medioVerificacionController");
            actorController.initActor();
            medioVerificacionController.listarMedioVerificacion(acti.getId());
            usuarioSession();
            verDetalleRegistro = true;
            actividadTemp = new ActividadTemp();
            actividadTemp = actividadHaciaActividadTemp(acti);
            generarCadenaCasos();
            caso = new Caso();
            caso.setNombre(acti.getNombreCaso());
            caso.setId(acti.getIdCaso());
            if (acti.getIdDepartamento() != 0) {
                comboProvincia();
            }
            if (acti.getIdProvincia() != 0) {
                comboDistrito();
            }
            actorController.listarActoresXcaso(acti.getId());
            nroActaAcuerdoDetalle = 0;
            nroActaAcuerdoDetalle = actaAcuerdoDetalleService.actaAcuerdoDetalleCount(acti.getId());
            limpiarActaAcuerdo();
            actaAcuerdo = new ActaAcuerdo();
            actaAcuerdo = actaAcuerdoService.actaAcuerdoxActividadBuscarOne(acti.getId());
            listaNoticiasRegistro();
            limpiarVictimas2();
            msg = new MessagesUtil();
            return "registroNuevo";
        } catch (Exception ex) {
            log.error(ex.getCause());
            return null;
        }
    }

    public void verDetalleNoticia(String detalle) {
        detalleNoticia = detalle;
    }

    public Actividad cargarActividadId(long idActividad) {
        Actividad a = actividadService.actividadxCasoBuscarID(idActividad);
        if (a != null) {
            return a;
        }
        return null;
    }

    public void cargarAcontecimientoModal(Caso c, int tipo) {
        tipoBoton = null;
        setCaso(c);
        FacesContext context = FacesContext.getCurrentInstance();
        ActorController actorController = (ActorController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "actorController");
        actorController.limpiarListaActorPaginado();
        actorController.cargarRegistroAgregarActor(c);
        usuarioSession();
        actividadCaso = new ActividadCaso();
        actividadTemp = new ActividadTemp();
        tipoBoton = tipo == 1;
        verDetalleRegistro = false;
        cambiarPaginaEstado(null);
    }

    public boolean vinculaNoticia(Noticia noticia) {
        NoticiaRegistro noticiaRegistro = new NoticiaRegistro();
        noticiaRegistro.setDescripcion(noticia.getDescripcion());
        noticiaRegistro.setEmpresa(noticia.getEmpresa());
        noticiaRegistro.setFechaPublicacion(noticia.getFechaPublica());
        noticiaRegistro.setFechaRegistro(noticia.getFechaRegistro());
        noticiaRegistro.setLink(noticia.getLink());
        noticiaRegistro.setRegion(noticia.getRegion());
        noticiaRegistro.setTitulo(noticia.getTitulo());
        noticiaRegistro.setIdActividad(actividadTemp.getId());
        noticiaRegistro.setEstado("ACT");
        for (NoticiaRegistro noticia1 : listaNoticiasRegistros) {
            if (StringUtils.equals(noticia.getTitulo(), noticia1.getTitulo())) {
                msg.messageAlert("Esta noticia ya fue vinculada", null);
                return false;
            }
        }
        listaNoticiasRegistros.add(noticiaRegistro);
        msg.messageInfo("Se vinculo la noticia", null);
        return true;
    }

    public void listaNoticiasRegistro() {
        List<NoticiaRegistro> list = noticiaRegistroService.noticiaRegistroBuscar(actividadTemp.getId());
        listaNoticiasRegistros = new ArrayList<>();
        listaNoticiasRegistros.addAll(list);
    }

    public void eliminarNoticiaRegistro(NoticiaRegistro noticiaRegistro) {
        noticiaRegistro.setEstado("INA");
        msg.messageAlert("Se ha marcado para eliminar esta noticia", null);
    }

    public String guardarVinculos() {
        if (listaNoticiasRegistros.isEmpty()) {
            msg.messageAlert("Debe de enlazar por lo menos una noticia para poder guardar", null);
            return null;
        }
        for (NoticiaRegistro noticiaRegistro : listaNoticiasRegistros) {
            if (noticiaRegistro.getId() == null) {
                noticiaRegistroService.noticiaRegistroInsertar(noticiaRegistro);
            } else {
                noticiaRegistroService.noticiaRegistroUpdate(noticiaRegistro);
            }
        }
        listaNoticiasRegistro();
        msg.messageInfo("Se han registrado los cambios", null);
        if (tip == 1) {
            return "registroNuevo";
        } else {
            return "registroEdit";
        }
    }

    private void generarCadenaCasos() {
        try {
            cadenaAutocomplete = casoService.casoBuscarAutocomplete();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public String generarCodigoAD() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMM");
        String codigo = formato.format(new Date());
        String numero = String.format("%2s", actividadService.actividadADCodigoGenerado().toString()).replace(' ', '0');
        return "AC" + codigo + numero;
    }

    public void buscarNoticia(Long pagina) {
        if (pagina > 0) {
            int paginado = ConstantesUtil.PAGINADO_10;
            Long ini = paginado * (pagina - 1) + 1;
            Long fin = paginado * pagina;
            if (pagina == 0) {
                ini = 1L;
                fin = 10L;
            }
            noticia.setIni(ini);
            noticia.setFin(fin);
            try {
                List<Noticia> list = noticiaService.listaNoticias(noticia);
                if (list.size() > 0) {
                    listaNoticias = list;
                    nroPagina = pagina;
                } else {
                    listaNoticias = null;
                    msg.messageAlert("La busqueda no ha obtenido resultados", null);
                }

            } catch (Exception e) {
                log.error(e);

            }
        }
    }

    public void limpiarNoticias() {
        noticia = new Noticia();
        listaNoticias = null;
    }

    public void buscarCaso() {
        try {
            casos = casoService.casoBuscar(caso);
        } catch (Exception ex) {
            log.error("ERROR : CasoController.buscarCaso" + ex.getMessage());
        }
    }

    private void limpiarListasActores() {
        FacesContext context = FacesContext.getCurrentInstance();
        ActorController actorController = (ActorController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "actorController");
        actorController.limpiarListas();
    }

    private void limpiarActaAcuerdo() {
        FacesContext context = FacesContext.getCurrentInstance();
        ActaAcuerdoController actaAcuerdoController = (ActaAcuerdoController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "actaAcuerdoController");
        actaAcuerdoController.limpiarActaAcuerdo();
    }

    private void limpiarVictimas() {
        FacesContext context = FacesContext.getCurrentInstance();
        VictimaViolenciaController victimaViolenciaController = (VictimaViolenciaController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "victimaViolenciaController");
        victimaViolenciaController.limpiarVictimas();
    }

    private void limpiarVictimas2() {
        FacesContext context = FacesContext.getCurrentInstance();
        VictimaViolenciaController victimaViolenciaController = (VictimaViolenciaController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "victimaViolenciaController");
        victimaViolenciaController.limpiarVictimasEdit(actividadTemp.getId());
    }

    public String cargarPaginaRetornoActividad(int tipo) {
        actividadTemp = new ActividadTemp();
        actorTemp = new ActorTemp();
        cambiarPaginaEstado(null);
        verVinculosMantenimientoActividad = false;
        return "registroNuevo";
    }

    public String cargarPaginaBusqueda(int tipo) {
        log.debug("METODO : ActividadController.cargarPaginaBusqueda");
        actividadBusquedaTemp = new ActividadBusquedaTemp();
        //definelink(tipo);
        return "actividadBusqueda";
    }

    public String regresarPaginaBusqueda() {
        log.debug("METODO : ActividadController.regresarPaginaBusqueda");
        return "actividadBusqueda";
    }

    public String regresarDeNoticias() {
        listaNoticiasRegistro();
        if (tip == 1) {
            return "registroNuevo";
        } else {
            return "registroEdit";
        }
    }

    public String cargarPaginaCrearActor() {
        actorTemp.setIndicadorActorExiste(false);
        return "";
    }

    private void cambiarPaginaEstado(String estado) {
        if (estado == null) {
            actividadTemp.setIsIndicadorActividadExiste(false);
        }
    }

    public void registrarActividad() {
        Actividad actividad;
        actividad = actividadTempHaciaActividad(actividadTemp);
        String ruta = uploadArchiveImage();
        if (StringUtils.isNoneBlank(ruta)) {
            actividad.setRuta(ruta);
        }
        try {
            String accionHistorial;
            if (actividadTemp.isIsIndicadorActividadExiste()) {
                actividad.setFechaModificacion(new Date());
                actividad.setUsuarioModificacion(usuarioSession.getCodigo());
                actividadService.actividadModificar(actividad);
                if (caso.getId() != null) {
                    insertaUpdateActividadCaso(setearActividadCaso(actividad, caso));
                }
                actividadTemp = actividadHaciaActividadTemp(actividad);
                accionHistorial = HistorialType.HISTORIAL_ACTUALIZACION.getKey();
            } else {
                actividad.setFechaRegistro(new Date());
                actividad.setUsuarioRegistro(usuarioSession.getCodigo());
                actividad.setCodigoActividad(generarCodigoAD());
                actividadService.actividadNuevo(actividad);
                actividadTemp = actividadHaciaActividadTemp(actividad);
                accionHistorial = HistorialType.HISTORIAL_CREACION.getKey();
                if (caso != null) {
                    if (caso.getId() != null) {
                        insertaUpdateActividadCaso(setearActividadCaso(actividad, caso));
                    }
                }
                verDetalleRegistro = true;
            }
            historialActividad(accionHistorial, actividadTemp.getId());
            msg.messageInfo("Se realizadon los cambios", null);
        } catch (Exception e) {
            log.error(e);
        }
    }

    private void insertaUpdateActividadCaso(ActividadCaso ac) {
        int count = actividadCasoService.actividadCasoValida(ac.getActividad().getId());
        if (count == 0) {
            actividadCasoService.actividadCasoInsertar(ac);
        } else {
            actividadCasoService.actividadCasoUpdate(ac);
        }
    }

    private String uploadArchiveImage() {
        String nameArchive = getFilename(file1);
        String extencion = "";
        if (StringUtils.isNoneBlank(nameArchive)) {
            switch (file1.getContentType()) {
                case "image/png":
                    extencion = ".png";
                    break;
                case "image/jpeg":
                    extencion = ".jpg";
                    break;
                case "image/gif":
                    extencion = ".gif";
                    break;
            }

            DateFormat fechaHora = new SimpleDateFormat("yyyyMMddHHmmss");
            String formato = fechaHora.format(new Date());
            String ruta = formato + extencion;
            File file = new File(ConstantesUtil.FILE_SYSTEM + ruta);
            try (InputStream input = file1.getInputStream()) {
                Files.copy(input, file.toPath());
            } catch (IOException ex) {
                log.error(ex.getCause());
            }
            return ruta;
        }
        return null;
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    public void registrarActividadModal(int tipo) {
        Actividad actividad;
        actividad = actividadTempHaciaActividad(actividadTemp);
        if (tipo == 1) {
            actividad.setTipo("AC");
        }
        if (tipo == 2) {
            actividad.setTipo("AD");
        }
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            String accionHistorial;
            if (actividadTemp.isIsIndicadorActividadExiste()) {
                actividad.setFechaModificacion(new Date());
                actividad.setUsuarioModificacion(usuarioSession.getCodigo());
                actividadService.actividadModificar(actividad);
                if (caso.getId() != null) {
                    actividadCasoService.actividadCasoUpdate(setearActividadCaso(actividad, caso));
                }

                ActorController actorController = (ActorController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "actorController");
                actorController.actividadUnionActorModal(actividad.getId());
                //addInfo(getMessage("registro.actividad.actualizo.ok"));
                accionHistorial = HistorialType.HISTORIAL_ACTUALIZACION.getKey();
            } else {
                actividad.setFechaRegistro(new Date());
                actividad.setUsuarioRegistro(usuarioSession.getCodigo());
                actividad.setCodigoActividad(generarCodigoAD());
                actividadService.actividadNuevo(actividad);
                actividadTemp = actividadHaciaActividadTemp(actividad);
                //addInfo(getMessage("registro.actividad.guardar.ok"));
                accionHistorial = HistorialType.HISTORIAL_CREACION.getKey();
                if (caso != null) {
                    if (caso.getId() != null) {
                        actividadCasoService.actividadCasoInsertar(setearActividadCaso(actividad, caso));
                    }

                }
                verDetalleRegistro = true;
            }
            CasoController casoController = (CasoController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "casoController");
            casoController.contarActividades();
            historialActividad(accionHistorial, actividadTemp.getId());
        } catch (Exception e) {
            log.error(e.getCause());
        }
    }

    private ActividadCaso setearActividadCaso(Actividad a, Caso c) {
        actividadCaso = new ActividadCaso();
        actividadCaso.setCaso(c);
        actividadCaso.setActividad(a);
        actividadCaso.setEstado("ACT");
        return actividadCaso;
    }
    
    private ActividadTemp actividadHaciaActividadTemp(Actividad actividad) {
        ActividadTemp out = new ActividadTemp();
        out.setId(actividad.getId());
        out.setNombre(actividad.getNombre());
        out.setDescripcion(actividad.getDescripcion());
        out.setLugarRealizacion(actividad.getLugarRealizacion());
        out.setFechaRealizacionIni(actividad.getFechaRealizacionIni());
        out.setFechaRealizacionFin(actividad.getFechaRealizacionFin());
        out.setHoraRealizacionIni(actividad.getHoraRealizacionIni());
        out.setHoraRealizacionFin(actividad.getHoraRealizacionFin());
        out.setIsIndicadorActividadExiste(true);
        out.setCodigoActividad(actividad.getCodigoActividad());
        out.setComentario(actividad.getComentario());
        out.setIdDepartamento(actividad.getIdDepartamento());
        out.setIdProvincia(actividad.getIdProvincia());
        out.setIdDistrito(actividad.getIdDistrito());
        out.setCoordenadaX(actividad.getCoordenadaX());
        out.setCoordenadaY(actividad.getCoordenadaY());
        out.setZoom(actividad.getZoom());
        out.setTipo(actividad.getTipo());
        out.setRuta(actividad.getRuta());
        out.setTipoAcontecimiento(actividad.getTipoAcontecimiento());
        out.setTipoViolencia(actividad.getTipoViolencia());
        out.setResultadoViolencia(actividad.getResultadoViolencia());
        if (actividad.getIndCurso() == 1) {
            out.setIndCurso(true);
        } else {
            out.setIndCurso(false);
        }
        out.setTipoActividad(actividad.getTipoActividad() == null ? null : actividad.getTipoActividad().getValorParametro());
        out.setTipoActividadNombre(actividad.getTipoActividad() == null ? null : actividad.getTipoActividad().getNombreParametro());
        out.setJustificacionIntervencion(actividad.getJustificacionIntervencion());
        out.setIdAcontecimiento(actividad.getIdAcontecimiento());
        out.setIndiceVinculado(actividad.getIndiceVinculado());
        return out;
    }

    private Actividad actividadTempHaciaActividad(ActividadTemp actividadTemp) {
        Actividad out = new Actividad();
        out.setId(actividadTemp.getId());
        out.setNombre(actividadTemp.getNombre());
        out.setDescripcion(actividadTemp.getDescripcion());
        out.setLugarRealizacion(actividadTemp.getLugarRealizacion());
        out.setFechaRealizacionIni(actividadTemp.getFechaRealizacionIni());
        out.setFechaRealizacionFin(actividadTemp.getFechaRealizacionFin());
        out.setHoraRealizacionIni(actividadTemp.getHoraRealizacionIni());
        out.setHoraRealizacionFin(actividadTemp.getHoraRealizacionFin());
        out.setCodigoActividad(actividadTemp.getCodigoActividad());
        out.setComentario(actividadTemp.getComentario());
        out.setIdDepartamento(actividadTemp.getIdDepartamento());
        out.setIdProvincia(actividadTemp.getIdProvincia());
        out.setIdDistrito(actividadTemp.getIdDistrito());
        out.setCoordenadaX(actividadTemp.getCoordenadaX());
        out.setCoordenadaY(actividadTemp.getCoordenadaY());
        out.setZoom(actividadTemp.getZoom());
        out.setTipo(actividadTemp.getTipo());
        out.setRuta(actividadTemp.getRuta());
        out.setTipoAcontecimiento(actividadTemp.getTipoAcontecimiento());
        out.setTipoViolencia(actividadTemp.getTipoViolencia());
        out.setResultadoViolencia(actividadTemp.getResultadoViolencia());
        if (actividadTemp.getIndCurso()) {
            out.setIndCurso(1);
        } else {
            out.setIndCurso(0);
        }

        Parametro p = new Parametro();
        Parametro p1 = new Parametro();
        p.setValorParametro(actividadTemp.getTipoActividad());
        p.setNombreParametro(actividadTemp.getTipoActividadNombre());
        p1.setValorParametro(actividadTemp.getTipoParticipacionDefensoria());
        p1.setNombreParametro(actividadTemp.getTipoParticipacionDefensoriaNombre());
        out.setTipoActividad(p);
        out.setJustificacionIntervencion(actividadTemp.getJustificacionIntervencion());
        out.setIdAcontecimiento(actividadTemp.getIdAcontecimiento());
        out.setIndiceVinculado(actividadTemp.getIndiceVinculado());
        return out;
    }

    public List<Actividad> buscarActividad() {
        log.debug("METODO : ActividadController.buscarActividad");
        List<Actividad> lst = null;
        try {
            FiltroActividad filtro = busquedaActividadTempHaciaFiltroActividad(actividadBusquedaTemp);
        } catch (Exception e) {
            log.error("ERROR : ActividadController.buscarActividad: " + e.getMessage());
        }
        return lst;
    }

    private FiltroActividad busquedaActividadTempHaciaFiltroActividad(ActividadBusquedaTemp bean) {
        FiltroActividad filtro = new FiltroActividad();
        if (!StringUtils.isBlank(bean.getNombre())) {
            filtro.setNombre(bean.getNombre().trim());
        }
        return filtro;
    }

    public String actividadUnionActor(Long idActor) {
        log.debug("METODO : ActividadController.actividadUnionActor");
        Actividad actividad = new Actividad();
        // String care = actividadActorTemp.getTipoParticipacion();
        Actor actor = new Actor();

        actividad.setId(actividadTemp.getId());
        actor.setId(idActor);
        ActividadActor actividadActor = new ActividadActor(actividad, actor, "TMP");
        try {
            actividadActorService.actividadActorInsertar(actividadActor);
            listaActoresxActividadTotal = listarActoresActividadTotal();
//            historialActorActividad(HistorialType.HISTORIAL_VINCULACION.getKey(), HistorialType.ENTIDAD_ACTIVIDAD.getKey(), actividadTemp.getId(), idActor);
        } catch (Exception e) {
            log.error("ERROR : ActividadController.actividadUnionActor: " + e.getMessage());
        }
        return "actividadDetalle";
    }

    public String actividadUnionActividad(Long idActividad) {
        log.debug("METODO : ActividadController.actividadUnionActividad");
        Actividad padre = new Actividad();
        Actividad hijo = new Actividad();

        padre.setId(actividadTemp.getId());
        hijo.setId(idActividad);
        ActividadActividad actividadActividad = new ActividadActividad(padre, hijo, "TMP");
        try {
            actividadActividadService.actividadActividadInsertar(actividadActividad);
            listaActividadxActividadTotal = listarActividadActividadTotal();
        } catch (Exception e) {
            log.error("ERROR : ActividadController.actividadUnionActividad: " + e.getMessage());
        }
        return "actividadDetalle";
    }

    private List<Actor> listarActoresActividadTotal() {
        List<Actor> list = null;
        try {
            list = actorService.actorxActividadBuscarTotal(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarActoresActividad: " + e.getMessage());
        }
        return list;
    }

    private List<Actividad> listarActividadActividadTotal() {
        List<Actividad> list = null;
        try {
            list = actividadService.actividadxActividadBuscarTotal(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarActividadActividadTotal: " + e.getMessage());
        }
        return list;
    }

    public String actividadUnionActa(Long idActaAcuerdo) {
        log.debug("METODO : ActividadController.actividadUnionActa");
        ActividadActaAcuerdo actividadActaAcuerdo = new ActividadActaAcuerdo();
        ActaAcuerdo actaAc = new ActaAcuerdo();
        Actividad actividad = new Actividad();
        actividad.setId(actividadTemp.getId());
        actaAc.setId(idActaAcuerdo);
        actividadActaAcuerdo.setActividad(actividad);
        actividadActaAcuerdo.setActaAcuerdo(actaAc);
        actividadActaAcuerdo.setEstado("TMP");
        try {
            listaActaAcuerdoxActividadTotal = listarActaAcuerdoActividadTotal();
        } catch (Exception e) {
            log.error("ERROR : ActividadController.actividadUnionActa: " + e.getMessage());
        }
        return "actividadDetalle";

    }

    public List<ActaAcuerdo> listarActaAcuerdoActividad() {
        List<ActaAcuerdo> list = null;
        try {
            list = actaAcuerdoService.actaAcuerdoxActividadBuscar(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarActaAcuerdoActividad: " + e.getMessage());
        }
        return list;
    }

    public List<ActaAcuerdo> listarActaAcuerdoActividadTotal() {
        List<ActaAcuerdo> list = null;
        try {
            list = actaAcuerdoService.actaAcuerdoxActividadBuscarTotal(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarActaAcuerdoActividadTotal: " + e.getMessage());
        }
        return list;
    }

    public String actividadUnionMedioVerificacion(Long idMedioVerificacion) {
        log.debug("METODO : ActividadController.actividadUnionMedioVerificacion");
        ActividadMedioVerificacion actividadMedioVerificacion = new ActividadMedioVerificacion();
        MedioVerificacion medioVerificacion = new MedioVerificacion();
        Actividad actividad = new Actividad();
        actividad.setId(actividadTemp.getId());
        medioVerificacion.setId(idMedioVerificacion);
        actividadMedioVerificacion.setActividad(actividad);
        actividadMedioVerificacion.setMedioVerificacion(medioVerificacion);
        actividadMedioVerificacion.setEstado("TMP");
        try {
            actividadMedioVerificacionService.actividadMedioVerificacionInsertar(actividadMedioVerificacion);
            listaMedioVerificacionxActividadTotal = listarMedioVerificacionActividadTotal();
        } catch (Exception e) {
            log.error("ERROR : ActividadController.actividadUnionMedioVerificacion: " + e.getMessage());
        }
        return "actividadDetalle";
    }

    private List<MedioVerificacion> listarMedioVerificacionActividadTotal() {
        List<MedioVerificacion> list = null;
        try {
            list = medioVerificacionService.medioVerificacionxActividadBuscarTotal(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarMedioVerificacionActividadTotal: " + e.getMessage());
        }
        return list;
    }

    public String actividadUnionCaso(Long idCaso) {
        log.debug("METODO : ActividadController.actividadUnionCaso");
        ActividadCaso actividadCaso1 = new ActividadCaso();
        Actividad actividad1 = new Actividad();
        Caso caso1 = new Caso();

        actividad1.setId(actividadTemp.getId());
        caso1.setId(idCaso);
        actividadCaso1.setActividad(actividad1);
        actividadCaso1.setCaso(caso1);
        actividadCaso1.setEstado("TMP");
        try {
            actividadCasoService.actividadCasoInsertar(actividadCaso1);
            listaCasoxActividadTotal = listarCasoActividadTotal();
        } catch (Exception e) {
            log.error("ERROR : ActividadController.actividadUnionCaso: " + e.getMessage());
        }
        return "actividadDetalle";
    }

    public void comboProvincia() {
        listaProvincia = new ArrayList<>();
        listaDistrito = new ArrayList<>();
        int id = actividadTemp.getIdDepartamento();
        if (id == 0) {
            listaProvincia.clear();
        } else {
            List<Provincia> list = ubigeoService.provinciaLista(id);
            if (list.size() > 0) {
                for (Provincia provincia : list) {
                    listaProvincia.add(new SelectItem(provincia.getId(), provincia.getDescripcion()));
                }
            }
            Departamento dep = ubigeoService.departamentoOne(id);
            cordenadax = dep.getCoordenadax();
            cordenaday = dep.getCoordenaday();
            zoom = dep.getZoom();
        }
    }

    public void comboDistrito() {
        listaDistrito = new ArrayList<>();
        int id = actividadTemp.getIdProvincia();
        if (id == 0) {
            listaDistrito.clear();
        } else {
            List<Distrito> list = ubigeoService.distritoLista(id);
            if (list.size() > 0) {
                for (Distrito distrito : list) {
                    listaDistrito.add(new SelectItem(distrito.getId(), distrito.getDescripcion()));
                }
            }
            Provincia prov = ubigeoService.provinciaOne(actividadTemp.getIdProvincia());
            cordenadax = prov.getCoordenadax();
            cordenaday = prov.getCoordenaday();
            zoom = prov.getZoom();
        }
    }

    public void coordenadasDistrito() {
        Integer idDistrito = actividadTemp.getIdDistrito();
        if (idDistrito != null) {
            Distrito dist = ubigeoService.distritoOne(idDistrito);
            cordenadax = dist.getCoordenadax();
            cordenaday = dist.getCoordenaday();
            zoom = dist.getZoom();
        }

    }

    private List<Caso> listarCasoActividadTotal() {
        List<Caso> list = null;
        try {
            list = casoService.casoxActividadBuscarTotal(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarCasoActividadTotal: " + e.getMessage());
        }
        return list;
    }

    public void eliminarActorActividad(Long idActor) {
        log.debug("METODO : ActividadController.eliminarActorActividad");
        Actividad actividad = new Actividad();
        Actor actor = new Actor();

        actividad.setId(actividadTemp.getId());
        actor.setId(idActor);
        ActividadActor actividadActor = new ActividadActor(actividad, actor, null);
        try {
            actividadActorService.actividadActorDelete(actividadActor);
            listaActoresxActividadTotal = listarActoresActividadTotal();
//            historialActorActividad(HistorialType.HISTORIAL_DESVINCULACION.getKey(), HistorialType.ENTIDAD_ACTIVIDAD.getKey(), actividadTemp.getId(), idActor);
        } catch (Exception e) {
            log.error("METODO : ActividadController.eliminarActorActividad" + e.getMessage());
        }
    }

    public void eliminarActaAcuerdoActividad(Long idActaAcuerdo) {
        log.debug("METODO : ActividadController.eliminarActaAcuerdoActividad");
        Actividad actividad = new Actividad();
        ActaAcuerdo actaAc = new ActaAcuerdo();

        actividad.setId(actividadTemp.getId());
        actaAc.setId(idActaAcuerdo);
        ActividadActaAcuerdo actividadActaAcuerdo = new ActividadActaAcuerdo(actividad, actaAc, null);
        try {
            actividadActaAcuerdoService.actividadActaAcuerdoDelete(actividadActaAcuerdo);
            listaActaAcuerdoxActividadTotal = listarActaAcuerdoActividadTotal();
        } catch (Exception e) {
            log.error("METODO : ActividadController.eliminarActaAcuerdoActividad" + e.getMessage());
        }
    }

    public void eliminarActividadActividad(Long idActividad) {
        log.debug("METODO : ActividadController.eliminarActividadActividad");

        Actividad padre = new Actividad();
        Actividad hijo = new Actividad();

        padre.setId(actividadTemp.getId());
        hijo.setId(idActividad);
        ActividadActividad actividadActividad = new ActividadActividad(padre, hijo, "ACT");
        try {
            actividadActividadService.actividadActividadDelete(actividadActividad);
            listaActividadxActividadTotal = listarActividadActividadTotal();
        } catch (Exception e) {
            log.error("METODO : ActividadController.eliminarActividadActividad" + e.getMessage());
        }
    }

    public void eliminarMedioVerificacionActividad(Long idMedioVerificacion) {
        log.debug("METODO : ActividadController.eliminarMedioVerificacionActividad");
        Actividad actividad = new Actividad();
        MedioVerificacion medioVerificacion = new MedioVerificacion();

        actividad.setId(actividadTemp.getId());
        medioVerificacion.setId(idMedioVerificacion);
        ActividadMedioVerificacion actividadMedioVerificacion = new ActividadMedioVerificacion(actividad, medioVerificacion, null);
        try {
            actividadMedioVerificacionService.actividadMedioVerificacionDelete(actividadMedioVerificacion);
            listaMedioVerificacionxActividadTotal = listarMedioVerificacionActividadTotal();
        } catch (Exception e) {
            log.error("METODO : ActividadController.eliminarMedioVerificacionActividad" + e.getMessage());
        }
    }

    public void eliminarCasoActividad(Long idCaso) {
        log.debug("METODO : ActividadController.eliminarCasoActividad");
        Actividad actividad = new Actividad();
        Caso c = new Caso();
        actividad.setId(actividadTemp.getId());
        c.setId(idCaso);
        ActividadCaso actaAc = new ActividadCaso(actividad, c, null);
        try {
            actividadCasoService.actividadCasoDelete(actaAc);
            listaCasoxActividadTotal = listarCasoActividadTotal();
        } catch (Exception e) {
            log.error("METODO : ActividadController.eliminarCasoActividad" + e.getMessage());
        }
    }

    public String fichaActividad(Long idActividad) {
        log.debug("METODO : ActividadController.fichaActividad");
        return "actividadFicha";
    }

    private void historialActividad(String accion, Long idActividad) {
        FacesContext context = FacesContext.getCurrentInstance();
        LoginController loginController = (LoginController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "loginController");
        ActividadHistorial historial = new ActividadHistorial();
        historial.setAccion(accion);
        historial.setIdActividad(idActividad);
        historial.setFechaRegistro(new Date());
        historial.setUsuarioRegistro(loginController.getUsuarioSesion().getCodigo());
        try {
            actividadHistorialService.actividadHistorialInsertar(historial);
        } catch (Exception e) {
            log.error("METODO : ActividadController.historialActividad" + e.getMessage());
        }
    }

    public List<ActividadHistorial> listarActividadHistorial() {
        List<ActividadHistorial> list = null;
        try {
            list = actividadHistorialService.actividadHistorialBuscarList(actividadTemp.getId());
        } catch (Exception e) {
            log.error("ERROR : ActividadController.listarActividadHistorial: " + e.getMessage());
        }
        return list;
    }

    public ActividadTemp getActividadTemp() {
        return actividadTemp;
    }

    public void setActividadTemp(ActividadTemp actividadTemp) {
        this.actividadTemp = actividadTemp;
    }

    public ActorTemp getActorTemp() {
        return actorTemp;
    }

    public void setActorTemp(ActorTemp actorTemp) {
        this.actorTemp = actorTemp;
    }

    public ActividadBusquedaTemp getActividadBusquedaTemp() {
        if (actividadBusquedaTemp == null) {
            actividadBusquedaTemp = new ActividadBusquedaTemp();
        }
        return actividadBusquedaTemp;
    }

    public void setActividadBusquedaTemp(ActividadBusquedaTemp actividadBusquedaTemp) {
        this.actividadBusquedaTemp = actividadBusquedaTemp;
    }

    public ActividadActorTemp getActividadActorTemp() {
        return actividadActorTemp;
    }

    public void setActividadActorTemp(ActividadActorTemp actividadActorTemp) {
        this.actividadActorTemp = actividadActorTemp;
    }

    public List<Actor> getListaActoresxActividad() {
        return listaActoresxActividad;
    }

    public void setListaActoresxActividad(List<Actor> listaActoresxActividad) {
        this.listaActoresxActividad = listaActoresxActividad;
    }

    public List<ActaAcuerdo> getListaActaAcuerdoxActividad() {
        return listaActaAcuerdoxActividad;
    }

    public void setListaActaAcuerdoxActividad(List<ActaAcuerdo> listaActaAcuerdoxActividad) {
        this.listaActaAcuerdoxActividad = listaActaAcuerdoxActividad;
    }

    public List<MedioVerificacion> getListaMedioVerificacionxActividad() {
        return listaMedioVerificacionxActividad;
    }

    public void setListaMedioVerificacionxActividad(List<MedioVerificacion> listaMedioVerificacionxActividad) {
        this.listaMedioVerificacionxActividad = listaMedioVerificacionxActividad;
    }

    public List<Caso> getListaCasoxActividad() {
        return listaCasoxActividad;
    }

    public void setListaCasoxActividad(List<Caso> listaCasoxActividad) {
        this.listaCasoxActividad = listaCasoxActividad;
    }

    public List<ActividadHistorial> getListaActividadHistorial() {
        return listaActividadHistorial;
    }

    public void setListaActividadHistorial(List<ActividadHistorial> listaActividadHistorial) {
        this.listaActividadHistorial = listaActividadHistorial;
    }

    public List<Actor> getListaActoresxActividadTotal() {
        return listaActoresxActividadTotal;
    }

    public void setListaActoresxActividadTotal(List<Actor> listaActoresxActividadTotal) {
        this.listaActoresxActividadTotal = listaActoresxActividadTotal;
    }

    public List<ActaAcuerdo> getListaActaAcuerdoxActividadTotal() {
        return listaActaAcuerdoxActividadTotal;
    }

    public void setListaActaAcuerdoxActividadTotal(List<ActaAcuerdo> listaActaAcuerdoxActividadTotal) {
        this.listaActaAcuerdoxActividadTotal = listaActaAcuerdoxActividadTotal;
    }

    public List<MedioVerificacion> getListaMedioVerificacionxActividadTotal() {
        return listaMedioVerificacionxActividadTotal;
    }

    public void setListaMedioVerificacionxActividadTotal(List<MedioVerificacion> listaMedioVerificacionxActividadTotal) {
        this.listaMedioVerificacionxActividadTotal = listaMedioVerificacionxActividadTotal;
    }

    public List<Caso> getListaCasoxActividadTotal() {
        return listaCasoxActividadTotal;
    }

    public void setListaCasoxActividadTotal(List<Caso> listaCasoxActividadTotal) {
        this.listaCasoxActividadTotal = listaCasoxActividadTotal;
    }

    public List<Actividad> getListaActividadxActividad() {
        return listaActividadxActividad;
    }

    public void setListaActividadxActividad(List<Actividad> listaActividadxActividad) {
        this.listaActividadxActividad = listaActividadxActividad;
    }

    public List<Actividad> getListaActividadxActividadTotal() {
        return listaActividadxActividadTotal;
    }

    public void setListaActividadxActividadTotal(List<Actividad> listaActividadxActividadTotal) {
        this.listaActividadxActividadTotal = listaActividadxActividadTotal;
    }

    public boolean isVerVinculosMantenimientoActividad() {
        return verVinculosMantenimientoActividad;
    }

    public void setVerVinculosMantenimientoActividad(boolean verVinculosMantenimientoActividad) {
        this.verVinculosMantenimientoActividad = verVinculosMantenimientoActividad;
    }

    public boolean isVerBoton() {
        return verBoton;
    }

    public void setVerBoton(boolean verBoton) {
        this.verBoton = verBoton;
    }

    public boolean isVerDetalleRegistro() {
        return verDetalleRegistro;
    }

    public void setVerDetalleRegistro(boolean verDetalleRegistro) {
        this.verDetalleRegistro = verDetalleRegistro;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public String getNombreCaso() {
        return nombreCaso;
    }

    public void setNombreCaso(String nombreCaso) {
        this.nombreCaso = nombreCaso;
    }

    public List<Caso> getCasos() {
        return casos;
    }

    public void setCasos(List<Caso> casos) {
        this.casos = casos;
    }

    public String getCadenaAutocomplete() {
        return cadenaAutocomplete;
    }

    public void setCadenaAutocomplete(String cadenaAutocomplete) {
        this.cadenaAutocomplete = cadenaAutocomplete;
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

    public Usuario getUsuarioSession() {
        return usuarioSession;
    }

    public void setUsuarioSession(Usuario usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public Boolean getTipoBoton() {
        return tipoBoton;
    }

    public void setTipoBoton(Boolean tipoBoton) {
        this.tipoBoton = tipoBoton;
    }

    public int getNroActaAcuerdoDetalle() {
        return nroActaAcuerdoDetalle;
    }

    public void setNroActaAcuerdoDetalle(int nroActaAcuerdoDetalle) {
        this.nroActaAcuerdoDetalle = nroActaAcuerdoDetalle;
    }

    public ActaAcuerdo getActaAcuerdo() {
        return actaAcuerdo;
    }

    public void setActaAcuerdo(ActaAcuerdo actaAcuerdo) {
        this.actaAcuerdo = actaAcuerdo;
    }

    public List<Noticia> getListaNoticias() {
        return listaNoticias;
    }

    public void setListaNoticias(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public Long getNroPagina() {
        return nroPagina;
    }

    public void setNroPagina(Long nroPagina) {
        this.nroPagina = nroPagina;
    }

    public String getDetalleNoticia() {
        return detalleNoticia;
    }

    public void setDetalleNoticia(String detalleNoticia) {
        this.detalleNoticia = detalleNoticia;
    }

    public List<NoticiaRegistro> getListaNoticiasRegistros() {
        return listaNoticiasRegistros;
    }

    public void setListaNoticiasRegistros(List<NoticiaRegistro> listaNoticiasRegistros) {
        this.listaNoticiasRegistros = listaNoticiasRegistros;
    }

    public boolean isVerEnlaceNoticia() {
        return verEnlaceNoticia;
    }

    public void setVerEnlaceNoticia(boolean verEnlaceNoticia) {
        this.verEnlaceNoticia = verEnlaceNoticia;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public String getCordenadax() {
        return cordenadax;
    }

    public void setCordenadax(String cordenadax) {
        this.cordenadax = cordenadax;
    }

    public String getCordenaday() {
        return cordenaday;
    }

    public void setCordenaday(String cordenaday) {
        this.cordenaday = cordenaday;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public MessagesUtil getMsg() {
        return msg;
    }

    public void setMsg(MessagesUtil msg) {
        this.msg = msg;
    }

    public List<Actividad> getListaActividadesPorCaso() {
        return listaActividadesPorCaso;
    }

    public void setListaActividadesPorCaso(List<Actividad> listaActividadesPorCaso) {
        this.listaActividadesPorCaso = listaActividadesPorCaso;
    }
    
    
}
