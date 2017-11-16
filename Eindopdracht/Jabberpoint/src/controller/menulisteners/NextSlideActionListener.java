package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.NextSlideEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the operations that need to be executed to navigate to the next slide.
 * @author Tim
 */
public class NextSlideActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the NextSlideEvent event.
     */
    private BaseEventDispatcher nextSlideEventDispatcher;

    /**
     * Initialize the NextSlideActionListener class.
     * @param nextSlideEventDispatcher The dispatcher used to dispatch the NextSlideEvent event.
     */
    public NextSlideActionListener(BaseEventDispatcher nextSlideEventDispatcher) {
        this.nextSlideEventDispatcher = nextSlideEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nextSlideEventDispatcher.fire(new NextSlideEvent(this));
    }
}
