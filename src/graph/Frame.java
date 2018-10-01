package graph;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import static java.lang.Math.abs;
import java.util.Arrays;

public class Frame extends javax.swing.JFrame {

    public class Selection<T> {

        public boolean isSelected;
        public Node<T> node;

        public Selection() {
            node = new Node(null);
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
            node.graphicInfo.color = selected ? Color.black : Color.white;
            node.graphicInfo.text_color = selected ? Color.white : Color.black;
        }
    }

    private final Graph<String> graph;
    private int[][] distancias;
    private String[][] caminos;
    private final int node_radii = 35;
    private Selection<String> selectedNode;
    private Selection<String> secondaryNode;

    public Frame() {
        graph = new Graph();
        selectedNode = new Selection();
        secondaryNode = new Selection();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
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

        lbMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/map_of_equestria.png"))); // NOI18N
        lbMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMapMouseClicked(evt);
            }
        });

        btFloyd.setRollover(true);

        btAddEdge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/route.png"))); // NOI18N
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

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/delete.png"))); // NOI18N
        btEliminar.setToolTipText("Eliminar ciudad");
        btEliminar.setFocusable(false);
        btEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFloyd.add(btEliminar);

        btCalculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/calculate.png"))); // NOI18N
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

        btHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graph/help.png"))); // NOI18N
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
                .addGap(10, 10, 10)
                .addComponent(lbMap, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void floydWarshall() {
        distancias = graph.getDistanceMatrix();
        caminos = graph.getPathMatrix();
        int n = distancias.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (distancias[i][j] != 0) {
                        if ((distancias[i][k] + distancias[k][j]) < distancias[i][j]) {
                            distancias[i][j] = distancias[i][k] + distancias[k][j];
                            caminos[i][j] = graph.nodeList.get(k).info;
                        }
                    }
                }
            }
        }
    }

    public Node getSelectedNode(int x, int y) {
        for (Node<String> node : graph.nodeList) {
            if (node.graphicInfo.contains(x, y)) {
                System.out.println("Contenido dentro de " + node.info);
                return node;
            }
        }
        return null;
    }

    private void mostrarDistancia(Node n1, Node n2) {
        if (n1 == n2) {
            JOptionPane.showMessageDialog(null, "No tienes que pagar nada para ir de " + n1.info + " hasta " + n2.info);
        } else {
            int costo = distancias[graph.nodeList.indexOf(n1)][graph.nodeList.indexOf(n2)];
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
            if (node.graphicInfo.contains(x, y)) {
                System.out.println("El punto (" + x + ", " + y + ") está dentro de " + node.info);
                nodeClicked = true;
                if (button == MouseEvent.BUTTON1) {
                    if (selectedNode.isSelected) {
                        selectedNode.node.graphicInfo.color = Color.white;
                        selectedNode.node.graphicInfo.text_color = Color.black;
                    }
                    selectedNode.isSelected = true;
                    selectedNode.node = node;
                    selectedNode.node.graphicInfo.color = Color.black;
                    selectedNode.node.graphicInfo.text_color = Color.white;
                } else {
                    if (secondaryNode.isSelected) {
                        secondaryNode.node.graphicInfo.color = Color.white;
                        secondaryNode.node.graphicInfo.text_color = Color.black;
                    }
                    secondaryNode.isSelected = true;
                    secondaryNode.node = node;
                    secondaryNode.node.graphicInfo.color = Color.blue;
                    secondaryNode.node.graphicInfo.text_color = Color.white;
                }
                break;
            }
        }
        return nodeClicked;
    }

    public void cleanSelection() {
        System.out.println("Cleaning...");
        if (selectedNode.isSelected) {
            selectedNode.setSelected(false);
        }
        if (secondaryNode.isSelected) {
            secondaryNode.setSelected(false);
        }
    }

    private void lbMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMapMouseClicked
        if (!selectNode(evt.getX(), evt.getY(), evt.getButton())) {
            if (!(selectedNode.isSelected || secondaryNode.isSelected)) {
                if (graph.isOccupied(evt.getX(), evt.getY(), node_radii)) {
                    JOptionPane.showMessageDialog(null, "El lugar está ocupado por otro nodo");
                } else {
                    String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del lugar");
                    if (!(nombre == null || nombre.trim().isEmpty() || graph.contains(nombre))) {
                        Node node = new Node(nombre);
                        node.setGraphicInfo(evt.getX(), evt.getY(), node_radii, Color.white, Color.black);
                        System.out.println("evt.getX() = " + evt.getX());
                        System.out.println("evt.getY() = " + evt.getY());
                        graph.addNode(node);
                    }
                }
            }
            cleanSelection();
        }
        drawGraph();
    }//GEN-LAST:event_lbMapMouseClicked

    private void btCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalculateActionPerformed
        if (selectedNode.isSelected && secondaryNode.isSelected && distancias != null){
            int costo = distancias[graph.nodeList.indexOf(selectedNode.node)][graph.nodeList.indexOf(secondaryNode.node)];
            if (costo == Graph.INF){
                JOptionPane.showMessageDialog(null, "Parece que no puedes ir de "+ selectedNode.node.info + " a " + secondaryNode.node.info);
            }else{
                JOptionPane.showMessageDialog(null, "Ir de " + selectedNode.node.info + " a " + secondaryNode.node.info + " cuesta " + costo);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona dos ciudades, y no olvides ejecutar el floyd-warshall");
        }
    }//GEN-LAST:event_btCalculateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        floydWarshall();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAddEdgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEdgeActionPerformed
        if (selectedNode.isSelected && secondaryNode.isSelected) {
            int weight = getWeight();
            if (weight == -1) {
                return;
            }
            Edge edge = new Edge(selectedNode.node, secondaryNode.node, weight);
            graph.edgeList.add(edge);
            graph.edgeList.add(edge.inverse());
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
        Node n1 = edge.origin;
        Node n2 = edge.destiny;
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        g.drawLine(n1.graphicInfo.h, n1.graphicInfo.k, n2.graphicInfo.h, n2.graphicInfo.k);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(String.valueOf(edge.weight), abs(n1.graphicInfo.h + n2.graphicInfo.h) / 2, abs(n1.graphicInfo.k + n2.graphicInfo.k) / 2);
    }

    private void drawNode(Node<String> node) {
        Graphics g = lbMap.getGraphics();
        int x = node.graphicInfo.h;
        int y = node.graphicInfo.k;
        int radius = node.graphicInfo.r;
        String info = node.info;
        int stringWidth = g.getFontMetrics().stringWidth(info);
        g.setColor(node.graphicInfo.color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        g.setColor(node.graphicInfo.text_color);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
        g.drawString(info, x - stringWidth / 2, y);
    }

    private void drawGraph() {
        lbMap.paint(lbMap.getGraphics());
        Graphics g = lbMap.getGraphics();
        for (Edge edge : graph.edgeList) {
            drawEdge(edge);
        }
        for (Node<String> node : graph.nodeList) {
            drawNode(node);
        }
    }

    void showMatrices() {
        int[][] distancia = graph.getDistanceMatrix();
        String[][] caminos = graph.getPathMatrix();
        System.out.println("Caminos:");
        for (int i = 0; i < caminos.length; i++) {
            System.out.println(Arrays.toString(caminos[i]));
        }
        System.out.println("\nDistancias:");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println(Arrays.toString(distancia[i]));
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
