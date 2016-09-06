/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.entity;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class ReporteSimco implements Serializable{
    
    private String anho;
    
    private String codigoCaso;
    
    private String nombreCaso;
    
    private String fechaInicioCaso;
    
    private String regionPrincial;
    
    private String tipologia;
    
    private String idRegion;
    
    private String tipoAcontecimiento;
    
    private String esComunidadNativa;
    
    private String estado;
    
    private String actividad;
    
    private String fase;
    
    private String acuerdos;
    
    private String tipoActor;
    
    private String nombreActor;
    
    private Long idActor;

    public String getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(String codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public String getNombreCaso() {
        return nombreCaso;
    }

    public void setNombreCaso(String nombreCaso) {
        this.nombreCaso = nombreCaso;
    }

    public String getFechaInicioCaso() {
        return fechaInicioCaso;
    }

    public void setFechaInicioCaso(String fechaInicioCaso) {
        this.fechaInicioCaso = fechaInicioCaso;
    }

    public String getRegionPrincial() {
        return regionPrincial;
    }

    public void setRegionPrincial(String regionPrincial) {
        this.regionPrincial = regionPrincial;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    public String getTipoAcontecimiento() {
        return tipoAcontecimiento;
    }

    public void setTipoAcontecimiento(String tipoAcontecimiento) {
        this.tipoAcontecimiento = tipoAcontecimiento;
    }

    public String getEsComunidadNativa() {
        return esComunidadNativa;
    }

    public void setEsComunidadNativa(String esComunidadNativa) {
        this.esComunidadNativa = esComunidadNativa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getAcuerdos() {
        return acuerdos;
    }

    public void setAcuerdos(String acuerdos) {
        this.acuerdos = acuerdos;
    }

    public String getTipoActor() {
        return tipoActor;
    }

    public void setTipoActor(String tipoActor) {
        this.tipoActor = tipoActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }
    
}
