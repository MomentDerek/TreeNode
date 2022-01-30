package tools;

import javax.swing.*;
import java.awt.*;

/**
 * 图片显示器
 * @author stonelu
 * @date 2019-04-30 17:20
 */
public class ImageForm {

    /**
     * 显示指定文件路径图片
     * @param imagePath
     * @param size
     */
    public static void showImage(String imagePath, Dimension size) {
        showImage(new ImageIcon(imagePath).getImage(), size);
    }

    /**
     * 显示Image图片元素
     * @param image
     * @param size
     */
    public static void showImage(Image image, Dimension size) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setSize(size);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new PaintPanel(image, size));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /**
     * 图片容器
     */
    private static class PaintPanel extends JPanel {

        private ImageIcon imageIcon;
        private Dimension size;

        public PaintPanel(Image image, Dimension size) {
            imageIcon = new ImageIcon(image);
            this.size = size;
        }

        @Override
        public Dimension getPreferredSize() {
            // 初识大小
            return size;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 图片大小自适应，可拖拽
            g.drawImage(this.imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), imageIcon.getImageObserver());
        }
    }
}
