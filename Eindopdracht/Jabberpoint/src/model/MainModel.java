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
 * The MainModel contains all the business logic for the presentation.
 * @author Tim
 */
public class MainModel implements Model, GoToSlideEventListener, PreviousSlideEventListener, NextSlideEventListener,
        SavePresentationEventListener, UpdateDrawnAnnotationEventListener, CreateDrawnAnnotationEventListener,
        NewPresentationEventListener, LoadPresentationEventListener, UpdateAnnotationColorEventListener,
        UpdateAnnotationThicknessEventListener {
    
    /**
     * The path pointing to the test presentation file.
     */
    private static final String TEST_PRESENTATION_PATH = "test.xml";
    
    /**
     * The path pointing to the default save location.
     */
    private static final String DEFAULT_SAVE_LOCATION = "dump.xml";
    
    /**
     * The currently active presentation.
     */
    private Presentation presentation;
    
    /**
     * The annotation style that is applied to newly created annotations.
     */
    private AnnotationStyle annotationStyle;
    
    /**
     * The collection of styles that are applied to the slide items when they need to be displayed. 
     */
    private SlideStyleCollection slideStyleCollection;
    
    // All the dispatchers
    /**
     * The dispatcher that is used to dispatch the DisplayCurrentSlideEvent event.
     */
    private BaseEventDispatcher displayCurrentSlideEventDispatcher;
    
    /**
     * The dispatcher that is used to dispatch the DisplayDrawnAnnotationEvent event.
     */
    private BaseEventDispatcher displayDrawnAnnotationEventDispatcher;
    
    /**
     * The dispatcher that is used to dispatch the DispalyPresentationTitleEvent event.
     */
    private BaseEventDispatcher displayPresentationTitleEventDispatcher;

    /**
     * Initialize the MainModel object.
     */
    public MainModel() {
        // Create the default annotation style and slide style collection
        this.annotationStyle = ModelFactory.createAnnotationStyle();
        this.slideStyleCollection = ModelFactory.createSlideStyleCollection();
    }

    /**
     * Retrieve the currently active presentation.
     * @return The currently active presentation.
     */
    public Presentation getPresentation() {
        return presentation;
    }

    /**
     * Retrieve the annotation style that is applied to newly created annotations.
     * @return The annotation style that is applied to newly created annotations.
     */
    public AnnotationStyle getAnnotationStyle() {
        return annotationStyle;
    }

    /**
     * Retrieve the collection of styles that are applied to the slide items when they need to be displayed. 
     * @return The collection of styles that are applied to the slide items when they need to be displayed. 
     */
    public SlideStyleCollection getSlideStyleCollection() {
        return slideStyleCollection;
    }

    /**
     * Set the currently active presentation.
     * @param presentation The currently active presentation.
     */
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
    
    /**
     * Load the presentation from a file.
     * @param presentationPath The path pointing to the file.
     */
    public void loadPresentation(String presentationPath) {
        // If presentation path is null, load the test presentation instead.
        if(presentationPath == null) {
            presentationPath = TEST_PRESENTATION_PATH;
        }
        
        AccessorFactory factory = AccessorFactory.getFactory(presentationPath);
        if(factory != null) {
            Presentation presentation = factory.createReader().read(presentationPath);
            this.setPresentation(presentation);
            this.displayPresentationTitle();
            this.displayCurrentSlide();
        }
    }
    
    /**
     * Save the presentation to a file.
     * @param saveLocation The path pointing to the file.
     */
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
    
    /**
     * Set the event dispatchers.
     * @param displayCurrentSlideEventDispatcher The dispatcher that is used to dispatch the DisplayCurrentSlideEvent event.
     * @param displayDrawnAnnotationEventDispatcher The dispatcher that is used to dispatch the DisplayDrawnAnnotationEvent event.
     * @param displayPresentationTitleEventDispatcher The dispatcher that is used to dispatch the DispalyPresentationTitleEvent event.
     */
    public void setEventDispatchers(BaseEventDispatcher displayCurrentSlideEventDispatcher, BaseEventDispatcher displayDrawnAnnotationEventDispatcher, 
            BaseEventDispatcher displayPresentationTitleEventDispatcher) {
        this.displayCurrentSlideEventDispatcher = displayCurrentSlideEventDispatcher;
        this.displayDrawnAnnotationEventDispatcher = displayDrawnAnnotationEventDispatcher;
        this.displayPresentationTitleEventDispatcher = displayPresentationTitleEventDispatcher;
    }
    
    /**
     * Display the current slide of the currently active presentation.
     */
    private void displayCurrentSlide() {
        Slide slide = this.presentation.getCurrentSlide();
        int currentSlideNumber = this.presentation.getCurrentSlideNumber();
        int totalSlides = this.presentation.getNumberOfSlides();
        
        this.displayCurrentSlideEventDispatcher.fire(new DisplayCurrentSlideEvent(this, currentSlideNumber, totalSlides, slide, this.slideStyleCollection));
    }
    
    /**
     * Display the currently being drawn annotation.
     * @param annotation The currently being drawn annotation.
     */
    private void displayDrawnAnnotation(Annotation annotation) {
        this.displayDrawnAnnotationEventDispatcher.fire(new DisplayDrawnAnnotationEvent(this, annotation));
    }
    
    /**
     * Display the title of the currently active presentation.
     */
    private void displayPresentationTitle() {
        String presentationTitle = this.presentation.getTitle();
        this.displayPresentationTitleEventDispatcher.fire(new DisplayPresentationTitleEvent(this, presentationTitle));
    }
    
    /**
     * Create a new annotation with the style that is applied to newly created annotations.
     * @param annotationPoints The points that outline the annotation.
     * @return A new annotation.
     */
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
        Slide currentSlide = this.presentation.getCurrentSlide(); 
        if(currentSlide != null) {
            List<Point> annotationPoints = event.getAnnotationPoints();
            Annotation drawnAnnotation = this.createAnnotation(annotationPoints);
            this.displayDrawnAnnotation(drawnAnnotation);
        }
    }

    @Override
    public void eventFired(CreateDrawnAnnotationEvent event) {
        Slide currentSlide = this.presentation.getCurrentSlide(); 
        if(currentSlide != null) {
            List<Point> annotationPoints = event.getAnnotationPoints();
            Annotation drawnAnnotation = this.createAnnotation(annotationPoints);
            currentSlide.addAnnotation(drawnAnnotation);
            this.displayCurrentSlide();
        }
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
