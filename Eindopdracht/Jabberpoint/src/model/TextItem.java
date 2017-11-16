package model;

import model.drawlogic.SlideItemDrawLogic;
import model.drawlogic.TextItemDrawLogic;

/**
 * The TextItem represents a text element on a slide.
 * @author Tim
 */
public class TextItem extends SlideItem {

    /**
     * The text of the element.
     */
    private String text;
    
    /**
     * Initialize the TextItem object.
     * @param nestingLevel The nesting level of the element.
     * @param text The text of the element.
     */
    public TextItem(int nestingLevel, String text) {
        super(nestingLevel);
        this.text = text;
    }

    /**
     * Retrieve the text of the element.
     * @return The text of the element.
     */
    public String getText() {
        return text;
    }

    @Override
    public SlideItemDrawLogic createDrawLogic() {
        return new TextItemDrawLogic(this);
    }
    
    @Override
    public String toString() {
        return "TextItem[" + getNestingLevel()+","+getText()+"]";
    }
}
