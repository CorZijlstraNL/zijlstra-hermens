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
 * This factory creates all the BaseEventDispatcher objects.
 * @author Tim
 */
public class EventDispatcherFactory {
    
    /**
     * Create the GoToSlideEventDispatcher.
     * @return The GoToSlideEventDispatcher.
     */
    public static BaseEventDispatcher createGoToSlideEventDispatcher() {
        return new GoToSlideEventDispatcher();
    }
    
    /**
     * Create the PreviousSlideEventDispatcher.
     * @return The PreviousSlideEventDispatcher.
     */
    public static BaseEventDispatcher createPreviousSlideEventDispatcher() {
        return new PreviousSlideEventDispatcher();
    }
    
    /**
     * Create the NextSlideEventDispatcher
     * @return The NextSlideEventDispatcher.
     */
    public static BaseEventDispatcher createNextSlideEventDispatcher() {
        return new NextSlideEventDispatcher();
    }
    
    /**
     * Create the SavePresentationEventDispatcher.
     * @return The SavePresentationEventDispatcher.
     */
    public static BaseEventDispatcher createSavePresentationEventDispatcher() {
        return new SavePresentationEventDispatcher();
    }
    
    /**
     * Create the ClosePresentationEventDispatcher.
     * @return The ClosePresentationEventDispatcher.
     */
    public static BaseEventDispatcher createClosePresentationEventDispatcher() {
        return new ClosePresentationEventDispatcher();
    }
    
    /**
     * Create the UpdateDrawnAnnotationEventDispatcher.
     * @return The UpdateDrawnAnnotationEventDispatcher.
     */
    public static BaseEventDispatcher createUpdateDrawnAnnotationEventDispatcher() {
        return new UpdateDrawnAnnotationEventDispatcher();
    }
    
    /**
     * Create the CreateDrawnAnnotationEventDispatcher.
     * @return The CreateDrawnAnnotationEventDispatcher.
     */
    public static BaseEventDispatcher createCreateDrawnAnnotationEventDispatcher() {
        return new CreateDrawnAnnotationEventDispatcher();
    }
    
    /**
     * Create the DisplayCurrentSlideEventDispatcher.
     * @return The DisplayCurrentSlideEventDispatcher.
     */
    public static BaseEventDispatcher createDisplayCurrentSlideEventDispatcher() {
        return new DisplayCurrentSlideEventDispatcher();
    }
    
    /**
     * Create the DisplayDrawnAnnotationEventDispatcher.
     * @return The DisplayDrawnAnnotationEventDispatcher.
     */
    public static BaseEventDispatcher createDisplayDrawnAnnotationEventDispatcher() {
        return new DisplayDrawnAnnotationEventDispatcher();
    }
    
    /**
     * Create the NewPresentationEventDispatcher.
     * @return The NewPresentationEventDispatcher.
     */
    public static BaseEventDispatcher createNewPresentationEventDispatcher() {
        return new NewPresentationEventDispatcher();
    }
    
    /**
     * Create the LoadPresentationEventDispatcher.
     * @return The LoadPresentationEventDispatcher.
     */
    public static BaseEventDispatcher createLoadPresentationEventDispatcher() {
        return new LoadPresentationEventDispatcher();
    }
    
    /**
     * Create the UpdateAnnotationColorEventDispatcher.
     * @return The UpdateAnnotationColorEventDispatcher.
     */
    public static BaseEventDispatcher createUpdateAnnotationColorEventDispatcher() {
        return new UpdateAnnotationColorEventDispatcher();
    }
    
    /**
     * Create the UpdateAnnotationThicknessEventDispatcher.
     * @return The UpdateAnnotationThicknessEventDispatcher.
     */
    public static BaseEventDispatcher createUpdateAnnotationThicknessEventDispatcher() {
        return new UpdateAnnotationThicknessEventDispatcher();
    }
    
    /**
     * Create the UpdateAnnotationModeEventDispatcher.
     * @return The UpdateAnnotationModeEventDispatcher.
     */
    public static BaseEventDispatcher createUpdateAnnotationModeEventDispatcher() {
        return new UpdateAnnotationModeEventDispatcher();
    }
    
    /**
     * Create the DisplayPresentationTitleEventDispatcher.
     * @return The DisplayPresentationTitleEventDispatcher.
     */
    public static BaseEventDispatcher createDisplayPresentationTitleEventDispatcher() {
        return new DisplayPresentationTitleEventDispatcher();
    }
}
