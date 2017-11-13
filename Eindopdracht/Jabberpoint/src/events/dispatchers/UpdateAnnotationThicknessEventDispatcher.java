/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.UpdateAnnotationThicknessEvent;
import events.listeners.UpdateAnnotationThicknessEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class UpdateAnnotationThicknessEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            UpdateAnnotationThicknessEventListener listener_ = (UpdateAnnotationThicknessEventListener) listener;
            listener_.eventFired((UpdateAnnotationThicknessEvent) event);
        }
    }
    
}
