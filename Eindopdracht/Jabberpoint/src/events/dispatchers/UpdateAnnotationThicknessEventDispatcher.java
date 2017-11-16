package events.dispatchers;

import events.events.UpdateAnnotationThicknessEvent;
import events.listeners.UpdateAnnotationThicknessEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class manages all the UpdateAnnotationThicknessEventListener objects and fires UpdateAnnotationThicknessEvent events.
 * @author Tim
 */
public class UpdateAnnotationThicknessEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateAnnotationThicknessEventListener listener_ = (UpdateAnnotationThicknessEventListener) listener;
            listener_.eventFired((UpdateAnnotationThicknessEvent) event);
        }
    }
    
}
