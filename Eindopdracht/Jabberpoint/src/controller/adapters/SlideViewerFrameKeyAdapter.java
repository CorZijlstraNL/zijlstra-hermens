/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adapters;

import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import events.events.NextSlideEvent;
import events.events.PreviousSlideEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tim
 */
public class SlideViewerFrameKeyAdapter extends KeyAdapter {
    
    private BaseEventDispatcher previousSlideEventDispatcher;
    private BaseEventDispatcher nextSlideEventDispatcher;
    private BaseEventDispatcher closePresentationEventDispatcher;

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
