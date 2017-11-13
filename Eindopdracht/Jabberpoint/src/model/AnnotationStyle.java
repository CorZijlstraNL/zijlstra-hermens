/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Tim
 */
public class AnnotationStyle {
    
    private Color lineColor;
    private int lineThickness;

    public AnnotationStyle(Color initialLineColor, int initialLineThickness) {
        this.lineColor = initialLineColor;
        this.lineThickness = initialLineThickness;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public int getLineThickness() {
        return lineThickness;
    }

    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }
}
