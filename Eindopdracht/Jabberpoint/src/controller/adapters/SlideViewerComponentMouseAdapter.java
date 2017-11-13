/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adapters;

import events.dispatchers.BaseEventDispatcher;
import events.events.CreateDrawnAnnotationEvent;
import events.events.UpdateAnnotationModeEvent;
import events.events.UpdateDrawnAnnotationEvent;
import events.listeners.UpdateAnnotationModeEventListener;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public class SlideViewerComponentMouseAdapter extends MouseAdapter implements MouseMotionListener, MouseListener, UpdateAnnotationModeEventListener {
    
    private boolean annotationModeIsEnabled;
    
    private List<Point> annotationPoints;
    
    private BaseEventDispatcher updateDrawnAnnotationEventDispatcher;
    private BaseEventDispatcher createDrawnAnnotationEventDispatcher;

    public SlideViewerComponentMouseAdapter(boolean annotationModeIsEnabled, BaseEventDispatcher updateDrawnAnnotationEventDispatcher, BaseEventDispatcher createDrawnAnnotationEventDispatcher) {
        this.annotationModeIsEnabled = annotationModeIsEnabled;
        this.updateDrawnAnnotationEventDispatcher = updateDrawnAnnotationEventDispatcher;
        this.createDrawnAnnotationEventDispatcher = createDrawnAnnotationEventDispatcher;
        this.resetAnnotationPoints();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.annotationModeIsEnabled) {
            this.addAnnotationPoint(e.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.annotationModeIsEnabled) {
            this.createAnnotation();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.annotationModeIsEnabled) {
            this.addAnnotationPoint(e.getPoint());
        }
    }
    
    private void resetAnnotationPoints() {
        this.annotationPoints = new ArrayList();
    }
    
    private void addAnnotationPoint(Point point) {
        this.annotationPoints.add(point);
        // Send the new point to be drawn on the SlideViewerComponent.
        this.updateDrawnAnnotationEventDispatcher.fire(new UpdateDrawnAnnotationEvent(this, this.annotationPoints));
    }
    
    private void createAnnotation() {
        this.createDrawnAnnotationEventDispatcher.fire(new CreateDrawnAnnotationEvent(this, this.annotationPoints));
        this.resetAnnotationPoints();
    }

    @Override
    public void eventFired(UpdateAnnotationModeEvent event) {
        this.annotationModeIsEnabled = !this.annotationModeIsEnabled;
    }
}
