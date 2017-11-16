package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The SlideStyleCollection object contains the collection of SlideStyle objects that represent
 * the styles for the SlideItem elements. Each style corresponds to a nesting level of a SlideItem.
 * @author Tim
 */
public class SlideStyleCollection {
    
    /**
     * The collection of styles for the SlideItem. The index position of a style in this collection 
     * indicates for what nesting level the style is applied.
     */
    private List<SlideStyle> slideStyles;

    /**
     * Initialize the SlideStyleCollection object.
     */
    public SlideStyleCollection() {
        this.slideStyles = new ArrayList();
        this.setDefaultStyles();
    }
    
    /**
     * Add a style to the collection of styles.
     * @param style The style to add.
     */
    public void addSlideStyle(SlideStyle style) {
        this.slideStyles.add(style);
    }
    
    /**
     * Retrieve the style for a specific nesting level.
     * @param nestingLevel The nesting level.
     * @return The style for a specific nesting level.
     */
    public SlideStyle getSlideStyle(int nestingLevel) {
        return this.slideStyles.get(nestingLevel);
    }
    
    /**
     * Set the style for a specific nesting level.
     * @param nestingLevel The nesting level.
     * @param style The style for the nesting level.
     */
    public void setSlideStyle(int nestingLevel, SlideStyle style) {
        this.slideStyles.set(nestingLevel, style);
    }
    
    /**
     * Set the default styles.
     */
    private void setDefaultStyles() {
        this.addSlideStyle(new SlideStyle(Color.red, 20, 0, 48)); // style for nestingLevel 0
        this.addSlideStyle(new SlideStyle(Color.blue, 10, 20, 40)); // style for nestingLevel 1
        this.addSlideStyle(new SlideStyle(Color.black, 10, 50, 36)); // style for nestingLevel 2
        this.addSlideStyle(new SlideStyle(Color.black, 10, 70, 30)); // style for nestingLevel 3
        this.addSlideStyle(new SlideStyle(Color.black, 10, 90, 24)); // style for nestingLevel 4
    }
}
