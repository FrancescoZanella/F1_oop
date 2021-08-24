package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class MyPasswordField extends JPasswordField {

    public MyPasswordField(int columns){ super(columns); }
    public MyPasswordField(String text, int columns){ super(text, columns); }

    @Override
    public void paintComponents(Graphics g) {
        g.fillRoundRect(0,0, getColumns() * 10 + 3, getHeight()-1, 15, 15);
        super.paintComponents(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(0, 0, getColumns() * 10 + 3, getHeight()-1, 15, 15);
    }

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getColumns() * 10 + 3, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
