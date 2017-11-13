/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.SavePresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class SavePresentationActionListener implements ActionListener {
    
    private BaseEventDispatcher savePresentationEventDispatcher;

    public SavePresentationActionListener(BaseEventDispatcher savePresentationEventDispatcher) {
        this.savePresentationEventDispatcher = savePresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use a null value for now to save the presentation to a default path...
        this.savePresentationEventDispatcher.fire(new SavePresentationEvent(this, null));
    }
}
