/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.LoadPresentationEvent;
import events.listeners.LoadPresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class LoadPresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            LoadPresentationEventListener listener_ = (LoadPresentationEventListener) listener;
            listener_.eventFired((LoadPresentationEvent) event);
        }
    }
    
}
