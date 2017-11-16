package model.drawlogic;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import model.SlideStyle;

/**
 * The SlideItemDrawLogic interface contains the required draw logic operations to be able to draw
 * the SlideItem objects.
 * @author Tim
 */
public interface SlideItemDrawLogic {
    /**
     * Draw the SlideItem object.
     * @param slideWidth The width of the slide.
     * @param graphics The graphics object of the component to draw the SlideItem object on.
     * @param posX The X-position where the SlideItem object needs to be drawn.
     * @param posY The Y-position where the SlideItem object needs to be drawn.
     * @param scale The scale to use to resize the SlideItem object.
     * @param observer The component to draw the SlideItem object on.
     * @param slideStyle The style to apply on the SlideItem object.
     */
    public void draw(int slideWidth, Graphics graphics, int posX, int posY, float scale, ImageObserver observer, SlideStyle slideStyle);
    
    /**
     * Determine the area needed to draw the SlideItem object.
     * @param slideWidth The width of the slide.
     * @param graphics The graphics object of the component to draw the SlideItem object on.
     * @param observer The component to draw the SlideItem object on.
     * @param scale The scale to use to resize the SlideItem object.
     * @param slideStyle The style to apply on the SlideItem object.
     * @return The area needed to draw the SlideItem object.
     */
    public Rectangle getBoundingBox(int slideWidth, Graphics graphics, ImageObserver observer, float scale, SlideStyle slideStyle);
}
