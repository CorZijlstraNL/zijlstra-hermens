/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import events.dispatchers.BaseEventDispatcher;
import events.dispatchers.ClosePresentationEventDispatcher;
import events.dispatchers.CreateDrawnAnnotationEventDispatcher;
import events.dispatchers.DisplayCurrentSlideEventDispatcher;
import events.dispatchers.DisplayDrawnAnnotationEventDispatcher;
import events.dispatchers.DisplayPresentationTitleEventDispatcher;
import events.dispatchers.GoToSlideEventDispatcher;
import events.dispatchers.LoadPresentationEventDispatcher;
import events.dispatchers.NewPresentationEventDispatcher;
import events.dispatchers.NextSlideEventDispatcher;
import events.dispatchers.PreviousSlideEventDispatcher;
import events.dispatchers.SavePresentationEventDispatcher;
import events.dispatchers.UpdateAnnotationColorEventDispatcher;
import events.dispatchers.UpdateAnnotationModeEventDispatcher;
import events.dispatchers.UpdateAnnotationThicknessEventDispatcher;
import events.dispatchers.UpdateDrawnAnnotationEventDispatcher;

/**
 *
 * @author Tim
 */
public class EventDispatcherFactory {
    
    public static BaseEventDispatcher createGoToSlideEventDispatcher() {
        return new GoToSlideEventDispatcher();
    }
    
    public static BaseEventDispatcher createPreviousSlideEventDispatcher() {
        return new PreviousSlideEventDispatcher();
    }
    
    public static BaseEventDispatcher createNextSlideEventDispatcher() {
        return new NextSlideEventDispatcher();
    }
    
    public static BaseEventDispatcher createSavePresentationEventDispatcher() {
        return new SavePresentationEventDispatcher();
    }
    
    public static BaseEventDispatcher createClosePresentationEventDispatcher() {
        return new ClosePresentationEventDispatcher();
    }
    
    public static BaseEventDispatcher createUpdateDrawnAnnotationEventDispatcher() {
        return new UpdateDrawnAnnotationEventDispatcher();
    }
    
    public static BaseEventDispatcher createCreateDrawnAnnotationEventDispatcher() {
        return new CreateDrawnAnnotationEventDispatcher();
    }
    
    public static BaseEventDispatcher createDisplayCurrentSlideEventDispatcher() {
        return new DisplayCurrentSlideEventDispatcher();
    }
    
    public static BaseEventDispatcher createDisplayDrawnAnnotationEventDispatcher() {
        return new DisplayDrawnAnnotationEventDispatcher();
    }
    
    public static BaseEventDispatcher createNewPresentationEventDispatcher() {
        return new NewPresentationEventDispatcher();
    }
    
    public static BaseEventDispatcher createLoadPresentationEventDispatcher() {
        return new LoadPresentationEventDispatcher();
    }
    
    public static BaseEventDispatcher createUpdateAnnotationColorEventDispatcher() {
        return new UpdateAnnotationColorEventDispatcher();
    }
    
    public static BaseEventDispatcher createUpdateAnnotationThicknessEventDispatcher() {
        return new UpdateAnnotationThicknessEventDispatcher();
    }
    
    public static BaseEventDispatcher createUpdateAnnotationModeEventDispatcher() {
        return new UpdateAnnotationModeEventDispatcher();
    }
    
    public static BaseEventDispatcher createDisplayPresentationTitleEventDispatcher() {
        return new DisplayPresentationTitleEventDispatcher();
    }
}
