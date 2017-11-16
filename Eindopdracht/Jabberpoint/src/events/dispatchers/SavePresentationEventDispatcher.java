package events.dispatchers;

import events.events.SavePresentationEvent;
import events.listeners.SavePresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the SavePresentationEventListener objects and fires SavePresentationEvent events.
 * @author Tim
 */
public class SavePresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            SavePresentationEventListener listener_ = (SavePresentationEventListener) listener;
            listener_.eventFired((SavePresentationEvent) event);
        }
    }
    
}
