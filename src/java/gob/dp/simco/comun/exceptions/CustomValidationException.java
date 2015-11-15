package gob.dp.simco.comun.exceptions;

public class CustomValidationException extends Exception 
{  
    public CustomValidationException(String msg) {  
        super(msg);  
    }  
      
    public CustomValidationException(String msg, Throwable ex) {  
        super(msg,ex);  
    }
}
