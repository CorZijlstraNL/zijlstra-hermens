package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the LoadPresentationEvent event.
 * @author Tim
 */
public class LoadPresentationEvent extends EventObject {
    
    /**
     * The path pointing to a presentation file.
     */
    private String presentationPath;
    
    /**
     * Initialize the LoadPresentationEvent class.
     * @param source The source object where the event initially occurred on.
     * @param presentationPath The path pointing to a presentation file.
     */
    public LoadPresentationEvent(Object source, String presentationPath) {
        super(source);
        this.presentationPath = presentationPath;
    }

    /**
     * Retrieve the path pointing to a presentation file.
     * @return The path pointing to a presentation file.
     */
    public String getPresentationPath() {
        return presentationPath;
    }
}
