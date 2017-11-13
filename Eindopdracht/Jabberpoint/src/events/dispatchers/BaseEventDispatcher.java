/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.dispatchers;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author Tim
 */
public abstract class BaseEventDispatcher {
    protected List<EventListener> listenerList = new ArrayList();

    public void addListener(EventListener listener) {
        listenerList.add(listener);
    }
    
    public void removeListener(EventListener listener) {
        listenerList.remove(listener);
    }

    public abstract void fire(EventObject event);
}
