/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.events;

import java.util.EventObject;
import model.Annotation;

/**
 *
 * @author Tim
 */
public class DisplayDrawnAnnotationEvent extends EventObject {
    
    private Annotation annotation;
    
    public DisplayDrawnAnnotationEvent(Object source, Annotation annotation) {
        super(source);
        this.annotation = annotation;
    }

    public Annotation getAnnotation() {
        return annotation;
    }
}
