/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import controller.adapters.SlideViewerComponentMouseAdapter;
import controller.adapters.SlideViewerFrameKeyAdapter;
import controller.adapters.SlideViewerFrameWindowAdapter;
import events.dispatchers.BaseEventDispatcher;

/**
 *
 * @author Tim
 */
public class AdapterFactory {
    
    public static SlideViewerFrameKeyAdapter createSlideViewerFrameKeyAdapter(BaseEventDispatcher previousSlideEventDispatcher, BaseEventDispatcher nextSlideEventDispatcher, BaseEventDispatcher closePresentationEventDispatcher) {
        return new SlideViewerFrameKeyAdapter(previousSlideEventDispatcher, nextSlideEventDispatcher, closePresentationEventDispatcher);
    }
    
    public static SlideViewerFrameWindowAdapter createSlideViewerFrameWindowAdapter(BaseEventDispatcher closePresentationEventDispatcher) {
        return new SlideViewerFrameWindowAdapter(closePresentationEventDispatcher);
    }
    
    public static SlideViewerComponentMouseAdapter createSlideViewerComponentMouseAdapter(boolean annotationModeIsEnabled, BaseEventDispatcher updateDrawnAnnotationEventDispatcher, BaseEventDispatcher createDrawnAnnotationEventDispatcher) {
        return new SlideViewerComponentMouseAdapter(annotationModeIsEnabled, updateDrawnAnnotationEventDispatcher, createDrawnAnnotationEventDispatcher);
    }
}
