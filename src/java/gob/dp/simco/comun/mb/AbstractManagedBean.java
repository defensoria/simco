package gob.dp.simco.comun.mb;

import java.util.Iterator;
import java.util.List;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
public class AbstractManagedBean
{
	protected FacesContext getCurrentContext()
    {
        return FacesContext.getCurrentInstance();
    }

    public void addInfo(String msg)
    {
        addMessage(msg, FacesMessage.SEVERITY_INFO);
    }

    public void addError(String msg) 
    {
        addMessage(msg, FacesMessage.SEVERITY_ERROR);
    }

    private void addMessage(String msg,FacesMessage.Severity severity)
    {
        FacesMessage message=new FacesMessage(msg);
        message.setSeverity(severity);
        FacesContext ctx=getCurrentContext();
        ctx.addMessage(null, message);
    }

    public String getMessage(String key)
    {
        return (String)getExpression("msg['"+key+"']");
    }

    private Object getExpression(String expression)
    {
        FacesContext ctx=getCurrentContext();
        ExpressionFactory factory=ctx.getApplication().getExpressionFactory();
        ValueExpression ex=factory.createValueExpression(ctx.getELContext(), "#{"+expression+"}", Object.class);
        return ex.getValue(ctx.getELContext());

    }
}
