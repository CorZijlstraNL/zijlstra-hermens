package events.listeners;

import events.events.UpdateAnnotationThicknessEvent;
import java.util.EventListener;

/**
 * This listener interface listens to fired UpdateAnnotationThicknessEvent events.
 * @author Tim
 */
public interface UpdateAnnotationThicknessEventListener extends EventListener {
    /**
     * Execute operations based on the received UpdateAnnotationThicknessEvent event.
     * @param event The received UpdateAnnotationThicknessEvent event.
     */
    public void eventFired(UpdateAnnotationThicknessEvent event);
}
