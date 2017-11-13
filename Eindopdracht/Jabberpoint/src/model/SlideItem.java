/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.drawlogic.SlideItemDrawLogic;

/**
 *
 * @author Tim
 */
public abstract class SlideItem {
    
    private int nestingLevel;

    protected SlideItem(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    public int getNestingLevel() {
        return nestingLevel;
    }
    
    public abstract SlideItemDrawLogic createDrawLogic();
}
