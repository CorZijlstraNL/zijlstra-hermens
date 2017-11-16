package view;

import factories.MenuFactory;
import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * The SlideViewerMenu object represents the menu bar of the application.
 * @author Tim
 */
public class SlideViewerMenu extends MenuBar {
    
    private static final long serialVersionUID = 227L;
    
    /**
     * The File menu name.
     */
    private static final String FILE = "File";
    
    /**
     * The Exit menu item of the File menu.
     */
    private static final String EXIT = "Exit";
    
    /**
     * The shortcut that can be used to activate the Exit menu item.
     */
    private static final char EXIT_SHORTCUT = 'E';
    
    /**
     * The New menu item of the File menu.
     */
    private static final String NEW = "New";
    
    /**
     * The shortcut that can be used to activate the New menu item.
     */
    private static final char NEW_SHORTCUT = 'N';
    
    /**
     * The Open menu item of the File menu.
     */
    private static final String OPEN = "Open";
    
    /**
     * The shortcut that can be used to activate the Open menu item.
     */
    private static final char OPEN_SHORTCUT = 'O';
    
    /**
     * The Save menu item of the File menu.
     */
    private static final String SAVE = "Save";
    
    /**
     * The shortcut that can be used to activate the Save menu item.
     */
    private static final char SAVE_SHORTCUT = 'S';
    
    /**
     * The View menu name.
     */
    private static final String VIEW = "View";
    
    /**
     * The Go to menu item of the View menu.
     */
    private static final String GOTO = "Go to";
    
    /**
     * The shortcut that can be used to activate the Go to menu item.
     */
    private static final char GOTO_SHORTCUT = 'G';
    
    /**
     * The Next menu item of the View menu.
     */
    private static final String NEXT = "Next";
    
    /**
     * The shortcut that can be used to activate the Next menu item.
     */
    private static final char NEXT_SHORTCUT = 'L';
    
    /**
     * The Prev menu item of the View menu.
     */
    private static final String PREV = "Prev";
    
    /**
     * The shortcut that can be used to activate the Prev menu item.
     */
    private static final char PREV_SHORTCUT = 'P';
    
    /**
     * The Help menu name.
     */
    private static final String HELP = "Help";
    
    /**
     * The About menu item of the Help menu.
     */
    private static final String ABOUT = "About";
    
    /**
     * The shortcut that can be used to activate the About menu item.
     */
    private static final char ABOUT_SHORTCUT = 'A';
    
    /**
     * The Annotation menu name.
     */
    private static final String ANNOTATION = "Annotation";
    
    /**
     * The Set color menu item of the Annotation menu.
     */
    private static final String ANNOTATION_COLOR = "Set color";
    
    /**
     * The shortcut that can be used to activate the Set color menu item.
     */
    private static final char ANNOTATION_COLOR_SHORTCUT = 'C';
    
    /**
     * The Set thickness menu item of the Annotation menu.
     */
    private static final String ANNOTATION_THICKNESS = "Set thickness";
    
    /**
     * The shortcut that can be used to activate the Set thickness menu item.
     */
    private static final char ANNOTATION_THICKNESS_SHORTCUT = 'T';
    
    /**
     * The Annotation mode menu item of the Annotation menu.
     */
    private static final String ANNOTATION_MODE = "Annotation mode";

    /**
     * Initialize the SlideViewerMenu object.
     * @param loadPresentationActionListener The listener that contains the operations that 
     * need to be executed to load a presentation.
     * @param newPresentationActionListener The listener that contains the operations that need 
     * to be executed to create a new presentation.
     * @param savePresentationActionListener The listener that contains the operations that need 
     * to be executed to save the presentation.
     * @param closePresentationActionListener The listener that contains the operations that need 
     * to be executed to close the presentation.
     * @param nextSlideActionListener The listener that contains the operations that need to be 
     * executed to navigate to the next slide.
     * @param previousSlideActionListener The listener that contains the operations that need to be 
     * executed to navigate to the previous slide.
     * @param goToSlideActionListener The listener that contains the operations that need to be executed 
     * to navigate to a specific slide.
     * @param selectAnnotationColorActionListener The listener that contains the operations that need to be 
     * executed to update the annotation color.
     * @param selectAnnotationThicknessActionListener The listener that contains the operations that need to 
     * be executed to update the annotation thickness.
     * @param annotationModeItemListener The listener that contains the operations that need to be executed to 
     * change the Annotation mode state.
     * @param aboutActionListener The listener that contains the operations that need to be executed to show the 
     * About information.
     * @param initialAnnotationModeIsEnabled The initial annotation mode status.
     */
    public SlideViewerMenu(ActionListener loadPresentationActionListener, ActionListener newPresentationActionListener, 
            ActionListener savePresentationActionListener, ActionListener closePresentationActionListener, ActionListener nextSlideActionListener, 
            ActionListener previousSlideActionListener, ActionListener goToSlideActionListener, ActionListener selectAnnotationColorActionListener, 
            ActionListener selectAnnotationThicknessActionListener, ItemListener annotationModeItemListener, ActionListener aboutActionListener,
            boolean initialAnnotationModeIsEnabled) {
        this.createFileMenu(loadPresentationActionListener, newPresentationActionListener, savePresentationActionListener, closePresentationActionListener);
        this.createViewMenu(nextSlideActionListener, previousSlideActionListener, goToSlideActionListener);
        this.createAnnotationMenu(selectAnnotationColorActionListener, selectAnnotationThicknessActionListener, annotationModeItemListener, initialAnnotationModeIsEnabled);
        this.createHelpMenu(aboutActionListener);
    }
    
    /**
     * Create the File menu.
     * @param loadPresentationActionListener The listener that contains the operations that 
     * need to be executed to load a presentation.
     * @param newPresentationActionListener The listener that contains the operations that need 
     * to be executed to create a new presentation.
     * @param savePresentationActionListener The listener that contains the operations that need 
     * to be executed to save the presentation.
     * @param closePresentationActionListener The listener that contains the operations that need 
     * to be executed to close the presentation.
     */
    private void createFileMenu(ActionListener loadPresentationActionListener, ActionListener newPresentationActionListener,
            ActionListener savePresentationActionListener, ActionListener closePresentationActionListener) {
        Menu menu = MenuFactory.createMenu(FILE);
        
        MenuItem menuItem = MenuFactory.createMenuItem(OPEN, OPEN_SHORTCUT);
        menuItem.addActionListener(loadPresentationActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(NEW, NEW_SHORTCUT);
        menuItem.addActionListener(newPresentationActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(SAVE, SAVE_SHORTCUT);
        menuItem.addActionListener(savePresentationActionListener);
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = MenuFactory.createMenuItem(EXIT, EXIT_SHORTCUT);
        menuItem.addActionListener(closePresentationActionListener);
        menu.add(menuItem);
        
        this.add(menu);
    }
    
    /**
     * Create the View menu.
     * @param nextSlideActionListener The listener that contains the operations that need to be 
     * executed to navigate to the next slide.
     * @param previousSlideActionListener The listener that contains the operations that need to be 
     * executed to navigate to the previous slide.
     * @param goToSlideActionListener The listener that contains the operations that need to be executed 
     * to navigate to a specific slide.
     */
    private void createViewMenu(ActionListener nextSlideActionListener, ActionListener previousSlideActionListener, ActionListener goToSlideActionListener) {
        Menu menu = MenuFactory.createMenu(VIEW);
        
        MenuItem menuItem = MenuFactory.createMenuItem(NEXT, NEXT_SHORTCUT);
        menuItem.addActionListener(nextSlideActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(PREV, PREV_SHORTCUT);
        menuItem.addActionListener(previousSlideActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(GOTO, GOTO_SHORTCUT);
        menuItem.addActionListener(goToSlideActionListener);
        menu.add(menuItem);
        
        this.add(menu);
    }
    
    /**
     * Create the Annotation menu.
     * @param selectAnnotationColorActionListener The listener that contains the operations that need to be 
     * executed to update the annotation color.
     * @param selectAnnotationThicknessActionListener The listener that contains the operations that need to 
     * be executed to update the annotation thickness.
     * @param annotationModeItemListener The listener that contains the operations that need to be executed to 
     * change the Annotation mode state.
     * @param initialAnnotationModeIsEnabled The initial annotation mode status.
     */
    private void createAnnotationMenu(ActionListener selectAnnotationColorActionListener, ActionListener selectAnnotationThicknessActionListener, 
            ItemListener annotationModeItemListener, boolean initialAnnotationModeIsEnabled) {
        Menu menu = MenuFactory.createMenu(ANNOTATION);
        
        CheckboxMenuItem checkboxMenuItem = MenuFactory.createCheckboxMenuItem(ANNOTATION_MODE, initialAnnotationModeIsEnabled);
        checkboxMenuItem.addItemListener(annotationModeItemListener);
        menu.add(checkboxMenuItem);
        
        MenuItem menuItem = MenuFactory.createMenuItem(ANNOTATION_COLOR, ANNOTATION_COLOR_SHORTCUT);
        menuItem.addActionListener(selectAnnotationColorActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(ANNOTATION_THICKNESS, ANNOTATION_THICKNESS_SHORTCUT);
        menuItem.addActionListener(selectAnnotationThicknessActionListener);
        menu.add(menuItem);
        
        this.add(menu);
    }
    
    /**
     * Create the Help menu.
     * @param aboutActionListener The listener that contains the operations that need to be executed to show the 
     * About information.
     */
    private void createHelpMenu(ActionListener aboutActionListener) {
        Menu menu = MenuFactory.createMenu(HELP);
        
        MenuItem menuItem = MenuFactory.createMenuItem(ABOUT, ABOUT_SHORTCUT);
        menuItem.addActionListener(aboutActionListener);
        menu.add(menuItem);
        
        this.setHelpMenu(menu);
    }
}
