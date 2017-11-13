/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwrite;

import model.Presentation;
import readwrite.format.Format;

/**
 *
 * @author Tim
 */
public class Writer {
    
    private Format format;

    public Writer(Format format) {
        this.format = format;
    }
    
    public void write(Presentation presentation, String path) {
        boolean fileOpened = this.format.open(path, false);
        
        if (fileOpened) {
            this.format.writeBegin();
            this.format.writePresentationTitle(presentation.getTitle());
            this.format.writeSlides(presentation.getSlides());
            this.format.writeEnd();
            this.format.close();
        }
    }
}
