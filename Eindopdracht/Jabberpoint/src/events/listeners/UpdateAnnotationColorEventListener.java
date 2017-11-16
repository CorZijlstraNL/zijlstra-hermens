package events.listeners;

import events.events.UpdateAnnotationColorEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired UpdateAnnotationColorEvent events.
 * @author Tim
 */
public interface UpdateAnnotationColorEventListener extends EventListener {
    /**
     * Execute operations based on the received UpdateAnnotationColorEvent event.
     * @param event The received UpdateAnnotationColorEvent event.
     */
    public void eventFired(UpdateAnnotationColorEvent event);
}
