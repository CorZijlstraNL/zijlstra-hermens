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
public class UpdateDrawnAnnotationEvent extends EventObject {
    
    private List<Point> annotationPoints;
    
    public UpdateDrawnAnnotationEvent(Object source, List<Point> annotationPoints) {
        super(source);
        this.annotationPoints = annotationPoints;
    }    

    public List<Point> getAnnotationPoints() {
        return annotationPoints;
    }
}
