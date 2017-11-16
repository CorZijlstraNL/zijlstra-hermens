package events.listeners;

import events.events.DisplayPresentationTitleEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired DisplayPresentationTitleEvent events.
 * @author Tim
 */
public interface DisplayPresentationTitleEventListener extends EventListener {
    /**
     * Execute operations based on the received DisplayPresentationTitleEvent event.
     * @param event The received DisplayPresentationTitleEvent event.
     */
    public void eventFired(DisplayPresentationTitleEvent event);
}
