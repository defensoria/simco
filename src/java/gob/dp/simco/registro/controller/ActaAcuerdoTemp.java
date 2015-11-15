/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.controller;

import java.util.Date;

/**
 *
 * @author carlos
 */
public class ActaAcuerdoTemp {
    private Long id;
    
    private String descripcionItem;
    
    private Date fechaRegistro;
    
    private String comentario;
    
    private String codigo;
    
    private String tipo;
    
    private Boolean IndicadorActaExiste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean isIndicadorActaExiste() {
        return IndicadorActaExiste;
    }

    public void setIndicadorActaExiste(Boolean IndicadorActaExiste) {
        this.IndicadorActaExiste = IndicadorActaExiste;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
