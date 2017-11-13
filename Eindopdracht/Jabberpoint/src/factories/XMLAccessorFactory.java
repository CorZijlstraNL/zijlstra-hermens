/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import readwrite.Reader;
import readwrite.Writer;
import readwrite.builder.PresentationBuilder;
import readwrite.format.XMLFormat;

/**
 *
 * @author Tim
 */
public class XMLAccessorFactory extends AccessorFactory {

    @Override
    public Reader createReader() {
        return new Reader(new XMLFormat(new PresentationBuilder()));
    }

    @Override
    public Writer createWriter() {
        return new Writer(new XMLFormat(new PresentationBuilder()));
    }
    
}
