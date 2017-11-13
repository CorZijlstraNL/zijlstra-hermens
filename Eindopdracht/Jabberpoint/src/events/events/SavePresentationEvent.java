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
public class SavePresentationEvent extends EventObject {
    
    private String saveLocation;
    
    public SavePresentationEvent(Object source, String saveLocation) {
        super(source);
        this.saveLocation = saveLocation;
    }

    public String getSaveLocation() {
        return saveLocation;
    }
}
