package events.events;

import java.util.EventObject;
import model.Slide;
import model.SlideStyleCollection;

/**
 * This class contains the information of the DisplayCurrentSlideEvent event.
 * @author Tim
 */
public class DisplayCurrentSlideEvent extends EventObject {
    
    /**
     * The current slide number of a presentation.
     */
    private int currentSlideNumber;
    
    /**
     * The total amount of slides of a presentation.
     */
    private int totalSlides;
    
    /**
     * The current slide of a presentation.
     */
    private Slide currentSlide;
    
    /**
     * The style to use to display the slide.
     */
    private SlideStyleCollection slideStyleCollection;
    
    /**
     * Initialize the DisplayCurrentSlideEvent class.
     * @param source The source object where the event initially occurred on.
     * @param currentSlideNumber The current slide number of a presentation.
     * @param totalSlides  The total amount of slides of a presentation.
     * @param currentSlide The current slide of a presentation.
     * @param slideStyleCollection The style to use to display the slide.
     */
    public DisplayCurrentSlideEvent(Object source, int currentSlideNumber, int totalSlides, Slide currentSlide, SlideStyleCollection slideStyleCollection) {
        super(source);
        this.currentSlideNumber = currentSlideNumber;
        this.totalSlides = totalSlides;
        this.currentSlide = currentSlide;
        this.slideStyleCollection = slideStyleCollection;
    }

    /**
     * Retrieve the current slide number of a presentation.
     * @return The current slide number of a presentation.
     */
    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }

    /**
     * Retrieve the total amount of slides of a presentation.
     * @return The total amount of slides of a presentation.
     */
    public int getTotalSlides() {
        return totalSlides;
    }

    /**
     * Retrieve the current slide of a presentation.
     * @return The current slide of a presentation.
     */
    public Slide getCurrentSlide() {
        return currentSlide;
    }

    /**
     * Retrieve the style to use to display the slide.
     * @return The style to use to display the slide.
     */
    public SlideStyleCollection getSlideStyleCollection() {
        return slideStyleCollection;
    }
}
