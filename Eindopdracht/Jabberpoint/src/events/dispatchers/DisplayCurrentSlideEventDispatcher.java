/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.DisplayCurrentSlideEvent;
import events.listeners.DisplayCurrentSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class DisplayCurrentSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            DisplayCurrentSlideEventListener listener_ = (DisplayCurrentSlideEventListener) listener;
            listener_.eventFired((DisplayCurrentSlideEvent) event);
        }
    }
    
}
