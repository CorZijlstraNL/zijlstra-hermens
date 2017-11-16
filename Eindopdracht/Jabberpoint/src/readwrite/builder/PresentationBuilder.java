package readwrite.builder;

import factories.PresentationFactory;
import model.Presentation;
import model.Slide;

/**
 * The PresentationBuilder object contains the operations to dynamically build a Presentation object.
 * @author Tim
 */
public class PresentationBuilder {
    
    /**
     * The Presentation object to build.
     */
    private Presentation presentation;
    
    /**
     * The Slide object that is used to store the intermediate results of the current Slide and
     * added to the Presentation object when it is complete.
     */
    private Slide slide;

    /**
     * Initialize the PresentationBuilder object.
     */
    public PresentationBuilder() {
        this.presentation = PresentationFactory.createPresentation();
    }
    
    /**
     * Set the presentation title.
     * @param title The presentation title.
     */
    public void buildPresentationTitle(String title) {
        this.presentation.setTitle(title);
    }
    
    /**
     * Create a new slide.
     * @param slideTitle The title of the slide.
     */
    public void buildSlide(String slideTitle) {
        this.addSlide(); // add the previously build slide to the presentation before creating a new one
        this.slide = PresentationFactory.createSlide(slideTitle);
    }
    
    /**
     * Create a new TextItem object and add it to the slide.
     * @param nestingLevel The nesting level of the TextItem object.
     * @param text The text of the TextItem object.
     */
    public void buildTextItem(int nestingLevel, String text) {
        this.slide.addSlideItem(PresentationFactory.createTextItem(nestingLevel, text));
    }
    
    /**
     * Create a new ImageItem object and add it to the slide.
     * @param nestingLevel The nesting level of the ImageItem object.
     * @param imageName The image name of the ImageItem object.
     */
    public void buildImageItem(int nestingLevel, String imageName) {
        this.slide.addSlideItem(PresentationFactory.createImageItem(nestingLevel, imageName));
    }
    
    /**
     * Add the slide to the presentation.
     */
    private void addSlide() {
        if(this.slide != null) {
            this.presentation.addSlide(this.slide);
        }
    }
    
    /**
     * Retrieve the result of the build Presentation object.
     * @return The resulting Presentation object.
     */
    public Presentation getResult() {
        this.addSlide(); // add the previously build slide to the presentation
        return this.presentation;
    }
}
