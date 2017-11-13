/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.UpdateAnnotationThicknessEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class SelectAnnotationThicknessActionListener implements ActionListener {
    
    private static final String ANNOTATION_THICKNESS = "Annotation line thickness?";
    
    private BaseEventDispatcher updateAnnotationThicknessEventDispatcher;

    public SelectAnnotationThicknessActionListener(BaseEventDispatcher updateAnnotationThicknessEventDispatcher) {
        this.updateAnnotationThicknessEventDispatcher = updateAnnotationThicknessEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String annotationThicknessString = JOptionPane.showInputDialog(ANNOTATION_THICKNESS);
        try {
            int annotationThickness = Integer.parseInt(annotationThicknessString);
            if(annotationThickness >= 1) {
                this.updateAnnotationThicknessEventDispatcher.fire(new UpdateAnnotationThicknessEvent(this, annotationThickness));
            }
        }
        catch (NumberFormatException exception) {
            System.err.println(exception.toString());
        }
    }
}
