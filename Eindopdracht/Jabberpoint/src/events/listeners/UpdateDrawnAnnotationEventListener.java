/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.listeners;

import events.events.UpdateDrawnAnnotationEvent;
import java.util.EventListener;

/**
 *
 * @author Tim
 */
public interface UpdateDrawnAnnotationEventListener extends EventListener {
    public void eventFired(UpdateDrawnAnnotationEvent event);
}
