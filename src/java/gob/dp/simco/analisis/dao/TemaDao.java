/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.analisis.dao;

import gob.dp.simco.analisis.entity.Tema;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface TemaDao {
    
    public void temaInsertar(Tema tema);
    
    public List<Tema> temaBuscar(Long idCaso);
    
    public Tema temaxidBuscar(Long idTema);
    
    public List<Tema> temaxcasoxactorBuscar(Tema tema);

}
