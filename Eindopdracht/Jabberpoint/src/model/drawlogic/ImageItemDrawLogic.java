/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drawlogic;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import model.ImageItem;
import model.SlideStyle;

/**
 *
 * @author Tim
 */
public class ImageItemDrawLogic implements SlideItemDrawLogic {

    private ImageItem imageItem;
    
    public ImageItemDrawLogic(ImageItem imageItem) {
        this.imageItem = imageItem;
    }

    @Override
    public void draw(int slideWidth, Graphics graphics, int posX, int posY, float scale, ImageObserver observer, SlideStyle slideStyle) {
        int width = posX + (int) (slideStyle.getIndent() * scale);
        int height = posY + (int) (slideStyle.getLeading() * scale);
        BufferedImage image = this.imageItem.getImage();
        graphics.drawImage(image, width, height, (int)(image.getWidth(observer)*scale),
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
