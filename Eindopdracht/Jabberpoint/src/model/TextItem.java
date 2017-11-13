/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.drawlogic.SlideItemDrawLogic;
import model.drawlogic.TextItemDrawLogic;

/**
 *
 * @author Tim
 */
public class TextItem extends SlideItem {

    private String text;
    
    public TextItem(int nestingLevel, String text) {
        super(nestingLevel);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public SlideItemDrawLogic createDrawLogic() {
        return new TextItemDrawLogic(this);
    }
    
}
