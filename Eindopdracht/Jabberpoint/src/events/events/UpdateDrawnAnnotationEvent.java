package events.events;

import java.awt.Point;
import java.util.EventObject;
import java.util.List;

/**
 * This class contains the information of the UpdateDrawnAnnotationEvent event.
 * @author Tim
 */
public class UpdateDrawnAnnotationEvent extends EventObject {
    
    /**
     * The annotation points.
     */
    private List<Point> annotationPoints;
    
    /**
     * Initialize the UpdateDrawnAnnotationEvent class.
     * @param source The source object where the event initially occurred on.
     * @param annotationPoints The annotation points.
     */
    public UpdateDrawnAnnotationEvent(Object source, List<Point> annotationPoints) {
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
