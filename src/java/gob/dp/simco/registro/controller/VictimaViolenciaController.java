/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.registro.controller;

import gob.dp.simco.comun.MessagesUtil;
import gob.dp.simco.registro.constantes.ConstantesUtil;
import gob.dp.simco.registro.entity.ActividadVictima;
import gob.dp.simco.registro.service.ActividadVictimaService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
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
public class VictimaViolenciaController implements Serializable{
    
    private static final Logger log = Logger.getLogger(RegistroController.class);
    
    private ActividadVictima actividadVictima;
    
    private int tipo = 0;
    
    private MessagesUtil msg;
    
    private Part file1;
    
    private List<ActividadVictima> listaVictimas;
    
    private Long idActividad;
    
    private Map tiposVictima;
    
    @Autowired
    private ActividadVictimaService actividadVictimaService;

    public VictimaViolenciaController() {
        msg = new MessagesUtil();
    }
    
    public String cargarPagina(long idActivid, int tip){
        tipo = tip;
        idActividad = idActivid;
        try {
            actividadVictima = new ActividadVictima();
            actividadVictima.setIdActividad(idActividad);
            listarVictimas(idActividad);
            mapearTipos();
        return "victimaViolencia";
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
    
    public void limpiarVictimas(){
        listaVictimas = null;
        mapearTipos();
    }
    
    public void limpiarVictimasEdit(long idActividad){
        listarVictimas(idActividad);
        mapearTipos();
    }
    
    public void mapearTipos(){
        tiposVictima = new HashMap();
        int nroMuertos = 0;
        int nroSecuestrados = 0;
        int nroHerido = 0;
        int nroDetenidos = 0;
        int nroOtros = 0;
        if(listaVictimas != null){
            for(ActividadVictima av : listaVictimas){
                if(StringUtils.equals(av.getTipo(), "01"))
                    nroMuertos++;
                if(StringUtils.equals(av.getTipo(), "02"))
                    nroHerido++;
                if(StringUtils.equals(av.getTipo(), "03"))
                    nroSecuestrados++;
                if(StringUtils.equals(av.getTipo(), "04"))
                    nroDetenidos++;
                if(StringUtils.equals(av.getTipo(), "05"))
                    nroOtros++;
            }
        }
        tiposVictima.put("Muertos", nroMuertos);
        tiposVictima.put("Heridos", nroHerido);
        tiposVictima.put("Secuestrados", nroSecuestrados);
        tiposVictima.put("Detenidos", nroDetenidos);
        tiposVictima.put("Otros", nroOtros);
    }
    
    public void nuevo(){
        long id = actividadVictima.getIdActividad();
        actividadVictima = new ActividadVictima();
        actividadVictima.setIdActividad(id);
    }
    
    public String regresar(){
        if(tipo == 1)
            return "registroNuevo";
        if(tipo == 2)
            return "registroEdit";
        
        return null;
    }
    
    public void guardarVictima(){
        try {
            remonbrarArchivo();
        if(actividadVictima.getId() == null){
            actividadVictima.setFechaRegistro(new Date());
            actividadVictimaService.actividadVictimaInsertar(actividadVictima);
            msg.messageInfo("Se registro la victima", null);
        }else{
            actividadVictima.setFechaModificacion(new Date());
            actividadVictimaService.actividadVictimaUpdate(actividadVictima);
            msg.messageInfo("Se actualizo la victima", null);
        }
        } catch (Exception e) {
             System.out.println(e);
        }
        listarVictimas(actividadVictima.getIdActividad());
        mapearTipos();
    }
    
    private void listarVictimas(long idActivida){
        listaVictimas = actividadVictimaService.actividadVictimaBuscar(idActivida);
    }
    
    private void remonbrarArchivo(){
        if(file1.getSize() > 0){
            DateFormat fechaHora = new SimpleDateFormat("yyyyMMddHHmmss");
            String formato = fechaHora.format(new Date());
            String ruta = formato + getFileExtension(getFilename(file1));
            File file = new File(ConstantesUtil.FILE_SYSTEM + ruta);
            try (InputStream input = file1.getInputStream()) {
                Files.copy(input, file.toPath());
            } catch (IOException ex) {
                log.error(ex);
            }
            actividadVictima.setRuta(ruta);
        }
    }
    
    public void setearVictima(ActividadVictima av){
        setActividadVictima(av);
        actividadVictima.setIdActividad(idActividad);
    }
    
    public void eliminarVictima(long idVictima){
        try {
            actividadVictimaService.actividadVictimaEliminar(idVictima);
            listarVictimas(idActividad);
            nuevo();
            msg.messageInfo("Se elimino el registro correctamente", null);
        } catch (Exception e) {
            log.error(e);
        }
        mapearTipos();
    }
    
    private String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf("."));

        } catch (Exception e) {
            log.error(e);
            return "";
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

    public ActividadVictima getActividadVictima() {
        return actividadVictima;
    }

    public void setActividadVictima(ActividadVictima actividadVictima) {
        this.actividadVictima = actividadVictima;
    }

    public MessagesUtil getMsg() {
        return msg;
    }

    public void setMsg(MessagesUtil msg) {
        this.msg = msg;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public List<ActividadVictima> getListaVictimas() {
        return listaVictimas;
    }

    public void setListaVictimas(List<ActividadVictima> listaVictimas) {
        this.listaVictimas = listaVictimas;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Map getTiposVictima() {
        return tiposVictima;
    }

    public void setTiposVictima(Map tiposVictima) {
        this.tiposVictima = tiposVictima;
    }

}
