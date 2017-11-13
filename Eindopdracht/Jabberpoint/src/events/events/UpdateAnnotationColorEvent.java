/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.events;

import java.awt.Color;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class UpdateAnnotationColorEvent extends EventObject {
    
    private Color annotationColor;
    
    public UpdateAnnotationColorEvent(Object source, Color annotationColor) {
        super(source);
        this.annotationColor = annotationColor;
    }

    public Color getAnnotationColor() {
        return annotationColor;
    }
}
