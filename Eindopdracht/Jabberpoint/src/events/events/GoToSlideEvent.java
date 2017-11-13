/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events.events;

import java.util.EventObject;

/**
 *
 * @author Tim
 */
public class GoToSlideEvent extends EventObject {
    
    private int slideNumber;
    
    public GoToSlideEvent(Object source, int slideNumber) {
        super(source);
        this.slideNumber = slideNumber;
    }

    public int getSlideNumber() {
        return slideNumber;
    }
}
