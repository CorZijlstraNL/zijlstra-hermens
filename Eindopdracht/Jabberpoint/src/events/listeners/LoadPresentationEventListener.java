package events.listeners;

import events.events.LoadPresentationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired LoadPresentationEvent events.
 * @author Tim
 */
public interface LoadPresentationEventListener extends EventListener {
    /**
     * Execute operations based on the received LoadPresentationEvent event.
     * @param event The received LoadPresentationEvent event.
     */
    public void eventFired(LoadPresentationEvent event);
}
