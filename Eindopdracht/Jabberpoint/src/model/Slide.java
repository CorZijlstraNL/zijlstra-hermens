/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.drawlogic.SlideDrawLogic;

/**
 *
 * @author Tim
 */
public class Slide {
    
    private List<Annotation> annotations;
    
    private SlideItem title;
    
    private List<SlideItem> slideItems;

    public Slide(String title) {
        this.annotations = new ArrayList();
        this.slideItems = new ArrayList();
        this.title = new TextItem(0, title);
    }

    public Iterator<Annotation> getAnnotations() {
        return annotations.iterator();
    }

    public SlideItem getTitle() {
        return title;
    }

    public Iterator<SlideItem> getSlideItems() {
        return slideItems.iterator();
    }
    
    public void addSlideItem(SlideItem item) {
        this.slideItems.add(item);
    }
    
    public void addAnnotation(Annotation annotation) {
        this.annotations.add(annotation);
    }
    
    public SlideDrawLogic createDrawLogic() {
        return new SlideDrawLogic(this);
    }
}
