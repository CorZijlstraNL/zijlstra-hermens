package events.dispatchers;

import events.events.CreateDrawnAnnotationEvent;
import events.listeners.CreateDrawnAnnotationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the CreateDrawnAnnotationEventListener objects and fires CreateDrawnAnnotationEvent events.
 * @author Tim
 */
public class CreateDrawnAnnotationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            CreateDrawnAnnotationEventListener listener_ = (CreateDrawnAnnotationEventListener) listener;
            listener_.eventFired((CreateDrawnAnnotationEvent) event);
        }
    }
    
}
