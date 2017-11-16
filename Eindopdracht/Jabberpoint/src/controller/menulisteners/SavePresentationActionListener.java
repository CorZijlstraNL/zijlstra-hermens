package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.SavePresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the operations that need to be executed to save the presentation.
 * @author Tim
 */
public class SavePresentationActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the SavePresentationEvent event.
     */
    private BaseEventDispatcher savePresentationEventDispatcher;

    /**
     * Initialize the SavePresentationActionListener class.
     * @param savePresentationEventDispatcher The dispatcher used to dispatch the SavePresentationEvent event.
     */
    public SavePresentationActionListener(BaseEventDispatcher savePresentationEventDispatcher) {
        this.savePresentationEventDispatcher = savePresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use a null value for now to save the presentation to a default path...
        this.savePresentationEventDispatcher.fire(new SavePresentationEvent(this, null));
    }
}
