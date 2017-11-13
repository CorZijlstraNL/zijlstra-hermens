/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.awt.Color;
import model.AnnotationStyle;
import model.SlideStyleCollection;

/**
 *
 * @author Tim
 */
public class ModelFactory {
    
    /**
     * The initial color for drawing the annotation.
     */
    private static final Color INITIAL_ANNOTATION_LINE_COLOR = Color.black;
    
    /**
     * The initial line thickness for drawing the annotation.
     */
    private static final int INITIAL_ANNOTATION_LINE_THICKNESS = 3;
    
    public static AnnotationStyle createAnnotationStyle() {
        return new AnnotationStyle(INITIAL_ANNOTATION_LINE_COLOR, INITIAL_ANNOTATION_LINE_THICKNESS);
    }
    
    public static SlideStyleCollection createSlideStyleCollection() {
        return new SlideStyleCollection();
    }
}
