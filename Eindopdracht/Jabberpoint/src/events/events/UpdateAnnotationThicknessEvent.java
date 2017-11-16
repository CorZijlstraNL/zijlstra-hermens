package events.events;

import java.util.EventObject;

/**
 * This class contains the information of the UpdateAnnotationThicknessEvent event.
 * @author Tim
 */
public class UpdateAnnotationThicknessEvent extends EventObject {
    
    /**
     * The annotation thickness.
     */
    private int annotationThickness;
    
    /**
     * Initialize the UpdateAnnotationThicknessEvent class.
     * @param source The source object where the event initially occurred on.
     * @param annotationThickness The annotation thickness.
     */
    public UpdateAnnotationThicknessEvent(Object source, int annotationThickness) {
        super(source);
        this.annotationThickness = annotationThickness;
    }

    /**
     * Retrieve the annotation thickness.
     * @return The annotation thickness.
     */
    public int getAnnotationThickness() {
        return annotationThickness;
    }
}
