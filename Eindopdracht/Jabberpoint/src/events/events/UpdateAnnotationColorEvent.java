package events.events;

import java.awt.Color;
import java.util.EventObject;

/**
 * This class contains the information of the UpdateAnnotationColorEvent event.
 * @author Tim
 */
public class UpdateAnnotationColorEvent extends EventObject {
    
    /**
     * The annotation color.
     */
    private Color annotationColor;
    
    /**
     * Initialize the UpdateAnnotationColorEvent class.
     * @param source The source object where the event initially occurred on.
     * @param annotationColor The annotation color.
     */
    public UpdateAnnotationColorEvent(Object source, Color annotationColor) {
        super(source);
        this.annotationColor = annotationColor;
    }

    /**
     * Retrieve the annotation color.
     * @return The annotation color.
     */
    public Color getAnnotationColor() {
        return annotationColor;
    }
}
