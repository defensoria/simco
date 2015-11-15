package gob.dp.simco.comun.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("gob.dp.simco.comun.validator.ComboRequeridoValidator")
public class ComboRequeridoValidator implements Validator {

	private static final String PATTERN = "^([\\d]{2})";

	private Pattern pattern;
	private Matcher matcher;

	public ComboRequeridoValidator() {
		pattern = Pattern.compile(PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException 
	{
		boolean valido = false;
		
		if (value != null) 
		{
			matcher = pattern.matcher(value.toString());
			if (matcher.matches())
				valido = true;
		} 
		
		if (!valido)
		{
			FacesMessage msg = new FacesMessage("Combo requerido","Seleccione un valor en el combo");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
	}

}
