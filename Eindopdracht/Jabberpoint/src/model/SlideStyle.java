package model;

import java.awt.Color;
import java.awt.Font;

/**
 * The SlideStyle object contains the style for an element on a slide.
 * @author Tim
 */
public class SlideStyle {
    
    /**
     * The font name to use for the font.
     */
    private static String FONT_NAME = "Helvetica";
    
    /**
     * The color for the SlideItem element.
     */
    private Color color;
    
    /**
     * The font for the SlideItem element.
     */
    private Font font;
    
    /**
     * The leading space between SlideItem elements.
     */
    private int leading;
    
    /**
     * The indent width of the SlideItem element.
     */
    private int indent;
    
    /**
     * The font size of the font.
     */
    private int fontSize;

    /**
     * Initialize the SlideStyle object.
     * @param color The color for the SlideItem element.
     * @param leading The leading space between SlideItem elements.
     * @param indent The indent width of the SlideItem element.
     * @param fontSize The font size of the font.
     */
    public SlideStyle(Color color, int leading, int indent, int fontSize) {
        this.color = color;
        this.leading = leading;
        this.indent = indent;
        this.fontSize = fontSize;
        this.font = new Font(FONT_NAME, Font.BOLD, fontSize);
    }

    /**
     * Retrieve the color for the SlideItem element.
     * @return The color for the SlideItem element.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retrieve the properly sized font for the SlideItem element.
     * @param scale The scale to modify the font size with.
     * @return The properly sized font for the SlideItem element.
     */
    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }

    /**
     * Retrieve the leading space between SlideItem elements.
     * @return The leading space between SlideItem elements.
     */
    public int getLeading() {
        return leading;
    }

    /**
     * Retrieve the indent width of the SlideItem element.
     * @return The indent width of the SlideItem element.
     */
    public int getIndent() {
        return indent;
    }
    
    @Override
    public String toString() {
        return "["+ indent + "," + color + "; " + fontSize + " on " + leading +"]";
    }
}
