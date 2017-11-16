package factories;

import java.awt.Color;
import model.AnnotationStyle;
import model.SlideStyleCollection;

/**
 * This factory creates the objects that are specifically needed by the Model.
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
    private static final int INITIAL_ANNOTATION_LINE_THICKNESS = 2;
    
    /**
     * Create the AnnotationStyle object with the initial values.
     * @return The AnnotationStyle object with the initial values.
     */
    public static AnnotationStyle createAnnotationStyle() {
        return new AnnotationStyle(INITIAL_ANNOTATION_LINE_COLOR, INITIAL_ANNOTATION_LINE_THICKNESS);
    }
    
    /**
     * Create the SlideStyleCollection object.
     * @return The SlideStyleCollection object.
     */
    public static SlideStyleCollection createSlideStyleCollection() {
        return new SlideStyleCollection();
    }
}
