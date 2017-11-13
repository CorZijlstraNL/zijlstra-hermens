/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public class SlideStyleCollection {
    
    private List<SlideStyle> slideStyles;

    public SlideStyleCollection() {
        this.slideStyles = new ArrayList();
        this.setDefaultStyles();
    }
    
    public void addSlideStyle(SlideStyle style) {
        this.slideStyles.add(style);
    }
    
    public SlideStyle getSlideStyle(int nestingLevel) {
        return this.slideStyles.get(nestingLevel);
    }
    
    public void setSlideStyle(int nestingLevel, SlideStyle style) {
        this.slideStyles.set(nestingLevel, style);
    }
    
    private void setDefaultStyles() {
        this.addSlideStyle(new SlideStyle(Color.red, 20, 0, 48)); // style for nestingLevel 0
        this.addSlideStyle(new SlideStyle(Color.blue, 10, 20, 40)); // style for nestingLevel 1
        this.addSlideStyle(new SlideStyle(Color.black, 10, 50, 36)); // style for nestingLevel 2
        this.addSlideStyle(new SlideStyle(Color.black, 10, 70, 30)); // style for nestingLevel 3
        this.addSlideStyle(new SlideStyle(Color.black, 10, 90, 24)); // style for nestingLevel 4
    }
}
