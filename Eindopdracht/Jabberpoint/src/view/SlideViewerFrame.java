/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import events.events.DisplayPresentationTitleEvent;
import events.listeners.DisplayPresentationTitleEventListener;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Tim
 */
public class SlideViewerFrame extends JFrame implements View, DisplayPresentationTitleEventListener {
    
    private static final long serialVersionUID = 3227L;
	
    private final static int WIDTH = 1200;
    private final static int HEIGHT = 800;

    public SlideViewerFrame() {
        super();
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
    }
    
    public void setupComponent(JComponent component) {
        this.getContentPane().add(component);
    }
    
    public void setupKeyAdapter(KeyAdapter keyAdapter) {
        this.addKeyListener(keyAdapter);
    }
    
    public void setupMenuBar(MenuBar menuBar) {
        this.setMenuBar(menuBar);
    }
    
    public void setupWindowAdapter(WindowAdapter windowAdapter) {
        this.addWindowListener(windowAdapter);
    }

    @Override
    public void eventFired(DisplayPresentationTitleEvent event) {
        this.setTitle(event.getPresentationTitle());
    }
}
