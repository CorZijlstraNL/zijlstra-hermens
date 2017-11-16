package events.dispatchers;

import events.events.UpdateDrawnAnnotationEvent;
import events.listeners.UpdateDrawnAnnotationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the UpdateDrawnAnnotationEventListener objects and fires UpdateDrawnAnnotationEvent events.
 * @author Tim
 */
public class UpdateDrawnAnnotationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateDrawnAnnotationEventListener listener_ = (UpdateDrawnAnnotationEventListener) listener;
            listener_.eventFired((UpdateDrawnAnnotationEvent) event);
        }
    }
    
}
