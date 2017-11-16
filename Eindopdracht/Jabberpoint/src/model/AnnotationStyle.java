package model;

import java.awt.Color;

/**
 * The AnnotationStyle object represents the style that is applied to newly created annotations.
 * @author Tim
 */
public class AnnotationStyle {
    
    /**
     * The color of the lines that represent the annotation.
     */
    private Color lineColor;
    
    /**
     * The thickness of the lines that represent the annotation.
     */
    private int lineThickness;

    /**
     * Initialize the AnnotationStyle object.
     * @param initialLineColor The initial color of the lines that represent the annotation.
     * @param initialLineThickness The initial thickness of the lines that represent the annotation.
     */
    public AnnotationStyle(Color initialLineColor, int initialLineThickness) {
        this.lineColor = initialLineColor;
        this.lineThickness = initialLineThickness;
    }

    /**
     * Retrieve the color of the lines that represent the annotation.
     * @return The color of the lines that represent the annotation.
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * Set the color of the lines that represent the annotation.
     * @param lineColor The color of the lines that represent the annotation.
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * Retrieve the thickness of the lines that represent the annotation.
     * @return The thickness of the lines that represent the annotation.
     */
    public int getLineThickness() {
        return lineThickness;
    }

    /**
     * Set the thickness of the lines that represent the annotation.
     * @param lineThickness The thickness of the lines that represent the annotation.
     */
    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }
}
