package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the DisplayPresentationTitleEvent event.
 * @author Tim
 */
public class DisplayPresentationTitleEvent extends EventObject {
    
    /**
     * The presentation title.
     */
    private String presentationTitle;

    /**
     * Initialize the DisplayPresentationTitleEvent class.
     * @param source The source object where the event initially occurred on.
     * @param presentationTitle The presentation title.
     */
    public DisplayPresentationTitleEvent(Object source, String presentationTitle) {
        super(source);
        this.presentationTitle = presentationTitle;
    }

    /**
     * Retrieve the presentation title.
     * @return The presentation title.
     */
    public String getPresentationTitle() {
        return presentationTitle;
    }
}
