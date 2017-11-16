package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.drawlogic.SlideDrawLogic;

/**
 * The Slide object represents a slide of the presentation.
 * @author Tim
 */
public class Slide {
    
    /**
     * The collection of annotations that are present on this slide.
     */
    private List<Annotation> annotations;
    
    /**
     * The title of the slide in the form of a SlideItem object.
     */
    private SlideItem title;
    
    /**
     * The collection of elements that are present on the slide.
     */
    private List<SlideItem> slideItems;

    /**
     * Initialize the Slide object.
     * @param title The title of the slide.
     */
    public Slide(String title) {
        this.annotations = new ArrayList();
        this.slideItems = new ArrayList();
        
        // Create the title as a TextItem object with nesting level 0 which is used for titles.
        this.title = new TextItem(0, title);
    }

    /**
     * Retrieve the collection of annotations that are present on this slide.
     * @return The collection of annotations that are present on this slide.
     */
    public Iterator<Annotation> getAnnotations() {
        return annotations.iterator();
    }

    /**
     * Retrieve the title of the slide in the form of a SlideItem object.
     * @return The title of the slide in the form of a SlideItem object.
     */
    public SlideItem getTitle() {
        return title;
    }

    /**
     * Retrieve the collection of elements that are present on the slide.
     * @return The collection of elements that are present on the slide.
     */
    public Iterator<SlideItem> getSlideItems() {
        return slideItems.iterator();
    }
    
    /**
     * Add an element to the slide.
     * @param item The element to add.
     */
    public void addSlideItem(SlideItem item) {
        this.slideItems.add(item);
    }
    
    /**
     * Add an annotation to the slide.
     * @param annotation The annotation to add.
     */
    public void addAnnotation(Annotation annotation) {
        this.annotations.add(annotation);
    }
    
    /**
     * Create the draw logic that can be used to draw the slide.
     * @return The draw logic that can be used to draw the slide.
     */
    public SlideDrawLogic createDrawLogic() {
        return new SlideDrawLogic(this);
    }
}
