package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.PreviousSlideEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the operations that need to be executed to navigate to the previous slide.
 * @author Tim
 */
public class PreviousSlideActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the PreviousSlideEvent event.
     */
    private BaseEventDispatcher previousSlideEventDispatcher;

    /**
     * Initialize the PreviousSlideActionListener class.
     * @param previousSlideEventDispatcher The dispatcher used to dispatch the PreviousSlideEvent event.
     */
    public PreviousSlideActionListener(BaseEventDispatcher previousSlideEventDispatcher) {
        this.previousSlideEventDispatcher = previousSlideEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.previousSlideEventDispatcher.fire(new PreviousSlideEvent(this));
    }
}
