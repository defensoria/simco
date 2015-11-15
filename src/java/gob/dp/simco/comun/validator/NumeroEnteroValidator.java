package gob.dp.simco.comun.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("gob.dp.simco.comun.validator.NumeroEnteroValidator")
public class NumeroEnteroValidator implements Validator
{

	private static final String PATTERN = "^([\\d]*[\\s]*)$";

	private Pattern pattern;
	private Matcher matcher;

	public NumeroEnteroValidator()
        {
		  pattern = Pattern.compile(PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component,Object value) throws ValidatorException
        {
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches())
                {
			FacesMessage msg = new FacesMessage("No es numero","El campo debe ser un número, sin espacios en blanco");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
}
