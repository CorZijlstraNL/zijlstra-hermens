/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.UpdateAnnotationModeEvent;
import events.listeners.UpdateAnnotationModeEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class UpdateAnnotationModeEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateAnnotationModeEventListener listener_ = (UpdateAnnotationModeEventListener) listener;
            listener_.eventFired((UpdateAnnotationModeEvent) event);
        }
    }
    
}
