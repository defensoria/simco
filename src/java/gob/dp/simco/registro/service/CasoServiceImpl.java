/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.registro.service;

import gob.dp.simco.registro.bean.FiltroCaso;
import gob.dp.simco.registro.dao.CasoDao;
import gob.dp.simco.registro.entity.Caso;
import gob.dp.simco.registro.entity.Parametro;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class CasoServiceImpl implements CasoService{
    
    private static final Logger log = Logger.getLogger(CasoServiceImpl.class);
    
    @Autowired
    private CasoDao casoDao;
    
    @Autowired
    private CacheService cacheService;

    @Override
    public void casoNuevo(Caso caso) throws Exception {
        log.debug("METODO : CasoServiceImpl.casoNuevo");
        casoDao.casoInsertar(caso);
    }

    @Override
    public void casoModificar(Caso caso) throws Exception {
        log.debug("METODO : CasoServiceImpl.casoModificar");
        casoDao.casoUpdate(caso);
    }

    @Override
    public List<Caso> casoBuscar(Caso caso) {
        try {
            log.debug("METODO : CasoServiceImpl.casoBuscar");
            return casoDao.casoBuscar(caso);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    @Override
    public Integer casoTotalBuscar(FiltroCaso filtroCaso) throws Exception {
        log.debug("METODO : CasoServiceImpl.casoTotalBuscar");
        return casoDao.casoTotalBuscar(filtroCaso);
    }

    @Override
    public List<Caso> casoxActividadBuscar(long idActividad) throws Exception {
        log.debug("METODO : CasoServiceImpl.casoxActividadBuscar");
        return casoDao.casoxActividadBuscar(idActividad);
    }

    @Override
    public List<Caso> casoxActividadBuscarTotal(long idActividad) throws Exception {
        log.debug("METODO : CasoServiceImpl.casoxActividadBuscarTotal");
        return casoDao.casoxActividadBuscarTotal(idActividad);
    }

    @Override
    public Caso casoBuscarOne(Long idCaso) throws Exception {
        log.debug("METODO : CasoServiceImpl.casoBuscarOne");
        return casoDao.casoBuscarOne(idCaso);
    }

    @Override
    public String casoBuscarAutocomplete(){
        log.debug("METODO : CasoServiceImpl.casoBuscarAutocomplete");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var projects = [");
        int i = 0;
        Caso caso1 = new Caso();
        try {
            for(Caso a:casoDao.casoBuscar(caso1)){
                if(i > 0)
                    stringBuilder.append(",");
                stringBuilder.append("{value: ").append(a.getId()).append(",");
                stringBuilder.append("label: '").append(a.getNombre()).append("' ,");
                stringBuilder.append("desc: ").append("''").append(",");
                stringBuilder.append("icon: ").append("'' },");
            }
            stringBuilder.append("];");
        } catch (Exception ex) {
            log.error(ex.getCause());
        }
        
        return stringBuilder.toString();
    }

    @Override
    public Integer casoCodigoGenerado() {
        return casoDao.casoCodigoGenerado();
    }

    @Override
    public String adjuntiaBuscarAutocomplete() {
        log.debug("METODO : CasoServiceImpl.adjuntiaBuscarAutocomplete");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var projects1 = [");
        int i = 0;
        try {
            for(Parametro a: cacheService.buscarAdjuntiaDefensorial()){
                if(i > 0)
                    stringBuilder.append(",");
                    stringBuilder.append("{value: '").append(a.getValorParametro()).append("' ,");
                    stringBuilder.append("label: '").append(a.getNombreParametro()).append("' ,");
                    stringBuilder.append("desc: ").append("''").append(",");
                    stringBuilder.append("icon: ").append("'' },");
            }
            stringBuilder.append("];");
        } catch (Exception ex) {
            log.error(ex.getCause());
        } 
        return stringBuilder.toString();
    }    

    @Override
    public Caso casoxActaAcuerdoDetalle(long idActaAcuerdoDetalle) {
        try {
            return casoDao.casoxActaAcuerdoDetalle(idActaAcuerdoDetalle);
        } catch (Exception ex) {
            log.error(ex.getCause());
            return null;
        }
    }

    @Override
    public void casoUpdateIndicador(Caso caso) {
        casoDao.casoUpdateIndicador(caso);
    }
    
}
