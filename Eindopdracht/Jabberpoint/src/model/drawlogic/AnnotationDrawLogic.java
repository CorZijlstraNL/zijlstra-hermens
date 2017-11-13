/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drawlogic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import model.Annotation;

/**
 *
 * @author Tim
 */
public class AnnotationDrawLogic {

    private Annotation annotation;
    
    public AnnotationDrawLogic(Annotation annotation) {
        this.annotation = annotation;
    }
    
    /**
     * Draw the annotation.
     * @param graphics 
     */
    public void draw(Graphics graphics) {
        // Set color
        graphics.setColor(this.annotation.getLineColor());
        
        // Get Graphics2D to be able to draw line thickness.
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        // Set line style with a rounded cap and join
        graphics2D.setStroke(new BasicStroke(this.annotation.getLineThickness(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        List<Point> points = this.annotation.getPoints();
        int numberOfPoints = points.size();
        
        // If there is only 1 point, draw a point.
        if(numberOfPoints == 1) {
            Point point = points.get(0);
            this.drawLine(graphics, point, point);
        }
        // If there is more than 1 point, connect the points and draw them.
        else if (numberOfPoints > 1) {
            Iterator<Point> iteratorPoints = points.iterator();
            Point sourcePoint = iteratorPoints.next();
            
            while(iteratorPoints.hasNext()) {
                Point targetPoint = iteratorPoints.next();
                this.drawLine(graphics, sourcePoint, targetPoint);
                sourcePoint = targetPoint;
            }
        }
    }
    
    /**
     * Draws a line between the source point and target point.
     * @param graphics
     * @param source
     * @param target 
     */
    private void drawLine(Graphics graphics, Point source, Point target) {
        graphics.drawLine(source.x, source.y, target.x, target.y);
    }
}
