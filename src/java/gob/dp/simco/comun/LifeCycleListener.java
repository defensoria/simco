package gob.dp.simco.comun;
 
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public class LifeCycleListener implements PhaseListener {
     
    private static final long serialVersionUID = -2504278325379445246L;
 
    private static final Log log = LogFactory.getLog(LifeCycleListener.class);
    
    MessagesUtil msg = new MessagesUtil();
     
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
 
    @Override
    public void beforePhase(PhaseEvent event) {
            msg.messageAlert("care", null);
        
    }
 
    @Override
    public void afterPhase(PhaseEvent event) {
    }
 
}