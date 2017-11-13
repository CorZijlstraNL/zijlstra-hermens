/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.UpdateAnnotationColorEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

/**
 *
 * @author Tim
 */
public class SelectAnnotationColorActionListener implements ActionListener {
    
    private static final String TITLE = "Color chooser";
    
    private BaseEventDispatcher updateAnnotationColorEventDispatcher;

    public SelectAnnotationColorActionListener(BaseEventDispatcher updateAnnotationColorEventDispatcher) {
        this.updateAnnotationColorEventDispatcher = updateAnnotationColorEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color annotationColor = JColorChooser.showDialog(null, TITLE, Color.BLACK);
        if(annotationColor != null) {
            this.updateAnnotationColorEventDispatcher.fire(new UpdateAnnotationColorEvent(this, annotationColor));
        }
    }
}
