package factories;

import controller.Controller;
import controller.MainController;
import model.MainModel;
import model.Model;
import view.SlideViewerFrame;
import view.View;

/**
 * This factory creates the main related Controller, Model and View objects.
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
