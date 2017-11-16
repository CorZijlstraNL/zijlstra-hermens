package factories;

import readwrite.Reader;
import readwrite.Writer;

/**
 * This factory creates related Reader and Writer objects based on the path.
 * @author Tim
 */
public abstract class AccessorFactory {
    
    /**
     * The XML file type.
     */
    private static final String XML = "xml";
    
    /**
     * Create the concrete AccessorFactory depending on the path.
     * @param path The path pointing to a presentation file.
     * @return The concrete AccessorFactory.
     */
    public static AccessorFactory getFactory(String path) {
        AccessorFactory factory = null;
        
        int dotIndex = path.lastIndexOf(".") + 1;
        String fileExtension = path.substring(dotIndex);
        
        if(XML.equalsIgnoreCase(fileExtension)) {
            factory = new XMLAccessorFactory();
        }
        
        return factory;
    }
    
    /**
     * Create the concrete Reader.
     * @return The concrete Reader.
     */
    public abstract Reader createReader();
    
    /**
     * Create the concrete Writer.
     * @return The concrete Writer.
     */
    public abstract Writer createWriter();
}
