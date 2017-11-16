package events.dispatchers;

import events.events.UpdateAnnotationModeEvent;
import events.listeners.UpdateAnnotationModeEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the UpdateAnnotationModeEventListener objects and fires UpdateAnnotationModeEvent events.
 * @author Tim
 */
public class UpdateAnnotationModeEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateAnnotationModeEventListener listener_ = (UpdateAnnotationModeEventListener) listener;
            listener_.eventFired((UpdateAnnotationModeEvent) event);
        }
    }
    
}
