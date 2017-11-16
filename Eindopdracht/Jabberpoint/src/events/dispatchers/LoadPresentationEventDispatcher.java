package events.dispatchers;

import events.events.LoadPresentationEvent;
import events.listeners.LoadPresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the LoadPresentationEventListener objects and fires LoadPresentationEvent events.
 * @author Tim
 */
public class LoadPresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            LoadPresentationEventListener listener_ = (LoadPresentationEventListener) listener;
            listener_.eventFired((LoadPresentationEvent) event);
        }
    }
    
}
