package graphics;

import database.DataLeague;
import database.Utils;
import domain_classes.League;

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

import static java.awt.Color.white;


public class Frame extends JFrame implements ActionListener{
    JComboBox<String> cbox;
    CardLayout cl1=new CardLayout();
    JPanel panel;
    MyButton join;
    MyButton create;
    String current_user;
    List<League> l;
    DataLeague d;

    public Frame(String title,String current_user) throws HeadlessException {
        super(title);
        this.current_user=current_user;
        JPanel main=new JPanel();
        setContentPane(main);
        main.setLayout(null);
        List <Image> listImage=new ArrayList<>();
        d=new DataLeague();
        try {
            listImage.add(ImageIO.read(new File("src/resources/images/16x16.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/32x32.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/64x64.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/128x128.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BackroundPanel p=new BackroundPanel("src/resources/background/bannerslim.JPG");
        p.setBounds(0, 0, Utils.width, 100);
        p.setLayout(null);

        cbox= new JComboBox<>();
        l=d.LeaguesPerUser(current_user);
        for(League g : l){
            cbox.addItem(g.getLeagueName());
        }


        cbox.setBackground(new Color(19, 19, 31, 255));
        cbox.setBounds(Utils.width-200,30,150,30);
        cbox.addActionListener(this);

        join=new MyButton("Join with  code",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/new_league.png"))));
        join.setBounds(880,30,180,30);

        create=new MyButton("Create League",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/create_league.png"))));
        create.setBounds(700,30,170,30);

        join.addActionListener(this);
        create.addActionListener(this);

        p.add(cbox);
        p.add(create);
        p.add(join);

        main.add(p);

    InitialPanel e5=new InitialPanel();
        InitialPanel e=new InitialPanel();
        InitialPanel e1=new InitialPanel();
        InitialPanel e2=new InitialPanel();
        panel=new JPanel();
        panel.setBounds(0,0,Utils.width,Utils.height);
        panel.setLayout(cl1);
        panel.add(e,"panel1");
        panel.add(e1,"panel2");
        panel.add(e2,"panel3");
        main.add(panel);




       // this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImages(listImage);
        this.setResizable(false);
        this.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cbox){
            String msg=(String)cbox.getSelectedItem();
            if(e.getSource()==cbox) {
                if(msg.equals("Lega 1")){
                    cl1.show(panel,"panel1");
                }
                if(msg.equals("Lega 2")){
                    cl1.show(panel,"panel2");
                }
                else{
                    cl1.show(panel,"panel3");

                }
            }

        }
        if(e.getSource()==create){
            this.setVisible(false);
            dispose();
            new CreateLeague();

        }
        if(e.getSource()==join){

        }

    }


}

