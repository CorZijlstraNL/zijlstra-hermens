package view;

import events.events.DisplayPresentationTitleEvent;
import events.listeners.DisplayPresentationTitleEventListener;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * The SlideViewerFrame object represents the main window of the application.
 * @author Tim
 */
public class SlideViewerFrame extends JFrame implements View, DisplayPresentationTitleEventListener {
    
    private static final long serialVersionUID = 3227L;

    /**
     * The initial width of the window frame.
     */
    private final static int WIDTH = 1200;
    
    /**
     * The initial height of the window frame.
     */
    private final static int HEIGHT = 800;

    /**
     * Initialize the SlideViewerFrame object.
     */
    public SlideViewerFrame() {
        super();
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
    }
    
    /**
     * Add the component to the frame's content pane.
     * @param component The component to add.
     */
    public void setupComponent(JComponent component) {
        this.getContentPane().add(component);
    }
    
    /**
     * Add the key adapter as a key listener to the frame.
     * @param keyAdapter The key adapter.
     */
    public void setupKeyAdapter(KeyAdapter keyAdapter) {
        this.addKeyListener(keyAdapter);
    }
    
    /**
     * Add the menu bar to the frame.
     * @param menuBar The menu bar.
     */
    public void setupMenuBar(MenuBar menuBar) {
        this.setMenuBar(menuBar);
    }
    
    /**
     * Add the window adapter as a window listener to the frame.
     * @param windowAdapter The window adapter.
     */
    public void setupWindowAdapter(WindowAdapter windowAdapter) {
        this.addWindowListener(windowAdapter);
    }

    @Override
    public void eventFired(DisplayPresentationTitleEvent event) {
        this.setTitle(event.getPresentationTitle());
    }
}
