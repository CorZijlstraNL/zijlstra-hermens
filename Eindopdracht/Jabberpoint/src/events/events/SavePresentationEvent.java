package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the SavePresentationEvent event.
 * @author Tim
 */
public class SavePresentationEvent extends EventObject {
    
    /**
     * The location that is used to save the presentation.
     */
    private String saveLocation;
    
    /**
     * Initialize the SavePresentationEvent class.
     * @param source The source object where the event initially occurred on.
     * @param saveLocation The location that is used to save the presentation.
     */
    public SavePresentationEvent(Object source, String saveLocation) {
        super(source);
        this.saveLocation = saveLocation;
    }

    /**
     * Retrieve the location that is used to save the presentation.
     * @return The location that is used to save the presentation.
     */
    public String getSaveLocation() {
        return saveLocation;
    }
}
