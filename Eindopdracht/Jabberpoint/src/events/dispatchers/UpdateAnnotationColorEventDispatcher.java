package events.dispatchers;

import events.events.UpdateAnnotationColorEvent;
import events.listeners.UpdateAnnotationColorEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the UpdateAnnotationColorEventListener objects and fires UpdateAnnotationColorEvent events.
 * @author Tim
 */
public class UpdateAnnotationColorEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateAnnotationColorEventListener listener_ = (UpdateAnnotationColorEventListener) listener;
            listener_.eventFired((UpdateAnnotationColorEvent) event);
        }
    }
    
}
