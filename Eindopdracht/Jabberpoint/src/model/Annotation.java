package model;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import model.drawlogic.AnnotationDrawLogic;

/**
 * The Annotation object represents a drawn annotation.
 * @author Tim
 */
public class Annotation {
    
    /**
     * The points that outline the annotation.
     */
    private List<Point> points;
    
    /**
     * The color of the lines that represent the annotation.
     */
    private Color lineColor;
    
    /**
     * The thickness of the lines that represent the annotation.
     */
    private int lineThickness;

    /**
     * Initialize the Annotation object.
     * @param points The points that outline the annotation.
     * @param lineColor The color of the lines that represent the annotation.
     * @param lineThickness The thickness of the lines that represent the annotation.
     */
    public Annotation(List<Point> points, Color lineColor, int lineThickness) {
        this.points = points;
        this.lineColor = lineColor;
        this.lineThickness = lineThickness;
    }

    /**
     * Retrieve the points that outline the annotation.
     * @return The points that outline the annotation.
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Retrieve the color of the lines that represent the annotation.
     * @return The color of the lines that represent the annotation.
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Retrieve the thickness of the lines that represent the annotation.
     * @return The thickness of the lines that represent the annotation.
     */
    public int getLineThickness() {
        return lineThickness;
    }
    
    /**
     * Create the draw logic that can be used to draw the annotation.
     * @return The draw logic that can be used to draw the annotation.
     */
    public AnnotationDrawLogic createDrawLogic() {
        return new AnnotationDrawLogic(this);
    }
}
