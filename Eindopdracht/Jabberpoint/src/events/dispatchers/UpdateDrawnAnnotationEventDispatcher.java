/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.UpdateDrawnAnnotationEvent;
import events.listeners.UpdateDrawnAnnotationEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class UpdateDrawnAnnotationEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateDrawnAnnotationEventListener listener_ = (UpdateDrawnAnnotationEventListener) listener;
            listener_.eventFired((UpdateDrawnAnnotationEvent) event);
        }
    }
    
}
