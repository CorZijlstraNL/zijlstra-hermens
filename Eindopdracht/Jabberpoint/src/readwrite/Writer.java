package readwrite;

import model.Presentation;
import readwrite.format.Format;

/**
 * The Writer object contains the operations to write a presentation to a specific storage format.
 * @author Tim
 */
public class Writer {
    
    /**
     * The storage format.
     */
    private Format format;

    /**
     * Initialize the Writer object.
     * @param format The storage format to write the presentation to.
     */
    public Writer(Format format) {
        this.format = format;
    }
    
    /**
     * Write the presentation to a specific storage format.
     * @param presentation The Presentation object to write.
     * @param path The location to write the presentation to.
     */
    public void write(Presentation presentation, String path) {
        boolean fileOpened = this.format.open(path, false);
        
        // Only write the presentation if the file to write to was succesfully opened.
        if (fileOpened) {
            this.format.writeBegin();
            this.format.writePresentationTitle(presentation.getTitle());
            this.format.writeSlides(presentation.getSlides());
            this.format.writeEnd();
            this.format.close();
        }
    }
}
