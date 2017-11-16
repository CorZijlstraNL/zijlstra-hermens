package events.listeners;

import events.events.PreviousSlideEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired PreviousSlideEvent events.
 * @author Tim
 */
public interface PreviousSlideEventListener extends EventListener {
    /**
     * Execute operations based on the received PreviousSlideEvent event.
     * @param event The received PreviousSlideEvent event.
     */
    public void eventFired(PreviousSlideEvent event);
}
