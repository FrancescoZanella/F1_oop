package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    int x;
    int y;
    int weight;
    int height;
    Color background;
    LayoutManager layout;
    String path;
    Image image;

    public MyPanel(String path) {
        this.path = path;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyPanel(int x, int y, int weight, int height, String path) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.path = path;

        this.path = path;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBounds(x, y, weight, height);

    }

    public MyPanel(int weight, int height, Color background) {
        this.weight = weight;
        this.height = height;
        this.background = background;

        this.setPreferredSize(new Dimension(weight, height));
        this.setBackground(background);
    }

    public MyPanel(int x, int y, int weight, int height, LayoutManager layout) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.layout = layout;
        this.setBounds(x, y, weight, height);
        this.setLayout(layout);
    }

    public MyPanel(int x, int y, int weight, int height, Color background) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.background = background;
        this.setBounds(x, y, weight, height);
        this.setBackground(background);
    }

    public MyPanel(int x, int y, int weight, int height, Color background, LayoutManager layout) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.background = background;
        this.layout = layout;

        this.setLayout(layout);
        this.setBounds(x, y, weight, height);
        this.setBackground(background);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
