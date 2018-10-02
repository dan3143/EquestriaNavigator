package graphlab.graphic;

import graphlab.graphic.Circle;
import java.awt.Color;

public class GraphicInfo {
    public Circle circle;
    public Color color;
    public Color text_color;
    public static final Color white = new Color(237, 237, 244);
    public static final Color black = new Color(43, 45, 66);
    public static final Color yellow = new Color(244, 241, 187);
    
    public GraphicInfo(Circle circle, Color color, Color text_color){
        this.circle = circle;
        this.color = color;
        this.text_color = text_color;
    }
}