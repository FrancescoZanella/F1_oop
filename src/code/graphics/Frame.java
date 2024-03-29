package graphics;

import database.DataLeague;
import database.Utils;
import domain_classes.League;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Frame extends JFrame implements ActionListener, MouseListener, KeyListener {
    JComboBox<String> cbox;
    CardLayout cl1=new CardLayout();
    MyPanel panel;
    MyButton join;
    MyButton create;
    String current_user;
    List<League> l;
    JLabel jLabel5;
    JLabel label;
    JLabel exit;

    public Frame(String title,String current_user) throws HeadlessException {
        super(title);
        this.current_user=current_user;
        JPanel main=new JPanel();
        setContentPane(main);
        main.setLayout(null);
        List <Image> listImage=new ArrayList<>();
        try {
            listImage.add(ImageIO.read(new File("src/resources/images/16x16.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/32x32.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/64x64.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/128x128.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyPanel p=new MyPanel(0,0, Utils.width,100,"src/resources/background/bannerslim.JPG");
        p.setBounds(0, 0, Utils.width, 100);
        p.setLayout(null);

        exit=new JLabel();
       // exit.setBackground(new java.awt.Color(60, 63, 65));
        exit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(153, 153, 153));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.setBounds(Utils.width-15,0,12,24);
        exit.addMouseListener(this);
        p.add(exit);


        
        cbox= new JComboBox<>();
        l=new ArrayList<>(League.leaguesPerUser(current_user));

        for(League g : l){
            cbox.addItem(g.getLeagueName());
        }

        
        cbox.setBackground(new Color(19, 19, 31, 255));
        cbox.setBounds(Utils.width-200,30,150,30);
        cbox.addActionListener(this);

        join=new MyButton("Join with code",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/new_league.png"))));
        join.setBounds(880,30,180,30);

        create=new MyButton("Create League",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/create_league.png"))));
        create.setBounds(700,30,170,30);

        join.addActionListener(this);
        create.addActionListener(this);
        create.addKeyListener(this);
        cbox.addKeyListener(this);



        p.add(cbox);
        p.add(create);
        p.add(join);
        main.add(p);


        panel=new MyPanel(0,0,Utils.width,Utils.height,"src/resources/background/blum (2).JPG");
        panel.setLayout(cl1);

        label=new JLabel();

        //panel.add(label);
        label.setText("                                                                                                              You don't have a league, join or create a new one!!");
        label.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_error_35px.png"))));
        label.setForeground(Color.RED);
        label.setHorizontalTextPosition(SwingConstants.LEFT);
        label.setFont(new Font("Segoe UI",Font.BOLD,15));

        for(League g : l){
            panel.add(new InitialPanel(current_user,g.getInviteCode()),g.getLeagueName());



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
        if(e.getSource()==cbox) {
            String msg=(String)cbox.getSelectedItem();
            cl1.show(panel, msg);
        }
        if(e.getSource()==create){
            this.setVisible(false);
            dispose();
            EventQueue.invokeLater(() -> new CreateLeague(current_user));

        }
        if(e.getSource()==join){
            new JoinLeague(current_user);
            dispose();

        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==exit){
            dispose();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

