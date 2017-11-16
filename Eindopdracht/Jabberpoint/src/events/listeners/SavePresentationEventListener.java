package events.listeners;

import events.events.SavePresentationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired SavePresentationEvent events.
 * @author Tim
 */
public interface SavePresentationEventListener extends EventListener {
    /**
     * Execute operations based on the received SavePresentationEvent event.
     * @param event The received SavePresentationEvent event.
     */
    public void eventFired(SavePresentationEvent event);
}
