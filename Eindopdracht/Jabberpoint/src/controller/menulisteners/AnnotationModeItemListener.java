/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menulisteners;

import events.dispatchers.BaseEventDispatcher;
import events.events.UpdateAnnotationModeEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Tim
 */
public class AnnotationModeItemListener implements ItemListener {

    private BaseEventDispatcher updateAnnotationModeEventDispatcher;

    public AnnotationModeItemListener(BaseEventDispatcher updateAnnotationModeEventDispatcher) {
        this.updateAnnotationModeEventDispatcher = updateAnnotationModeEventDispatcher;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.updateAnnotationModeEventDispatcher.fire(new UpdateAnnotationModeEvent(this));
    }
}
