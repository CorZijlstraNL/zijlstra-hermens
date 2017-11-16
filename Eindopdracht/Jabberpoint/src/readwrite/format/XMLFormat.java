/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwrite.format;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.ImageItem;
import model.Presentation;
import model.Slide;
import model.SlideItem;
import model.TextItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import readwrite.builder.PresentationBuilder;

/**
 *
 * @author Tim
 */
public class XMLFormat extends Format {

    /** namen van xml tags of attributen */
    /**
     * The presentation title XML tag.
     */
    private static final String PRESENTATION_TITLE = "showtitle";
    
    /**
     * The slide title XML tag.
     */
    private static final String SLIDE_TITLE = "title";
    
    /**
     * The slide XML tag.
     */
    private static final String SLIDE = "slide";
    
    /**
     * The item XML tag.
     */
    private static final String ITEM = "item";
    
    /**
     * The nesting level XML tag.
     */
    private static final String LEVEL = "level";
    
    /**
     * The kind XML tag.
     */
    private static final String KIND = "kind";
    
    /**
     * The text XML tag that indicates the TextItem object.
     */
    private static final String TEXT = "text";
    
    /**
     * The image XML tag that indicates the ImageItem object.
     */
    private static final String IMAGE = "image";
    
    /** tekst van messages */
    private static final String UNKNOWNTYPE = "Unknown Element type";
    
    // is reading?
    /**
     * Determines if the file is being read.
     */
    private boolean read;
    
    // reader objects
    /**
     * The object used to parse the XML file.
     */
    private Document document;
    
    /**
     * The cursor that determines which XML element is being read.
     */
    private Element currentElement;
    
    // writer objects
    /**
     * The object used to write the XML file.
     */
    private PrintWriter out;
    
    public XMLFormat(PresentationBuilder builder) {
        super(builder);
    }
    
    @Override
    public boolean open(String path, boolean read) {
        boolean fileOpened = false;
        
        this.read = read;
        
        if(read) {
            try {
                // reader
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                this.document = builder.parse(new File(path)); // maak een JDOM document
                fileOpened = true;
            } catch (ParserConfigurationException ex) {
                System.err.println(ex.toString());
            } catch (SAXException ex) {
                System.err.println(ex.toString());
            } catch (IOException ex) {
                System.err.println(ex.toString());
            }
        }
        else {
            try {
                // writer
                this.out = new PrintWriter(new FileWriter(path));
                fileOpened = true;
            } catch (IOException ex) {
                System.err.println(ex.toString());
            }
        }
        
        return fileOpened;
    }

    @Override
    public void close() {
        if (!this.read) {
            this.out.close();
        }
    }
    
    private String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();
    }

    @Override
    public void readBegin() {
        this.currentElement = document.getDocumentElement();
    }

    @Override
    public void readPresentationTitle() {
        String presentationTitle = this.getTitle(this.currentElement, PRESENTATION_TITLE);
        this.presentationBuilder.buildPresentationTitle(presentationTitle);
    }

    @Override
    public void readSlides() {
        NodeList slides = this.currentElement.getElementsByTagName(SLIDE);
	int numberOfSlides = slides.getLength();
        for (int slideNumber = 0; slideNumber < numberOfSlides; slideNumber++) {
            this.currentElement = (Element) slides.item(slideNumber);
            this.readSlide();
        }
    }

    @Override
    protected void readSlide() {
        String slideTitle = this.getTitle(this.currentElement, SLIDE_TITLE);
        this.presentationBuilder.buildSlide(slideTitle);
        this.readSlideItems();
    }

    @Override
    protected void readSlideItems() {
        NodeList slideItems = this.currentElement.getElementsByTagName(ITEM);
        int numberOfSlideItems = slideItems.getLength();
        for (int itemNumber = 0; itemNumber < numberOfSlideItems; itemNumber++) {
            this.currentElement = (Element) slideItems.item(itemNumber);
            this.readSlideItem();
        }
    }

    @Override
    protected void readSlideItem() {
        int nestingLevel = 1; // default
        NamedNodeMap attributes = this.currentElement.getAttributes();
        String nestingLevelText = attributes.getNamedItem(LEVEL).getTextContent();
        String slideItemValue = this.currentElement.getTextContent();
        if (nestingLevelText != null) {
            try {
                nestingLevel = Integer.parseInt(nestingLevelText);
            }
            catch(NumberFormatException nfe) {
                System.err.println(nfe.toString());
            }
        }
        String slideItemType = attributes.getNamedItem(KIND).getTextContent();
        if (TEXT.equals(slideItemType)) {
            this.presentationBuilder.buildTextItem(nestingLevel, slideItemValue);
        }
        else if (IMAGE.equals(slideItemType)) {
            this.presentationBuilder.buildImageItem(nestingLevel, slideItemValue);
        }
        else {
            System.err.println(UNKNOWNTYPE);
        }
    }

    @Override
    public Presentation readEnd() {
        return this.presentationBuilder.getResult();
    }

    @Override
    public void writeBegin() {
        this.out.println("<?xml version=\"1.0\"?>");
        this.out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        this.out.println("<presentation>");
    }

    @Override
    public void writePresentationTitle(String title) {
        this.out.print("<"+PRESENTATION_TITLE+">");
        this.out.print(title);
        this.out.println("</"+PRESENTATION_TITLE+">");
    }

    @Override
    public void writeSlides(Iterator<Slide> slides) {
        while (slides.hasNext()) {
            Slide slide = slides.next();
            this.writeSlide(slide);
        }
    }

    @Override
    protected void writeSlide(Slide slide) {
        this.out.println("<"+SLIDE+">");
	this.out.println("<"+SLIDE_TITLE+">" + ((TextItem) slide.getTitle()).getText() + "</"+SLIDE_TITLE+">");
        Iterator<SlideItem> slideItems = slide.getSlideItems();
        this.writeSlideItems(slideItems);
        this.out.println("</"+SLIDE+">");
    }

    @Override
    protected void writeSlideItems(Iterator<SlideItem> slideItems) {
        while(slideItems.hasNext()) {
            SlideItem slideItem = slideItems.next();
            this.writeSlideItem(slideItem);
        }
    }

    @Override
    protected void writeSlideItem(SlideItem slideItem) {
        this.out.print("<"+ITEM+" "+KIND+"=");
        if (slideItem instanceof TextItem) {
            this.out.print("\""+TEXT+"\" "+LEVEL+"=\"" + slideItem.getNestingLevel() + "\">");
            this.out.print(((TextItem) slideItem).getText());
        }
        else {
            if (slideItem instanceof ImageItem) {
                this.out.print("\""+IMAGE+"\" "+LEVEL+"=\"" + slideItem.getNestingLevel()+ "\">");
                this.out.print(((ImageItem) slideItem).getImageName());
            }
            else {
                System.out.println("Ignoring " + slideItem);
            }
        }
        this.out.println("</"+ITEM+">");
    }

    @Override
    public void writeEnd() {
        this.out.println("</presentation>");
    }
    
}
