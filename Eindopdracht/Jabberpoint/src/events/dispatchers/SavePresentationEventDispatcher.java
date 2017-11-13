/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.SavePresentationEvent;
import events.listeners.SavePresentationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class SavePresentationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            SavePresentationEventListener listener_ = (SavePresentationEventListener) listener;
            listener_.eventFired((SavePresentationEvent) event);
        }
    }
    
}
