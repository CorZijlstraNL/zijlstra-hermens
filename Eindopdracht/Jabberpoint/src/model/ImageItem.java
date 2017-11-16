package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.drawlogic.ImageItemDrawLogic;
import model.drawlogic.SlideItemDrawLogic;

/**
 * The ImageItem represents an image element on a slide.
 * @author Tim
 */
public class ImageItem extends SlideItem {

    /**
     * The full image name.
     */
    private String imageName;
    
    /**
     * The data of the image.
     */
    private BufferedImage bufferedImage;
    
    // Parts of messages when the image file cannot be found
    private static final String FILE = "Bestand ";
    private static final String NOTFOUND = " niet gevonden";
    
    /**
     * Initialize the ImageItem object.
     * @param nestingLevel The nesting level of the object.
     * @param imageName The full image name.
     */
    public ImageItem(int nestingLevel, String imageName) {
        super(nestingLevel);
        this.imageName = imageName;
        
        try {
            this.bufferedImage = ImageIO.read(new File(imageName));
        } catch (IOException ex) {
            System.err.println(FILE + imageName + NOTFOUND);
        }
    }

    /**
     * Retrieve the full image name.
     * @return The full image name.
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Retrieve the data of the image.
     * @return The data of the image.
     */
    public BufferedImage getImage() {
        return bufferedImage;
    }

    @Override
    public SlideItemDrawLogic createDrawLogic() {
        return new ImageItemDrawLogic(this);
    }
    
    @Override
    public String toString() {
        return "ImageItem[" + getNestingLevel() + "," + imageName + "]";
    }
}
