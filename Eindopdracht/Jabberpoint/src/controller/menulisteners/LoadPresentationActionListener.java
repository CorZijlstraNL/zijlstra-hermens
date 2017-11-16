package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.LoadPresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the operations that need to be executed to load a presentation.
 * @author Tim
 */
public class LoadPresentationActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the LoadPresentationEvent event.
     */
    private BaseEventDispatcher loadPresentationEventDispatcher;

    /**
     * Initialize the LoadPresentationActionListener class.
     * @param loadPresentationEventDispatcher The dispatcher used to dispatch the LoadPresentationEvent event.
     */
    public LoadPresentationActionListener(BaseEventDispatcher loadPresentationEventDispatcher) {
        this.loadPresentationEventDispatcher = loadPresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use a null value for now to load the test presentation only...
        this.loadPresentationEventDispatcher.fire(new LoadPresentationEvent(this, null));
    }
}
