package graphics;

import database.DataLeague;
import database.Utils;
import domain_classes.League;
import jdk.jshell.execution.Util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Frame extends JFrame implements ActionListener {
    JComboBox<String> cbox;
    CardLayout cl1 = new CardLayout();
    JPanel panel;
    MyButton join;
    MyButton create;
    String current_user;
    List<League> l;
    JLabel jLabel5;
    DataLeague d;

    public Frame(String title, String current_user) throws HeadlessException {
        super(title);
        this.current_user = current_user;
        JPanel main = new JPanel();
        setContentPane(main);
        main.setLayout(null);
        List<Image> listImage = new ArrayList<>();
        d = new DataLeague();
        try {
            listImage.add(ImageIO.read(new File("src/resources/images/16x16.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/32x32.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/64x64.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/128x128.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyPanel p = new MyPanel(0, 0, Utils.width, 100, "src/resources/background/bannerslim.JPG");
        p.setBounds(0, 0, Utils.width, 100);
        p.setLayout(null);

        cbox = new JComboBox<>();
        l = new ArrayList<>(d.LeaguesPerUser(current_user));

        for (League g : l) {
            cbox.addItem(g.getLeagueName());
        }


        cbox.setBackground(new Color(19, 19, 31, 255));
        cbox.setBounds(Utils.width - 200, 30, 150, 30);
        cbox.addActionListener(this);

        join = new MyButton("Join with code", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/new_league.png"))));
        join.setBounds(880, 30, 180, 30);

        create = new MyButton("Create League", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/create_league.png"))));
        create.setBounds(700, 30, 170, 30);

        join.addActionListener(this);
        create.addActionListener(this);

        p.add(cbox);
        p.add(create);
        p.add(join);

        main.add(p);


        panel = new JPanel();
        panel.setBounds(0, 0, Utils.width, Utils.height);
        panel.setLayout(cl1);

        for (League g : l) {
            panel.add(new InitialPanel(current_user), g.getLeagueName());

        }

        main.add(panel);


        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImages(listImage);
        this.setResizable(false);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbox) {
            String msg = (String) cbox.getSelectedItem();
            cl1.show(panel, msg);
        }
        if (e.getSource() == create) {
            this.setVisible(false);
            dispose();
            EventQueue.invokeLater(() -> new CreateLeague());

        }
        if (e.getSource() == join) {

        }

    }


}

