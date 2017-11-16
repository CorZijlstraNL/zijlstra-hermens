package factories;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import view.SlideViewerMenu;

/**
 * This factory creates MenuBar classes for frame windows.
 * @author Tim
 */
public class MenuBarFactory {
    
    /**
     * Create the SlideViewerMenu MenuBar class.
     * @param loadPresentationActionListener The listener class that contains the operations that need 
     * to be executed to load a presentation.
     * @param newPresentationActionListener The listener class that contains the operations that need 
     * to be executed to create a new presentation.
     * @param savePresentationActionListener The listener class that contains the operations that need 
     * to be executed to save the presentation.
     * @param closePresentationActionListener The listener class that contains the operations that need 
     * to be executed to close the presentation.
     * @param nextSlideActionListener The listener class that contains the operations that need to be 
     * executed to navigate to the next slide.
     * @param previousSlideActionListener The listener class that contains the operations that need to be 
     * executed to navigate to the previous slide.
     * @param goToSlideActionListener The listener class that contains the operations that need to be executed 
     * to navigate to a specific slide.
     * @param selectAnnotationColorActionListener The listener class that contains the operations that need to be 
     * executed to update the annotation color.
     * @param selectAnnotationThicknessActionListener The listener class that contains the operations that need 
     * to be executed to update the annotation thickness.
     * @param annotationModeItemListener The listener class that contains the operations that need to be executed 
     * to change the Annotation mode state.
     * @param aboutActionListener The listener class that contains the operations that need to be executed to show 
     * the About information.
     * @param initialAnnotationModeIsEnabled The initial annotation mode state.
     * @return The SlideViewerMenu MenuBar class.
     */
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
