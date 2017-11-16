package events.dispatchers;

import events.events.PreviousSlideEvent;
import events.listeners.PreviousSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the PreviousSlideEventListener objects and fires PreviousSlideEvent events.
 * @author Tim
 */
public class PreviousSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            PreviousSlideEventListener listener_ = (PreviousSlideEventListener) listener;
            listener_.eventFired((PreviousSlideEvent) event);
        }
    }
    
}
