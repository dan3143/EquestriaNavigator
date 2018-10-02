package graph.data;

import graphlab.graphic.GraphicInfo;
import java.awt.Color;

/**
 *
 * @author Daniel
 */
public class Selection<T> {

        public boolean isSelected;
        public Node<T> node;

        public Selection() {
            node = new Node(null);
        }

        public void turnOff() {
            isSelected = false;
            node.graphicInfo.color = GraphicInfo.white;
            node.graphicInfo.text_color = GraphicInfo.black;
        }
    }