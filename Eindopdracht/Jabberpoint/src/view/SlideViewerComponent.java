package view;

import events.events.DisplayCurrentSlideEvent;
import events.events.DisplayDrawnAnnotationEvent;
import events.listeners.DisplayCurrentSlideEventListener;
import events.listeners.DisplayDrawnAnnotationEventListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import javax.swing.JComponent;

/**
 * The SlideViewerComponent object is mainly responsible for drawing the current slide of the presentation.
 * @author Tim
 */
public class SlideViewerComponent extends JComponent implements DisplayCurrentSlideEventListener, DisplayDrawnAnnotationEventListener {
    
    private static final long serialVersionUID = 227L;
    
    /**
     * The background color of the slide.
     */
    private static final Color BGCOLOR = Color.white;
    
    /**
     * The color used for the slide numbering.
     */
    private static final Color COLOR = Color.black;
    
    /**
     * The font name used for the slide numbering font.
     */
    private static final String FONTNAME = "Dialog";
    
    /**
     * The font style used for the slide numbering font.
     */
    private static final int FONTSTYLE = Font.BOLD;
    
    /**
     * The font size used for the slide numbering font.
     */
    private static final int FONTSIZE = 10;
    
    /**
     * The X-position where the slide numbering is drawn.
     */
    private static final int XPOS = 1100;
    
    /**
     * The Y-position where the slide numbering is drawn.
     */
    private static final int YPOS = 20;
    
    /**
     * The slide numbering font that is used to draw the slide numbering.
     */
    private Font slideNumberingFont;
    
    // Data
    /**
     * The information that is used to draw the currently being drawn annotation.
     */
    private DisplayDrawnAnnotationEvent drawnAnnotationInformation;
    
    /**
     * The information that is used to draw the current slide and the slide numbering.
     */
    private DisplayCurrentSlideEvent currentSlideInformation;

    /**
     * Initialize the SlideViewerComponent object.
     */
    public SlideViewerComponent() {
        this.setBackground(BGCOLOR);
        this.slideNumberingFont = new Font(FONTNAME, FONTSTYLE, FONTSIZE);
    }
    
    /**
     * Set the mouse adapter for this object. Add a mouse listener and mouse motion listener
     * to the SlideViewerComponent object with this mouse adapter.
     * @param mouseAdapter The mouse adapter.
     */
    public void setupMouseAdapter(MouseAdapter mouseAdapter) {
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        this.drawBackground(graphics);
        
        // Only draw something else if slide information is available
        if(this.currentSlideInformation != null) {
            if(this.currentSlideInformation.getCurrentSlide() != null) {
                this.drawSlideNumbering(graphics);
                this.drawSlide(graphics);
                // Only draw the drawn annotation if the information is available
                if(this.drawnAnnotationInformation != null) {
                    this.drawDrawnAnnotation(graphics);
                }
            }
        }
    }
    
    /**
     * Draw the background of the slide.
     * @param graphics The graphics object of this component to draw the background on.
     */
    private void drawBackground(Graphics graphics) {
        graphics.setColor(BGCOLOR);
        Dimension dimension = this.getSize();
        graphics.fillRect(0, 0, dimension.width, dimension.height);
    }
    
    /**
     * Draw the slide numbering.
     * @param graphics The graphics object of this component to draw the slide numbering on.
     */
    private void drawSlideNumbering(Graphics graphics) {
        graphics.setFont(this.slideNumberingFont);
        graphics.setColor(COLOR);
        graphics.drawString("Slide " + (this.currentSlideInformation.getCurrentSlideNumber()) + " of " +
                this.currentSlideInformation.getTotalSlides(), XPOS, YPOS);
    }
    
    /**
     * Draw the current slide.
     * @param graphics The graphics object of this component to draw the current slide on.
     */
    private void drawSlide(Graphics graphics) {
        Rectangle drawArea = new Rectangle(0, YPOS, this.getWidth(), (this.getHeight() - YPOS));
        this.currentSlideInformation.getCurrentSlide().createDrawLogic().draw(
                graphics, drawArea, this, this.currentSlideInformation.getSlideStyleCollection());
    }
    
    /**
     * Draw the currently being drawn annotation.
     * @param graphics The graphics object of this component to draw the currently being drawn 
     * annotation on.
     */
    private void drawDrawnAnnotation(Graphics graphics) {
        this.drawnAnnotationInformation.getAnnotation().createDrawLogic().draw(graphics);
    }

    @Override
    public void eventFired(DisplayCurrentSlideEvent event) {
        // Clear the information of the drawn annotation so it will not be drawn twice
        this.drawnAnnotationInformation = null; 
        this.currentSlideInformation = event;
        this.repaint();
    }

    @Override
    public void eventFired(DisplayDrawnAnnotationEvent event) {
        this.drawnAnnotationInformation = event;
        this.repaint();
    }
}
