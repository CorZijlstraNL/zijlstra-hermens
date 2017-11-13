/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.events;

import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class UpdateAnnotationThicknessEvent extends EventObject {
    
    private int annotationThickness;
    
    public UpdateAnnotationThicknessEvent(Object source, int annotationThickness) {
        super(source);
        this.annotationThickness = annotationThickness;
    }

    public int getAnnotationThickness() {
        return annotationThickness;
    }
}
