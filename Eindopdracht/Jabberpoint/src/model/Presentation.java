package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Presentation object represents the presentation.
 * @author Tim
 */
public class Presentation {
    
    /**
     * The title of the presentation.
     */
    private String title;
    
    /**
     * The current slide number.
     */
    private int currentSlideNumber;
    
    /**
     * The collection of slides that are contained in this presentation.
     */
    private List<Slide> slides;

    /**
     * Initialize the Presentation object.
     */
    public Presentation() {
        // Initialize the default collection of slides and current slide number
        this.slides = new ArrayList();
        this.currentSlideNumber = 1;
    }
    
    /**
     * Add a slide to the presentation.
     * @param slide The slide to add.
     */
    public void addSlide(Slide slide) {
        this.slides.add(slide);
    }

    /**
     * Retrieve the title of the presentation.
     * @return The title of the presentation.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieve the current slide number.
     * @return The current slide number.
     */
    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    /**
     * Set the title of the presentation.
     * @param title The title of the presentation.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieve the slides contained in this presentation.
     * @return The slides contained in this presentation.
     */
    public Iterator<Slide> getSlides() {
        return slides.iterator();
    }
    
    /**
     * Retrieve the number of slides contained in this presentation.
     * @return The number of slides contained in this presentation.
     */
    public int getNumberOfSlides() {
        return slides.size();
    }
    
    /**
     * Set the next slide as the current slide.
     */
    public void setNextSlide() {
        if(this.currentSlideNumber < this.getNumberOfSlides()) {
            this.setCurrentSlideNumber(this.currentSlideNumber + 1);
        }
    }
    
    /**
     * Set the previous slide as the current slide.
     */
    public void setPreviousSlide() {
        if(this.currentSlideNumber > 1) {
            this.setCurrentSlideNumber(this.currentSlideNumber - 1);
        }
    }
    
    /**
     * Set the slide that corresponds to the given slide number as the current slide.
     * @param slideNumber The slide number of the slide that needs to become the current slide.
     */
    public void setSlide(int slideNumber) {
        if(slideNumber >= 1 && slideNumber <= this.getNumberOfSlides()) {
            this.setCurrentSlideNumber(slideNumber);
        }
    }
    
    /**
     * Set the current slide number.
     * @param currentSlideNumber The current slide number.
     */
    private void setCurrentSlideNumber(int currentSlideNumber) {
        this.currentSlideNumber = currentSlideNumber;
    }
    
    /**
     * Retrieve the current slide of the presentation.
     * @return The current slide of the presentation.
     */
    public Slide getCurrentSlide() {
        if(this.getNumberOfSlides() > 0) {
            return this.slides.get(this.currentSlideNumber - 1);
        }
        else {
            return null;
        }
    }
}
