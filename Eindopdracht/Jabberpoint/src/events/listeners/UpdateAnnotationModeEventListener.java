package events.listeners;

import events.events.UpdateAnnotationModeEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired UpdateAnnotationModeEvent events.
 * @author Tim
 */
public interface UpdateAnnotationModeEventListener extends EventListener {
    /**
     * Execute operations based on the received UpdateAnnotationModeEvent event.
     * @param event The received UpdateAnnotationModeEvent event.
     */
    public void eventFired(UpdateAnnotationModeEvent event);
}
