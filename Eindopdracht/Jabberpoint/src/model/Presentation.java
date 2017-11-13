/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Tim
 */
public class Presentation {
    
    private String title;
    
    private int currentSlideNumber;
    
    private List<Slide> slides;

    public Presentation() {
        this.slides = new ArrayList();
        this.currentSlideNumber = 1;
    }
    
    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }

    public String getTitle() {
        return title;
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Iterator<Slide> getSlides() {
        return slides.iterator();
    }
    
    public int getNumberOfSlides() {
        return slides.size();
    }
    
    public void setNextSlide() {
        if(this.currentSlideNumber < this.getNumberOfSlides()) {
            this.setCurrentSlideNumber(this.currentSlideNumber + 1);
        }
    }
    
    public void setPreviousSlide() {
        if(this.currentSlideNumber > 1) {
            this.setCurrentSlideNumber(this.currentSlideNumber - 1);
        }
    }
    
    public void setSlide(int slideNumber) {
        if(slideNumber >= 1 && slideNumber <= this.getNumberOfSlides()) {
            this.setCurrentSlideNumber(slideNumber);
        }
    }
    
    public void setCurrentSlideNumber(int currentSlideNumber) {
        this.currentSlideNumber = currentSlideNumber;
    }
    
    public Slide getCurrentSlide() {
        if(this.getNumberOfSlides() > 0) {
            return this.slides.get(this.currentSlideNumber - 1);
        }
        else {
            return null;
        }
    }
}
