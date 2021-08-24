package graphics;


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

import static java.awt.Color.*;

public class InitialFrame extends JFrame implements ActionListener {
        private JButton homeButton;
        private JButton teamButton;
        private JButton leaderboardButton;
        private JButton profileButton;
        private JButton rulesButton;
        private JButton settingsButton;
        private JButton logoutButton;


        public InitialFrame(String title) {
                super(title);

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width=screenSize.width;
                int height=screenSize.height;

                //UPpanel
                this.setLayout(null);
                BackroundPanel upPanel=new BackroundPanel("src/resources/background/bannerslim.JPG");
                //upPanel.setPreferredSize(new Dimension(width,100));
                upPanel.setBounds(0,0,width,100);
                this.add(upPanel);


                //leftpanel
                JPanel leftpanel=new JPanel();
                //leftpanel.setPreferredSize(new Dimension(250,height-100));
                leftpanel.setBackground(Color.black);
                leftpanel.setBounds(0,100,250,height-100);
                leftpanel.setLayout(new FlowLayout());
                this.add(leftpanel);

                //leftuppanel
                JPanel leftuppanel=new JPanel();
                leftuppanel.setPreferredSize(new Dimension(250,20));
                leftuppanel.setBackground(Color.black);
                leftpanel.add(leftuppanel);

                //HomeButton
                homeButton=new JButton("Home",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_home_20px_7.png"))));
                homeButton.setPreferredSize(new Dimension(200,40));
                homeButton.setForeground(white);
                homeButton.setBackground(Color.black);
                homeButton.setBorderPainted(false);
                homeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                homeButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(homeButton);

                //TeamButton
                teamButton=new JButton("Team",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_crowd_20px.png"))));
                teamButton.setPreferredSize(new Dimension(200,40));
                teamButton.setForeground(white);
                teamButton.setBackground(Color.black);
                teamButton.setBorderPainted(false);
                teamButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                teamButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(teamButton);

                //leaderboards botton
                leaderboardButton=new JButton("Leaderboards",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_leaderboard_20px.png"))));
                leaderboardButton.setPreferredSize(new Dimension(200,40));
                leaderboardButton.setForeground(white);
                leaderboardButton.setBackground(Color.black);
                leaderboardButton.setBorderPainted(false);
                leaderboardButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                leaderboardButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(leaderboardButton);
                
                //profile botton
                profileButton=new JButton("Profile",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_customer_20px.png"))));
                profileButton.setPreferredSize(new Dimension(200,40));
                profileButton.setForeground(white);
                profileButton.setBackground(Color.black);
                profileButton.setBorderPainted(false);
                profileButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                profileButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(profileButton);

                //rules botton
                rulesButton=new JButton("Rules",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/regole.png"))));
                rulesButton.setPreferredSize(new Dimension(200,40));
                rulesButton.setForeground(white);
                rulesButton.setBackground(Color.black);
                rulesButton.setBorderPainted(false);
                rulesButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                rulesButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(rulesButton);


                //leftdownpanel
                JPanel leftdownpanel=new JPanel();
                leftdownpanel.setPreferredSize(new Dimension(250,230));
                leftdownpanel.setBackground(black);
                leftpanel.add(leftdownpanel);

                //barseparator
                JSeparator sep=new JSeparator();
                sep.setBackground(WHITE);
                sep.setForeground(WHITE);
                sep.setOrientation(SwingConstants.HORIZONTAL);
                sep.setPreferredSize(new Dimension(200,10));
                leftdownpanel.add(sep);
                
                //settings button
                settingsButton=new JButton("Settings",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/settings.png"))));
                settingsButton.setPreferredSize(new Dimension(200,40));
                settingsButton.setForeground(white);
                settingsButton.setBackground(Color.black);
                settingsButton.setBorderPainted(false);
                settingsButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                settingsButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(settingsButton);

                //logout button
                logoutButton=new JButton("Logout",new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/logout.png"))));
                logoutButton.setPreferredSize(new Dimension(200,40));
                logoutButton.setForeground(white);
                logoutButton.setBackground(Color.black);
                logoutButton.setBorderPainted(false);
                logoutButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
                leftpanel.add(logoutButton);


                //downpanel
                JPanel downPanel=new JPanel();
                downPanel.setBackground(white);
                downPanel.setBounds(250,500,width-250,200);
                this.add(downPanel);

                

                List <Image> listImage=new ArrayList<>();
                try {
                        listImage.add(ImageIO.read(new File("src/resources/images/16x16.png")));
                        listImage.add(ImageIO.read(new File("src/resources/images/32x32.png")));
                        listImage.add(ImageIO.read(new File("src/resources/images/64x64.png")));
                        listImage.add(ImageIO.read(new File("src/resources/images/128x128.png")));
                } catch (IOException e) {
                        e.printStackTrace();
                }


                //frame
                this.add(upPanel,BorderLayout.NORTH);
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setIconImages(listImage);
                this.setResizable(false);
                this.setVisible(true);



        }

        public static void main(String[] args) {
                new InitialFrame("Prova");
        }


        @Override
        public void actionPerformed(ActionEvent e) {

        }
}
