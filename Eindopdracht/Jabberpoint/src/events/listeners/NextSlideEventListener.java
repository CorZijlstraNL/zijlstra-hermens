package events.listeners;

import events.events.NextSlideEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired NextSlideEvent events.
 * @author Tim
 */
public interface NextSlideEventListener extends EventListener {
    /**
     * Execute operations based on the received NextSlideEvent event.
     * @param event The received NextSlideEvent event.
     */
    public void eventFired(NextSlideEvent event);
}
