package gob.dp.simco.comun.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("gob.dp.simco.comun.validator.CampoRequeridoValidator")
public class CampoRequeridoValidator implements Validator
{
	public CampoRequeridoValidator()
    {

	}

	@Override
	public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException
    {
		if (value==null)
			value="";
		
		
        if(value.toString().isEmpty())
        {
                FacesMessage msg = new FacesMessage("Campo requerido","Ingrese el campo");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
        }
    }



}