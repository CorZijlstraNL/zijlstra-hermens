package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.UpdateAnnotationThicknessEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * This class contains the operations that need to be executed to update the annotation thickness.
 * @author Tim
 */
public class SelectAnnotationThicknessActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the UpdateAnnotationThicknessEvent event.
     */
    private BaseEventDispatcher updateAnnotationThicknessEventDispatcher;

    /**
     * Initialize the SelectAnnotationThicknessActionListener class.
     * @param updateAnnotationThicknessEventDispatcher The dispatcher used to dispatch the UpdateAnnotationThicknessEvent event.
     */
    public SelectAnnotationThicknessActionListener(BaseEventDispatcher updateAnnotationThicknessEventDispatcher) {
        this.updateAnnotationThicknessEventDispatcher = updateAnnotationThicknessEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String annotationThicknessString = JOptionPane.showInputDialog("Annotation line thickness?");
        
        if(annotationThicknessString != null) {
            try {
                int annotationThickness = Integer.parseInt(annotationThicknessString);
                if(annotationThickness >= 1) {
                    this.updateAnnotationThicknessEventDispatcher.fire(new UpdateAnnotationThicknessEvent(this, annotationThickness));
                }
            }
            catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, 
                        "The input must be a number.",
                        "Invalid input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
