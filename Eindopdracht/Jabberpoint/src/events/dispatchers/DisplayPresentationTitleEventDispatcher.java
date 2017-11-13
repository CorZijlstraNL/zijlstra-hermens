/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import events.events.DisplayPresentationTitleEvent;
import events.listeners.DisplayPresentationTitleEventListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class DisplayPresentationTitleEventDispatcher extends BaseEventDispatcher {

    @Override
    public void fire(EventObject event) {
        for(EventListener listener : this.listenerList) {
            DisplayPresentationTitleEventListener listener_ = (DisplayPresentationTitleEventListener) listener;
            listener_.eventFired((DisplayPresentationTitleEvent) event);
        }
    }
    
}
