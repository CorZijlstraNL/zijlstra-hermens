package model;

import model.drawlogic.SlideItemDrawLogic;

/**
 * The SlideItem object represents an element on a slide.
 * @author Tim
 */
public abstract class SlideItem {
    
    /**
     * The nesting level of the element.
     */
    private int nestingLevel;

    /**
     * Initialize the SlideItem object.
     * @param nestingLevel The nesting level of the object.
     */
    protected SlideItem(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    /**
     * Retrieve the nesting level of the element.
     * @return The nesting level of the element.
     */
    public int getNestingLevel() {
        return nestingLevel;
    }
    
    /**
     * Create the draw logic that can be used to draw the element.
     * @return The draw logic that can be used to draw the annotation.
     */
    public abstract SlideItemDrawLogic createDrawLogic();
}
