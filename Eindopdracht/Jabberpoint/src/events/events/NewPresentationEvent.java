package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the NewPresentationEvent event.
 * @author Tim
 */
public class NewPresentationEvent extends EventObject {
    
    /**
     * Initialize the NewPresentationEvent class.
     * @param source The source object where the event initially occurred on.
     */
    public NewPresentationEvent(Object source) {
        super(source);
    }
}
