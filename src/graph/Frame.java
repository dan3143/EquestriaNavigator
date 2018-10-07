package graph;

import graph.data.Graph;
import graph.data.Node;
import graph.data.Edge;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import graph.data.Selection;
import graph.graphic.Circle;
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
import static graph.graphic.Circle.pow2;
import graph.graphic.GraphicInfo;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import javax.imageio.ImageIO;

public class Frame extends javax.swing.JFrame {

    private Graph<String> graph;
    private final Selection<String> selected;
    private final Selection<String> secondary;
    private final Selection<String> firstNode;
    private BufferedImage offScreenGraphImage;
    private BufferedImage offScreenLineImage;
    private boolean auto = true;
    private Point p1;
    private Point p2;
    private String price;

    private final Image MAP = getBackImage();
    private final static int FONT_SIZE = 12;
    private final Font font = new Font("Segoe", Font.PLAIN, FONT_SIZE);

    public Frame() {
        graph = Graph.MapOfEquestria();
        selected = new Selection();
        secondary = new Selection();
        firstNode = new Selection();
        initComponents();
        paneMap.setDoubleBuffered(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("files/icon.png")));
    }

    @Override
    public void update(Graphics g) {
        drawGraph();
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
        java.awt.EventQueue.invokeLater(() -> {
            frame.drawGraph();
        });
    }

    private Image getBackImage() {
        try {
            return ImageIO.read(new File(new File("").getAbsoluteFile() + "/src/graph/files/map_of_equestria.png"));
        } catch (IOException ex) {
            System.err.println("Error cargango imagen");
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        paneMap = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        newGraphMenu = new javax.swing.JMenuItem();
        equestriaMapMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        deleteNodeMenu = new javax.swing.JMenuItem();
        connectNodesMenu = new javax.swing.JMenuItem();
        shortestPathMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        automaticWarshall = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Equestria Navigator");
        setResizable(false);

        paneMap.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paneMapMouseDragged(evt);
            }
        });
        paneMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneMapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paneMapMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paneMapMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout paneMapLayout = new javax.swing.GroupLayout(paneMap);
        paneMap.setLayout(paneMapLayout);
        paneMapLayout.setHorizontalGroup(
            paneMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        paneMapLayout.setVerticalGroup(
            paneMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        menu.setText("Grafo");

        newGraphMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGraphMenu.setText("Nuevo grafo");
        newGraphMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGraphMenuActionPerformed(evt);
            }
        });
        menu.add(newGraphMenu);

        equestriaMapMenu.setText("Mapa de Equestria");
        equestriaMapMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equestriaMapMenuActionPerformed(evt);
            }
        });
        menu.add(equestriaMapMenu);
        menu.add(jSeparator2);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Ejecutar Floyd-Warshall");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem2);

        deleteNodeMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        deleteNodeMenu.setText("Eliminar nodo seleccionado");
        deleteNodeMenu.setEnabled(false);
        deleteNodeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNodeMenuActionPerformed(evt);
            }
        });
        menu.add(deleteNodeMenu);

        connectNodesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        connectNodesMenu.setText("Conectar nodos");
        connectNodesMenu.setEnabled(false);
        connectNodesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectNodesMenuActionPerformed(evt);
            }
        });
        menu.add(connectNodesMenu);

        shortestPathMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        shortestPathMenu.setText("Hallar camino mínimo");
        shortestPathMenu.setEnabled(false);
        shortestPathMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortestPathMenuActionPerformed(evt);
            }
        });
        menu.add(shortestPathMenu);
        menu.add(jSeparator1);

        automaticWarshall.setSelected(true);
        automaticWarshall.setText("Ejecutar Floyd-Warshall automáticamente");
        automaticWarshall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automaticWarshallActionPerformed(evt);
            }
        });
        menu.add(automaticWarshall);

        jMenuBar1.add(menu);

        jMenu1.setText("Ayuda");

        helpMenu.setText("Instrucciones");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });
        jMenu1.add(helpMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteNodeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNodeMenuActionPerformed
        if (selected.isSelected) {
            graph.deleteNode(selected.node);
            graph.floydWarshall();
            drawGraph();
        }
    }//GEN-LAST:event_deleteNodeMenuActionPerformed

    private void connectNodesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectNodesMenuActionPerformed
        double w = getWeight();
        if (w < Graph.INF) {
            graph.edgeList.add(new Edge(selected.node, secondary.node, w));
            drawGraph();
        }
        cleanSelection();
        connectNodesMenu.setEnabled(false);
    }//GEN-LAST:event_connectNodesMenuActionPerformed

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuActionPerformed
        new Ayuda().setVisible(true);
    }//GEN-LAST:event_helpMenuActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        graph.floydWarshall();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void automaticWarshallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automaticWarshallActionPerformed
        auto = automaticWarshall.isSelected();
    }//GEN-LAST:event_automaticWarshallActionPerformed

    private void newGraphMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGraphMenuActionPerformed
        graph = new Graph();
        drawGraph();
    }//GEN-LAST:event_newGraphMenuActionPerformed

    private void equestriaMapMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equestriaMapMenuActionPerformed
        graph = Graph.MapOfEquestria();
        drawGraph();
    }//GEN-LAST:event_equestriaMapMenuActionPerformed

    private void paneMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseClicked
        if (!selectNode(evt.getX(), evt.getY(), evt.getButton())) {
            if (!(selected.isSelected || secondary.isSelected)) {
                Circle c = new Circle(evt.getX(), evt.getY(), Graph.RADII);
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
        if (selected.isSelected && secondary.isSelected) {
            connectNodesMenu.setEnabled(true);
            if (graph.distances != null) {
                shortestPathMenu.setEnabled(true);
            }
        }
        drawGraph();
    }//GEN-LAST:event_paneMapMouseClicked

    private void paneMapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMousePressed
        Node node = graph.getNodeAt(evt.getX(), evt.getY());
        p1 = new Point(evt.getX(), evt.getY());
        p2 = new Point();
        if (node != null) {
            firstNode.isSelected = true;
            firstNode.node = node;
        }
    }//GEN-LAST:event_paneMapMousePressed

    private void paneMapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseReleased
        p1 = null;
        if (firstNode.isSelected) {
            Node node = graph.getNodeAt(evt.getX(), evt.getY());
            if (!(node == firstNode.node || node == null)) {
                double weight = getWeight();
                if (weight < Graph.INF) {
                    graph.edgeList.add(new Edge(firstNode.node, node, weight));
                    firstNode.isSelected = false;
                    if (auto) {
                        graph.floydWarshall();
                    }
                }
            }
        }
        firstNode.isSelected = false;
        drawGraph();
    }//GEN-LAST:event_paneMapMouseReleased

    private void paneMapMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMapMouseDragged
        p2.x = evt.getX();
        p2.y = evt.getY();
        drawLine();
    }//GEN-LAST:event_paneMapMouseDragged

    private void shortestPathMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortestPathMenuActionPerformed
        cleanEdges();
        price = null;
        if (!selected.isSelected || !secondary.isSelected) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar dos nodos");
        } else if (graph.distances == null) {
            JOptionPane.showMessageDialog(null, "Primero ejecuta el algorimo floyd-warshall");
        } else if (selected.node == secondary.node) {
            price = "Costo: gratis";
        } else {
            int i = graph.nodeList.indexOf(selected.node);
            int j = graph.nodeList.indexOf(secondary.node);
            double costo = graph.distances[i][j];
            if (costo == Graph.INF) {
                JOptionPane.showMessageDialog(null, "No hay camino entre estas dos ciudades");

            } else {
                price = "Costo: " + graph.distances[i][j] + " bits";
                mostrarDistancia(selected.node, secondary.node);
            }
        }
        drawGraph();
    }//GEN-LAST:event_shortestPathMenuActionPerformed

    private void drawLine() {
        if (p1 != null && firstNode.isSelected) {
            Dimension d = paneMap.getSize();
            offScreenLineImage = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            if (offScreenGraphImage != null) {
                offScreenLineImage.getGraphics().drawImage(offScreenGraphImage, 0, 0, null);
            }
            Graphics2D g = (Graphics2D) offScreenLineImage.getGraphics();
            g.setColor(GraphicInfo.BLACK);
            g.draw(new Line2D.Double(p1, p2));
            paneMap.getGraphics().drawImage(offScreenLineImage, 0, 0, null);
        }
    }

    private void drawGraph() {
        //paneMap.paint(paneMap.getGraphics());
        if (offScreenGraphImage == null) {
            Dimension d = paneMap.getSize();
            this.offScreenGraphImage = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D g = (Graphics2D) offScreenGraphImage.getGraphics();
        g.drawImage(MAP, 0, 0, null);
        for (Edge edge : graph.edgeList) {
            drawEdge(edge);
        }

        for (Node<String> node : graph.nodeList) {
            drawNode(node);
        }
        if (price != null) {
            int width = g.getFontMetrics().stringWidth(price);
            g.setColor(GraphicInfo.BLACK);
            g.draw(new RoundRectangle2D.Double(20, 20, width + 20, FONT_SIZE * 2, 10, 10));
            g.setColor(GraphicInfo.YELLOW);
            g.fill(new RoundRectangle2D.Double(20, 20, width + 20, FONT_SIZE * 2, 10, 10));
            g.setColor(GraphicInfo.BLACK);
            g.setFont(font);
            g.drawString(price, (width + 20) / 2 - width / 2 + 20, (FONT_SIZE * 2) / 2 + 20 + 5);
            price = null;
        }
        paneMap.getGraphics().drawImage(offScreenGraphImage, 0, 0, null);
    }

    private double getWeight() {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el costo:"));
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            return Graph.INF;
        }
    }

    private void cleanEdges() {
        for (Edge edge : graph.edgeList) {
            edge.color = GraphicInfo.BLACK;
            edge.stroke = 1;
            drawEdge(edge);
        }
    }

    private void drawEdge(Edge edge) {
        Graphics2D g = (Graphics2D) offScreenGraphImage.getGraphics();
        Node n1 = edge.origin;
        Node n2 = edge.destiny;
        double x0 = n1.graphicInfo.circle.h;
        double y0 = n1.graphicInfo.circle.k;
        double x1 = n2.graphicInfo.circle.h;
        double y1 = n2.graphicInfo.circle.k;
        double[][] in = getIntersectionPoints(x0, y0, x1, y1, x1, y1, Graph.RADII);
        double x_text = (x0 + x1) / 2;
        double y_text = (y0 + y1) / 2;
        double x, y;
        int size = 12;

        if (x0 > x1) {
            y = in[0][1];
            x = in[0][0];
        } else {
            y = in[1][1];
            x = in[1][0];
        }

        drawArrow(x0, y0, x, y, edge.color);
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(edge.color);
        g.setStroke(new BasicStroke(edge.stroke));
        g.draw(new Line2D.Double(x0, y0, x, y));
        g.setFont(new Font("Arial", Font.BOLD, size));
        g.drawString(String.valueOf(edge.weight), (int) (x_text), (int) (y_text));
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

    private void drawArrow(double h0, double k0, double h, double k, Color color) {
        double phi = Math.toRadians(40);
        double tam_punta = 15;
        double delta_y = k - k0;
        double delta_x = h - h0;
        double theta = Math.atan2(delta_y, delta_x);
        double x, y, alpha = theta + phi;
        Graphics2D g = (Graphics2D) offScreenGraphImage.getGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        x = h - tam_punta * Math.cos(alpha);
        y = k - tam_punta * Math.sin(alpha);
        g.draw(new Line2D.Double(h, k, x, y));
        alpha = theta - phi;
        x = h - tam_punta * Math.cos(alpha);
        y = k - tam_punta * Math.sin(alpha);
        g.draw(new Line2D.Double(h, k, x, y));
    }

    private void drawNode(Node<String> node) {
        Graphics2D g = (Graphics2D) offScreenGraphImage.getGraphics();
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
        g.fill(new Rectangle2D.Double(x - stringWidth / 2 - 10, y + Graph.RADII + 10, stringWidth + 20, 15));
        g.setColor(node.graphicInfo.text_color);
        g.draw(new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2));
        g.drawString(info, (int) x - stringWidth / 2, (int) y + Graph.RADII + 20);
    }

    private void mostrarDistancia(Node u, Node v) {
        Stack<Node<String>> nodes = graph.getPath(u, v);
        Stack<Node<String>> ns = new Stack();
        while (!nodes.isEmpty()) {
            ns.push(nodes.pop());
        }
        System.out.println(Arrays.toString(nodes.toArray()));
        System.out.println(Arrays.toString(ns.toArray()));
        while (!ns.isEmpty()) {
            Node n = ns.pop();
            if (ns.isEmpty()) {
                break;
            }
            paintEdge(ns.peek(), n);
        }
    }

    private void paintEdge(Node u, Node v) {
        for (Edge edge : graph.edgeList) {
            if (edge.origin == u && edge.destiny == v) {
                edge.stroke = 3;
                edge.color = GraphicInfo.RED;
                drawEdge(edge);
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
            deleteNodeMenu.setEnabled(true);
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

            secondary.node.graphicInfo.color = GraphicInfo.PINK;
            secondary.node.graphicInfo.text_color = GraphicInfo.BLACK;
        }
        return true;
    }

    public void cleanSelection() {
        if (selected.isSelected) {
            selected.turnOff();
            deleteNodeMenu.setEnabled(false);
        }
        if (secondary.isSelected) {
            secondary.turnOff();
        }
        if (firstNode.isSelected) {
            firstNode.turnOff();
        }
        connectNodesMenu.setEnabled(false);
        shortestPathMenu.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem automaticWarshall;
    private javax.swing.JMenuItem connectNodesMenu;
    private javax.swing.JMenuItem deleteNodeMenu;
    private javax.swing.JMenuItem equestriaMapMenu;
    private javax.swing.JMenuItem helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem newGraphMenu;
    private javax.swing.JPanel paneMap;
    private javax.swing.JMenuItem shortestPathMenu;
    // End of variables declaration//GEN-END:variables
}
