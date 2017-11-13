/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import view.SlideViewerMenu;

/**
 *
 * @author Tim
 */
public class MenuBarFactory {
    
    public static SlideViewerMenu createSlideViewerMenu(ActionListener loadPresentationActionListener, ActionListener newPresentationActionListener, 
            ActionListener savePresentationActionListener, ActionListener closePresentationActionListener, ActionListener nextSlideActionListener, 
            ActionListener previousSlideActionListener, ActionListener goToSlideActionListener, ActionListener selectAnnotationColorActionListener, 
            ActionListener selectAnnotationThicknessActionListener, ItemListener annotationModeItemListener, ActionListener aboutActionListener,
            boolean initialAnnotationModeIsEnabled) {
        return new SlideViewerMenu(loadPresentationActionListener, newPresentationActionListener, savePresentationActionListener, closePresentationActionListener,
                nextSlideActionListener, previousSlideActionListener, goToSlideActionListener, selectAnnotationColorActionListener, selectAnnotationThicknessActionListener,
                annotationModeItemListener, aboutActionListener, initialAnnotationModeIsEnabled);
    }
}
