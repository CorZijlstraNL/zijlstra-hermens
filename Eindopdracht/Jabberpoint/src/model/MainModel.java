package model;

import events.dispatchers.BaseEventDispatcher;
import events.events.CreateDrawnAnnotationEvent;
import events.events.DisplayCurrentSlideEvent;
import events.events.DisplayDrawnAnnotationEvent;
import events.events.DisplayPresentationTitleEvent;
import events.events.GoToSlideEvent;
import events.events.LoadPresentationEvent;
import events.events.NewPresentationEvent;
import events.events.NextSlideEvent;
import events.events.PreviousSlideEvent;
import events.events.SavePresentationEvent;
import events.events.UpdateAnnotationColorEvent;
import events.events.UpdateAnnotationThicknessEvent;
import events.events.UpdateDrawnAnnotationEvent;
import events.listeners.CreateDrawnAnnotationEventListener;
import events.listeners.GoToSlideEventListener;
import events.listeners.LoadPresentationEventListener;
import events.listeners.NewPresentationEventListener;
import events.listeners.NextSlideEventListener;
import events.listeners.PreviousSlideEventListener;
import events.listeners.SavePresentationEventListener;
import events.listeners.UpdateAnnotationColorEventListener;
import events.listeners.UpdateAnnotationThicknessEventListener;
import events.listeners.UpdateDrawnAnnotationEventListener;
import factories.AccessorFactory;
import factories.ModelFactory;
import factories.PresentationFactory;
import java.awt.Color;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author Tim
 */
public class MainModel implements Model, GoToSlideEventListener, PreviousSlideEventListener, NextSlideEventListener,
        SavePresentationEventListener, UpdateDrawnAnnotationEventListener, CreateDrawnAnnotationEventListener,
        NewPresentationEventListener, LoadPresentationEventListener, UpdateAnnotationColorEventListener,
        UpdateAnnotationThicknessEventListener {
    
    private static final String DEMO_PRESENTATION_PATH = "test.xml";
    
    private static final String DEFAULT_SAVE_LOCATION = "dump.xml";
    
    private Presentation presentation;
    
    private AnnotationStyle annotationStyle;
    
    private SlideStyleCollection slideStyleCollection;
    
    // All the dispatchers
    private BaseEventDispatcher displayCurrentSlideEventDispatcher;
    private BaseEventDispatcher displayDrawnAnnotationEventDispatcher;
    private BaseEventDispatcher displayPresentationTitleEventDispatcher;

    public MainModel() {
        this.annotationStyle = ModelFactory.createAnnotationStyle();
        this.slideStyleCollection = ModelFactory.createSlideStyleCollection();
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public AnnotationStyle getAnnotationStyle() {
        return annotationStyle;
    }

    public SlideStyleCollection getSlideStyleCollection() {
        return slideStyleCollection;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
    
    public void loadPresentation(String presentationPath) {
        // If presentation path is null, load the demo presentation instead.
        if(presentationPath == null) {
            presentationPath = DEMO_PRESENTATION_PATH;
        }
        
        AccessorFactory factory = AccessorFactory.getFactory(presentationPath);
        if(factory != null) {
            Presentation presentation = factory.createReader().read(presentationPath);
            this.setPresentation(presentation);
            this.displayPresentationTitle();
            this.displayCurrentSlide();
        }
    }
    
    public void savePresentation(String saveLocation) {
        // If save location path is null, save the presentation in the default save location.
        if(saveLocation == null) {
            saveLocation = DEFAULT_SAVE_LOCATION;
        }
        
        AccessorFactory factory = AccessorFactory.getFactory(saveLocation);
        if(factory != null) {
            factory.createWriter().write(this.presentation, saveLocation);
        }
    }
    
    public void setEventDispatchers(BaseEventDispatcher displayCurrentSlideEventDispatcher, BaseEventDispatcher displayDrawnAnnotationEventDispatcher, 
            BaseEventDispatcher displayPresentationTitleEventDispatcher) {
        this.displayCurrentSlideEventDispatcher = displayCurrentSlideEventDispatcher;
        this.displayDrawnAnnotationEventDispatcher = displayDrawnAnnotationEventDispatcher;
        this.displayPresentationTitleEventDispatcher = displayPresentationTitleEventDispatcher;
    }
    
    private void displayCurrentSlide() {
        Slide slide = this.presentation.getCurrentSlide();
        int currentSlideNumber = this.presentation.getCurrentSlideNumber();
        int totalSlides = this.presentation.getNumberOfSlides();
        
        this.displayCurrentSlideEventDispatcher.fire(new DisplayCurrentSlideEvent(this, currentSlideNumber, totalSlides, slide, this.slideStyleCollection));
    }
    
    private void displayDrawnAnnotation(Annotation annotation) {
        this.displayDrawnAnnotationEventDispatcher.fire(new DisplayDrawnAnnotationEvent(this, annotation));
    }
    
    private void displayPresentationTitle() {
        String presentationTitle = this.presentation.getTitle();
        this.displayPresentationTitleEventDispatcher.fire(new DisplayPresentationTitleEvent(this, presentationTitle));
    }
    
    private Annotation createAnnotation(List<Point> annotationPoints) {
        Color annotationLineColor = this.annotationStyle.getLineColor();
        int annotationLineThickness = this.annotationStyle.getLineThickness();
        return PresentationFactory.createAnnotation(annotationPoints, annotationLineColor, annotationLineThickness);
    }

    @Override
    public void eventFired(GoToSlideEvent event) {
        this.presentation.setSlide(event.getSlideNumber());
        this.displayCurrentSlide();
    }

    @Override
    public void eventFired(PreviousSlideEvent event) {
        this.presentation.setPreviousSlide();
        this.displayCurrentSlide();
    }

    @Override
    public void eventFired(NextSlideEvent event) {
        this.presentation.setNextSlide();
        this.displayCurrentSlide();
    }

    @Override
    public void eventFired(SavePresentationEvent event) {
        String saveLocation = event.getSaveLocation();
        this.savePresentation(saveLocation);
    }

    @Override
    public void eventFired(UpdateDrawnAnnotationEvent event) {
        List<Point> annotationPoints = event.getAnnotationPoints();
        Annotation drawnAnnotation = this.createAnnotation(annotationPoints);
        this.displayDrawnAnnotation(drawnAnnotation);
    }

    @Override
    public void eventFired(CreateDrawnAnnotationEvent event) {
        List<Point> annotationPoints = event.getAnnotationPoints();
        Annotation drawnAnnotation = this.createAnnotation(annotationPoints);
        this.presentation.getCurrentSlide().addAnnotation(drawnAnnotation);
        this.displayCurrentSlide(); // SLIDEVIEWERCOMPONENT SHOULD REMOVE CURRENT DRAWN ANNOTATION
    }

    @Override
    public void eventFired(NewPresentationEvent event) {
        this.setPresentation(PresentationFactory.createPresentation());
        this.displayPresentationTitle();
        this.displayCurrentSlide();
    }

    @Override
    public void eventFired(LoadPresentationEvent event) {
        String presentationPath = event.getPresentationPath();
        this.loadPresentation(presentationPath);
    }

    @Override
    public void eventFired(UpdateAnnotationColorEvent event) {
        Color annotationColor = event.getAnnotationColor();
        this.annotationStyle.setLineColor(annotationColor);
    }

    @Override
    public void eventFired(UpdateAnnotationThicknessEvent event) {
        int annotationThickness = event.getAnnotationThickness();
        this.annotationStyle.setLineThickness(annotationThickness);
    }
}
