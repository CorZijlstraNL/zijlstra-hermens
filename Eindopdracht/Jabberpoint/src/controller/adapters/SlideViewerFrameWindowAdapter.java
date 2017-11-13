/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adapters;

import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Tim
 */
public class SlideViewerFrameWindowAdapter extends WindowAdapter {
    
    private BaseEventDispatcher closePresentationEventDispatcher;

    public SlideViewerFrameWindowAdapter(BaseEventDispatcher closePresentationEventDispatcher) {
        this.closePresentationEventDispatcher = closePresentationEventDispatcher;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.closePresentationEventDispatcher.fire(new ClosePresentationEvent(this));
    }
}
