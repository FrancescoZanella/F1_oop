package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class BackroundPanel extends JPanel {
    String path;
    Image image;


    public BackroundPanel(String path) {
        this.path = path;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
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
