/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Tim
 */
public class SlideViewerComponent extends JComponent implements DisplayCurrentSlideEventListener, DisplayDrawnAnnotationEventListener {
    
    private static final long serialVersionUID = 227L;
    
    private static final Color BGCOLOR = Color.white;
    private static final Color COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTSIZE = 10;
    private static final int XPOS = 1100;
    private static final int YPOS = 20;
    
    private Font slideNumberingFont;
    
    // Data
    private DisplayDrawnAnnotationEvent drawnAnnotationInformation;
    
    private DisplayCurrentSlideEvent currentSlideInformation;

    public SlideViewerComponent() {
        this.setBackground(BGCOLOR);
        this.slideNumberingFont = new Font(FONTNAME, FONTSTYLE, FONTSIZE);
    }
    
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
    
    private void drawBackground(Graphics graphics) {
        graphics.setColor(BGCOLOR);
        Dimension dimension = this.getSize();
        graphics.fillRect(0, 0, dimension.width, dimension.height);
    }
    
    private void drawSlideNumbering(Graphics graphics) {
        graphics.setFont(this.slideNumberingFont);
        graphics.setColor(COLOR);
        graphics.drawString("Slide " + (this.currentSlideInformation.getCurrentSlideNumber()) + " of " +
                this.currentSlideInformation.getTotalSlides(), XPOS, YPOS);
    }
    
    private void drawSlide(Graphics graphics) {
        Rectangle drawArea = new Rectangle(0, YPOS, this.getWidth(), (this.getHeight() - YPOS));
        this.currentSlideInformation.getCurrentSlide().createDrawLogic().draw(
                graphics, drawArea, this, this.currentSlideInformation.getSlideStyleCollection());
    }
    
    private void drawDrawnAnnotation(Graphics graphics) {
        this.drawnAnnotationInformation.getAnnotation().createDrawLogic().draw(graphics);
    }

    @Override
    public void eventFired(DisplayCurrentSlideEvent event) {
        // Clear the drawn annotation so it will not be drawn twice
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
