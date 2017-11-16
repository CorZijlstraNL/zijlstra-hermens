package factories;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import model.Annotation;
import model.ImageItem;
import model.Presentation;
import model.Slide;
import model.SlideItem;
import model.TextItem;

/**
 * This factory creates the presentation-related components.
 * @author Tim
 */
public class PresentationFactory {
    
    /**
     * Create a new Presentation object.
     * @return A new Presentation object.
     */
    public static Presentation createPresentation() {
        return new Presentation();
    }
    
    /**
     * Create a new Slide object.
     * @param title The title of the slide.
     * @return A new Slide object.
     */
    public static Slide createSlide(String title) {
        return new Slide(title);
    }
    
    /**
     * Create a new TextItem object.
     * @param nestingLevel The nesting level of the object.
     * @param text The text of the object.
     * @return A new TextItem object.
     */
    public static SlideItem createTextItem(int nestingLevel, String text) {
        return new TextItem(nestingLevel, text);
    }
    
    /**
     * Create a new ImageItem object.
     * @param nestingLevel The nesting level of the object.
     * @param imageName The image name of the object.
     * @return A new ImageItem object.
     */
    public static SlideItem createImageItem(int nestingLevel, String imageName) {
        return new ImageItem(nestingLevel, imageName);
    }
    
    /**
     * Create a new Annotation object.
     * @param points The points that outline the annotation.
     * @param lineColor The color of the annotation.
     * @param lineThickness The thickness of the annotation.
     * @return A new Annotation object.
     */
    public static Annotation createAnnotation(List<Point> points, Color lineColor, int lineThickness) {
        return new Annotation(points, lineColor, lineThickness);
    }
}
