/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.administracion.parametro.controller;

import gob.dp.simco.administracion.parametro.bean.FiltroCatalogo;
import gob.dp.simco.administracion.parametro.constantes.Constantes;
import gob.dp.simco.administracion.parametro.entity.Catalogo;
import gob.dp.simco.administracion.parametro.service.CatalogoService;
import gob.dp.simco.comun.MessagesUtil;
import gob.dp.simco.comun.mb.AbstractManagedBean;
import gob.dp.simco.registro.constantes.ConstantesUtil;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Administrador
 */
@Named
@Scope("session")
public class CatalogoController extends AbstractManagedBean implements Serializable {

    private static final Logger log = Logger.getLogger(CatalogoController.class);

    private String mensaje;

    private Long nroPagina = 1L;

    private Long nroPaginaHijo = 1L;

    private List<Catalogo> listaCatalogo;

    private List<Catalogo> listaCatalogoHijo;

    private int padreParametro = 0;
    
    MessagesUtil msg;

    private BusquedaCatalogoTemp busquedaCatalogoTemp;

    private Catalogo catalogoPadre;

    private Catalogo catalogoHijo;

    private boolean habilitado = true;

    private boolean verGuardar = true;
    
    @Autowired
    private CatalogoService catalogoService;

    public CatalogoController() {
        msg = new MessagesUtil();
    }
    
    public boolean isVerGuardar() {
        return verGuardar;
    }

    public void setVerGuardar(boolean verGuardar) {
        this.verGuardar = verGuardar;
    }

    public BusquedaCatalogoTemp getBusquedaCatalogoTemp() {
        if (busquedaCatalogoTemp == null) {
            busquedaCatalogoTemp = new BusquedaCatalogoTemp();
        }
        return busquedaCatalogoTemp;
    }

    public void setBusquedaCatalogoTemp(BusquedaCatalogoTemp busquedaCatalogoTemp) {
        this.busquedaCatalogoTemp = busquedaCatalogoTemp;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Catalogo getCatalogoPadre() {
        if (catalogoPadre == null) {
            catalogoPadre = new Catalogo();
        }
        return catalogoPadre;
    }

    public void setCatalogoPadre(Catalogo catalogoPadre) {
        this.catalogoPadre = catalogoPadre;
    }

    public Catalogo getCatalogoHijo() {
        if (catalogoHijo == null) {
            catalogoHijo = new Catalogo();
        }
        return catalogoHijo;
    }

    public void setCatalogoHijo(Catalogo catalogoHijo) {
        this.catalogoHijo = catalogoHijo;
    }

    public String cargarPagina() {
        log.debug("METODO : CatalogoController.cargarPagina");
        busquedaCatalogoTemp = new BusquedaCatalogoTemp();
        listaCatalogo = null;
        return "catalogoPadreList";
    }

    public String cargarPaginaDerivados() {
        busquedaCatalogoTemp = new BusquedaCatalogoTemp();
        listaCatalogoHijo = null;
        return "catalogoHijoList";
    }

    public String buscarCatalogoPadre(long page) {
        log.debug("METODO : CatalogoController.buscarCatalogoPadre");
        try {
            FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
            if (!StringUtils.isBlank(busquedaCatalogoTemp.getNombreParametro())) {
                filtroCatalogo.setNombreParametro(busquedaCatalogoTemp.getNombreParametro().toUpperCase());
            }

            filtroCatalogo.setNumParametro((busquedaCatalogoTemp.getNumParametro() == null || busquedaCatalogoTemp.getNumParametro().equals(new Integer(0))) ? null : busquedaCatalogoTemp.getNumParametro());
            listarPaginado(filtroCatalogo, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catalogoPadreList";
    }

    public void listarPaginado(FiltroCatalogo filtroCatalogo, Long pagina) {
        if (pagina > 0) {
            int paginado = ConstantesUtil.PAGINADO_10;
            Long ini = paginado * (pagina - 1) + 1;
            Long fin = paginado * pagina;
            if (pagina == 0) {
                ini = 1L;
                fin = 10L;
            }
            filtroCatalogo.setIni(ini);
            filtroCatalogo.setFin(fin);
            try {
                List<Catalogo> list = catalogoService.buscarCatalogoPadre(filtroCatalogo);
                if (list.size() > 0) {
                    listaCatalogo = list;
                    nroPagina = pagina;
                }
            } catch (Exception e) {
                log.error("ERROR : BusquedaUsuarioController.listarPaginado: " + e.getMessage());
            }
        }
    }

    public String viewCatalogoPadre(Integer numParametro) {
        log.debug("METODO : CatalogoController.viewCatalogoPadre");
        this.verGuardar = true;
        try {
            getCatalogoPadre().setNumParametro(numParametro);
            setCatalogoPadre(catalogoService.viewCatalogoPadre(getCatalogoPadre()));
            this.habilitado = getCatalogoPadre().getCodEstado().equals(Constantes.ESTADO_ACTIVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catalogoPadreUpdate";
    }

    public String updateCatalogoPadre(Integer numParametro) {
        log.debug("METODO : CatalogoController.updateCatalogoPadre");
        this.verGuardar = true;
        try {
            getCatalogoPadre().setNumParametro(numParametro);
            getCatalogoPadre().setPadreParametro(getCatalogoPadre().getPadreParametro());
            if (getCatalogoPadre().getValorParametro() == null || getCatalogoPadre().getValorParametro().equals("")) {
                getCatalogoPadre().setValorParametro("");
            }

            if (isHabilitado() == true) {
                getCatalogoPadre().setCodEstado(Constantes.ESTADO_ACTIVO);
            } else {
                getCatalogoPadre().setCodEstado(Constantes.ESTADO_INACTIVO);
            }
            getCatalogoHijo().setPadreParametro(numParametro);
            getCatalogoHijo().setCodEstado(getCatalogoPadre().getCodEstado());
            catalogoService.updateEstadoCatalogoHijo(getCatalogoHijo());
            catalogoService.updateCatalogoPadre(getCatalogoPadre());
            msg.messageInfo("Se realizacion los cambios correctamente", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catalogoPadreUpdate";
    }

    public String nuevoCatalogoPadre() {
        log.debug("METODO : CatalogoController.nuevoCatalogoPadre");
        this.verGuardar = true;
        busquedaCatalogoTemp = new BusquedaCatalogoTemp();
        this.catalogoPadre = new Catalogo();
        return "catalogoPadreNuevo";
    }

    public String insertarCatalogoPadre() {
        log.debug("METODO : CatalogoController.insertarCatalogoPadre");
        if (catalogoPadre.getNumParametro() == null) {
            if (isHabilitado() == true) {
                getCatalogoPadre().setCodEstado(Constantes.ESTADO_ACTIVO);
            } else {
                getCatalogoPadre().setCodEstado(Constantes.ESTADO_INACTIVO);
            }
            try {
                getCatalogoPadre().setPadreParametro(0);
                getCatalogoPadre().setValorParametro("");
                getCatalogoPadre().setNombreParametro(getCatalogoPadre().getNombreParametro().toUpperCase());
                catalogoService.nuevoCatalogoPadre(getCatalogoPadre());
                this.verGuardar = false;
                msg.messageInfo("Se realizaron todos los cambios correctamente", null);
            } catch (Exception ex) {
                log.error(ex);
            }
        }
        return "catalogoPadreNuevo";
    }

    public String buscarCatalogoHijo(Integer padreParam, long page) {
        log.debug("METODO : CatalogoController.buscarCatalogoHijo");
        try {
            FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
            getCatalogoHijo().setPadreParametro(padreParam);
            if (!StringUtils.isBlank(busquedaCatalogoTemp.getNombreParametro())) {
                filtroCatalogo.setNombreParametro(busquedaCatalogoTemp.getNombreParametro().toUpperCase());
            }
            filtroCatalogo.setNumParametro((busquedaCatalogoTemp.getNumParametro() == null || busquedaCatalogoTemp.getNumParametro().equals(new Integer(0))) ? null : busquedaCatalogoTemp.getNumParametro());
            if (padreParam == null || padreParam.equals(new Integer(0))) {
                filtroCatalogo.setPadreParametro(null);
            } else {
                filtroCatalogo.setPadreParametro(padreParam);
            }
            listarPaginadoHijo(filtroCatalogo, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        padreParametro = padreParam;
        return "catalogoHijoListVer";
    }

    public String buscarCatalogoHijoLista(long page) {
        log.debug("METODO : CatalogoController.buscarCatalogoHijo");
        try {
            FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
            if (!StringUtils.isBlank(busquedaCatalogoTemp.getNombreParametro())) {
                filtroCatalogo.setNombreParametro(busquedaCatalogoTemp.getNombreParametro().toUpperCase());
            }
            filtroCatalogo.setNumParametro((busquedaCatalogoTemp.getNumParametro() == null || busquedaCatalogoTemp.getNumParametro().equals(new Integer(0))) ? null : busquedaCatalogoTemp.getNumParametro());
            listarPaginadoHijo(filtroCatalogo, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catalogoHijoList";
    }

    public void listarPaginadoHijo(FiltroCatalogo filtroCatalogo, Long pagina) {
        if (pagina > 0) {
            int paginado = ConstantesUtil.PAGINADO_10;
            Long ini = paginado * (pagina - 1) + 1;
            Long fin = paginado * pagina;
            if (pagina == 0) {
                ini = 1L;
                fin = 10L;
            }
            filtroCatalogo.setIni(ini);
            filtroCatalogo.setFin(fin);
            try {
                List<Catalogo> list = catalogoService.buscarCatalogoHijo(filtroCatalogo);
                if (list.size() > 0) {
                    listaCatalogoHijo = list;
                    nroPaginaHijo = pagina;
                }
            } catch (Exception e) {
                log.error("ERROR : BusquedaUsuarioController.listarPaginado: " + e.getMessage());
            }
        }
    }

    public String viewCatalogoHijo(Integer hijoParametro) {
        log.debug("viewCatalogoHijo");
        this.verGuardar = true;
        try {
            getCatalogoHijo().setNumParametro(hijoParametro);
            setCatalogoHijo(catalogoService.viewCatalogoHijo(getCatalogoHijo()));
            this.habilitado = getCatalogoHijo().getCodEstado().equals(Constantes.ESTADO_ACTIVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catalogoHijoUpdate";
    }

    public String updateCatalogoHijo(Integer numParametro) {
        log.debug("updateCatalogoHijo");
        this.verGuardar = true;
        try {
            getCatalogoHijo().setNumParametro(numParametro);
            getCatalogoHijo().setPadreParametro(getCatalogoHijo().getPadreParametro());
            if (getCatalogoHijo().getValorParametro() == null || getCatalogoHijo().getValorParametro().equals("")) {
                getCatalogoHijo().setValorParametro("");
            }
            if (isHabilitado() == true) {
                getCatalogoHijo().setCodEstado(Constantes.ESTADO_ACTIVO);
            } else {
                getCatalogoHijo().setCodEstado(Constantes.ESTADO_INACTIVO);
            }
            catalogoService.updateCatalogoHijo(getCatalogoHijo());
            msg.messageInfo("Se realizaron los cambios correctamente", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "catalogoHijoUpdate";
    }

    public String nuevoCatalogoHijo(Integer padreParametro) {
        log.debug("METODO : CatalogoController.nuevoCatalogoHijo");
        this.verGuardar = true;
        busquedaCatalogoTemp = new BusquedaCatalogoTemp();
        this.catalogoHijo = new Catalogo();
        getCatalogoHijo().setPadreParametro(padreParametro);
        return "catalogoHijoNuevo";
    }

    public String insertarCatalogoHijo(Integer padreParametro) {
        log.debug("METODO : CatalogoController.insertarCatalogoHijo");
        if (isHabilitado() == true) {
            getCatalogoHijo().setCodEstado(Constantes.ESTADO_ACTIVO);
        } else {
            getCatalogoHijo().setCodEstado(Constantes.ESTADO_INACTIVO);
        }
        try {
            log.debug("->padreParametro=" + getCatalogoHijo().getPadreParametro());
            getCatalogoHijo().setNombreParametro(getCatalogoHijo().getNombreParametro().toUpperCase());
            catalogoService.nuevoCatalogoHijo(getCatalogoHijo());
            this.verGuardar = false;
            msg.messageInfo("Se registraron los cambios correctamente", null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "catalogoHijoNuevo";
    }

    public Long getNroPagina() {
        return nroPagina;
    }

    public void setNroPagina(Long nroPagina) {
        this.nroPagina = nroPagina;
    }

    public List<Catalogo> getListaCatalogo() {
        return listaCatalogo;
    }

    public void setListaCatalogo(List<Catalogo> listaCatalogo) {
        this.listaCatalogo = listaCatalogo;
    }

    public Long getNroPaginaHijo() {
        return nroPaginaHijo;
    }

    public void setNroPaginaHijo(Long nroPaginaHijo) {
        this.nroPaginaHijo = nroPaginaHijo;
    }

    public List<Catalogo> getListaCatalogoHijo() {
        return listaCatalogoHijo;
    }

    public void setListaCatalogoHijo(List<Catalogo> listaCatalogoHijo) {
        this.listaCatalogoHijo = listaCatalogoHijo;
    }

    public int getPadreParametro() {
        return padreParametro;
    }

    public void setPadreParametro(int padreParametro) {
        this.padreParametro = padreParametro;
    }

}
