/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drawlogic;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import model.Annotation;
import model.Slide;
import model.SlideItem;
import model.SlideStyle;
import model.SlideStyleCollection;

/**
 *
 * @author Tim
 */
public class SlideDrawLogic {

    // Slide width and height
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    
    private Slide slide;
    
    public SlideDrawLogic(Slide slide) {
        this.slide = slide;
    }
    
    public void draw(Graphics graphics, Rectangle drawArea, ImageObserver observer, SlideStyleCollection styles) {
        float scale = this.getScale(drawArea);
        int posY = drawArea.y;
        
        // draw the title
        SlideItem slideItem = this.slide.getTitle();
        posY = this.drawSlideItem(slideItem, graphics, drawArea, posY, scale, observer, styles);
        
        // draw the slide items
        Iterator<SlideItem> slideItems = this.slide.getSlideItems();
        while (slideItems.hasNext()) {
            slideItem = slideItems.next();
            posY = this.drawSlideItem(slideItem, graphics, drawArea, posY, scale, observer, styles);
        }
        
        // draw the annotations
        Iterator<Annotation> annotations = this.slide.getAnnotations();
        while (annotations.hasNext()) {
            Annotation annotation = annotations.next();
            annotation.createDrawLogic().draw(graphics);
        }
    }
    
    private int drawSlideItem(SlideItem slideItem, Graphics graphics, Rectangle drawArea, int posY, float scale, 
            ImageObserver observer, SlideStyleCollection styles) {
        SlideStyle style = styles.getSlideStyle(slideItem.getNestingLevel());
        
        SlideItemDrawLogic slideItemDrawLogic = slideItem.createDrawLogic();
        slideItemDrawLogic.draw(WIDTH, graphics, drawArea.x, posY, scale, observer, style);
        
        posY += slideItemDrawLogic.getBoundingBox(WIDTH, graphics, observer, scale, style).height;
        
        return posY;
    }
    
    private float getScale(Rectangle drawArea) {
        return Math.min(((float)drawArea.width) / ((float)WIDTH), ((float)drawArea.height) / ((float)HEIGHT));
    }
}
