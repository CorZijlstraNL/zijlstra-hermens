package events.dispatchers;

import events.events.DisplayPresentationTitleEvent;
import events.listeners.DisplayPresentationTitleEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the DisplayPresentationTitleEventListener objects and fires DisplayPresentationTitleEvent events.
 * @author Tim
 */
public class DisplayPresentationTitleEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            DisplayPresentationTitleEventListener listener_ = (DisplayPresentationTitleEventListener) listener;
            listener_.eventFired((DisplayPresentationTitleEvent) event);
        }
    }
    
}
