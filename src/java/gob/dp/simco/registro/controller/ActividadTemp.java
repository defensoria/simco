/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.controller;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class ActividadTemp implements Serializable{
    
    private Long id;
    
    private String nombre;
    
    private String descripcion;
    
    private String lugarRealizacion;
    
    private Date fechaRealizacionIni;
    
    private Date fechaRealizacionFin;
    
    private Date horaRealizacionIni;
    
    private Date horaRealizacionFin;
    
    private Boolean isIndicadorActividadExiste;
    
    private Boolean indCurso = false;
    
    private String tipoActividad;
    
    private String tipoParticipacionDefensoria;
    
    private String justificacionIntervencion;
    
    private String tipoParticipacionDefensoriaNombre;
    
    private String tipoActividadNombre;
    
    private String codigoActividad;
    
    private String comentario;
    
    private int idDepartamento;
    
    private int idProvincia;
    
    private int idDistrito;
    
    private Double coordenadaX;
    
    private Double coordenadaY;
    
    private Integer zoom;
    
    private String ruta;
    
    private String tipo;
    
    private String tipoAcontecimiento;
    
    private String tipoViolencia;
    
    private String resultadoViolencia;
    
    private Long idAcontecimiento;
    
    private Integer indiceVinculado;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugarRealizacion() {
        return lugarRealizacion;
    }

    public void setLugarRealizacion(String lugarRealizacion) {
        this.lugarRealizacion = lugarRealizacion;
    }

    public Boolean isIsIndicadorActividadExiste() {
        return isIndicadorActividadExiste;
    }

    public void setIsIndicadorActividadExiste(Boolean isIndicadorActividadExiste) {
        this.isIndicadorActividadExiste = isIndicadorActividadExiste;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getJustificacionIntervencion() {
        return justificacionIntervencion;
    }

    public void setJustificacionIntervencion(String justificacionIntervencion) {
        this.justificacionIntervencion = justificacionIntervencion;
    }

    public String getTipoParticipacionDefensoria() {
        return tipoParticipacionDefensoria;
    }

    public void setTipoParticipacionDefensoria(String tipoParticipacionDefensoria) {
        this.tipoParticipacionDefensoria = tipoParticipacionDefensoria;
    }

    public String getTipoParticipacionDefensoriaNombre() {
        return tipoParticipacionDefensoriaNombre;
    }

    public void setTipoParticipacionDefensoriaNombre(String tipoParticipacionDefensoriaNombre) {
        this.tipoParticipacionDefensoriaNombre = tipoParticipacionDefensoriaNombre;
    }

    public String getTipoActividadNombre() {
        return tipoActividadNombre;
    }

    public void setTipoActividadNombre(String tipoActividadNombre) {
        this.tipoActividadNombre = tipoActividadNombre;
    }

    public Date getFechaRealizacionIni() {
        return fechaRealizacionIni;
    }

    public void setFechaRealizacionIni(Date fechaRealizacionIni) {
        this.fechaRealizacionIni = fechaRealizacionIni;
    }

    public Date getFechaRealizacionFin() {
        return fechaRealizacionFin;
    }

    public void setFechaRealizacionFin(Date fechaRealizacionFin) {
        this.fechaRealizacionFin = fechaRealizacionFin;
    }

    public Date getHoraRealizacionIni() {
        return horaRealizacionIni;
    }

    public void setHoraRealizacionIni(Date horaRealizacionIni) {
        this.horaRealizacionIni = horaRealizacionIni;
    }

    public Date getHoraRealizacionFin() {
        return horaRealizacionFin;
    }

    public void setHoraRealizacionFin(Date horaRealizacionFin) {
        this.horaRealizacionFin = horaRealizacionFin;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getIndCurso() {
        return indCurso;
    }

    public void setIndCurso(Boolean indCurso) {
        this.indCurso = indCurso;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipoAcontecimiento() {
        return tipoAcontecimiento;
    }

    public void setTipoAcontecimiento(String tipoAcontecimiento) {
        this.tipoAcontecimiento = tipoAcontecimiento;
    }

    public String getTipoViolencia() {
        return tipoViolencia;
    }

    public void setTipoViolencia(String tipoViolencia) {
        this.tipoViolencia = tipoViolencia;
    }

    public String getResultadoViolencia() {
        return resultadoViolencia;
    }

    public void setResultadoViolencia(String resultadoViolencia) {
        this.resultadoViolencia = resultadoViolencia;
    }

    public Long getIdAcontecimiento() {
        return idAcontecimiento;
    }

    public void setIdAcontecimiento(Long idAcontecimiento) {
        this.idAcontecimiento = idAcontecimiento;
    }

    public Integer getIndiceVinculado() {
        return indiceVinculado;
    }

    public void setIndiceVinculado(Integer indiceVinculado) {
        this.indiceVinculado = indiceVinculado;
    }

    

    
}
