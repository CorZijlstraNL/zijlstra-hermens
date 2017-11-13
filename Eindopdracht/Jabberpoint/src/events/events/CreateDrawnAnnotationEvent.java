/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.events;

import java.awt.Point;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author Tim
 */
public class CreateDrawnAnnotationEvent extends EventObject {
    
    private List<Point> annotationPoints;
    
    public CreateDrawnAnnotationEvent(Object source, List<Point> annotationPoints) {
        super(source);
        this.annotationPoints = annotationPoints;
    }

    public List<Point> getAnnotationPoints() {
        return annotationPoints;
    }
}
