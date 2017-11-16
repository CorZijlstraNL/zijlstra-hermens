package events.listeners;

import events.events.ClosePresentationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired ClosePresentationEvent events.
 * @author Tim
 */
public interface ClosePresentationEventListener extends EventListener {
    /**
     * Execute operations based on the received ClosePresentationEvent event.
     * @param event The received ClosePresentationEvent event.
     */
    public void eventFired(ClosePresentationEvent event);
}
