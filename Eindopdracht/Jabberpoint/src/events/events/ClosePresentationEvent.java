package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the ClosePresentationEvent event.
 * @author Tim
 */
public class ClosePresentationEvent extends EventObject {
    
    /**
     * Initialize the ClosePresentationEvent class.
     * @param source The source object where the event initially occurred on.
     */
    public ClosePresentationEvent(Object source) {
        super(source);
    }
    
}
