package events.listeners;

import events.events.CreateDrawnAnnotationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired CreateDrawnAnnotationEvent events.
 * @author Tim
 */
public interface CreateDrawnAnnotationEventListener extends EventListener {
    /**
     * Execute operations based on the received CreateDrawnAnnotationEvent event.
     * @param event The received CreateDrawnAnnotationEvent event.
     */
    public void eventFired(CreateDrawnAnnotationEvent event);
}
