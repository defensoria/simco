/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.controller;

/**
 *
 * @author carlos
 */
public class MedioVerificacionTemp {
    
    private Long id;
    
    private String observacion;
    
    private String palabraClave;
    
    private String tipo;
    
    private Boolean IndicadorMedioVerificacionExiste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean isIndicadorMedioVerificacionExiste() {
        return IndicadorMedioVerificacionExiste;
    }

    public void setIndicadorMedioVerificacionExiste(Boolean IndicadorMedioVerificacionExiste) {
        this.IndicadorMedioVerificacionExiste = IndicadorMedioVerificacionExiste;
    }
    
    
    
}
