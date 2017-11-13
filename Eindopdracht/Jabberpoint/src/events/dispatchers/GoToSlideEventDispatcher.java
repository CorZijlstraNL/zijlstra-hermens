/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.GoToSlideEvent;
import events.listeners.GoToSlideEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class GoToSlideEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            GoToSlideEventListener listener_ = (GoToSlideEventListener) listener;
            listener_.eventFired((GoToSlideEvent) event);
        }
    }
    
}
