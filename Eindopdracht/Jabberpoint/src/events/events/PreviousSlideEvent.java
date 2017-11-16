package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the PreviousSlideEvent event.
 * @author Tim
 */
public class PreviousSlideEvent extends EventObject {
    
    /**
     * Initialize the PreviousSlideEvent class.
     * @param source The source object where the event initially occurred on.
     */
    public PreviousSlideEvent(Object source) {
        super(source);
    }
}
