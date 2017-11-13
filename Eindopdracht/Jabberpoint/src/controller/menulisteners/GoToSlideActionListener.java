/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.GoToSlideEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class GoToSlideActionListener implements ActionListener {
    
    private BaseEventDispatcher goToSlideEventDispatcher;
    
    private static final String SLIDE_NUMBER = "Slide number?";

    public GoToSlideActionListener(BaseEventDispatcher goToSlideEventDispatcher) {
        this.goToSlideEventDispatcher = goToSlideEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String slideNumberString = JOptionPane.showInputDialog(SLIDE_NUMBER);
        
        if(slideNumberString != null) {
            try {
                int slideNumber = Integer.parseInt(slideNumberString);
                if(slideNumber >= 1) {
                    this.goToSlideEventDispatcher.fire(new GoToSlideEvent(this, slideNumber));
                }
            }
            catch (NumberFormatException exception) {
                System.err.println(exception.toString());
            }
        }
    }
}
