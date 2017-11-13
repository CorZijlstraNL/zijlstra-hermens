/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import controller.Controller;
import controller.MainController;
import model.MainModel;
import model.Model;
import view.SlideViewerFrame;
import view.View;

/**
 *
 * @author Tim
 */
public class MainMVCFactory extends MVCFactory {

    @Override
    public Controller createController(MVCFactory factory) {
        return new MainController(factory);
    }

    @Override
    public Model createModel() {
        return new MainModel();
    }

    @Override
    public View createView() {
        return new SlideViewerFrame();
    }
    
}
