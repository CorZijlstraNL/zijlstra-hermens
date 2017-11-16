package controller.adapters;

import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class handles the window events that are triggered on the SlideViewerFrame.
 * @author Tim
 */
public class SlideViewerFrameWindowAdapter extends WindowAdapter {
    
    /**
     * The dispatcher used to dispatch the ClosePresentationEvent event.
     */
    private BaseEventDispatcher closePresentationEventDispatcher;

    /**
     * Initialize the SlideViewerFrameWindowAdapter class.
     * @param closePresentationEventDispatcher The dispatcher used to dispatch the ClosePresentationEvent event.
     */
    public SlideViewerFrameWindowAdapter(BaseEventDispatcher closePresentationEventDispatcher) {
        this.closePresentationEventDispatcher = closePresentationEventDispatcher;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.closePresentationEventDispatcher.fire(new ClosePresentationEvent(this));
    }
}
