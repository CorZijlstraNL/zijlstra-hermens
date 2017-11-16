package events.listeners;

import events.events.DisplayDrawnAnnotationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired DisplayDrawnAnnotationEvent events.
 * @author Tim
 */
public interface DisplayDrawnAnnotationEventListener extends EventListener {
    /**
     * Execute operations based on the received DisplayDrawnAnnotationEvent event.
     * @param event The received DisplayDrawnAnnotationEvent event.
     */
    public void eventFired(DisplayDrawnAnnotationEvent event);
}
