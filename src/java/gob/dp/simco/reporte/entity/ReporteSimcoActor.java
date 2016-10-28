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
public class ReporteSimcoActor implements Serializable {

    private Integer anho;

    private String codigoCaso;

    private String nombreCaso;

    private Integer tipologia;

    private Integer idRegion;

    private Integer tipoAcontecimiento;

    private Integer estado;

    private String tipoActor;

    private String nombreActor;

    private Long idActor;

    private String esComunidadNativa;

    private String nombreDepartamento;
    
    private Integer contadorActorAcontecimiento;
    
    private Integer contadorActorAcuerdoComprometido;
    
    private Integer contadorActorAcuerdoBeneficiario;
    
    private Double ponderado;
    
    private String documento;
    
    private String ruc;
    /**
     *
     * @return
     */
    
    

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(String codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public Integer getTipologia() {
        return tipologia;
    }

    public void setTipologia(Integer tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Integer getTipoAcontecimiento() {
        return tipoAcontecimiento;
    }

    public void setTipoAcontecimiento(Integer tipoAcontecimiento) {
        this.tipoAcontecimiento = tipoAcontecimiento;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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

    public String getEsComunidadNativa() {
        return esComunidadNativa;
    }

    public void setEsComunidadNativa(String esComunidadNativa) {
        this.esComunidadNativa = esComunidadNativa;
    }

    public String getNombreCaso() {
        return nombreCaso;
    }

    public void setNombreCaso(String nombreCaso) {
        this.nombreCaso = nombreCaso;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getContadorActorAcontecimiento() {
        return contadorActorAcontecimiento;
    }

    public void setContadorActorAcontecimiento(Integer contadorActorAcontecimiento) {
        this.contadorActorAcontecimiento = contadorActorAcontecimiento;
    }

    public Integer getContadorActorAcuerdoComprometido() {
        return contadorActorAcuerdoComprometido;
    }

    public void setContadorActorAcuerdoComprometido(Integer contadorActorAcuerdoComprometido) {
        this.contadorActorAcuerdoComprometido = contadorActorAcuerdoComprometido;
    }

    public Integer getContadorActorAcuerdoBeneficiario() {
        return contadorActorAcuerdoBeneficiario;
    }

    public void setContadorActorAcuerdoBeneficiario(Integer contadorActorAcuerdoBeneficiario) {
        this.contadorActorAcuerdoBeneficiario = contadorActorAcuerdoBeneficiario;
    }

    public Double getPonderado() {
        return ponderado;
    }

    public void setPonderado(Double ponderado) {
        this.ponderado = ponderado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    

}
