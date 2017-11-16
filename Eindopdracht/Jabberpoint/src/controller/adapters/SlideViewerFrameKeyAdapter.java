package controller.adapters;

import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import events.events.NextSlideEvent;
import events.events.PreviousSlideEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class handles the key events that are triggered on the SlideViewerFrame.
 * @author Tim
 */
public class SlideViewerFrameKeyAdapter extends KeyAdapter {
    
    /**
     * The dispatcher used to dispatch the PreviousSlideEvent event.
     */
    private BaseEventDispatcher previousSlideEventDispatcher;
    
    /**
     * The dispatcher used to dispatch the NextSlideEvent event.
     */
    private BaseEventDispatcher nextSlideEventDispatcher;
    
    /**
     * The dispatcher used to dispatch the ClosePresentationEvent event.
     */
    private BaseEventDispatcher closePresentationEventDispatcher;

    /**
     * Initialize the SlideViewerFrameKeyAdapter class.
     * @param previousSlideEventDispatcher The dispatcher used to dispatch the PreviousSlideEvent event.
     * @param nextSlideEventDispatcher The dispatcher used to dispatch the NextSlideEvent event.
     * @param closePresentationEventDispatcher The dispatcher used to dispatch the ClosePresentationEvent event.
     */
    public SlideViewerFrameKeyAdapter(BaseEventDispatcher previousSlideEventDispatcher, BaseEventDispatcher nextSlideEventDispatcher, BaseEventDispatcher closePresentationEventDispatcher) {
        this.previousSlideEventDispatcher = previousSlideEventDispatcher;
        this.nextSlideEventDispatcher = nextSlideEventDispatcher;
        this.closePresentationEventDispatcher = closePresentationEventDispatcher;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                this.nextSlideEventDispatcher.fire(new NextSlideEvent(this));
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                this.previousSlideEventDispatcher.fire(new PreviousSlideEvent(this));
                break;
            case 'q':
            case 'Q':
                this.closePresentationEventDispatcher.fire(new ClosePresentationEvent(this));
                break;
            default:
                break;
        }
    }
    
    
}
