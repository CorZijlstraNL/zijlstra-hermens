/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.NewPresentationEvent;
import events.listeners.NewPresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class NewPresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            NewPresentationEventListener listener_ = (NewPresentationEventListener) listener;
            listener_.eventFired((NewPresentationEvent) event);
        }
    }
    
}
