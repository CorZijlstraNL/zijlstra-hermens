/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.listeners;

import events.events.ClosePresentationEvent;
import java.util.EventListener;

/**
 *
 * @author Tim
 */
public interface ClosePresentationEventListener extends EventListener {
    public void eventFired(ClosePresentationEvent event);
}
