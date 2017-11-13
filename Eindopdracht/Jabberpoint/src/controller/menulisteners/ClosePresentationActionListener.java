/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class ClosePresentationActionListener implements ActionListener {
    
    private BaseEventDispatcher closePresentationEventDispatcher;

    public ClosePresentationActionListener(BaseEventDispatcher closePresentationEventDispatcher) {
        this.closePresentationEventDispatcher = closePresentationEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.closePresentationEventDispatcher.fire(new ClosePresentationEvent(this));
    }
}
