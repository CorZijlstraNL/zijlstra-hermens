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
 * This class handles the mouse events that are triggered on the SlideViewerComponent. 
 * Annotations are drawn depending on the annotation mode.
 * @author Tim
 */
public class SlideViewerComponentMouseAdapter extends MouseAdapter implements MouseMotionListener, MouseListener, UpdateAnnotationModeEventListener {
    
    /**
     * Indicates if the annotation mode is enabled.
     */
    private boolean annotationModeIsEnabled;
    
    /**
     * The drawn annotation points.
     */
    private List<Point> annotationPoints;
    
    /**
     * The dispatcher used to dispatch the UpdateDrawnAnnotationEvent event.
     */
    private BaseEventDispatcher updateDrawnAnnotationEventDispatcher;
    
    /**
     * The dispatcher used to dispatch the CreateDrawnAnnotationEvent event.
     */
    private BaseEventDispatcher createDrawnAnnotationEventDispatcher;

    /**
     * Initialize the SlideViewerComponentMouseAdapter class. 
     * @param annotationModeIsEnabled The initial annotation mode.
     * @param updateDrawnAnnotationEventDispatcher The dispatcher used to dispatch the UpdateDrawnAnnotationEvent event.
     * @param createDrawnAnnotationEventDispatcher The dispatcher used to dispatch the CreateDrawnAnnotationEvent event.
     */
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
    
    /**
     * Initialize a new list to store the annotation points.
     */
    private void resetAnnotationPoints() {
        this.annotationPoints = new ArrayList();
    }
    
    /**
     * Add a new annotation point.
     * @param point The new annotation point.
     */
    private void addAnnotationPoint(Point point) {
        this.annotationPoints.add(point);
        // Send the new point to be drawn on the SlideViewerComponent.
        this.updateDrawnAnnotationEventDispatcher.fire(new UpdateDrawnAnnotationEvent(this, this.annotationPoints));
    }
    
    /**
     * Create the annotation.
     */
    private void createAnnotation() {
        this.createDrawnAnnotationEventDispatcher.fire(new CreateDrawnAnnotationEvent(this, this.annotationPoints));
        this.resetAnnotationPoints();
    }

    @Override
    public void eventFired(UpdateAnnotationModeEvent event) {
        // Change the annotation mode
        this.annotationModeIsEnabled = !this.annotationModeIsEnabled;
    }
}
