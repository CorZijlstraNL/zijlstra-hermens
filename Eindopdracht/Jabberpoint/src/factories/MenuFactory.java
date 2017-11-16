package factories;

import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;

/**
 * This factory creates the components to build a MenuBar object with.
 * @author Tim
 */
public class MenuFactory {
    
    /**
     * Create a pull-down Menu component for a MenuBar object.
     * @param name The name of the Menu component.
     * @return The Menu component of a MenuBar object.
     */
    public static Menu createMenu(String name) {
        return new Menu(name);
    }
    
    /**
     * Create a MenuItem component for a Menu object.
     * @param name The name of the MenuItem component.
     * @param shortcut The shortcut that can be used to activate the MenuItem.
     * @return The MenuItem component for a Menu object.
     */
    public static MenuItem createMenuItem(String name, char shortcut) {
        return new MenuItem(name, new MenuShortcut(shortcut));
    }
    
    /**
     * Create a CheckboxMenuItem component for a Menu object.
     * @param name The name of the CheckboxMenuItem component.
     * @param state The initial state of the CheckboxMenuItem component which indicates if the
     * menu item is activated or not.
     * @return The CheckboxMenuItem component for a Menu object.
     */
    public static CheckboxMenuItem createCheckboxMenuItem(String name, boolean state) {
        return new CheckboxMenuItem(name, state);
    }
}
