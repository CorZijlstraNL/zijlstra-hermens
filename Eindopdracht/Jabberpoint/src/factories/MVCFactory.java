package factories;

import controller.Controller;
import model.Model;
import view.View;

/**
 * This factory creates related Controller, Model and View objects.
 * @author Tim
 */
public abstract class MVCFactory {
    
    /**
     * Create the default MVCFactory concrete factory.
     * @return The default MVCFactory concrete factory.
     */
    public static MVCFactory getDefaultFactory() {
        return new MainMVCFactory();
    }
    
    /**
     * Create the Controller object.
     * @param factory The factory the Controller object uses to create the Model and View objects.
     * @return The Controller object.
     */
    public abstract Controller createController(MVCFactory factory);
    
    /**
     * Create the Model object.
     * @return The Model object.
     */
    public abstract Model createModel();
    
    /**
     * Create the View object.
     * @return The View object.
     */
    public abstract View createView();
}
