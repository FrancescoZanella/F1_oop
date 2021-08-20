package graphic_interface;


import javax.swing.*;
import java.awt.*;


public class Frame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Panel background = new Panel("banner.jpg");

                JFrame frame = new JFrame("Testing");
                frame.setContentPane(background);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Gui());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }}

