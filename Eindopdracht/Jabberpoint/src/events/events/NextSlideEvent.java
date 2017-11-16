package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the NextSlideEvent event.
 * @author Tim
 */
public class NextSlideEvent extends EventObject {
    
    /**
     * Initialize the NextSlideEvent class.
     * @param source The source object where the event initially occurred on.
     */
    public NextSlideEvent(Object source) {
        super(source);
    }
}
