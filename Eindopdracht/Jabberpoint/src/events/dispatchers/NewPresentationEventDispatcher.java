package events.dispatchers;

import events.events.NewPresentationEvent;
import events.listeners.NewPresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the NewPresentationEventListener objects and fires NewPresentationEvent events.
 * @author Tim
 */
public class NewPresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            NewPresentationEventListener listener_ = (NewPresentationEventListener) listener;
            listener_.eventFired((NewPresentationEvent) event);
        }
    }
    
}
