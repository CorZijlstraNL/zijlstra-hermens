package model.drawlogic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.SlideStyle;
import model.TextItem;

/**
 * The TextItemDrawLogic object contains the draw logic to be able to draw the TextItem objects.
 * @author Tim
 */
public class TextItemDrawLogic implements SlideItemDrawLogic {

    /**
     * The TextItem object to draw.
     */
    private TextItem textItem;
    
    /**
     * Initialize the TextItemDrawLogic object.
     * @param textItem The TextItem object to draw.
     */
    public TextItemDrawLogic(TextItem textItem) {
        this.textItem = textItem;
    }

    @Override
    public void draw(int slideWidth, Graphics graphics, int posX, int posY, float scale, ImageObserver observer, SlideStyle slideStyle) {
        Iterator<TextLayout> layouts = this.getLayouts(graphics, slideStyle, scale, slideWidth, this.textItem.getText());
        Point pen = new Point(posX + (int)(slideStyle.getIndent() * scale),
                posY + (int) (slideStyle.getLeading() * scale));
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(slideStyle.getColor());

        while (layouts.hasNext()) {
            TextLayout layout = layouts.next();
            pen.y += layout.getAscent();
            layout.draw(graphics2D, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    @Override
    public Rectangle getBoundingBox(int slideWidth, Graphics graphics, ImageObserver observer, float scale, SlideStyle slideStyle) {
        String text = this.textItem.getText();
        Iterator<TextLayout> layouts = this.getLayouts(graphics, slideStyle, scale, slideWidth, text);
        int width = 0;
        int height = (int) (slideStyle.getLeading() * scale);

        while (layouts.hasNext()) {
            TextLayout layout = layouts.next();
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > width) {
                width = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0) {
                height += bounds.getHeight();
            }
            height += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (slideStyle.getIndent() * scale), 0, width, height);
    }
    
    /**
     * Determine the AttributedString for the text of the TextItem object.
     * @param slideStyle The style of the TextItem object.
     * @param scale The scale to use to resize the TextItem object.
     * @param text The text of the TextItem object.
     * @return The AttributedString.
     */
    private AttributedString getAttributedString(SlideStyle slideStyle, float scale, String text) {
        AttributedString attributedString = new AttributedString(text);
        attributedString.addAttribute(TextAttribute.FONT, slideStyle.getFont(scale), 0, text.length());
        return attributedString;
    }
    
    /**
     * Determine the graphical representations of the styled text data of the TextItem object.
     * @param graphics The graphics object of the component to draw the TextItem object on.
     * @param slideStyle The style of the TextItem object.
     * @param scale The scale to use to resize the TextItem object.
     * @param slideWidth The width of the slide.
     * @param text The text of the TextItem object.
     * @return The graphical representations of the styled text data of the TextItem object.
     */
    private Iterator<TextLayout> getLayouts(Graphics graphics, SlideStyle slideStyle, float scale, int slideWidth, String text) {
        List<TextLayout> layouts = new ArrayList();
        AttributedString attributedString = this.getAttributedString(slideStyle, scale, text);
    	Graphics2D graphics2D = (Graphics2D) graphics;
    	FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
    	LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(attributedString.getIterator(), fontRenderContext);
    	float wrappingWidth = (slideWidth - slideStyle.getIndent()) * scale;
    	while (lineBreakMeasurer.getPosition() < text.length()) {
            TextLayout layout = lineBreakMeasurer.nextLayout(wrappingWidth);
            layouts.add(layout);
    	}
    	return layouts.iterator();
    }
}
