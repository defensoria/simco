/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.noticia.dao;

import gob.dp.simco.noticia.entity.Noticia;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface NoticiaDAO {
    
    public List<Noticia> listaNoticias(Noticia noticia);
    
}
