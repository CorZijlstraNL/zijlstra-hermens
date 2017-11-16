package readwrite;

import model.Presentation;
import readwrite.format.Format;

/**
 * The Reader object contains the operations to read a presentation from a specific storage format.
 * @author Tim
 */
public class Reader {
    
    /**
     * The storage format.
     */
    private Format format;

    /**
     * Initialize the Reader object.
     * @param format The storage format to read the presentation from.
     */
    public Reader(Format format) {
        this.format = format;
    }
    
    /**
     * Read the presentation from a specific storage format.
     * @param path The location of the presentation file.
     * @return The read presentation.
     */
    public Presentation read(String path) {
        boolean fileOpened = this.format.open(path, true);
        
        // Only read the file if it was succesfully opened.
        if(fileOpened) {
            this.format.readBegin();
            this.format.readPresentationTitle();
            this.format.readSlides();
            this.format.close();
        }
        
        return this.format.readEnd();
    }
}
