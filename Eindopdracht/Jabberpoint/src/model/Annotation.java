/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import model.drawlogic.AnnotationDrawLogic;

/**
 *
 * @author Tim
 */
public class Annotation {
    
    private List<Point> points;
    private Color lineColor;
    private int lineThickness;

    public Annotation(List<Point> points, Color lineColor, int lineThickness) {
        this.points = points;
        this.lineColor = lineColor;
        this.lineThickness = lineThickness;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public int getLineThickness() {
        return lineThickness;
    }
    
    public AnnotationDrawLogic createDrawLogic() {
        return new AnnotationDrawLogic(this);
    }
}
