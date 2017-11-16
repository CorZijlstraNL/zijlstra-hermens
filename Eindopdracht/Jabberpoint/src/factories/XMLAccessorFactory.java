package factories;

import readwrite.Reader;
import readwrite.Writer;
import readwrite.builder.PresentationBuilder;
import readwrite.format.XMLFormat;

/**
 * This factory creates the XML-related Reader and Writer objects.
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
