/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.drawlogic;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import model.SlideStyle;

/**
 *
 * @author Tim
 */
public interface SlideItemDrawLogic {
    public void draw(int slideWidth, Graphics graphics, int posX, int posY, float scale, ImageObserver observer, SlideStyle slideStyle);
    
    public Rectangle getBoundingBox(int slideWidth, Graphics graphics, ImageObserver observer, float scale, SlideStyle slideStyle);
}
