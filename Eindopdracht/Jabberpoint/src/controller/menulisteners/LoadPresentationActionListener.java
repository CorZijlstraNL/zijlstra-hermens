/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.LoadPresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class LoadPresentationActionListener implements ActionListener {
    
    private BaseEventDispatcher loadPresentationEventDispatcher;

    public LoadPresentationActionListener(BaseEventDispatcher loadPresentationEventDispatcher) {
        this.loadPresentationEventDispatcher = loadPresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use a null value for now to load the demo presentation only...
        this.loadPresentationEventDispatcher.fire(new LoadPresentationEvent(this, null));
    }
}
