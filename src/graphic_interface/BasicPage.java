package graphic_interface;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class BasicPage extends JFrame {

    public BasicPage() {
        super();
        BasicPanel mp = new BasicPanel();
        BasicMenuBar basic = new BasicMenuBar();

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(mp, BorderLayout.CENTER);
        c.add(basic);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setVisible(true);
    }

    public static void main(String[] args){
        BasicPage mp = new BasicPage();
    }
}
