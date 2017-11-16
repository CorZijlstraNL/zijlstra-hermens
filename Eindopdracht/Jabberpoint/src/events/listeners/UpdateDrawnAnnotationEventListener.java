package events.listeners;

import events.events.UpdateDrawnAnnotationEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired UpdateDrawnAnnotationEvent events.
 * @author Tim
 */
public interface UpdateDrawnAnnotationEventListener extends EventListener {
    /**
     * Execute operations based on the received UpdateDrawnAnnotationEvent event.
     * @param event The received UpdateDrawnAnnotationEvent event.
     */
    public void eventFired(UpdateDrawnAnnotationEvent event);
}
