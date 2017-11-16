package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.NewPresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the operations that need to be executed to create a new presentation.
 * @author Tim
 */
public class NewPresentationActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the NewPresentationEvent event.
     */
    private BaseEventDispatcher newPresentationEventDispatcher;

    /**
     * Initialize the NewPresentationActionListener class.
     * @param newPresentationEventDispatcher The dispatcher used to dispatch the NewPresentationEvent event.
     */
    public NewPresentationActionListener(BaseEventDispatcher newPresentationEventDispatcher) {
        this.newPresentationEventDispatcher = newPresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.newPresentationEventDispatcher.fire(new NewPresentationEvent(this));
    }
}
