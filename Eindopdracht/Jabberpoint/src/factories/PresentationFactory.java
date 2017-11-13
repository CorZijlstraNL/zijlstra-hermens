/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Tim
 */
public class PresentationFactory {
    
    public static Presentation createPresentation() {
        return new Presentation();
    }
    
    public static Slide createSlide(String title) {
        return new Slide(title);
    }
    
    public static SlideItem createTextItem(int nestingLevel, String text) {
        return new TextItem(nestingLevel, text);
    }
    
    public static SlideItem createImageItem(int nestingLevel, String imageName) {
        return new ImageItem(nestingLevel, imageName);
    }
    
    public static Annotation createAnnotation(List<Point> points, Color lineColor, int lineThickness) {
        return new Annotation(points, lineColor, lineThickness);
    }
}
