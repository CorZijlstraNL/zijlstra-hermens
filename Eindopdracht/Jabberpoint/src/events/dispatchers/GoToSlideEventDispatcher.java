package events.dispatchers;

import events.events.GoToSlideEvent;
import events.listeners.GoToSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the GoToSlideEventListener objects and fires GoToSlideEvent events.
 * @author Tim
 */
public class GoToSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            GoToSlideEventListener listener_ = (GoToSlideEventListener) listener;
            listener_.eventFired((GoToSlideEvent) event);
        }
    }
    
}
