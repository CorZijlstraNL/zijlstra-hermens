/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Tim
 */
public class SlideStyle {
    
    private static String FONT_NAME = "Helvetica";
    
    private Color color;
    private Font font;
    private int leading;
    private int indent;
    private int fontSize;

    public SlideStyle(Color color, int leading, int indent, int fontSize) {
        this.color = color;
        this.leading = leading;
        this.indent = indent;
        this.fontSize = fontSize;
        this.font = new Font(FONT_NAME, Font.BOLD, fontSize);
    }

    public Color getColor() {
        return color;
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }

    public int getLeading() {
        return leading;
    }

    public int getIndent() {
        return indent;
    }
}
