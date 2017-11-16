package events.dispatchers;

import events.events.DisplayCurrentSlideEvent;
import events.listeners.DisplayCurrentSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the DisplayCurrentSlideEventListener objects and fires DisplayCurrentSlideEvent events.
 * @author Tim
 */
public class DisplayCurrentSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            DisplayCurrentSlideEventListener listener_ = (DisplayCurrentSlideEventListener) listener;
            listener_.eventFired((DisplayCurrentSlideEvent) event);
        }
    }
    
}
