package graphic_interface;

import javax.swing.*;
import java.awt.*;

public class BasicMenuBar extends JMenuBar {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(0, 0, getWidth(), 50);
    }
}
