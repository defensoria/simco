/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.seguimiento.entity;

import gob.dp.simco.registro.entity.ActaAcuerdoDetalle;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class SeguimientoAcuerdo implements Serializable{
    
    private Long id;
    
    private Date inicioSeguimiento;
    
    private Date finSeguimiento;
    
    private String tipoTiempoIni;
    
    private String tipoTiempoFin;
    
    private Integer numeroInicial;
    
    private Integer numeroFinal;
    
    private String indicadorAntesDespuesIni;
    
    private String indicadorAntesDespuesFin;
    
    private Date inicioDefinitivo;
    
    private Date finDefinitivo;
    
    private String indicadorLunesViernes;
    
    private Date ultimaEjecucion;
    
    private String indiceRepeticion;
    
    private String estado;
    
    private ActaAcuerdoDetalle actaAcuerdoDetalle;
    
    private Boolean indicadorSeleccionHoraIni;
    
    private Boolean indicadorSeleccionHoraFin;
    
    private String opcionales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicioSeguimiento() {
        return inicioSeguimiento;
    }

    public void setInicioSeguimiento(Date inicioSeguimiento) {
        this.inicioSeguimiento = inicioSeguimiento;
    }

    public Date getFinSeguimiento() {
        return finSeguimiento;
    }

    public void setFinSeguimiento(Date finSeguimiento) {
        this.finSeguimiento = finSeguimiento;
    }

    public Integer getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(Integer numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public Integer getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(Integer numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public Date getInicioDefinitivo() {
        return inicioDefinitivo;
    }

    public void setInicioDefinitivo(Date inicioDefinitivo) {
        this.inicioDefinitivo = inicioDefinitivo;
    }

    public Date getFinDefinitivo() {
        return finDefinitivo;
    }

    public void setFinDefinitivo(Date finDefinitivo) {
        this.finDefinitivo = finDefinitivo;
    }

    public String getIndicadorLunesViernes() {
        return indicadorLunesViernes;
    }

    public void setIndicadorLunesViernes(String indicadorLunesViernes) {
        this.indicadorLunesViernes = indicadorLunesViernes;
    }

    public Date getUltimaEjecucion() {
        return ultimaEjecucion;
    }

    public void setUltimaEjecucion(Date ultimaEjecucion) {
        this.ultimaEjecucion = ultimaEjecucion;
    }

    public String getIndiceRepeticion() {
        return indiceRepeticion;
    }

    public void setIndiceRepeticion(String indiceRepeticion) {
        this.indiceRepeticion = indiceRepeticion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ActaAcuerdoDetalle getActaAcuerdoDetalle() {
        return actaAcuerdoDetalle;
    }

    public void setActaAcuerdoDetalle(ActaAcuerdoDetalle actaAcuerdoDetalle) {
        this.actaAcuerdoDetalle = actaAcuerdoDetalle;
    }

    public String getTipoTiempoIni() {
        return tipoTiempoIni;
    }

    public void setTipoTiempoIni(String tipoTiempoIni) {
        this.tipoTiempoIni = tipoTiempoIni;
    }

    public String getTipoTiempoFin() {
        return tipoTiempoFin;
    }

    public void setTipoTiempoFin(String tipoTiempoFin) {
        this.tipoTiempoFin = tipoTiempoFin;
    }

    public String getIndicadorAntesDespuesIni() {
        return indicadorAntesDespuesIni;
    }

    public void setIndicadorAntesDespuesIni(String indicadorAntesDespuesIni) {
        this.indicadorAntesDespuesIni = indicadorAntesDespuesIni;
    }

    public String getIndicadorAntesDespuesFin() {
        return indicadorAntesDespuesFin;
    }

    public void setIndicadorAntesDespuesFin(String indicadorAntesDespuesFin) {
        this.indicadorAntesDespuesFin = indicadorAntesDespuesFin;
    }

    public Boolean getIndicadorSeleccionHoraIni() {
        return indicadorSeleccionHoraIni;
    }

    public void setIndicadorSeleccionHoraIni(Boolean indicadorSeleccionHoraIni) {
        this.indicadorSeleccionHoraIni = indicadorSeleccionHoraIni;
    }

    public Boolean getIndicadorSeleccionHoraFin() {
        return indicadorSeleccionHoraFin;
    }

    public void setIndicadorSeleccionHoraFin(Boolean indicadorSeleccionHoraFin) {
        this.indicadorSeleccionHoraFin = indicadorSeleccionHoraFin;
    }

    public String getOpcionales() {
        return opcionales;
    }

    public void setOpcionales(String opcionales) {
        this.opcionales = opcionales;
    }
    
}
