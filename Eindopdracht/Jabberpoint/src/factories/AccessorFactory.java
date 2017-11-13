/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import readwrite.Reader;
import readwrite.Writer;

/**
 *
 * @author Tim
 */
public abstract class AccessorFactory {
    
    private static final String XML = "xml";
    
    public static AccessorFactory getFactory(String path) {
        AccessorFactory factory = null;
        
        int dotIndex = path.lastIndexOf(".") + 1;
        String fileExtension = path.substring(dotIndex);
        
        if(XML.equalsIgnoreCase(fileExtension)) {
            factory = new XMLAccessorFactory();
        }
        
        return factory;
    }
    
    public abstract Reader createReader();
    
    public abstract Writer createWriter();
}
