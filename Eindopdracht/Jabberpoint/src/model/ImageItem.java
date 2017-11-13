/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.drawlogic.ImageItemDrawLogic;
import model.drawlogic.SlideItemDrawLogic;

/**
 *
 * @author Tim
 */
public class ImageItem extends SlideItem {

    private String imageName;
    private BufferedImage bufferedImage;
    
    private static final String FILE = "Bestand ";
    private static final String NOTFOUND = " niet gevonden";
    
    public ImageItem(int nestingLevel, String imageName) {
        super(nestingLevel);
        this.imageName = imageName;
        
        try {
            this.bufferedImage = ImageIO.read(new File(imageName));
        } catch (IOException ex) {
            System.err.println(FILE + imageName + NOTFOUND);
        }
    }

    public String getImageName() {
        return imageName;
    }

    public BufferedImage getImage() {
        return bufferedImage;
    }

    @Override
    public SlideItemDrawLogic createDrawLogic() {
        return new ImageItemDrawLogic(this);
    }
    
}
