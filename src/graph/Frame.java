package graph;

import graph.data.Graph;
import graph.data.Node;
import graph.data.Edge;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import graph.data.Selection;
import graphlab.graphic.Circle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import static java.lang.Math.sqrt;
import static graphlab.graphic.Circle.pow2;
import graphlab.graphic.GraphicInfo;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Frame extends javax.swing.JFrame {

    private final Graph<String> graph;
    private final int node_radii = 10;
    private final Selection<String> selected;
    private final Selection<String> secondary;
    private final Selection<String> firstNode;
    private final static int font_size = 20;
    private final Font font = new Font("Segoe", Font.PLAIN, font_size);

    public Frame() {
        graph = new Graph();
        selected = new Selection();
        secondary = new Selection();
        firstNode = new Selection();
        initComponents();
        super.setLocationRelativeTo(null);
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("files/icon.png")));
    }

    public static void main(String args[]) {
        //<editor-fold desc="Look and feel" defaultstate="collapsed">
        try {
            javax.swing.UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Look and Feel no soportado");
        }
        //</editor-fold>
        Frame frame = new Frame();
        frame.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMap = new javax.swing.JLabel();
        btCalcCamino = new javax.swing.JButton();
        lbCosto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Equestria Navigator");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lbMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/files/map_of_equestria.png"))); // NOI18N
        lbMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbMapMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbMapMouseReleased(evt);
            }
        });

        btCalcCamino.setText("Calcular camino");
        btCalcCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcCaminoActionPerformed(evt);
            }
        });
        btCalcCamino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCalcCaminoKeyPressed(evt);
            }
        });

        lbCosto.setText("Costo:");

        jMenu1.setText("Grafo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Ejecutar Floyd-Warshall");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMap)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCalcCamino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCosto))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbMap, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCalcCamino)
                    .addComponent(lbCosto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMapMouseClicked
        if (!selectNode(evt.getX(), evt.getY(), evt.getButton())) {
            if (!(selected.isSelected || secondary.isSelected)) {
                Circle c = new Circle(evt.getX(), evt.getY(), node_radii);
                if (graph.isOccupied(c)) {
                    JOptionPane.showMessageDialog(null, "El lugar está ocupado por otro nodo");
                } else {
                    String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del lugar");
                    if (!(nombre == null || nombre.trim().isEmpty() || graph.contains(nombre))) {
                        Node node = new Node(nombre);
                        node.setGraphicInfo(new GraphicInfo(c, GraphicInfo.WHITE, GraphicInfo.BLACK));
                        graph.addNode(node);
                        graph.distances = null;
                        graph.paths = null;
                    }
                }
            }
            cleanSelection();
            cleanEdges();
        }
        drawGraph();
    }//GEN-LAST:event_lbMapMouseClicked

    private void lbMapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMapMousePressed
        Node node = graph.getNodeAt(evt.getX(), evt.getY());
        if (node != null) {
            firstNode.isSelected = true;
            firstNode.node = node;
        }
    }//GEN-LAST:event_lbMapMousePressed

    private void lbMapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMapMouseReleased
        if (firstNode.isSelected) {
            Node node = graph.getNodeAt(evt.getX(), evt.getY());
            if (node == firstNode.node || node == null) {
                return;
            }
            int weight = getWeight();
            if (weight < Graph.INF) {
                graph.edgeList.add(new Edge(firstNode.node, node, weight));
                drawGraph();
                firstNode.isSelected = false;
            }
        }
    }//GEN-LAST:event_lbMapMouseReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE && selected.isSelected) {
            graph.deleteNode(selected.node);
            redrawGraph();
        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        graph.floydWarshall();
        showMatrices();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btCalcCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcCaminoActionPerformed
        if (!selected.isSelected || !secondary.isSelected) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar dos nodos");
        } else if (graph.distances == null) {
            JOptionPane.showMessageDialog(null, "Primero ejecuta el algorimo floyd-warshall");
        } else if (selected.node == secondary.node) {
            lbCosto.setText("Costo: gratis");
        } else {
            int i = graph.nodeList.indexOf(selected.node);
            int j = graph.nodeList.indexOf(secondary.node);
            int costo = graph.distances[i][j];
            if (costo == Graph.INF) {
                JOptionPane.showMessageDialog(null, "No hay camino entre estas dos ciudades");
            } else {
                lbCosto.setText("Costo: " + graph.distances[i][j] + " bits");
                mostrarDistancia(selected.node, secondary.node);
            }
        }
        drawGraph();
    }//GEN-LAST:event_btCalcCaminoActionPerformed

    private void btCalcCaminoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCalcCaminoKeyPressed
        formKeyPressed(evt);
    }//GEN-LAST:event_btCalcCaminoKeyPressed

    private int getWeight() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el costo:"));
        } catch (Exception e) {
            return -1;
        }
    }

    private void cleanEdges() {
        for (Edge edge : graph.edgeList) {
            edge.color = GraphicInfo.BLACK;
            edge.stroke = 1;
        }
    }

    private void drawEdge(Edge edge) {
        Graphics2D g = (Graphics2D) lbMap.getGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Node n1 = edge.origin;
        Node n2 = edge.destiny;
        double x0 = n1.graphicInfo.circle.h;
        double y0 = n1.graphicInfo.circle.k;
        double x1 = n2.graphicInfo.circle.h;
        double y1 = n2.graphicInfo.circle.k;
        double[][] in = getIntersectionPoints(x0, y0, x1, y1, x1, y1, node_radii);
        double x, y, x_text, y_text;
        x_text = (x0 + x1) / 2;
        y_text = (y0 + y1) / 2;
        if (x0 > x1) {
            y = in[0][1];
            x = in[0][0];
        } else {
            y = in[1][1];
            x = in[1][0];
        }
        drawArrow(x0, y0, x, y);
        g.setColor(edge.color);
        g.setStroke(new BasicStroke(edge.stroke));
        g.draw(new Line2D.Double(x0, y0, x, y));
        int size = 12;
        g.setFont(new Font("Courier New", Font.BOLD, size));
        int stringWidth = g.getFontMetrics().stringWidth(String.valueOf(edge.weight));
        g.fill(new RoundRectangle2D.Double(x_text, y_text, stringWidth + 10, size + 5, 5, 5));
        g.setColor(Color.white);
        g.drawString(String.valueOf(edge.weight), (int) (x_text + stringWidth / 2), (int) (y_text + size / 2 + 5));
    }

    private double[][] getIntersectionPoints(double x0, double y0, double x1, double y1, double h, double k, double r) {
        double m = (y1 - y0) / (x1 - x0);
        double b = y0 - m * x0;
        double A = 1 + pow2(m);
        double B = 2 * m * b - 2 * h - 2 * k * m;
        double C = pow2(h) + pow2(b) + pow2(k) - 2 * b * k - pow2(r);
        double X1 = (-B + sqrt(pow2(B) - 4 * A * C)) / (2 * A);
        double X2 = (-B - sqrt(pow2(B) - 4 * A * C)) / (2 * A);
        double Y1 = m * X1 + b;
        double Y2 = m * X2 + b;
        double points[][] = {{X1, Y1}, {X2, Y2}};
        return points;
    }

    private void drawArrow(double h0, double k0, double h, double k) {
        double phi = Math.toRadians(40);
        double tam_punta = 15;
        double delta_y = k - k0;
        double delta_x = h - h0;
        double theta = Math.atan2(delta_y, delta_x);
        double x, y, alpha = theta + phi;
        Graphics2D g = (Graphics2D) lbMap.getGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(240, 93, 94));
        x = h - tam_punta * Math.cos(alpha);
        y = k - tam_punta * Math.sin(alpha);
        g.draw(new Line2D.Double(h, k, x, y));
        alpha = theta - phi;
        x = h - tam_punta * Math.cos(alpha);
        y = k - tam_punta * Math.sin(alpha);
        g.draw(new Line2D.Double(h, k, x, y));
    }

    private void drawNode(Node<String> node) {
        Graphics2D g = (Graphics2D) lbMap.getGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        double x = node.graphicInfo.circle.h;
        double y = node.graphicInfo.circle.k;
        double radius = node.graphicInfo.circle.r;
        String info = node.info;
        int stringWidth = g.getFontMetrics().stringWidth(info);
        g.setColor(node.graphicInfo.color);
        g.fill(new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2));
        g.fill(new Rectangle2D.Double(x - stringWidth / 2 - 10, y + node_radii + 10, stringWidth + 20, 15));
        g.setColor(node.graphicInfo.text_color);
        g.draw(new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2));
        g.drawString(info, (int) x - stringWidth / 2, (int) y + node_radii + 20);
    }

    private void drawGraph() {
        for (Edge edge : graph.edgeList) {
            drawEdge(edge);
        }
        for (Node<String> node : graph.nodeList) {
            drawNode(node);
        }
    }

    private void redrawGraph() {
        lbMap.paint(lbMap.getGraphics());
        drawGraph();
    }

    private void mostrarDistancia(Node u, Node v) {
        Stack<Node<String>> nodes = graph.getPath(u, v);
        while(!nodes.isEmpty()){
            Node n = nodes.pop();
            if (nodes.isEmpty()) break;
            paintEdge(nodes.peek(), n);
        }
    }

    private void paintEdge(Node u, Node v) {
        for (Edge edge : graph.edgeList) {
            if (edge.origin == u && edge.destiny == v) {
                edge.stroke = 2;
                edge.color = GraphicInfo.BLUE;
                break;
            }
        }
    }

    public boolean selectNode(int x, int y, int button) {
        Node node = graph.getNodeAt(x, y);
        if (node == null) {
            return false;
        }
        if (button == MouseEvent.BUTTON1) {
            if (selected.isSelected) {
                selected.node.graphicInfo.color = GraphicInfo.WHITE;
                selected.node.graphicInfo.text_color = GraphicInfo.BLACK;
            }
            selected.isSelected = true;
            selected.node = node;
            selected.node.graphicInfo.color = GraphicInfo.BLACK;
            selected.node.graphicInfo.text_color = GraphicInfo.WHITE;
        } else {
            if (secondary.isSelected) {
                secondary.node.graphicInfo.color = GraphicInfo.WHITE;
                secondary.node.graphicInfo.text_color = GraphicInfo.BLACK;
            }
            secondary.isSelected = true;
            secondary.node = node;

            secondary.node.graphicInfo.color = GraphicInfo.YELLOW;
            secondary.node.graphicInfo.text_color = GraphicInfo.BLACK;
        }
        return true;
    }

    public void cleanSelection() {
        if (selected.isSelected) {
            selected.turnOff();
        }
        if (secondary.isSelected) {
            secondary.turnOff();
        }
    }

    void showMatrices() {
        int[][] distancia = graph.distances;
        ArrayList<ArrayList<Node<String>>> caminos = graph.paths;
        System.out.println("Caminos:");
        System.out.println("\nDistancias:");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println(Arrays.toString(distancia[i]));
        }
        if (graph.paths == null) {
            return;
        }
        for (ArrayList<Node<String>> camino : caminos) {
            for (Node<String> node : camino) {
                if (node == null) break;
                System.out.print(node.toString() + ", ");
            }
            System.out.println();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcCamino;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lbCosto;
    private javax.swing.JLabel lbMap;
    // End of variables declaration//GEN-END:variables
}
