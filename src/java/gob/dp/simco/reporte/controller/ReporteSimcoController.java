/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.controller;

import gob.dp.simco.comun.ConstantesUtil;
import gob.dp.simco.comun.type.AnhosEnum;
import gob.dp.simco.registro.entity.Actor;
import gob.dp.simco.registro.service.ActorService;
import gob.dp.simco.reporte.entity.ReporteSimco;
import gob.dp.simco.reporte.entity.ReporteSimcoActor;
import gob.dp.simco.reporte.service.ReporteSimcoActorService;
import gob.dp.simco.reporte.service.ReporteSimcoService;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author carlos
 */
@Named
@Scope("session")
public class ReporteSimcoController implements Serializable {

    @Autowired
    private ReporteSimcoService reporteSimcoService;

    @Autowired
    private ReporteSimcoActorService reporteSimcoActorService;

    @Autowired
    private ActorService actorService;

    private List<SelectItem> listaAnhos;

    private List<ReporteSimco> listReporteCasos;

    private List<ReporteSimcoActor> listReporteActor;

    private ReporteSimco reporteSimco;

    private ReporteSimcoActor reporteSimcoActor;

    JasperPrint jasperPrint;

    public String cargarReporteCaso() {
        listaAnhos = AnhosEnum.getList();
        reporteSimco = new ReporteSimco();
        listReporteCasos = null;
        return "reporteSimcoCaso";
    }

    public String cargarReporteActor() {
        listaAnhos = AnhosEnum.getList();
        reporteSimcoActor = new ReporteSimcoActor();
        listReporteCasos = null;
        return "reporteSimcoActor";
    }

    public void reporteCasos() {
        listReporteCasos = reporteSimcoService.reporteCasos(reporteSimco);
        for (ReporteSimco rs : listReporteCasos) {
            String esEmpresaMinera = "No";
            String esComunidadNativa = "No";
            List<Actor> listaActor = listaActoresCaso(rs.getIdCaso());
            for (Actor a : listaActor) {
                if (StringUtils.equals(a.getSubTipo2Empresa(), "01")) {
                    esEmpresaMinera = "Si";
                }
                if (StringUtils.equals(a.getTipoOrganizacion(), "10")) {
                    esComunidadNativa = "Si";
                }
            }
            rs.setEsEmpresaMinera(esEmpresaMinera);
            rs.setEsComunidadNativa(esComunidadNativa);
        }
    }

    public void reporteSimcoCasoExcel() throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = simpleDateFormat.format(date);
        initJasperSimcoCaso(1);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse = (HttpServletResponse) facesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_reporteSimcoCaso.xls");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRXlsxExporter jrXlsxExporter = new JRXlsxExporter();
        jrXlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        jrXlsxExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
        jrXlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        jrXlsxExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
        jrXlsxExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
        jrXlsxExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
        jrXlsxExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        jrXlsxExporter.exportReport();
        facesContext.responseComplete();
        facesContext.renderResponse();
    }
    
    public void reporteSimcoCasoPdf() throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = simpleDateFormat.format(date);
        initJasperSimcoCaso(2);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse;
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_reporteSimcoCaso.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        facesContext.responseComplete();
        facesContext.renderResponse();
    }

    public void initJasperSimcoCaso(int tipo) throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listReporteCasos);
        if(tipo == 1)
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT + "reporteSimcoCasoExcel.jasper", new HashMap(), beanCollectionDataSource);
        else
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT + "reporteSimcoCasoPdf.jasper", new HashMap(), beanCollectionDataSource);
    }

    private List<Actor> listaActoresCaso(Long idCaso) {
        List<Actor> actors = actorService.actorxCasoBuscar(idCaso);
        return actors;
    }

    public void reporteActor() {
        listReporteActor = reporteSimcoActorService.reporteActor(reporteSimcoActor);
    }

    public void limpiar() {
        reporteSimco = new ReporteSimco();
        listReporteCasos = null;
    }

    public void setearActor(Actor actor) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(actor.getNombre())) {
            sb.append(actor.getNombre());
        }
        if (StringUtils.isNotBlank(actor.getApellidoPat())) {
            sb.append(" " + actor.getApellidoPat());
        }
        if (StringUtils.isNotBlank(actor.getApellidoMat())) {
            sb.append(" " + actor.getApellidoMat());
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
