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
public class Reader {
    
    private Format format;

    public Reader(Format format) {
        this.format = format;
    }
    
    public Presentation read(String path) {
        boolean fileOpened = this.format.open(path, true);
        
        if(fileOpened) {
            this.format.readBegin();
            this.format.readPresentationTitle();
            this.format.readSlides();
            this.format.close();
        }
        
        return this.format.readEnd();
    }
}
