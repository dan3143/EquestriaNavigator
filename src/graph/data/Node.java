package graph.data;

import graph.graphic.Circle;
import graph.graphic.GraphicInfo;
import java.awt.Color;

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
        graphicInfo = new GraphicInfo(new Circle(0,0,0), Color.white, Color.black);
    }
    
    public Node(T info, double x, double y){
        this.info = info;
        graphicInfo = new GraphicInfo(new Circle(x, y, Graph.RADII), Color.white, Color.black);
    }
    
    public void setGraphicInfo(GraphicInfo graphicInfo){
        this.graphicInfo = graphicInfo;
    }
    
    public void setColor(Color color){
        if (graphicInfo != null){
            graphicInfo.color = color;
        }
    }
    
    public boolean contains(double x, double y){
        return graphicInfo.circle.contains(x, y);
    }
    
    public boolean intersects(Circle circle){
        return graphicInfo.circle.insersects(circle);
    }
    
    @Override
    public String toString(){
        if (info == null) return null;
        return info.toString();
    }
}
