package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the operations that need to be executed to close the presentation.
 * @author Tim
 */
public class ClosePresentationActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the ClosePresentationEvent event.
     */
    private BaseEventDispatcher closePresentationEventDispatcher;

    /**
     * Initialize the ClosePresentationActionListener class.
     * @param closePresentationEventDispatcher The dispatcher used to dispatch the ClosePresentationEvent event.
     */
    public ClosePresentationActionListener(BaseEventDispatcher closePresentationEventDispatcher) {
        this.closePresentationEventDispatcher = closePresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.closePresentationEventDispatcher.fire(new ClosePresentationEvent(this));
    }
}
