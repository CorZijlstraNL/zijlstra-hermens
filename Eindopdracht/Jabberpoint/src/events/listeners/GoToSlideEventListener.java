package events.listeners;

import events.events.GoToSlideEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired GoToSlideEvent events.
 * @author Tim
 */
public interface GoToSlideEventListener extends EventListener {
    /**
     * Execute operations based on the received GoToSlideEvent event.
     * @param event The received GoToSlideEvent event.
     */
    public void eventFired(GoToSlideEvent event);
}
