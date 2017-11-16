package model.drawlogic;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import model.ImageItem;
import model.SlideStyle;

/**
 * The ImageItemDrawLogic object contains the draw logic to be able to draw the ImageItem objects.
 * @author Tim
 */
public class ImageItemDrawLogic implements SlideItemDrawLogic {

    /**
     * The ImageItem object to draw.
     */
    private ImageItem imageItem;
    
    /**
     * Initialize the ImageItemDrawLogic object.
     * @param imageItem The ImageItem object to draw.
     */
    public ImageItemDrawLogic(ImageItem imageItem) {
        this.imageItem = imageItem;
    }

    @Override
    public void draw(int slideWidth, Graphics graphics, int posX, int posY, float scale, ImageObserver observer, SlideStyle slideStyle) {
        int x = posX + (int) (slideStyle.getIndent() * scale);
        int y = posY + (int) (slideStyle.getLeading() * scale);
        BufferedImage image = this.imageItem.getImage();
        graphics.drawImage(image, x, y, (int)(image.getWidth(observer)*scale),
                (int)(image.getHeight(observer)*scale), observer);
    }

    @Override
    public Rectangle getBoundingBox(int slideWidth, Graphics graphics, ImageObserver observer, float scale, SlideStyle slideStyle) {
        BufferedImage image = this.imageItem.getImage();
        return new Rectangle((int) (slideStyle.getIndent() * scale), 0,
				(int) (image.getWidth(observer) * scale),
				((int) (slideStyle.getLeading() * scale)) + 
				(int) (image.getHeight(observer) * scale));
    }
    
}
