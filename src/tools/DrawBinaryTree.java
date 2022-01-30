package tools;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DrawBinaryTree {
    private static DrawBinaryTree drawBinaryTree;

    private GraphViz graphViz;

    public static DrawBinaryTree getInstance() {
        if (drawBinaryTree == null) {
            synchronized (DrawBinaryTree.class) {
                if (drawBinaryTree == null) {
                    drawBinaryTree = new DrawBinaryTree();
                }
            }
        }
        return drawBinaryTree;
    }

    public void addEdge(Integer p, Integer c) {
        graphViz.addln(p + " -> " + c + ";");
    }

    private DrawBinaryTree() {
        graphViz = new GraphViz();
        graphViz.addln(graphViz.start_graph());
    }

    public static void empty() {
        synchronized (DrawBinaryTree.class) {
            if (drawBinaryTree != null) {
                drawBinaryTree = null;
            }
        }
    }

    public static void saveImage(String filename) {
        synchronized (DrawBinaryTree.class) {
            if (drawBinaryTree != null) {
                GraphViz gv = drawBinaryTree.graphViz;
                gv.addln(gv.end_graph());
                //System.out.println(gv.getDotSource());
                gv.increaseDpi();   // 106 dpi

                String type = "png";
                String representationType = "dot";
                File out = new File(filename +"."+ type);
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, representationType), out);
                drawBinaryTree = null;
            }
        }
    }

    public static void showImage() {
        synchronized (DrawBinaryTree.class) {
            if (drawBinaryTree != null) {
                GraphViz gv = drawBinaryTree.graphViz;
                gv.addln(gv.end_graph());
                //System.out.println(gv.getDotSource());
                gv.increaseDpi();   // 106 dpi

                byte[] graphBytes = gv.getGraph(gv.getDotSource(), "png", "dot");
                ImageIcon graph = new ImageIcon(graphBytes);
                ImageForm.showImage(graph.getImage(),new Dimension(graph.getIconWidth(),graph.getIconHeight()));
                drawBinaryTree = null;
            }
        }
    }
}
