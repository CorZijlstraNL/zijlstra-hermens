/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwrite.format;

import java.util.Iterator;
import model.Presentation;
import model.Slide;
import model.SlideItem;
import readwrite.builder.PresentationBuilder;

/**
 *
 * @author Tim
 */
public abstract class Format {
    
    protected PresentationBuilder presentationBuilder;
    
    protected Format(PresentationBuilder builder) {
        this.presentationBuilder = builder;
    }
    
    public abstract boolean open(String path, boolean read);
    
    public abstract void close();
    
    public abstract void readBegin();
    
    public abstract void readPresentationTitle();
    
    public abstract void readSlides();
    
    protected abstract void readSlide();
    
    protected abstract void readSlideItems();
    
    protected abstract void readSlideItem();
    
    public abstract Presentation readEnd();
    
    public abstract void writeBegin();
    
    public abstract void writePresentationTitle(String title);
    
    public abstract void writeSlides(Iterator<Slide> slides);
    
    protected abstract void writeSlide(Slide slide);
    
    protected abstract void writeSlideItems(Iterator<SlideItem> slideItems);
    
    protected abstract void writeSlideItem(SlideItem slideItem);
    
    public abstract void writeEnd();
}
