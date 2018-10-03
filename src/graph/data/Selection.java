package graph.data;

import graphlab.graphic.GraphicInfo;

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
            node.graphicInfo.color = GraphicInfo.WHITE;
            node.graphicInfo.text_color = GraphicInfo.BLACK;
        }
    }