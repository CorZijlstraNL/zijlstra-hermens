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
public class LoadPresentationEvent extends EventObject {
    
    private String presentationPath;
    
    public LoadPresentationEvent(Object source, String presentationPath) {
        super(source);
        this.presentationPath = presentationPath;
    }

    public String getPresentationPath() {
        return presentationPath;
    }
}
