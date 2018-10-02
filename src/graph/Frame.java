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
import java.awt.geom.Ellipse2D;

public class Frame extends javax.swing.JFrame {

    private final Graph<String> graph;
    private final int node_radii = 30;
    private Selection<String> selectedNode;
    private Selection<String> secondaryNode;
    private final Font font = new Font("Segoe UI", Font.PLAIN, 20);

    public Frame() {
        graph = new Graph();
        selectedNode = new Selection();
        secondaryNode = new Selection();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("files/icon.png")));
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
        btFloyd = new javax.swing.JToolBar();
        btAddEdge = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCalculate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Equestria Navigator");
        setResizable(false);

        lbMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/files/map_of_equestria.png"))); // NOI18N
        lbMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMapMouseClicked(evt);
            }
        });

        btFloyd.setRollover(true);

        btAddEdge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/files/route.png"))); // NOI18N
        btAddEdge.setMnemonic('r');
        btAddEdge.setToolTipText("Conectar dos ciudades");
        btAddEdge.setFocusable(false);
        btAddEdge.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAddEdge.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAddEdge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddEdgeActionPerformed(evt);
            }
        });
        btFloyd.add(btAddEdge);

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/files/delete.png"))); // NOI18N
        btEliminar.setToolTipText("Eliminar ciudad");
        btEliminar.setFocusable(false);
        btEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFloyd.add(btEliminar);

        btCalculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/files/calculate.png"))); // NOI18N
        btCalculate.setToolTipText("Calcular todos los caminos");
        btCalculate.setFocusable(false);
        btCalculate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCalculate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalculateActionPerformed(evt);
            }
        });
        btFloyd.add(btCalculate);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Ejecutar Floyd-Warshall");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        btFloyd.add(jButton1);

        jToolBar2.setRollover(true);

        btHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/files/help.png"))); // NOI18N
        btHelp.setText("Ayuda");
        jToolBar2.add(btHelp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMap)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btFloyd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btFloyd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMap, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMapMouseClicked
        if (!selectNode(evt.getX(), evt.getY(), evt.getButton())) {
            if (!(selectedNode.isSelected || secondaryNode.isSelected)) {
                Circle c = new Circle(evt.getX(), evt.getY(), node_radii);
                if (graph.isOccupied(c)) {
                    JOptionPane.showMessageDialog(null, "El lugar está ocupado por otro nodo");
                } else {
                    String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del lugar");
                    if (!(nombre == null || nombre.trim().isEmpty() || graph.contains(nombre))) {
                        Node node = new Node(nombre);
                        node.setGraphicInfo(new GraphicInfo(c, GraphicInfo.white, GraphicInfo.black));
                        graph.addNode(node);
                    }
                }
            }
            cleanSelection();
        }
        drawGraph();
    }//GEN-LAST:event_lbMapMouseClicked

    private void btCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalculateActionPerformed
        if (selectedNode.isSelected && secondaryNode.isSelected && graph.distances != null) {
            int costo = graph.distances[graph.nodeList.indexOf(selectedNode.node)][graph.nodeList.indexOf(secondaryNode.node)];
            if (costo == Graph.INF) {
                JOptionPane.showMessageDialog(null, "Parece que no puedes ir de " + selectedNode.node.info + " a " + secondaryNode.node.info);
            } else {
                JOptionPane.showMessageDialog(null, "Ir de " + selectedNode.node.info + " a " + secondaryNode.node.info + " cuesta " + costo);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona dos ciudades, y no olvides ejecutar el floyd-warshall");
        }
    }//GEN-LAST:event_btCalculateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        graph.floydWarshall();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAddEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEdgeActionPerformed
        if (selectedNode.isSelected && secondaryNode.isSelected) {
            int weight = getWeight();
            if (weight == -1) {
                return;
            }
            Edge edge = new Edge(selectedNode.node, secondaryNode.node, weight);
            graph.edgeList.add(edge);
            //drawEdge(edge);
            drawGraph();
        }
    }//GEN-LAST:event_btAddEdgeActionPerformed

    private int getWeight() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el costo:"));
        } catch (Exception e) {
            return -1;
        }
    }

    private void drawEdge(Edge edge) {
        Graphics2D g = (Graphics2D) lbMap.getGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Node n1 = edge.origin;
        Node n2 = edge.destiny;
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        double x0 = n1.graphicInfo.circle.h;
        double y0 = n1.graphicInfo.circle.k;
        double x1 = n2.graphicInfo.circle.h;
        double y1 = n2.graphicInfo.circle.k;
        g.setColor(Color.black);
        g.draw(new Line2D.Double(x0, y0, x1, y1));
        g.setColor(Color.white);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString(String.valueOf(edge.weight), (int) ((x0 + x1) / 2), (int) ((y1 + y0) / 2));
    }

    private double[] getIntersectionPoints(double x0, double y0, double x1, double y1, double h, double k, double r) {
        double m = (y1 - y0) / (x1 - x0);
        double b = y0 - m * x0;
        double A = 1 + pow2(m);
        double B = 2 * m * b - 2 * h - 2 * k * m;
        double C = pow2(h) + pow2(b) + pow2(k) - 2 * b * k - pow2(r);
        double X1 = (-B + sqrt(pow2(B) - 4 * A * C)) / (2 * A);
        double X2 = (-B - sqrt(pow2(B) - 4 * A * C)) / (2 * A);
        double Y1 = m * X1 + b;
        double Y2 = m * X2 + b;
        double points[] = {X1, Y1};
        return points;
    }

    private void drawArrow(double h0, double k0, double h, double k) {
        double phi = Math.toRadians(40);
        double punta = 20;
        double delta_y = k - k0;
        double delta_x = h - h0;
        double theta = Math.atan2(delta_y, delta_x);
        double x, y, alpha = theta + phi;
        Graphics2D g = (Graphics2D) lbMap.getGraphics();
        g.setStroke(new BasicStroke(3));
        x = h - punta * Math.cos(alpha);
        y = k - punta * Math.sin(alpha);
        g.draw(new Line2D.Double(h, k, x, y));
        alpha = theta - phi;
        x = h - punta * Math.cos(alpha);
        y = k - punta * Math.sin(alpha);
        g.draw(new Line2D.Double(h, k, x, y));
    }

    private void drawNode(Node<String> node) {
        Graphics2D g = (Graphics2D) lbMap.getGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(2));
        double x = node.graphicInfo.circle.h;
        double y = node.graphicInfo.circle.k;
        double radius = node.graphicInfo.circle.r;
        String info = node.info;
        int stringWidth = g.getFontMetrics().stringWidth(info);
        g.setColor(node.graphicInfo.color);
        g.fill(new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2));
        g.setColor(node.graphicInfo.text_color);
        g.draw(new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2));
        g.drawString(info, (int) (x - stringWidth / 2), (int) y);
    }

    private void drawGraph() {
        for (Edge edge : graph.edgeList) {
            drawEdge(edge);
        }
        for (Node<String> node : graph.nodeList) {
            drawNode(node);
        }
    }

    private void mostrarDistancia(Node n1, Node n2) {
        if (n1 == n2) {
            JOptionPane.showMessageDialog(null, "No tienes que pagar nada para ir de " + n1.info + " hasta " + n2.info);
        } else {
            int costo = graph.distances[graph.nodeList.indexOf(n1)][graph.nodeList.indexOf(n2)];
            if (costo == Graph.INF) {
                JOptionPane.showMessageDialog(null, "Al parecer no se puede ir desde " + n1.info + " hasta " + n2.info);
            } else {
                JOptionPane.showMessageDialog(null, "Te costaría " + costo + " bits ir de " + n1.info + " hasta " + n2.info);
            }
        }
    }

    public boolean selectNode(int x, int y, int button) {
        boolean nodeClicked = false;
        for (Node node : graph.nodeList) {
            if (node.contains(x, y)) {
                nodeClicked = true;
                if (button == MouseEvent.BUTTON1) {
                    if (selectedNode.isSelected) {
                        selectedNode.node.graphicInfo.color = GraphicInfo.white;
                        selectedNode.node.graphicInfo.text_color = GraphicInfo.black;
                    }
                    selectedNode.isSelected = true;
                    selectedNode.node = node;
                    selectedNode.node.graphicInfo.color = GraphicInfo.black;
                    selectedNode.node.graphicInfo.text_color = GraphicInfo.white;
                } else {
                    if (secondaryNode.isSelected) {
                        secondaryNode.node.graphicInfo.color = GraphicInfo.white;
                        secondaryNode.node.graphicInfo.text_color = GraphicInfo.black;
                    }
                    secondaryNode.isSelected = true;
                    secondaryNode.node = node;
                    secondaryNode.node.graphicInfo.color = GraphicInfo.yellow;
                    secondaryNode.node.graphicInfo.text_color = GraphicInfo.black;
                }
                break;
            }
        }
        return nodeClicked;
    }

    public void cleanSelection() {
        if (selectedNode.isSelected) {
            selectedNode.turnOff();
        }
        if (secondaryNode.isSelected) {
            secondaryNode.turnOff();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddEdge;
    private javax.swing.JButton btCalculate;
    private javax.swing.JButton btEliminar;
    private javax.swing.JToolBar btFloyd;
    private javax.swing.JButton btHelp;
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lbMap;
    // End of variables declaration//GEN-END:variables
}
