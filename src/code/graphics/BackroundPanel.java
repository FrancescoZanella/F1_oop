package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class BackroundPanel extends JPanel {
    String path;
    Image image;


    public BackroundPanel(String path) {
        this.path = path;
        try {
            image=ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
