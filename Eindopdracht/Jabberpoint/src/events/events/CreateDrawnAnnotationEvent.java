package events.events;

import java.awt.Point;
import java.util.EventObject;
import java.util.List;

/**
 * This class contains the information of the CreateDrawnAnnotationEvent event.
 * @author Tim
 */
public class CreateDrawnAnnotationEvent extends EventObject {
    
    /**
     * The list of annotation points.
     */
    private List<Point> annotationPoints;
    
    /**
     * Initializes the CreateDrawnAnnotationEvent class.
     * @param source The source object where the event initially occurred on.
     * @param annotationPoints The list of annotation points.
     */
    public CreateDrawnAnnotationEvent(Object source, List<Point> annotationPoints) {
        super(source);
        this.annotationPoints = annotationPoints;
    }

    /**
     * Retrieve the annotation points.
     * @return The annotation points.
     */
    public List<Point> getAnnotationPoints() {
        return annotationPoints;
    }
}
