/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwrite.builder;

import factories.PresentationFactory;
import model.Presentation;
import model.Slide;
import model.SlideItem;

/**
 *
 * @author Tim
 */
public class PresentationBuilder {
    
    private Presentation presentation;
    
    private Slide slide;

    public PresentationBuilder() {
        this.presentation = PresentationFactory.createPresentation();
    }
    
    public void buildPresentationTitle(String title) {
        this.presentation.setTitle(title);
    }
    
    public void buildSlide(String slideTitle) {
        this.addSlide();
        this.slide = PresentationFactory.createSlide(slideTitle);
    }
    
    public void buildTextItem(int nestingLevel, String text) {
        this.slide.addSlideItem(PresentationFactory.createTextItem(nestingLevel, text));
    }
    
    public void buildImageItem(int nestingLevel, String imageName) {
        this.slide.addSlideItem(PresentationFactory.createImageItem(nestingLevel, imageName));
    }
    
    private void addSlide() {
        if(this.slide != null) {
            this.presentation.addSlide(this.slide);
        }
    }
    
    public Presentation getResult() {
        this.addSlide();
        return this.presentation;
    }
}
