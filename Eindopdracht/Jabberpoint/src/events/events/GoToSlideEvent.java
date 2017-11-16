package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the GoToSlideEvent event.
 * @author Tim
 */
public class GoToSlideEvent extends EventObject {
    
    /**
     * The slide number to navigate to.
     */
    private int slideNumber;
    
    /**
     * Initialize the GoToSlideEvent class.
     * @param source The source object where the event initially occurred on.
     * @param slideNumber The slide number to navigate to.
     */
    public GoToSlideEvent(Object source, int slideNumber) {
        super(source);
        this.slideNumber = slideNumber;
    }

    /**
     * Retrieve the slide number to navigate to.
     * @return The slide number to navigate to.
     */
    public int getSlideNumber() {
        return slideNumber;
    }
}
