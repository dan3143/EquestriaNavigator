package graph;

import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 * @param <T> type of the information contained in the node
 */
public class Node<T> {
    
    public T info;
    public GraphicInfo graphicInfo;
    
    public Node(T info){
        this.info = info;
        graphicInfo = new GraphicInfo(0, 0, 0, Color.white, Color.black);
    }
    
    public void setGraphicInfo(int h, int k, int r, Color color, Color text_color){
        graphicInfo = new GraphicInfo(h, k, r, color, text_color);
    }
    
    public void setColor(Color color){
        if (graphicInfo != null){
            graphicInfo.color = color;
        }
    }
    
    @Override
    public String toString(){
        return info.toString();
    }
}
