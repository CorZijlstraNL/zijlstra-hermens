package events.listeners;

import events.events.DisplayCurrentSlideEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired DisplayCurrentSlideEvent events.
 * @author Tim
 */
public interface DisplayCurrentSlideEventListener extends EventListener {
    /**
     * Execute operations based on the received DisplayCurrentSlideEvent event.
     * @param event The received DisplayCurrentSlideEvent event.
     */
    public void eventFired(DisplayCurrentSlideEvent event);
}
