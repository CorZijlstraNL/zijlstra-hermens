/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.NextSlideEvent;
import events.listeners.NextSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class NextSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            NextSlideEventListener listener_ = (NextSlideEventListener) listener;
            listener_.eventFired((NextSlideEvent) event);
        }
    }
    
}
