/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.CreateDrawnAnnotationEvent;
import events.listeners.CreateDrawnAnnotationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class CreateDrawnAnnotationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            CreateDrawnAnnotationEventListener listener_ = (CreateDrawnAnnotationEventListener) listener;
            listener_.eventFired((CreateDrawnAnnotationEvent) event);
        }
    }
    
}
