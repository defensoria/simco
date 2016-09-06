/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.controller;

import gob.dp.simco.comun.type.AnhosEnum;
import gob.dp.simco.registro.entity.Actor;
import gob.dp.simco.reporte.entity.ReporteSimco;
import gob.dp.simco.reporte.entity.ReporteSimcoActor;
import gob.dp.simco.reporte.service.ReporteSimcoActorService;
import gob.dp.simco.reporte.service.ReporteSimcoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author carlos
 */
@Named
@Scope("session")
public class ReporteSimcoController implements Serializable{
    
    @Autowired
    private ReporteSimcoService reporteSimcoService;
    
    @Autowired
    private ReporteSimcoActorService reporteSimcoActorService;
    
    private List<SelectItem> listaAnhos;
    
    private List<ReporteSimco> listReporteCasos;
    
    private List<ReporteSimcoActor> listReporteActor;
    
    private ReporteSimco reporteSimco;
    
    private ReporteSimcoActor reporteSimcoActor;
    
    
    public String cargarReporteCaso(){
        listaAnhos = AnhosEnum.getList();
        reporteSimco = new ReporteSimco();
        listReporteCasos= null;
        return "reporteSimcoCaso";
    }
    
    public String cargarReporteActor(){
        listaAnhos = AnhosEnum.getList();
        reporteSimcoActor = new ReporteSimcoActor();
        listReporteCasos= null;
        return "reporteSimcoActor";
    }
    
    public void reporteCasos(){
        listReporteCasos = reporteSimcoService.reporteCasos(reporteSimco);
    }
    
    public void reporteActor(){
        listReporteActor = reporteSimcoActorService.reporteActor(reporteSimcoActor);
    }
    
    public void limpiar(){
        reporteSimco = new ReporteSimco();
        listReporteCasos= null;
    }
    
    public void setearActor(Actor actor){
        StringBuilder sb = new StringBuilder();
        if(StringUtils.isNotBlank(actor.getNombre())){
            sb.append(actor.getNombre());
        }
        if(StringUtils.isNotBlank(actor.getApellidoPat())){
            sb.append(" "+actor.getApellidoPat());
        }
        if(StringUtils.isNotBlank(actor.getApellidoMat())){
            sb.append(" "+actor.getApellidoMat());
        }
        reporteSimco.setNombreActor(sb.toString());
        reporteSimco.setIdActor(actor.getId());
    }

    public List<SelectItem> getListaAnhos() {
        return listaAnhos;
    }

    public void setListaAnhos(List<SelectItem> listaAnhos) {
        this.listaAnhos = listaAnhos;
    }

    public List<ReporteSimco> getListReporteCasos() {
        return listReporteCasos;
    }

    public void setListReporteCasos(List<ReporteSimco> listReporteCasos) {
        this.listReporteCasos = listReporteCasos;
    }

    public ReporteSimco getReporteSimco() {
        return reporteSimco;
    }

    public void setReporteSimco(ReporteSimco reporteSimco) {
        this.reporteSimco = reporteSimco;
    }

    public List<ReporteSimcoActor> getListReporteActor() {
        return listReporteActor;
    }

    public void setListReporteActor(List<ReporteSimcoActor> listReporteActor) {
        this.listReporteActor = listReporteActor;
    }

    public ReporteSimcoActor getReporteSimcoActor() {
        return reporteSimcoActor;
    }

    public void setReporteSimcoActor(ReporteSimcoActor reporteSimcoActor) {
        this.reporteSimcoActor = reporteSimcoActor;
    }
    
    
}
