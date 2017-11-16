package factories;

import controller.adapters.SlideViewerComponentMouseAdapter;
import controller.adapters.SlideViewerFrameKeyAdapter;
import controller.adapters.SlideViewerFrameWindowAdapter;
import events.dispatchers.BaseEventDispatcher;

/**
 * This factory creates Adapter objects for the View-related objects.
 * @author Tim
 */
public class AdapterFactory {
    
    /**
     * Create the SlideViewerFrameKeyAdapter.
     * @param previousSlideEventDispatcher The PreviousSlideEventDispatcher object.
     * @param nextSlideEventDispatcher The NextSlideEventDispatcher object.
     * @param closePresentationEventDispatcher The ClosePresentationEventDispatcher object.
     * @return The SlideViewerFrameKeyAdapter.
     */
    public static SlideViewerFrameKeyAdapter createSlideViewerFrameKeyAdapter(BaseEventDispatcher previousSlideEventDispatcher, BaseEventDispatcher nextSlideEventDispatcher, BaseEventDispatcher closePresentationEventDispatcher) {
        return new SlideViewerFrameKeyAdapter(previousSlideEventDispatcher, nextSlideEventDispatcher, closePresentationEventDispatcher);
    }
    
    /**
     * Create the SlideViewerFrameWindowAdapter.
     * @param closePresentationEventDispatcher The ClosePresentationEventDispatcher object.
     * @return The SlideViewerFrameWindowAdapter.
     */
    public static SlideViewerFrameWindowAdapter createSlideViewerFrameWindowAdapter(BaseEventDispatcher closePresentationEventDispatcher) {
        return new SlideViewerFrameWindowAdapter(closePresentationEventDispatcher);
    }
    
    /**
     * Create the SlideViewerComponentMouseAdapter.
     * @param annotationModeIsEnabled The initial annotation mode value.
     * @param updateDrawnAnnotationEventDispatcher The UpdateDrawnAnnotationEventDispatcher object.
     * @param createDrawnAnnotationEventDispatcher The CreateDrawnAnnotationEventDispatcher object.
     * @return The SlideViewerComponentMouseAdapter.
     */
    public static SlideViewerComponentMouseAdapter createSlideViewerComponentMouseAdapter(boolean annotationModeIsEnabled, BaseEventDispatcher updateDrawnAnnotationEventDispatcher, BaseEventDispatcher createDrawnAnnotationEventDispatcher) {
        return new SlideViewerComponentMouseAdapter(annotationModeIsEnabled, updateDrawnAnnotationEventDispatcher, createDrawnAnnotationEventDispatcher);
    }
}
