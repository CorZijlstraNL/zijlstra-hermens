package events.events;

import java.util.EventObject;
import model.Annotation;

/**
 * This class contains the information of the DisplayDrawnAnnotationEvent event.
 * @author Tim
 */
public class DisplayDrawnAnnotationEvent extends EventObject {
    
    /**
     * The drawn annotation.
     */
    private Annotation annotation;
    
    /**
     * Initialize the DisplayDrawnAnnotationEvent class.
     * @param source The source object where the event initially occurred on.
     * @param annotation The drawn annotation.
     */
    public DisplayDrawnAnnotationEvent(Object source, Annotation annotation) {
        super(source);
        this.annotation = annotation;
    }

    /**
     * Retrieve the drawn annotation.
     * @return The drawn annotation.
     */
    public Annotation getAnnotation() {
        return annotation;
    }
}
