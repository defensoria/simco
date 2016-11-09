/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.reporte.controller;

import gob.dp.simco.analisis.entity.AnalisisActorIntensidad;
import gob.dp.simco.analisis.service.AnalisisActorIntensidadService;
import gob.dp.simco.comun.ConstantesUtil;
import gob.dp.simco.comun.FunctionUtil;
import gob.dp.simco.comun.type.AnhosEnum;
import gob.dp.simco.intervencion.entity.Intervencion;
import gob.dp.simco.intervencion.service.IntervencionService;
import gob.dp.simco.registro.bean.FiltroCaso;
import gob.dp.simco.registro.entity.Actor;
import gob.dp.simco.registro.entity.Caso;
import gob.dp.simco.registro.entity.CasoActor;
import gob.dp.simco.registro.service.ActividadActorService;
import gob.dp.simco.registro.service.ActividadService;
import gob.dp.simco.registro.service.ActorService;
import gob.dp.simco.registro.service.CasoService;
import gob.dp.simco.reporte.entity.ReporteSimcoActividad;
import gob.dp.simco.reporte.entity.ReporteSimcoCaso;
import gob.dp.simco.reporte.entity.ReporteSimcoActor;
import gob.dp.simco.reporte.service.ReporteSimcoActividadService;
import gob.dp.simco.reporte.service.ReporteSimcoActorService;
import gob.dp.simco.reporte.service.ReporteSimcoCasoService;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ReporteSimcoCasoService reporteSimcoCasoService;

    @Autowired
    private ReporteSimcoActorService reporteSimcoActorService;

    @Autowired
    private ActorService actorService;
    
    @Autowired
    private AnalisisActorIntensidadService analisisActorIntensidadService;
    
    @Autowired
    private ActividadService actividadService;
    
    @Autowired
    private IntervencionService intervencionService;
    
    @Autowired
    private CasoService casoService;
    
    @Autowired
    private ActividadActorService actividadActorService;
    
    @Autowired
    private ReporteSimcoActividadService reporteSimcoActividadService;

    private List<SelectItem> listaAnhos;

    private List<ReporteSimcoCaso> listReporteCasos;

    private List<ReporteSimcoActor> listReporteActor;
    
    private List<ReporteSimcoActividad> listReporteActividad;
    
    private List<Caso> listadoCasos;

    private ReporteSimcoCaso reporteSimcoCaso;

    private ReporteSimcoActor reporteSimcoActor;
    
    private ReporteSimcoActividad reporteSimcoActividad;

    JasperPrint jasperPrint;
    
    private Long nroPagina = 1L;

    public String cargarReporteCaso() {
        listaAnhos = AnhosEnum.getList();
        reporteSimcoCaso = new ReporteSimcoCaso();
        listReporteCasos = null;
        return "reporteSimcoCaso";
    }

    public String cargarReporteActor() {
        listaAnhos = AnhosEnum.getList();
        reporteSimcoActor = new ReporteSimcoActor();
        limpiarReporteActor();
        return "reporteSimcoActor";
    }
    
    public String cargarReporteActividad() {
        listaAnhos = AnhosEnum.getList();
        reporteSimcoActividad = new ReporteSimcoActividad();
        limpiarReporteActor();
        return "reporteSimcoActividad";
    }

    public void reporteCasos() {
        listReporteCasos = reporteSimcoCasoService.reporteCasos(reporteSimcoCaso);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (ReporteSimcoCaso rs : listReporteCasos) {
            String esEmpresaMinera = "No";
            String esComunidadNativa = "No";
            List<Actor> listaActor = listaActoresCaso(rs.getIdCaso());
            int minera = 0;
            int nativa = 0;
            for (Actor a : listaActor) {
                if (StringUtils.equals(a.getSubTipo2Empresa(), "01")) {
                    minera++;
                }
                if (StringUtils.equals(a.getTipoOrganizacion(), "10")) {
                    nativa++;
                }
            }
            if(minera > 0)
                esEmpresaMinera = "Si";
            if(nativa > 0)
                esComunidadNativa = "Si";
            rs.setEsEmpresaMinera(esEmpresaMinera);
            rs.setEsComunidadNativa(esComunidadNativa);
            if(StringUtils.equals(rs.getEstado(), "Resuelto")){//resuelto
                rs.setFechaResolucion(rs.getFechaFinCaso());
                try {
                    rs.setMesesResolucion(FunctionUtil.calcularMesesAFecha(simpleDateFormat.parse(rs.getFechaInicioCaso()), simpleDateFormat.parse(rs.getFechaFinCaso())));
                } catch (ParseException ex) {
                    Logger.getLogger(ReporteSimcoController.class.getName()).log(Level.SEVERE, null, ex);
                    rs.setMesesResolucion(null);
                }
            }
            rs.setCantidadAcontecimientos(actividadService.contadorActuacionesAcontecimientos(rs.getIdCaso(), 1));
            rs.setCantidadActuaciones(actividadService.contadorActuacionesAcontecimientos(rs.getIdCaso(), 2));
            
            List<AnalisisActorIntensidad> listaAnalisis = analisisActorIntensidadService.analisisActorIntensidadBuscar(rs.getIdCaso());
            if(listaAnalisis.size() > 0)
                rs.setCantidadAnalisis(1);
            else
                rs.setCantidadAnalisis(0);
            
            Intervencion interv = intervencionService.intervencionBuscarCaso(rs.getCodigoCaso());
            if(interv != null)
                rs.setCantidadIntervencion(1);
            else
                rs.setCantidadIntervencion(0);
            
            rs.setCantidadAcuerdos(reporteSimcoCasoService.cantidadAcuerdosCaso(rs.getIdCaso()));
            
            rs.setCantidadMuertoCiviles(reporteSimcoCasoService.cantidadMuertosHeridos(rs.getCodigoCaso(), "01", "01"));
            rs.setCantidadMuertoPNP(reporteSimcoCasoService.cantidadMuertosHeridos(rs.getCodigoCaso(), "01", "02"));
            rs.setCantidadMuertoFFAA(reporteSimcoCasoService.cantidadMuertosHeridos(rs.getCodigoCaso(), "01", "03"));
            rs.setCantidadHeridoCiviles(reporteSimcoCasoService.cantidadMuertosHeridos(rs.getCodigoCaso(), "02", "01"));
            rs.setCantidadHeridoPNP(reporteSimcoCasoService.cantidadMuertosHeridos(rs.getCodigoCaso(), "02", "02"));
            rs.setCantidadHeridoFFAA(reporteSimcoCasoService.cantidadMuertosHeridos(rs.getCodigoCaso(), "02", "03"));
            
        }
    }

    public void reporteSimcoCasoExcel() throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = simpleDateFormat.format(date);
        initJasperSimcoCaso(1);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse = (HttpServletResponse) facesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_reporteCasos.xlsx");
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
    
    public void reporteSimcoActorExcel() throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = simpleDateFormat.format(date);
        initJasperSimcoActor(1);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse = (HttpServletResponse) facesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_reporteActores.xlsx");
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
    
    public void initJasperSimcoActor(int tipo) throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listReporteActor);
        if(tipo == 1)
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT + "reporteSimcoActorExcel.jasper", new HashMap(), beanCollectionDataSource);
        else
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT + "reporteSimcoCasoPdf.jasper", new HashMap(), beanCollectionDataSource);
    }

    private List<Actor> listaActoresCaso(Long idCaso) {
        List<Actor> actors = actorService.actorxCasoBuscar(idCaso);
        return actors;
    }
    
    public void listaCasos(Long pagina) {
        int paginado = ConstantesUtil.PAGINADO_10;
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nombreCaso");
        Long ini = paginado * (pagina - 1) + 1;
        Long fin = paginado * pagina;
        if (pagina == 0) {
            ini = 1L;
            fin = 10L;
            pagina = 1L;
        }
        FiltroCaso filtroCaso = new FiltroCaso();
        filtroCaso.setIni(ini);
        filtroCaso.setFin(fin);
        filtroCaso.setNombre(value);
        try {
            List<Caso> lista = casoService.buscarCasoXnombreCodigo(filtroCaso);
            if(lista.size() > 0){
                listadoCasos = lista;
                nroPagina = pagina;
            }
        } catch (Exception e) {
            
        }
    }
    
    public void setearCasoActor(Caso caso){
        reporteSimcoActor.setCodigoCaso(caso.getCodigo());
        reporteSimcoActor.setNombreCaso(caso.getCodigo()+" "+caso.getNombre());
    }
    
    public void setearActorActor(Actor actor){
        reporteSimcoActor.setIdActor(actor.getId());
        StringBuilder sb = new StringBuilder();
        if(StringUtils.isNotBlank(actor.getNombre()))
            sb.append(actor.getNombre());
        if(StringUtils.isNotBlank(actor.getApellidoPat()))
            sb.append(" ").append(actor.getApellidoPat());
        if(StringUtils.isNotBlank(actor.getApellidoMat()))
            sb.append(" ").append(actor.getApellidoMat());
        reporteSimcoActor.setNombreActor(sb.toString());
    }

    public void reporteActores() {
        listReporteActor = reporteSimcoActorService.reporteActor(reporteSimcoActor);
        for(ReporteSimcoActor a : listReporteActor){
            if(StringUtils.equals(a.getTipoActor(),"PE"))
                a.setDescripcionTipoActor("Población");
            if(StringUtils.equals(a.getTipoActor(),"EN"))
                a.setDescripcionTipoActor("Entidad estatal");
            if(StringUtils.equals(a.getTipoActor(),"EM") && StringUtils.equals(a.getClasificacion(),"OR"))
                a.setDescripcionTipoActor("Organización");
            if(StringUtils.equals(a.getTipoActor(),"EM") && StringUtils.equals(a.getClasificacion(),"EM"))
                a.setDescripcionTipoActor("Empresa");
            
            if(StringUtils.equals(a.getSexo(),"M"))
                a.setSexo("Masculino");
            if(StringUtils.equals(a.getSexo(),"F"))
                a.setSexo("Femenino");
            
            if(StringUtils.equals(a.getTipoActor(),"PE")){
                a.setSubtipo(a.getTipoPoblacion());
                a.setSubtipo1(a.getSubTipo1Poblacion());
                a.setSubtipo2(a.getSubTipo2Poblacion());
            }
            if(StringUtils.equals(a.getTipoActor(),"EN")){
                a.setSubtipo(a.getTipoEntidad());
                a.setSubtipo1(a.getSubTipo1Entidad());
                a.setSubtipo2(a.getSubTipo2Entidad());
            }   
            if(StringUtils.equals(a.getTipoActor(),"EM") && StringUtils.equals(a.getClasificacion(),"OR")){
                a.setSubtipo(a.getTipoOrganizacion());
                a.setSubtipo1(a.getSubTipo1Organizacion());
                a.setSubtipo2(a.getSubTipo2Organizacion());
            }
            if(StringUtils.equals(a.getTipoActor(),"EM") && StringUtils.equals(a.getClasificacion(),"EM")){
                a.setSubtipo(a.getTipoEmpresa());
                a.setSubtipo1(a.getSubTipo1Empresa());
                a.setSubtipo2(a.getSubTipo2Empresa());
                a.setSubtipo3(a.getSubTipo3Empresa());
            }
            
            a.setContadorActorAcontecimiento(reporteSimcoActorService.contarActorAcontecimiento(a.getIdActor()));
            a.setContadorActorAcontecimientoProtesta(reporteSimcoActorService.contarActorAcontecimientoProtesta(a.getIdActor()));
            a.setContadorActorAcontecimientoProtestaViolencia(reporteSimcoActorService.contarActorAcontecimientoProtestaViolencia(a.getIdActor()));
            a.setContadorActorAcuerdoComprometido(reporteSimcoActorService.contarActorAcuerdoComprometido(a.getIdActor()));
            a.setContadorActorAcuerdoBeneficiario(reporteSimcoActorService.contarActorAcuerdoBeneficiario(a.getIdActor()));
            a.setPonderado(actividadActorService.ponderadoAD(a.getIdActor()));
            a.setContadorActorCaso(reporteSimcoActorService.contarCasosPorActor(a.getIdActor()));
            a.setContadorCasosPorActorPrimario(reporteSimcoActorService.contarCasosPorActorParticipacion(new CasoActor(a.getIdActor(), "01")));
            a.setContadorCasosPorActorSecundario(reporteSimcoActorService.contarCasosPorActorParticipacion(new CasoActor(a.getIdActor(), "02")));
            a.setContadorCasosPorActorTerciario(reporteSimcoActorService.contarCasosPorActorParticipacion(new CasoActor(a.getIdActor(), "03")));
        }
    }
    
    public void reporteActividades() {
        listReporteActividad = reporteSimcoActividadService.reporteActividad(reporteSimcoActividad);
        for(ReporteSimcoActividad ac : listReporteActividad){
            if(StringUtils.equals(ac.getClaseActividad(), "AD"))
                ac.setClaseActividad("Actuacion defensorial");
            if(StringUtils.equals(ac.getClaseActividad(), "AC"))
                ac.setClaseActividad("Acontecimiento");
        }
    }

    public void limpiarReporteCaso() {
        reporteSimcoCaso = new ReporteSimcoCaso();
        listReporteCasos = null;
    }

    public void limpiarReporteActor() {
        reporteSimcoActor = new ReporteSimcoActor();
        listReporteActor = null;
    }
    
    public void limpiarReporteActividad() {
        reporteSimcoActividad = new ReporteSimcoActividad();
        listReporteActividad = null;
    }
    
    public void setearActor(Actor actor) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(actor.getNombre())) {
            sb.append(actor.getNombre());
        }
        if (StringUtils.isNotBlank(actor.getApellidoPat())) {
            sb.append(" ").append(actor.getApellidoPat());
        }
        if (StringUtils.isNotBlank(actor.getApellidoMat())) {
            sb.append(" ").append(actor.getApellidoMat());
        }
        reporteSimcoCaso.setNombreActor(sb.toString());
    }

    public List<SelectItem> getListaAnhos() {
        return listaAnhos;
    }

    public void setListaAnhos(List<SelectItem> listaAnhos) {
        this.listaAnhos = listaAnhos;
    }

    public List<ReporteSimcoCaso> getListReporteCasos() {
        return listReporteCasos;
    }

    public void setListReporteCasos(List<ReporteSimcoCaso> listReporteCasos) {
        this.listReporteCasos = listReporteCasos;
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

    public ReporteSimcoCaso getReporteSimcoCaso() {
        return reporteSimcoCaso;
    }

    public void setReporteSimcoCaso(ReporteSimcoCaso reporteSimcoCaso) {
        this.reporteSimcoCaso = reporteSimcoCaso;
    }

    public List<Caso> getListadoCasos() {
        return listadoCasos;
    }

    public void setListadoCasos(List<Caso> listadoCasos) {
        this.listadoCasos = listadoCasos;
    }

    public Long getNroPagina() {
        return nroPagina;
    }

    public void setNroPagina(Long nroPagina) {
        this.nroPagina = nroPagina;
    }

    public ReporteSimcoActividad getReporteSimcoActividad() {
        return reporteSimcoActividad;
    }

    public void setReporteSimcoActividad(ReporteSimcoActividad reporteSimcoActividad) {
        this.reporteSimcoActividad = reporteSimcoActividad;
    }

    public List<ReporteSimcoActividad> getListReporteActividad() {
        return listReporteActividad;
    }

    public void setListReporteActividad(List<ReporteSimcoActividad> listReporteActividad) {
        this.listReporteActividad = listReporteActividad;
    }

}
