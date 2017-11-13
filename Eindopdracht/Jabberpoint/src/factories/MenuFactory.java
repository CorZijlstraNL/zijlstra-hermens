/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.awt.CheckboxMenuItem;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;

/**
 *
 * @author Tim
 */
public class MenuFactory {
    
    public static Menu createMenu(String name) {
        return new Menu(name);
    }
    
    public static MenuItem createMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
    
    public static CheckboxMenuItem createCheckboxMenuItem(String name, boolean state) {
        return new CheckboxMenuItem(name, state);
    }
}
