/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.administracion.seguridad.controller;
import gob.dp.simco.administracion.seguridad.bean.FiltroUsuario;
import gob.dp.simco.administracion.seguridad.constantes.ConstantesAuditoria;
import gob.dp.simco.administracion.seguridad.entity.Usuario;
import gob.dp.simco.administracion.seguridad.service.AuditoriaService;
import gob.dp.simco.administracion.seguridad.service.UsuarioService;
import gob.dp.simco.comun.MessagesUtil;
import gob.dp.simco.comun.SessionUtil;
import gob.dp.simco.comun.mb.AbstractManagedBean;
import java.io.Serializable;
import javax.faces.context.FacesContext;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;


/**
 *
 * @author Administrador
 */
@Named
@Scope("session")
public class LoginController extends AbstractManagedBean implements Serializable {

    private static final Logger log = Logger.getLogger(LoginController.class);

    private Usuario usuario;

    private String mensaje="";
    
    private MessagesUtil msg;

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private AuditoriaService auditoriaService;

    public String ingresarSistema(){
        msg= new MessagesUtil();
     try{ 
    	 if (usuario.getCodigo()!=null)
    		 usuario.setCodigo(usuario.getCodigo().toUpperCase());
    	 
         FiltroUsuario filtro=new FiltroUsuario();
         filtro.setCodigo(usuario.getCodigo());
         filtro.setIncluirLstRol(true);
         filtro.setIncluirMapRol(true);
         filtro.setIncluirMapRecurso(true);
         Usuario objUsuario=usuarioService.consultarUsuario(filtro);
         log.debug("Entrando a ingresarSistema 1 ");

        if(objUsuario!=null){
             //String encPass = CryptoAES.getInstance().encriptar(usuario.getClave().trim());
            log.debug("Entrando a ingresarSistema 2 ");
            log.debug("Entrando a ingresarSistema 2 : Clave a encriptar : "+usuario.getClave().trim());
            String clave1 = usuario.getClave().trim();
           // String encPass = new String(MEncript.getStringMessageDigest(usuario.getClave().trim()));
            String encPass = usuario.getClave().trim();
            
            log.debug("Entrando a ingresarSistema 3 ");
            if(objUsuario.getClave().trim().equals(encPass))
            {
            	log.debug("Clave correcta, creando sesion");
            	
              SessionUtil.setUsuario(objUsuario);
              //auditoriaService.auditar(ConstantesAuditoria.SEGURIDAD_LOGIN_CORRECTO, "Login correcto");
              
              this.mensaje="";
              cargarMenu();
              return "ingresarSistema";
            }
            else{
                  msg.messageAlert("El usuario o contraseña no existen", null);
                  auditoriaService.auditar(ConstantesAuditoria.SEGURIDAD_LOGIN_INCORRECTO, "Login incorrecto",objUsuario);
                  return "login";
            }
        } else{
            msg.messageAlert("El usuario o contraseña no existen", null);
            return "login";     
        }
               
     } catch (Exception ex) {
           log.error("Ocurrió un error", ex);
           this.mensaje="Ocurrió un Error: "+ex.getMessage();
           return null;
       }
        
    }
    
    private void cargarMenu(){
        FacesContext context = FacesContext.getCurrentInstance();
        MenuController menuController = (MenuController) context.getELContext().getELResolver().getValue(context.getELContext(), null, "menuController");
        menuController.cargarMenu();
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario getUsuario() {
        if(this.usuario==null){
            this.usuario=new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

   public Usuario getUsuarioSesion() {    
           return SessionUtil.getUsuario();
    }

     public void setAuditoriaService(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    public MessagesUtil getMsg() {
        return msg;
    }

    public void setMsg(MessagesUtil msg) {
        this.msg = msg;
    }

}
