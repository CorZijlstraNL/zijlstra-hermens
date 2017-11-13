/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.ClosePresentationEvent;
import events.listeners.ClosePresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class ClosePresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            ClosePresentationEventListener listener_ = (ClosePresentationEventListener) listener;
            listener_.eventFired((ClosePresentationEvent) event);
        }
    }
    
}
