package graphics;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.white;

public class MyButton extends JButton {
    public MyButton(String text, Icon icon) {
        super(text, icon);
        this.setPreferredSize(new Dimension(200,40));
        this.setForeground(white);
        this.setBackground(new Color(19,19,31,255));
        this.setBorderPainted(false);
        this.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.setHorizontalAlignment(SwingConstants.LEFT);

    }


}
