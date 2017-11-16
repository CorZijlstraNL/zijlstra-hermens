package events.dispatchers;

import events.events.DisplayDrawnAnnotationEvent;
import events.listeners.DisplayDrawnAnnotationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the DisplayDrawnAnnotationEventListener objects and fires DisplayDrawnAnnotationEvent events.
 * @author Tim
 */
public class DisplayDrawnAnnotationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            DisplayDrawnAnnotationEventListener listener_ = (DisplayDrawnAnnotationEventListener) listener;
            listener_.eventFired((DisplayDrawnAnnotationEvent) event);
        }
    }
    
}
