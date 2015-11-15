/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.registro.controller;

import gob.dp.simco.comun.MessagesUtil;
import gob.dp.simco.registro.constantes.ConstantesUtil;
import gob.dp.simco.registro.entity.Actividad;
import gob.dp.simco.registro.entity.ActividadMedioVerificacion;
import gob.dp.simco.registro.entity.MedioVerificacion;
import gob.dp.simco.registro.service.ActividadMedioVerificacionService;
import gob.dp.simco.registro.service.MedioVerificacionService;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author carlos
 */
@Named
@Scope("session")
public class MedioVerificacionController implements Serializable {

    private static final Logger log = Logger.getLogger(MedioVerificacionController.class);

    private MedioVerificacion medioVerificacion;

    private List<MedioVerificacion> medioVerificacions;

    private Actividad actividad;

    private Part file1;

    private MessagesUtil msg;

    @Autowired
    private MedioVerificacionService medioVerificacionService;

    @Autowired
    private ActividadMedioVerificacionService actividadMedioVerificacionService;

    public MedioVerificacionController() {
        msg = new MessagesUtil();
    }

    public String cargarPagina(Long idActividad) {
        medioVerificacion = new MedioVerificacion();
        actividad = new Actividad();
        actividad.setId(idActividad);
        listarMedioVerificacion(idActividad);
        return "medioVerificacionNuevo";
    }

    public void listarMedioVerificacion(Long idActividad) {
        try {
            DateFormat fechaHora = new SimpleDateFormat("dd/MM/yyyy");
            medioVerificacions = medioVerificacionService.medioVerificacionxActividadBuscar(idActividad);
            for (MedioVerificacion mv : medioVerificacions) {
                String fec = fechaHora.format(mv.getRegistro());
                mv.setFechaRegistro(fec);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void limpiarListaMedios() {
        medioVerificacions = new ArrayList<>();
    }

    public boolean saveMedioVerificacion() {
        try {
            if (medioVerificacion.getId() != null) 
                return false;
            DateFormat fechaHora = new SimpleDateFormat("yyyyMMddHHmmss");
            String formato = fechaHora.format(new Date());
            String ruta = formato + getFileExtension(getFilename(file1));
            File file = new File(ConstantesUtil.FILE_SYSTEM + ruta);
            try (InputStream input = file1.getInputStream()) {
                Files.copy(input, file.toPath());
            }
            medioVerificacion.setRuta(ruta);
            medioVerificacion.setRegistro(new Date());
            medioVerificacion.setCodigo(generarCodigoMedioVerificacion());
            medioVerificacionService.medioVerificacionNuevo(medioVerificacion);
            saveMedioVerificacionActividad(medioVerificacion);
            listarMedioVerificacion(actividad.getId());
            msg.messageInfo("Se ha registro el nuevo medio", null);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        } finally {
            medioVerificacion = new MedioVerificacion();
        }
        return true;
    }

    private String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf("."));

        } catch (Exception e) {
            return "";
        }
    }

    public String generarCodigoMedioVerificacion() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMM");
        String codigo = formato.format(new Date());
        String numero = String.format("%2s", medioVerificacionService.medioVerificacionCodigoGenerado().toString()).replace(' ', '0');
        return "MV" + codigo + numero;
    }

    public void saveMedioVerificacionActividad(MedioVerificacion mv) {
        try {
            ActividadMedioVerificacion actividadMedioVerificacion = new ActividadMedioVerificacion();
            actividadMedioVerificacion.setActividad(actividad);
            actividadMedioVerificacion.setMedioVerificacion(medioVerificacion);
            actividadMedioVerificacion.setEstado("ACT");
            actividadMedioVerificacionService.actividadMedioVerificacionInsertar(actividadMedioVerificacion);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public void removeMedioVerificacion(MedioVerificacion mv) {
        try {
            ActividadMedioVerificacion actividadMedioVerificacion = new ActividadMedioVerificacion();
            actividadMedioVerificacion.setActividad(actividad);
            actividadMedioVerificacion.setMedioVerificacion(mv);
            actividadMedioVerificacion.setEstado("INA");
            actividadMedioVerificacionService.actividadMedioVerificacionUpdate(actividadMedioVerificacion);
            listarMedioVerificacion(actividad.getId());
            msg.messageInfo("Se ha eliminado el medio", null);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
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

    public MedioVerificacion getMedioVerificacion() {
        return medioVerificacion;
    }

    public void setMedioVerificacion(MedioVerificacion medioVerificacion) {
        this.medioVerificacion = medioVerificacion;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public List<MedioVerificacion> getMedioVerificacions() {
        return medioVerificacions;
    }

    public void setMedioVerificacions(List<MedioVerificacion> medioVerificacions) {
        this.medioVerificacions = medioVerificacions;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public MessagesUtil getMsg() {
        return msg;
    }

    public void setMsg(MessagesUtil msg) {
        this.msg = msg;
    }

}
