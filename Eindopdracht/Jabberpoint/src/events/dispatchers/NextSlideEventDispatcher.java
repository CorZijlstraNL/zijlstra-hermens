package events.dispatchers;

import events.events.NextSlideEvent;
import events.listeners.NextSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the NextSlideEventListener objects and fires NextSlideEvent events.
 * @author Tim
 */
public class NextSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            NextSlideEventListener listener_ = (NextSlideEventListener) listener;
            listener_.eventFired((NextSlideEvent) event);
        }
    }
    
}
