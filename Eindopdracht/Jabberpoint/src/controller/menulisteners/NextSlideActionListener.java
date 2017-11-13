/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.NextSlideEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tim
 */
public class NextSlideActionListener implements ActionListener {
    
    private BaseEventDispatcher nextSlideEventDispatcher;

    public NextSlideActionListener(BaseEventDispatcher nextSlideEventDispatcher) {
        this.nextSlideEventDispatcher = nextSlideEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nextSlideEventDispatcher.fire(new NextSlideEvent(this));
    }
}
