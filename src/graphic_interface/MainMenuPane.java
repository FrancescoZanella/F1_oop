package graphic_interface;

import javax.swing.*;
import java.awt.*;

public class MainMenuPane extends JPanel {

    JButton singlePlayerButton;
    JButton multiPlayerButton;

    JLabel text;

    public MainMenuPane() {

        setLayout(new GridBagLayout());
        setOpaque(false);
        setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.ipadx = 20;
        gbc.ipady = 20;

        singlePlayerButton = new JButton("Login");

        add(singlePlayerButton, gbc);

        multiPlayerButton = new JButton("Register");

        add(multiPlayerButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // This is faking transparency, so the background color
        // will be see through
        Graphics2D g2d = (Graphics2D) g.create();
        Composite old = g2d.getComposite();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setComposite(old);
    }

}
