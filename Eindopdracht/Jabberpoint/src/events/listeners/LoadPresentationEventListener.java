/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.listeners;

import events.events.LoadPresentationEvent;
import java.util.EventListener;

/**
 *
 * @author Tim
 */
public interface LoadPresentationEventListener extends EventListener {
    public void eventFired(LoadPresentationEvent event);
}