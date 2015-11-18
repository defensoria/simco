/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.comun.controller;

import gob.dp.simco.comun.entity.RegistroCarga;
import gob.dp.simco.comun.entity.Departamento;
import gob.dp.simco.comun.entity.Resumen;
import gob.dp.simco.comun.service.RegistroCargaService;
import gob.dp.simco.comun.service.ReporteService;
import gob.dp.simco.comun.service.UbigeoService;
import gob.dp.simco.registro.constantes.ConstantesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class ReporteController implements Serializable {

    private List<Resumen> listaResumen;

    private List<Resumen> listaResumen2;

    
    private List<Resumen> listaResumen3;

    private List<Resumen> listaResumen4;

    private List<Resumen> listaResumen5;

    private List<Resumen> listaResumen6;

    private List<Resumen> listaAnhos;

    private Resumen reporte1;

    private Resumen reporte2;

    private Resumen reporte3;

    private List<SelectItem> listaDepartamento;

    JasperPrint jasperPrint;

    private RegistroCarga registroCarga;
    
    /**NUEVO*/
    private String tituloPanel;
    

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private UbigeoService ubigeoService;

    @Autowired
    private RegistroCargaService registroCargaService;

    private Map listasMeses;

    public String reporteCaso() {
        cargarMeses();
        limpiarListas();
        cargarAnhosCaso();
        reporte1 = new Resumen();
        reporte2 = new Resumen();
        reporte3 = new Resumen();
        //cargarReporte002();
        //cargarReporte003();
        //cargarReporte004();
        cargarReporte005();
        cargarReporte006();
        return "reporteCaso";
    }
    
    public String reporte(){
        
        return "reporteCaso";
    }

    public void cargarReporteMensual() {
        registroCarga = new RegistroCarga();
        registroCarga.setFecha(new Date());
        registroCarga.setUltimoMes("SI");
        registroCarga.setUltimoAnho("SI");
        compararUltimoMes();
        cargarCodigoCarga(registroCarga);
        reporteService.cargaCasoMes(registroCarga.getId());
    }

    private void cargarCodigoCarga(RegistroCarga registrocar) {
        registroCargaService.registroCargaInsert(registrocar);
    }

    private void compararUltimoMes() {
        SimpleDateFormat simpleDateFormatMes = new SimpleDateFormat("yyyyMM");
        RegistroCarga carga = registroCargaService.registroCargaBuscarUltimo();
        if (carga != null) {
            String fecha1 = simpleDateFormatMes.format(carga.getFecha());
            String fecha2 = simpleDateFormatMes.format(new Date());
            if (Integer.parseInt(fecha2) == Integer.parseInt(fecha1)) {
                carga.setUltimoAnho("NO");
                carga.setUltimoMes("NO");
                registroCargaService.registroCargaBuscarUpdate(carga);
            }
        }
    }

    private void cargarMeses() {
        listasMeses = new HashMap();
        listasMeses.put("01", "Enero");
        listasMeses.put("02", "Febrero");
        listasMeses.put("03", "Marzo");
        listasMeses.put("04", "Abril");
        listasMeses.put("05", "Mayo");
        listasMeses.put("06", "Junio");
        listasMeses.put("07", "Julio");
        listasMeses.put("08", "Agosto");
        listasMeses.put("09", "Septiembre");
        listasMeses.put("10", "Octubre");
        listasMeses.put("11", "Noviembre");
        listasMeses.put("12", "Diciembre");
        listasMeses = sortByValues((HashMap) listasMeses);
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getKey())
                        .compareTo(((Map.Entry) (o2)).getKey());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    private void limpiarListas() {
        listaResumen = null;
        listaResumen2 = null;
        listaResumen3 = null;
        listaResumen4 = null;
        listaResumen5 = null;
        listaResumen6 = null;
    }

    private void cargarAnhosCaso() {
        listaAnhos = reporteService.listadoAnhoCaso();
    }

    public void cargarGraficoEstadoAnho() {
        if (StringUtils.isNotBlank(reporte1.getParametro())) {
            String[] adArray = reporte1.getParametro().split(",");
            listaResumen = new ArrayList<>();
            List<Integer> listaAnhos = new ArrayList<>();
            for (String adArray1 : adArray) {
                listaAnhos.add(Integer.parseInt(adArray1));
            }
            listaResumen.addAll(reporteService.graficoEstadoAnho(listaAnhos));
        }
        for (Resumen r : listaResumen) {
            r.setTipo("04");
            r.setActivo(reporteService.grafico001Activo(r) == 0 ? "-" : reporteService.grafico001Activo(r).toString());
            r.setTipo("05");
            r.setLatente(reporteService.grafico001Activo(r) == 0 ? "-" : reporteService.grafico001Activo(r).toString());
            r.setTipo("06");
            r.setResuelto(reporteService.grafico001Activo(r) == 0 ? "-" : reporteService.grafico001Activo(r).toString());
        }
    }

    public void cargarReporte002() {
        List<Resumen> listaResumenTemp = new ArrayList<>();
        if (StringUtils.isNotBlank(reporte2.getParametro())) {
            String[] adArray = reporte2.getParametro().split(",");
            listaResumen2 = new ArrayList<>();
            for (String adArray1 : adArray) {
                listaResumen2.addAll(reporteService.grafico001Meses(adArray1));
            }
        }
        if (StringUtils.isNotBlank(reporte2.getColumna())) {
            String[] adArray0 = reporte2.getColumna().split(",");
            for (Resumen r : listaResumen2) {
                for (String adArray1 : adArray0) {
                    if (StringUtils.equals(adArray1, r.getMes())) {
                        listaResumenTemp.add(r);
                    }
                }
            }
            listaResumen2 = listaResumenTemp;
        }
        for (Resumen r : listaResumen2) {
            Resumen r1 = new Resumen();
            r1.setMes(r.getMes() + r.getAnho());
            r1.setTipo("04");
            r.setActivo(reporteService.grafico001MesesCount(r1) == 0 ? "-" : reporteService.grafico001MesesCount(r1).toString());
            r1.setTipo("05");
            r.setLatente(reporteService.grafico001MesesCount(r1) == 0 ? "-" : reporteService.grafico001MesesCount(r1).toString());
            r1.setTipo("06");
            r.setResuelto(reporteService.grafico001MesesCount(r1) == 0 ? "-" : reporteService.grafico001MesesCount(r1).toString());
        }
    }

    public void cargarReporte003() {
        List<Resumen> listaResumenTemp = new ArrayList<>();
        listaResumen3 = reporteService.grafico001Departamento(reporte3.getParametro());
        if (StringUtils.isNotBlank(reporte3.getColumna())) {
            String[] adArray = reporte3.getColumna().split(",");
            for (Resumen r : listaResumen3) {
                for (String adArray1 : adArray) {
                    if (StringUtils.equals(adArray1, Integer.toString(r.getIdDepartamento()))) {
                        listaResumenTemp.add(r);
                    }
                }
            }
            listaResumen3 = listaResumenTemp;
        }
        for (Resumen r : listaResumen3) {
            Resumen r1 = new Resumen();
            r1.setAnho(reporte3.getParametro());
            r1.setTipo("04");
            r1.setIdDepartamento(r.getIdDepartamento());
            r.setActivo(reporteService.grafico001DepartamentoCount(r1) == 0 ? "-" : reporteService.grafico001DepartamentoCount(r1).toString());
            r1.setTipo("05");
            r.setLatente(reporteService.grafico001DepartamentoCount(r1) == 0 ? "-" : reporteService.grafico001DepartamentoCount(r1).toString());
            r1.setTipo("06");
            r.setResuelto(reporteService.grafico001DepartamentoCount(r1) == 0 ? "-" : reporteService.grafico001DepartamentoCount(r1).toString());
        }
    }

    private void cargarReporte004() {
        //listaResumen4 = reporteService.graficoEstadoAnho("2015");
        for (Resumen r : listaResumen4) {
            r.setColumna(r.getColumna());
            r.setTipoCaso("09");
            r.setSocioambiental(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("01");
            r.setAsuntosGobiernoLocal(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("08");
            r.setLaboral(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("04");
            r.setComunal(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("02");
            r.setAsuntosGobiernoNacional(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("03");
            r.setAsuntosGobiernoRegional(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("06");
            r.setDemarcacionTerritorial(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("07");
            r.setElectoral(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("05");
            r.setCultivoCoca(reporteService.grafico004TipoCaso(r));
            r.setTipoCaso("10");
            r.setOtrosAsuntos(reporteService.grafico004TipoCaso(r));
        }
    }

    private void cargarReporte005() {
        listaResumen5 = reporteService.grafico001Departamento("2015");
        for (Resumen r : listaResumen5) {
            r.setMes("2015");
            r.setTipoCaso("09");
            r.setSocioambiental(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("01");
            r.setAsuntosGobiernoLocal(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("08");
            r.setLaboral(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("04");
            r.setComunal(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("02");
            r.setAsuntosGobiernoNacional(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("03");
            r.setAsuntosGobiernoRegional(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("06");
            r.setDemarcacionTerritorial(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("07");
            r.setElectoral(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("05");
            r.setCultivoCoca(reporteService.grafico005DepartamentoCount(r));
            r.setTipoCaso("10");
            r.setOtrosAsuntos(reporteService.grafico005DepartamentoCount(r));
        }
    }

    private void cargarReporte006() {
        listaResumen6 = reporteService.grafico001Meses("2015");
        for (Resumen r : listaResumen6) {
            r.setMes(r.getMes() + "2015");
            r.setTipoCaso("09");
            r.setSocioambiental(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("01");
            r.setAsuntosGobiernoLocal(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("08");
            r.setLaboral(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("04");
            r.setComunal(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("02");
            r.setAsuntosGobiernoNacional(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("03");
            r.setAsuntosGobiernoRegional(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("06");
            r.setDemarcacionTerritorial(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("07");
            r.setElectoral(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("05");
            r.setCultivoCoca(reporteService.grafico006MesesCount(r));
            r.setTipoCaso("10");
            r.setOtrosAsuntos(reporteService.grafico006MesesCount(r));
        }
    }

    public void initJasper(int ind) throws JRException {
        if (ind == 1) {
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaResumen);
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT+"\\reporteCaso001.jasper", new HashMap(), beanCollectionDataSource);
        }
        if (ind == 2) {
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaResumen2);
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT+"\\reporteCaso002.jasper", new HashMap(), beanCollectionDataSource);
        }

        if (ind == 3) {
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaResumen3);
            jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT+"\\reporteCaso003.jasper", new HashMap(), beanCollectionDataSource);
        }
    }

    public void initJasper4() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                listaResumen4);
        jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT+"\\reporteCaso004.jasper",
                new HashMap(), beanCollectionDataSource);

    }

    public void initJasper5() throws JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
                listaResumen5);
        jasperPrint = JasperFillManager.fillReport(ConstantesUtil.BASE_URL_REPORT+"\\reporteCaso004.jasper",
                new HashMap(), beanCollectionDataSource);

    }

    public void pdf(int ind) throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = simpleDateFormat.format(date);
        initJasper(ind);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse;
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_caso.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        facesContext.responseComplete();
        facesContext.renderResponse();
    }

    public void xls(int ind) throws JRException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = simpleDateFormat.format(new Date());
        initJasper(ind);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse = (HttpServletResponse) facesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_reporte.xlsx");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JRXlsxExporter jrXlsxExporter = new JRXlsxExporter();
        jrXlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        jrXlsxExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
        jrXlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        jrXlsxExporter.exportReport();
        facesContext.responseComplete();
        facesContext.renderResponse();
    }

    public void pdf4() throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = simpleDateFormat.format(date);
        initJasper4();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse;
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_caso.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        facesContext.responseComplete();
        facesContext.renderResponse();
    }

    public void pdf5() throws JRException, IOException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fecha = simpleDateFormat.format(date);
        initJasper5();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse httpServletResponse;
        httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fecha + "_caso.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        facesContext.responseComplete();
        facesContext.renderResponse();
    }

    public List<SelectItem> getListaDepartamento() {
        listaDepartamento = new ArrayList<>();
        List<Departamento> list = ubigeoService.departamentoLista();
        if (list.size() > 0) {
            for (Departamento departamento : list) {
                listaDepartamento.add(new SelectItem(departamento.getId(), departamento.getDescripcion()));
            }
        }
        return listaDepartamento;
    }

    public List<Resumen> getListaResumen() {
        return listaResumen;
    }

    public void setListaResumen(List<Resumen> listaResumen) {
        this.listaResumen = listaResumen;
    }

    public ReporteService getReporteService() {
        return reporteService;
    }

    public void setReporteService(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    public List<Resumen> getListaResumen2() {
        return listaResumen2;
    }

    public void setListaResumen2(List<Resumen> listaResumen2) {
        this.listaResumen2 = listaResumen2;
    }

    public List<Resumen> getListaResumen3() {
        return listaResumen3;
    }

    public void setListaResumen3(List<Resumen> listaResumen3) {
        this.listaResumen3 = listaResumen3;
    }

    public List<Resumen> getListaResumen4() {
        return listaResumen4;
    }

    public void setListaResumen4(List<Resumen> listaResumen4) {
        this.listaResumen4 = listaResumen4;
    }

    public List<Resumen> getListaResumen5() {
        return listaResumen5;
    }

    public void setListaResumen5(List<Resumen> listaResumen5) {
        this.listaResumen5 = listaResumen5;
    }

    public List<Resumen> getListaResumen6() {
        return listaResumen6;
    }

    public void setListaResumen6(List<Resumen> listaResumen6) {
        this.listaResumen6 = listaResumen6;
    }

    public List<Resumen> getListaAnhos() {
        return listaAnhos;
    }

    public void setListaAnhos(List<Resumen> listaAnhos) {
        this.listaAnhos = listaAnhos;
    }

    public Resumen getReporte1() {
        return reporte1;
    }

    public void setReporte1(Resumen reporte1) {
        this.reporte1 = reporte1;
    }

    public Resumen getReporte2() {
        return reporte2;
    }

    public void setReporte2(Resumen reporte2) {
        this.reporte2 = reporte2;
    }

    public Map getListasMeses() {
        return listasMeses;
    }

    public void setListasMeses(Map listasMeses) {
        this.listasMeses = listasMeses;
    }

    public Resumen getReporte3() {
        return reporte3;
    }

    public void setReporte3(Resumen reporte3) {
        this.reporte3 = reporte3;
    }

    public RegistroCarga getRegistroCarga() {
        return registroCarga;
    }

    public void setRegistroCarga(RegistroCarga registroCarga) {
        this.registroCarga = registroCarga;
    }

    public String getTituloPanel() {
        return tituloPanel;
    }

    public void setTituloPanel(String tituloPanel) {
        this.tituloPanel = tituloPanel;
    }

}
