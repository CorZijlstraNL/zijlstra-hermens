/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.adapters.SlideViewerComponentMouseAdapter;
import controller.adapters.SlideViewerFrameKeyAdapter;
import controller.adapters.SlideViewerFrameWindowAdapter;
import events.dispatchers.BaseEventDispatcher;
import events.events.ClosePresentationEvent;
import events.listeners.ClosePresentationEventListener;
import factories.AdapterFactory;
import factories.ComponentFactory;
import factories.EventDispatcherFactory;
import factories.MVCFactory;
import factories.MenuBarFactory;
import factories.MenuListenerFactory;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import model.MainModel;
import view.SlideViewerComponent;
import view.SlideViewerFrame;
import view.SlideViewerMenu;

/**
 *
 * @author Tim
 */
public class MainController implements Controller, ClosePresentationEventListener {

    private static final boolean INITIAL_ANNOTATION_MODE_IS_ENABLED = false;
    
    private MainModel model;
    
    private SlideViewerFrame view;
    
    public MainController(MVCFactory factory) {
        this.model = (MainModel) factory.createModel();
        this.view = (SlideViewerFrame) factory.createView();
        this.setup();
    }
    
    /**
     * Registers all EventListener objects and passes all EventDispatcher objects to the relevant classes.
     */
    private void setup() {
        // create all event dispatchers
        BaseEventDispatcher closePresentationEventDispatcher = EventDispatcherFactory.createClosePresentationEventDispatcher();
        BaseEventDispatcher createDrawnAnnotationEventDispatcher = EventDispatcherFactory.createCreateDrawnAnnotationEventDispatcher();
        BaseEventDispatcher displayCurrentSlideEventDispatcher = EventDispatcherFactory.createDisplayCurrentSlideEventDispatcher();
        BaseEventDispatcher displayDrawnAnnotationEventDispatcher = EventDispatcherFactory.createDisplayDrawnAnnotationEventDispatcher();
        BaseEventDispatcher displayPresentationTitleEventDispatcher = EventDispatcherFactory.createDisplayPresentationTitleEventDispatcher();
        BaseEventDispatcher goToSlideEventDispatcher = EventDispatcherFactory.createGoToSlideEventDispatcher();
        BaseEventDispatcher loadPresentationEventDispatcher = EventDispatcherFactory.createLoadPresentationEventDispatcher();
        BaseEventDispatcher newPresentationEventDispatcher = EventDispatcherFactory.createNewPresentationEventDispatcher();
        BaseEventDispatcher nextSlideEventDispatcher = EventDispatcherFactory.createNextSlideEventDispatcher();
        BaseEventDispatcher previousSlideEventDispatcher = EventDispatcherFactory.createPreviousSlideEventDispatcher();
        BaseEventDispatcher savePresentationEventDispatcher = EventDispatcherFactory.createSavePresentationEventDispatcher();
        BaseEventDispatcher updateAnnotationColorEventDispatcher = EventDispatcherFactory.createUpdateAnnotationColorEventDispatcher();
        BaseEventDispatcher updateAnnotationModeEventDispatcher = EventDispatcherFactory.createUpdateAnnotationModeEventDispatcher();
        BaseEventDispatcher updateAnnotationThicknessEventDispatcher = EventDispatcherFactory.createUpdateAnnotationThicknessEventDispatcher();
        BaseEventDispatcher updateDrawnAnnotationEventDispatcher = EventDispatcherFactory.createUpdateDrawnAnnotationEventDispatcher();
        
        // create all menu listeners
        ActionListener aboutActionListener = MenuListenerFactory.createAboutActionListener();
        ActionListener closePresentationActionListener = MenuListenerFactory.createClosePresentationActionListener(closePresentationEventDispatcher);
        ActionListener goToSlideActionListener = MenuListenerFactory.createGoToSlideActionListener(goToSlideEventDispatcher);
        ActionListener loadPresentationActionListener = MenuListenerFactory.createLoadPresentationActionListener(loadPresentationEventDispatcher);
        ActionListener newPresentationActionListener = MenuListenerFactory.createNewPresentationActionListener(newPresentationEventDispatcher);
        ActionListener nextSlideActionListener = MenuListenerFactory.createNextSlideActionListener(nextSlideEventDispatcher);
        ActionListener previousSlideActionListener = MenuListenerFactory.createPreviousSlideActionListener(previousSlideEventDispatcher);
        ActionListener savePresentationActionListener = MenuListenerFactory.createSavePresentationActionListener(savePresentationEventDispatcher);
        ActionListener selectAnnotationColorActionListener = MenuListenerFactory.createSelectAnnotationColorActionListener(updateAnnotationColorEventDispatcher);
        ActionListener selectAnnotationThicknessActionListener = MenuListenerFactory.createSelectAnnotationThicknessActionListener(updateAnnotationThicknessEventDispatcher);
        ItemListener annotationModeItemListener = MenuListenerFactory.createAnnotationModeItemListener(updateAnnotationModeEventDispatcher);
        
        // create the view objects
        SlideViewerComponent slideViewerComponent = ComponentFactory.createSlideViewerComponent();
        
        // create the controller adapters
        SlideViewerComponentMouseAdapter slideViewerComponentMouseAdapter = AdapterFactory.createSlideViewerComponentMouseAdapter(INITIAL_ANNOTATION_MODE_IS_ENABLED, updateDrawnAnnotationEventDispatcher, createDrawnAnnotationEventDispatcher);
        SlideViewerFrameKeyAdapter slideViewerFrameKeyAdapter = AdapterFactory.createSlideViewerFrameKeyAdapter(previousSlideEventDispatcher, nextSlideEventDispatcher, closePresentationEventDispatcher);
        SlideViewerFrameWindowAdapter slideViewerFrameWindowAdapter = AdapterFactory.createSlideViewerFrameWindowAdapter(closePresentationEventDispatcher);
        
        // create menubar
        SlideViewerMenu slideViewerMenu = MenuBarFactory.createSlideViewerMenu(loadPresentationActionListener, newPresentationActionListener, savePresentationActionListener,
                closePresentationActionListener, nextSlideActionListener, previousSlideActionListener, goToSlideActionListener, selectAnnotationColorActionListener,
                selectAnnotationThicknessActionListener, annotationModeItemListener, aboutActionListener, INITIAL_ANNOTATION_MODE_IS_ENABLED);
        
        // add remaining event dispatchers
        this.model.setEventDispatchers(displayCurrentSlideEventDispatcher, displayDrawnAnnotationEventDispatcher, displayPresentationTitleEventDispatcher);
        
        // register controller listeners
        closePresentationEventDispatcher.addListener(this);
        
        // register model listeners
        createDrawnAnnotationEventDispatcher.addListener(this.model);        
        goToSlideEventDispatcher.addListener(this.model);
        loadPresentationEventDispatcher.addListener(this.model);
        newPresentationEventDispatcher.addListener(this.model);
        nextSlideEventDispatcher.addListener(this.model);
        previousSlideEventDispatcher.addListener(this.model);
        savePresentationEventDispatcher.addListener(this.model);
        updateAnnotationColorEventDispatcher.addListener(this.model);        
        updateAnnotationThicknessEventDispatcher.addListener(this.model);
        updateDrawnAnnotationEventDispatcher.addListener(this.model);
        
        // register view listeners
        displayPresentationTitleEventDispatcher.addListener(this.view);
        
        // register SlideViewerComponent listeners
        displayCurrentSlideEventDispatcher.addListener(slideViewerComponent);
        displayDrawnAnnotationEventDispatcher.addListener(slideViewerComponent);
        
        // register SlideViewerComponentMouseAdapter listeners
        updateAnnotationModeEventDispatcher.addListener(slideViewerComponentMouseAdapter);
        
        // pass objects
        slideViewerComponent.setupMouseAdapter(slideViewerComponentMouseAdapter);
        this.view.setupComponent(slideViewerComponent);
        this.view.setupKeyAdapter(slideViewerFrameKeyAdapter);
        this.view.setupMenuBar(slideViewerMenu);
        this.view.setupWindowAdapter(slideViewerFrameWindowAdapter);
    }
    
    public void loadPresentation(String presentationPath) {
        this.model.loadPresentation(presentationPath);
    }

    @Override
    public void eventFired(ClosePresentationEvent event) {
        System.exit(0);
    }
}
