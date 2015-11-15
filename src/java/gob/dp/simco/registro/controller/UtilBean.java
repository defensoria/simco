package gob.dp.simco.registro.controller;

import gob.dp.simco.comun.Mail;
import gob.dp.simco.comun.TimerEmail;
import java.io.Serializable;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;


@Named
@Scope("session")
public class UtilBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	
	//variables
	
	
	
	public UtilBean(){
		
	}

	

	
	/*metodos creados*/
	
	public void correo(){
            TimerEmail email = new TimerEmail();
                email.envioEmail();
		Mail mail = new Mail();	
		//tblEmailDetalle.setNIdDestinatarioPersona(tblEmailPersona.getNIdEmail());
		mail.send("careli_2710@hotmail.com","asunto","cuerpo");
                
	}
	
	
	
	
	

	
	
}