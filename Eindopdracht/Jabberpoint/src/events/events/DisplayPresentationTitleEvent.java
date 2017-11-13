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
public class DisplayPresentationTitleEvent extends EventObject {
    
    private String presentationTitle;

    public DisplayPresentationTitleEvent(Object source, String presentationTitle) {
        super(source);
        this.presentationTitle = presentationTitle;
    }

    public String getPresentationTitle() {
        return presentationTitle;
    }
}
