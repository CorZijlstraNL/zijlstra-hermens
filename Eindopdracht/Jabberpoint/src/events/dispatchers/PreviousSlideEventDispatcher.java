/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.PreviousSlideEvent;
import events.listeners.PreviousSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class PreviousSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            PreviousSlideEventListener listener_ = (PreviousSlideEventListener) listener;
            listener_.eventFired((PreviousSlideEvent) event);
        }
    }
    
}
