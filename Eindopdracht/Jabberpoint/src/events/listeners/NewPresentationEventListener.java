package events.listeners;

import events.events.NewPresentationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired NewPresentationEvent events.
 * @author Tim
 */
public interface NewPresentationEventListener extends EventListener {
    /**
     * Execute operations based on the received NewPresentationEvent event.
     * @param event The received NewPresentationEvent event.
     */
    public void eventFired(NewPresentationEvent event);
}
