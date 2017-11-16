package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.UpdateAnnotationModeEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class contains the operations that need to be executed to change the Annotation mode state.
 * @author Tim
 */
public class AnnotationModeItemListener implements ItemListener {

    /**
     * The dispatcher used to dispatch the UpdateAnnotationModeEvent event.
     */
    private BaseEventDispatcher updateAnnotationModeEventDispatcher;

    /**
     * Initialize the AnnotationModeItemListener class.
     * @param updateAnnotationModeEventDispatcher The dispatcher used to dispatch the UpdateAnnotationModeEvent event.
     */
    public AnnotationModeItemListener(BaseEventDispatcher updateAnnotationModeEventDispatcher) {
        this.updateAnnotationModeEventDispatcher = updateAnnotationModeEventDispatcher;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // change the annotation mode
        this.updateAnnotationModeEventDispatcher.fire(new UpdateAnnotationModeEvent(this));
    }
}
