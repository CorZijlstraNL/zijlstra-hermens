/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.events;

import java.util.EventObject;
import model.Slide;
import model.SlideStyleCollection;

/**
 *
 * @author Tim
 */
public class DisplayCurrentSlideEvent extends EventObject {
    
    private int currentSlideNumber;
    private int totalSlides;
    private Slide currentSlide;
    private SlideStyleCollection slideStyleCollection;
    
    public DisplayCurrentSlideEvent(Object source, int currentSlideNumber, int totalSlides, Slide currentSlide, SlideStyleCollection slideStyleCollection) {
        super(source);
        this.currentSlideNumber = currentSlideNumber;
        this.totalSlides = totalSlides;
        this.currentSlide = currentSlide;
        this.slideStyleCollection = slideStyleCollection;
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    public int getTotalSlides() {
        return totalSlides;
    }

    public Slide getCurrentSlide() {
        return currentSlide;
    }

    public SlideStyleCollection getSlideStyleCollection() {
        return slideStyleCollection;
    }
}
