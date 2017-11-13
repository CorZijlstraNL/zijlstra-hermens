/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import factories.MenuFactory;
import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 *
 * @author Tim
 */
public class SlideViewerMenu extends MenuBar {
    
    private static final long serialVersionUID = 227L;
	
    private static final String ABOUT = "About";
    private static final String FILE = "File";
    private static final String EXIT = "Exit";
    private static final String GOTO = "Go to";
    private static final String HELP = "Help";
    private static final String NEW = "New";
    private static final String NEXT = "Next";
    private static final String OPEN = "Open";
    private static final String PREV = "Prev";
    private static final String SAVE = "Save";
    private static final String VIEW = "View";
    
    private static final String ANNOTATION = "Annotation";
    private static final String ANNOTATION_COLOR = "Set color";
    private static final String ANNOTATION_THICKNESS = "Set thickness";
    private static final String ANNOTATION_MODE = "Annotation mode";

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
    
    private void createFileMenu(ActionListener loadPresentationActionListener, ActionListener newPresentationActionListener,
            ActionListener savePresentationActionListener, ActionListener closePresentationActionListener) {
        Menu menu = MenuFactory.createMenu(FILE);
        
        MenuItem menuItem = MenuFactory.createMenuItem(OPEN);
        menuItem.addActionListener(loadPresentationActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(NEW);
        menuItem.addActionListener(newPresentationActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(SAVE);
        menuItem.addActionListener(savePresentationActionListener);
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = MenuFactory.createMenuItem(EXIT);
        menuItem.addActionListener(closePresentationActionListener);
        menu.add(menuItem);
        
        this.add(menu);
    }
    
    private void createViewMenu(ActionListener nextSlideActionListener, ActionListener previousSlideActionListener, ActionListener goToSlideActionListener) {
        Menu menu = MenuFactory.createMenu(VIEW);
        
        MenuItem menuItem = MenuFactory.createMenuItem(NEXT);
        menuItem.addActionListener(nextSlideActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(PREV);
        menuItem.addActionListener(previousSlideActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(GOTO);
        menuItem.addActionListener(goToSlideActionListener);
        menu.add(menuItem);
        
        this.add(menu);
    }
    
    private void createAnnotationMenu(ActionListener selectAnnotationColorActionListener, ActionListener selectAnnotationThicknessActionListener, 
            ItemListener annotationModeItemListener, boolean initialAnnotationModeIsEnabled) {
        Menu menu = MenuFactory.createMenu(ANNOTATION);
        
        CheckboxMenuItem checkboxMenuItem = MenuFactory.createCheckboxMenuItem(ANNOTATION_MODE, initialAnnotationModeIsEnabled);
        checkboxMenuItem.addItemListener(annotationModeItemListener);
        menu.add(checkboxMenuItem);
        
        MenuItem menuItem = MenuFactory.createMenuItem(ANNOTATION_COLOR);
        menuItem.addActionListener(selectAnnotationColorActionListener);
        menu.add(menuItem);
        
        menuItem = MenuFactory.createMenuItem(ANNOTATION_THICKNESS);
        menuItem.addActionListener(selectAnnotationThicknessActionListener);
        menu.add(menuItem);
        
        this.add(menu);
    }
    
    private void createHelpMenu(ActionListener aboutActionListener) {
        Menu menu = MenuFactory.createMenu(HELP);
        
        MenuItem menuItem = MenuFactory.createMenuItem(ABOUT);
        menuItem.addActionListener(aboutActionListener);
        menu.add(menuItem);
        
        this.setHelpMenu(menu);
    }
}
