package gob.dp.simco.comun.mb;

import gob.dp.simco.comun.MessagesUtil;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
public abstract class AbstractManagedBean implements Serializable{
    
    protected MessagesUtil msg;
    
    FacesContext context = FacesContext.getCurrentInstance();

    public AbstractManagedBean() {
        msg = new MessagesUtil();
    }
}