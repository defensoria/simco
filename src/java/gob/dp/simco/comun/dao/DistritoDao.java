/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.comun.dao;

import gob.dp.simco.comun.entity.Distrito;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface DistritoDao {
    
    public List<Distrito> distritoLista(Distrito distrito);
    
    public Distrito distritoOne(Distrito distrito);
    
}
