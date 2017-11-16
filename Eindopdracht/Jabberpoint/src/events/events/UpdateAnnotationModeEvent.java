package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the UpdateAnnotationModeEvent event.
 * @author Tim
 */
public class UpdateAnnotationModeEvent extends EventObject {
    
    /**
     * Initialize the UpdateAnnotationModeEvent class.
     * @param source The source object where the event initially occurred on.
     */
    public UpdateAnnotationModeEvent(Object source) {
        super(source);
    }
}
