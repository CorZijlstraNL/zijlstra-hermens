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
 * The SlideDrawLogic object contains the draw logic to be able to draw the Slide objects.
 * @author Tim
 */
public class SlideDrawLogic {

    // Slide width and height
    /**
     * The Slide reference width.
     */
    private static final int WIDTH = 1200;
    
    /**
     * The Slide reference height.
     */
    private static final int HEIGHT = 800;
    
    /**
     * The Slide object to draw.
     */
    private Slide slide;
    
    /**
     * Initialize the SlideDrawLogic object.
     * @param slide The Slide object to draw.
     */
    public SlideDrawLogic(Slide slide) {
        this.slide = slide;
    }
    
    /**
     * Draw the Slide object.
     * @param graphics The graphics object of the component to draw the Slide object on.
     * @param drawArea The area the Slide object needs to be drawn in.
     * @param observer The component to draw the Slide object on.
     * @param styles The collection of styles that are used to apply a style on SlideItem elements.
     */
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
    
    /**
     * Draw the SlideItem object.
     * @param slideItem The SlideItem object to draw.
     * @param graphics The graphics object of the component to draw the SlideItem object on.
     * @param drawArea The area the SlideItem object needs to be drawn in.
     * @param posY The Y-position where the SlideItem object needs to be drawn.
     * @param scale The scale to use to resize the SlideItem object.
     * @param observer The component to draw the SlideItem object on.
     * @param styles The collection of styles that are used to apply a style on SlideItem elements.
     * @return The Y-position where the next SlideItem object needs to be drawn.
     */
    private int drawSlideItem(SlideItem slideItem, Graphics graphics, Rectangle drawArea, int posY, float scale, 
            ImageObserver observer, SlideStyleCollection styles) {
        SlideStyle style = styles.getSlideStyle(slideItem.getNestingLevel());
        
        SlideItemDrawLogic slideItemDrawLogic = slideItem.createDrawLogic();
        slideItemDrawLogic.draw(WIDTH, graphics, drawArea.x, posY, scale, observer, style);
        
        posY += slideItemDrawLogic.getBoundingBox(WIDTH, graphics, observer, scale, style).height;
        
        return posY;
    }
    
    /**
     * Determine the scale that needs to be used to resize the SlideItem objects.
     * @param drawArea The area the SlideItem object needs to be drawn in.
     * @return The scale that needs to be used to resize the SlideItem objects.
     */
    private float getScale(Rectangle drawArea) {
        return Math.min(((float)drawArea.width) / ((float)WIDTH), ((float)drawArea.height) / ((float)HEIGHT));
    }
}
