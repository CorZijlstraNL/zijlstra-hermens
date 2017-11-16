package factories;

import view.SlideViewerComponent;

/**
 * This factory creates Component objects for the view-related objects.
 * @author Tim
 */
public class ComponentFactory {
    
    /**
     * Create the SlideViewerComponent.
     * @return The SlideViewerComponent.
     */
    public static SlideViewerComponent createSlideViewerComponent() {
        return new SlideViewerComponent();
    }
}
