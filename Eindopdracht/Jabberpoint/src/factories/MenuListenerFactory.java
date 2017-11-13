/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import controller.menulisteners.AboutActionListener;
import controller.menulisteners.AnnotationModeItemListener;
import controller.menulisteners.ClosePresentationActionListener;
import controller.menulisteners.GoToSlideActionListener;
import controller.menulisteners.LoadPresentationActionListener;
import controller.menulisteners.NewPresentationActionListener;
import controller.menulisteners.NextSlideActionListener;
import controller.menulisteners.PreviousSlideActionListener;
import controller.menulisteners.SavePresentationActionListener;
import controller.menulisteners.SelectAnnotationColorActionListener;
import controller.menulisteners.SelectAnnotationThicknessActionListener;
import events.dispatchers.BaseEventDispatcher;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 *
 * @author Tim
 */
public class MenuListenerFactory {
    
    public static ActionListener createLoadPresentationActionListener(BaseEventDispatcher dispatcher) {
        return new LoadPresentationActionListener(dispatcher);
    }
    
    public static ActionListener createNewPresentationActionListener(BaseEventDispatcher dispatcher) {
        return new NewPresentationActionListener(dispatcher);
    }
    
    public static ActionListener createSavePresentationActionListener(BaseEventDispatcher dispatcher) {
        return new SavePresentationActionListener(dispatcher);
    }
    
    public static ActionListener createClosePresentationActionListener(BaseEventDispatcher dispatcher) {
        return new ClosePresentationActionListener(dispatcher);
    }
    
    public static ActionListener createNextSlideActionListener(BaseEventDispatcher dispatcher) {
        return new NextSlideActionListener(dispatcher);
    }
    
    public static ActionListener createPreviousSlideActionListener(BaseEventDispatcher dispatcher) {
        return new PreviousSlideActionListener(dispatcher);
    }
    
    public static ActionListener createGoToSlideActionListener(BaseEventDispatcher dispatcher) {
        return new GoToSlideActionListener(dispatcher);
    }
    
    public static ActionListener createSelectAnnotationColorActionListener(BaseEventDispatcher dispatcher) {
        return new SelectAnnotationColorActionListener(dispatcher);
    }
    
    public static ActionListener createSelectAnnotationThicknessActionListener(BaseEventDispatcher dispatcher) {
        return new SelectAnnotationThicknessActionListener(dispatcher);
    }
    
    public static ActionListener createAboutActionListener() {
        return new AboutActionListener();
    }
    
    public static ItemListener createAnnotationModeItemListener(BaseEventDispatcher dispatcher) {
        return new AnnotationModeItemListener(dispatcher);
    }
}
