package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.UpdateAnnotationColorEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;

/**
 * This class contains the operations that need to be executed to update the annotation color.
 * @author Tim
 */
public class SelectAnnotationColorActionListener implements ActionListener {
    
    /**
     * The dispatcher used to dispatch the UpdateAnnotationColorEvent event.
     */
    private BaseEventDispatcher updateAnnotationColorEventDispatcher;

    /**
     * Initialize the SelectAnnotationColorActionListener event.
     * @param updateAnnotationColorEventDispatcher The dispatcher used to dispatch the UpdateAnnotationColorEvent event.
     */
    public SelectAnnotationColorActionListener(BaseEventDispatcher updateAnnotationColorEventDispatcher) {
        this.updateAnnotationColorEventDispatcher = updateAnnotationColorEventDispatcher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color annotationColor = JColorChooser.showDialog(null, "Color chooser", Color.BLACK);
        if(annotationColor != null) {
            this.updateAnnotationColorEventDispatcher.fire(new UpdateAnnotationColorEvent(this, annotationColor));
        }
    }
}
