/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.PreviousSlideEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class PreviousSlideActionListener implements ActionListener {
    
    private BaseEventDispatcher previousSlideEventDispatcher;

    public PreviousSlideActionListener(BaseEventDispatcher previousSlideEventDispatcher) {
        this.previousSlideEventDispatcher = previousSlideEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.previousSlideEventDispatcher.fire(new PreviousSlideEvent(this));
    }
}
