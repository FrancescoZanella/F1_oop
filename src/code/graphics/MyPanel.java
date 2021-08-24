package graphics;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    int x;
    int y;
    int weight;
    int height;
    Color background;
    LayoutManager layout;

    public MyPanel(int weight, int height, Color background) {
        this.weight = weight;
        this.height = height;
        this.background = background;

        this.setPreferredSize(new Dimension(weight,height));
        this.setBackground(background);
    }

    public MyPanel(int x, int y, int weight, int height, LayoutManager layout) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.layout = layout;
        this.setBounds(x,y,weight,height);
        this.setLayout(layout);
    }

    public MyPanel(int x, int y, int weight, int height, Color background) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.background = background;
        this.setBounds(x,y,weight,height);
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
        this.setBounds(x,y,weight,height);
        this.setBackground(background);
    }
}
