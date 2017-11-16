package readwrite.format;

import java.util.Iterator;
import model.Presentation;
import model.Slide;
import model.SlideItem;
import readwrite.builder.PresentationBuilder;

/**
 * The Format object contains the operations required to read and write presentations to and from files.
 * @author Tim
 */
public abstract class Format {
    
    /**
     * The Builder object to build the Presentation object that is read from a file.
     */
    protected PresentationBuilder presentationBuilder;
    
    /**
     * Initialize the Format object.
     * @param builder The Builder object to build the Presentation object that is read from a file.
     */
    protected Format(PresentationBuilder builder) {
        this.presentationBuilder = builder;
    }
    
    /**
     * Open the connection to the file to enable the read and write operations on it.
     * @param path The path pointing to the file.
     * @param read Determines if the file is being read or not.
     * @return Whether or not the file has been successfully opened.
     */
    public abstract boolean open(String path, boolean read);
    
    /**
     * Close the connection to the file.
     */
    public abstract void close();
    
    /**
     * Read the first bits from the file.
     */
    public abstract void readBegin();
    
    /**
     * Read the presentation title from the file.
     */
    public abstract void readPresentationTitle();
    
    /**
     * Read the slides from the file.
     */
    public abstract void readSlides();
    
    /**
     * Read a slide from the file.
     */
    protected abstract void readSlide();
    
    /**
     * Read the slide items from the file.
     */
    protected abstract void readSlideItems();
    
    /**
     * Read a slide item from the file.
     */
    protected abstract void readSlideItem();
    
    /**
     * Return the Presentation object that was read from the file.
     * @return The Presentation object that was read from the file.
     */
    public abstract Presentation readEnd();
    
    /**
     * Write the first bits to the file.
     */
    public abstract void writeBegin();
    
    /**
     * Write the presentation title to the file.
     * @param title The presentation title.
     */
    public abstract void writePresentationTitle(String title);
    
    /**
     * Write the slides to the file.
     * @param slides The slides to write.
     */
    public abstract void writeSlides(Iterator<Slide> slides);
    
    /**
     * Write a slide to the file.
     * @param slide The slide to write.
     */
    protected abstract void writeSlide(Slide slide);
    
    /**
     * Write the slide items to the file.
     * @param slideItems The slide items to write.
     */
    protected abstract void writeSlideItems(Iterator<SlideItem> slideItems);
    
    /**
     * Write a slide item to the file.
     * @param slideItem The slide item to write.
     */
    protected abstract void writeSlideItem(SlideItem slideItem);
    
    /**
     * Write the last bits to the file.
     */
    public abstract void writeEnd();
}
