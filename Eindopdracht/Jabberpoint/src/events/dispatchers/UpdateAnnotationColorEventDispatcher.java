/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.UpdateAnnotationColorEvent;
import events.listeners.UpdateAnnotationColorEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class UpdateAnnotationColorEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateAnnotationColorEventListener listener_ = (UpdateAnnotationColorEventListener) listener;
            listener_.eventFired((UpdateAnnotationColorEvent) event);
        }
    }
    
}
