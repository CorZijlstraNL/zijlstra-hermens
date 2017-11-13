/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.NewPresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class NewPresentationActionListener implements ActionListener {
    
    private BaseEventDispatcher newPresentationEventDispatcher;

    public NewPresentationActionListener(BaseEventDispatcher newPresentationEventDispatcher) {
        this.newPresentationEventDispatcher = newPresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.newPresentationEventDispatcher.fire(new NewPresentationEvent(this));
    }
}
