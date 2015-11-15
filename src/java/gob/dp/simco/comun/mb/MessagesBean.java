package gob.dp.simco.comun.mb;

import java.io.Serializable;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;


@Named
@Scope("session")
public class MessagesBean extends AbstractManagedBean implements Serializable
{  
    public boolean isError() {  
        return !getCurrentContext().getMessageList().isEmpty();  
    }
}
