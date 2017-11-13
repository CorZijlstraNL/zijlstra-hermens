/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import controller.Controller;
import model.Model;
import view.View;

/**
 *
 * @author Tim
 */
public abstract class MVCFactory {
    
    public static MVCFactory getDefaultFactory() {
        return new MainMVCFactory();
    }
    
    public abstract Controller createController(MVCFactory factory);
    
    public abstract Model createModel();
    
    public abstract View createView();
}
