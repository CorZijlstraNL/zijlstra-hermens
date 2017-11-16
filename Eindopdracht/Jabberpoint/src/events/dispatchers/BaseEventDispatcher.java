package events.dispatchers;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

/**
 * This class manages all the EventListener objects and fires EventObject events.
 * @author Tim
 */
public abstract class BaseEventDispatcher {
    
    /**
     * The list of EventListener objects that are added to this dispatcher class.
     */
    protected List<EventListener> listenerList = new ArrayList();

    /**
     * Add a EventListener object to the list of EventListener objects.
     * @param listener The object that wants to listen to the events dispatched by this class.
     */
    public void addListener(EventListener listener) {
        listenerList.add(listener);
    }
    
    /**
     * Remove a EventListener object from the list of EventListener objects.
     * @param listener The object that wants to stop listening to the events dispatched by this class.
     */
    public void removeListener(EventListener listener) {
        listenerList.remove(listener);
    }

    /**
     * Fire the event.
     * @param event The event to fire.
     */
    public abstract void fire(EventObject event);
}
