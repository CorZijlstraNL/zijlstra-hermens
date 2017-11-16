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
 * This factory creates the listeners for the SlideViewerMenu MenuBar's MenuItems.
 * @author Tim
 */
public class MenuListenerFactory {
    
    /**
     * Create the listener class that contains the operations that need to be executed to load a presentation.
     * @param dispatcher The event dispatcher object that notifies which presentation needs to be loaded.
     * @return The listener class that contains the operations that need to be executed to load a presentation.
     */
    public static ActionListener createLoadPresentationActionListener(BaseEventDispatcher dispatcher) {
        return new LoadPresentationActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to create a new presentation.
     * @param dispatcher The event dispatcher object that notifies to create a new presentation.
     * @return The listener class that contains the operations that need to be executed to create a new presentation.
     */
    public static ActionListener createNewPresentationActionListener(BaseEventDispatcher dispatcher) {
        return new NewPresentationActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to save the presentation.
     * @param dispatcher The event dispatcher object that notifies where to save the presentation.
     * @return The listener class that contains the operations that need to be executed to save the presentation.
     */
    public static ActionListener createSavePresentationActionListener(BaseEventDispatcher dispatcher) {
        return new SavePresentationActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to close the presentation.
     * @param dispatcher The event dispatcher object that notifies to close the presentation.
     * @return The listener class that contains the operations that need to be executed to close the presentation.
     */
    public static ActionListener createClosePresentationActionListener(BaseEventDispatcher dispatcher) {
        return new ClosePresentationActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to navigate to the next slide.
     * @param dispatcher The event dispatcher object that notifies to navigate to the next slide.
     * @return The listener class that contains the operations that need to be executed to navigate to the next slide.
     */
    public static ActionListener createNextSlideActionListener(BaseEventDispatcher dispatcher) {
        return new NextSlideActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to navigate to the previous slide.
     * @param dispatcher The event dispatcher object that notifies to navigate to the previous slide.
     * @return The listener class that contains the operations that need to be executed to navigate to the previous slide.
     */
    public static ActionListener createPreviousSlideActionListener(BaseEventDispatcher dispatcher) {
        return new PreviousSlideActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to navigate to a specific slide.
     * @param dispatcher The event dispatcher object that notifies to navigate to a given slide.
     * @return The listener class that contains the operations that need to be executed to navigate to a specific slide.
     */
    public static ActionListener createGoToSlideActionListener(BaseEventDispatcher dispatcher) {
        return new GoToSlideActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to update the annotation color.
     * @param dispatcher The event dispatcher object that notifies to update the annotation color.
     * @return The listener class that contains the operations that need to be executed to update the annotation color.
     */
    public static ActionListener createSelectAnnotationColorActionListener(BaseEventDispatcher dispatcher) {
        return new SelectAnnotationColorActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to update the annotation thickness.
     * @param dispatcher The event dispatcher object that notifies to update the annotation thickness.
     * @return The listener class that contains the operations that need to be executed to update the annotation thickness.
     */
    public static ActionListener createSelectAnnotationThicknessActionListener(BaseEventDispatcher dispatcher) {
        return new SelectAnnotationThicknessActionListener(dispatcher);
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to show the About information.
     * @return The listener class that contains the operations that need to be executed to show the About information.
     */
    public static ActionListener createAboutActionListener() {
        return new AboutActionListener();
    }
    
    /**
     * Create the listener class that contains the operations that need to be executed to change the Annotation mode state.
     * @param dispatcher The event dispatcher object that notifies to update the annotation mode state.
     * @return The listener class that contains the operations that need to be executed to change the Annotation mode state.
     */
    public static ItemListener createAnnotationModeItemListener(BaseEventDispatcher dispatcher) {
        return new AnnotationModeItemListener(dispatcher);
    }
}
