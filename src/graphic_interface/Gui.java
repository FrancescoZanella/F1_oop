package graphic_interface;

import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel {

    private MainMenuPane mainMenuPane;
    private CardLayout cardLayout;

    public Gui() {

        setOpaque(false);

        setVisible(true);
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        mainMenuPane = new MainMenuPane();
        // Other views

        add(mainMenuPane, "MainMenu");

        cardLayout.show(this, "MainMenu");

    }

}