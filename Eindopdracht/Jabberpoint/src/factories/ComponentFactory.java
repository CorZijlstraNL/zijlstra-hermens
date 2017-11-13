/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import view.SlideViewerComponent;

/**
 *
 * @author Tim
 */
public class ComponentFactory {
    
    public static SlideViewerComponent createSlideViewerComponent() {
        return new SlideViewerComponent();
    }
}
