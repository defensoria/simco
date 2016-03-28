/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.registro.dao;

import gob.dp.simco.registro.bean.FiltroActor;
import gob.dp.simco.registro.entity.Actor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlos
 */
public class ActorDaoImplTest {
    
    public ActorDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actorInsertar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorInsertar() throws Exception {
        System.out.println("actorInsertar");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        instance.actorInsertar(actor);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorUpdate method, of class ActorDaoImpl.
     */
    @Test
    public void testActorUpdate() throws Exception {
        System.out.println("actorUpdate");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        instance.actorUpdate(actor);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscar() throws Exception {
        System.out.println("actorBuscar");
        FiltroActor filtroActor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorBuscar(filtroActor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorTotalBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorTotalBuscar() throws Exception {
        System.out.println("actorTotalBuscar");
        FiltroActor filtroActor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        Integer expResult = null;
        Integer result = instance.actorTotalBuscar(filtroActor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxActividadBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxActividadBuscar() throws Exception {
        System.out.println("actorxActividadBuscar");
        Long idActividad = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxActividadBuscar(idActividad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxActividadBuscarTotal method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxActividadBuscarTotal() throws Exception {
        System.out.println("actorxActividadBuscarTotal");
        Long idActividad = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxActividadBuscarTotal(idActividad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarOne method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarOne() throws Exception {
        System.out.println("actorBuscarOne");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        Actor expResult = null;
        Actor result = instance.actorBuscarOne(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarPaginado method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarPaginado() throws Exception {
        System.out.println("actorBuscarPaginado");
        FiltroActor filtroActor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorBuscarPaginado(filtroActor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxAcuerdoDetalleBusqueda method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxAcuerdoDetalleBusqueda() {
        System.out.println("actorxAcuerdoDetalleBusqueda");
        Long idAcuerdoDetalle = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxAcuerdoDetalleBusqueda(idAcuerdoDetalle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxCasoBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxCasoBuscar() {
        System.out.println("actorxCasoBuscar");
        Long idCaso = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxCasoBuscar(idCaso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxCasoIntensidadBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxCasoIntensidadBuscar() {
        System.out.println("actorxCasoIntensidadBuscar");
        Long idCaso = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxCasoIntensidadBuscar(idCaso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorTodosBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorTodosBuscar() {
        System.out.println("actorTodosBuscar");
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorTodosBuscar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarEmpresaEntidad method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarEmpresaEntidad() {
        System.out.println("actorBuscarEmpresaEntidad");
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorBuscarEmpresaEntidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorXactividadSimpleBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorXactividadSimpleBuscar() {
        System.out.println("actorXactividadSimpleBuscar");
        Long id = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorXactividadSimpleBuscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarSimple method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarSimple() {
        System.out.println("actorBuscarSimple");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorBuscarSimple(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarTotalSimple method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarTotalSimple() {
        System.out.println("actorBuscarTotalSimple");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        Actor expResult = null;
        Actor result = instance.actorBuscarTotalSimple(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarTotalSimpleCount method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarTotalSimpleCount() {
        System.out.println("actorBuscarTotalSimpleCount");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        Integer expResult = null;
        Integer result = instance.actorBuscarTotalSimpleCount(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorBuscarTotalSimpleCountRUC method, of class ActorDaoImpl.
     */
    @Test
    public void testActorBuscarTotalSimpleCountRUC() {
        System.out.println("actorBuscarTotalSimpleCountRUC");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        Integer expResult = null;
        Integer result = instance.actorBuscarTotalSimpleCountRUC(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxActaAcuerdoBuscar method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxActaAcuerdoBuscar() {
        System.out.println("actorxActaAcuerdoBuscar");
        long idAcuerdoDetalle = 0L;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxActaAcuerdoBuscar(idAcuerdoDetalle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorxAcuerdoDetalleBusquedaFin method, of class ActorDaoImpl.
     */
    @Test
    public void testActorxAcuerdoDetalleBusquedaFin() {
        System.out.println("actorxAcuerdoDetalleBusquedaFin");
        Long idAcuerdoDetalle = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actorxAcuerdoDetalleBusquedaFin(idAcuerdoDetalle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorValidadDNI method, of class ActorDaoImpl.
     */
    @Test
    public void testActorValidadDNI() {
        System.out.println("actorValidadDNI");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        int expResult = 0;
        int result = instance.actorValidadDNI(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actorValidadRUC method, of class ActorDaoImpl.
     */
    @Test
    public void testActorValidadRUC() {
        System.out.println("actorValidadRUC");
        Actor actor = null;
        ActorDaoImpl instance = new ActorDaoImpl();
        int expResult = 0;
        int result = instance.actorValidadRUC(actor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actoresSigues method, of class ActorDaoImpl.
     */
    @Test
    public void testActoresSigues() {
        System.out.println("actoresSigues");
        String codigoUsuario = "";
        ActorDaoImpl instance = new ActorDaoImpl();
        List<Actor> expResult = null;
        List<Actor> result = instance.actoresSigues(codigoUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
