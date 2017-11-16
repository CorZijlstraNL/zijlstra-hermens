package events.dispatchers;

import events.events.ClosePresentationEvent;
import events.listeners.ClosePresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the ClosePresentationEventListener objects and fires ClosePresentationEvent events.
 * @author Tim
 */
public class ClosePresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            ClosePresentationEventListener listener_ = (ClosePresentationEventListener) listener;
            listener_.eventFired((ClosePresentationEvent) event);
        }
    }
    
}
