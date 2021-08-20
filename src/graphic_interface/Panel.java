package graphic_interface;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Panel extends JPanel {

    BufferedImage image;

    public Panel(String filename) {
        setLayout(new BorderLayout());
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(), image.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}


