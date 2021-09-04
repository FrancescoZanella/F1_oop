package graphics;



import database.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

import static java.awt.Color.*;

public class InitialPanel extends JPanel implements ActionListener, MouseListener {
        //private final MyButton homeButton;
        private final MyButton teamButton;
        private final MyButton leaderboardButton;
        private final MyButton profileButton;
        private final MyButton rulesButton;
        private final MyButton settingsButton;
        private final MyButton logoutButton;
        //MyPanel centerHome;
        MyPanel downPanel;
        TeamPage centerTeam;
        MyPanel centerLeaderboards;
        ProfilePage centerProfile;
        RulesPage centerRules;
        SettingsPage centerSettings;
        MyPanel centerLogout;
        MyPanel centerPanel;
        MyPanel leftpanel;
        MyPanel leftdownpanel;
        MyPanel leftuppanel;
        CardLayout cl = new CardLayout();
        ArrayList<MyButton> ar;
        String current_user;




        public InitialPanel(String current_user,String current_league){
                
                this.current_user = current_user;
                this.setLayout(null);

                leftpanel = new MyPanel(0,100,250,Utils.height-100,new Color(19, 19, 31, 255),new FlowLayout());
               // leftuppanel = new MyPanel(250,120,new Color(19, 19, 31, 255));
                //leftpanel.add(leftuppanel);

                //HomeButton
                /*homeButton = new MyButton("Home", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/home.png"))));
                homeButton.addActionListener(this);
                homeButton.addMouseListener(this);

                leftpanel.add(homeButton);*/

                //TeamButton
                teamButton = new MyButton("Team", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/team.png"))));
                teamButton.addActionListener(this);
                teamButton.addMouseListener(this);
                leftpanel.add(teamButton);

                //leaderboards botton
                leaderboardButton = new MyButton("Leaderboards", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/leaderboard.png"))));
                leaderboardButton.addActionListener(this);
                leaderboardButton.addMouseListener(this);

                leftpanel.add(leaderboardButton);

                //profile botton
                profileButton = new MyButton("Profile", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/profile.png"))));
                profileButton.addActionListener(this);
                profileButton.addMouseListener(this);

                leftpanel.add(profileButton);

                //rules botton
                rulesButton = new MyButton("Rules", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/regoles.png"))));
                rulesButton.addActionListener(this);
                rulesButton.addMouseListener(this);

                leftpanel.add(rulesButton);


                //leftdownpanel
                leftdownpanel = new MyPanel(250,250,new Color(19, 19, 31, 255));
                leftpanel.add(leftdownpanel);

                //barseparator
                JSeparator sep = new JSeparator();
                sep.setBackground(WHITE);
                sep.setForeground(WHITE);
                sep.setOrientation(SwingConstants.HORIZONTAL);
                sep.setPreferredSize(new Dimension(200, 10));
                leftdownpanel.add(sep);

                //settings button
                settingsButton = new MyButton("Settings", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/settingss.png"))));
                settingsButton.addActionListener(this);
                settingsButton.addMouseListener(this);

                leftpanel.add(settingsButton);

                //logout button
                logoutButton = new MyButton("Logout", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/logouts.png"))));
                logoutButton.addActionListener(this);
                logoutButton.addMouseListener(this);

                leftpanel.add(logoutButton);


                downPanel = new MyPanel(250,600, Utils.width-250,120,"src/resources/background/Cattura.jpg");
                centerPanel = new MyPanel(250,100,Utils.width-250,Utils.height-200,cl);
                //centerHome = new MyPanel(250,100,Utils.width-250,Utils.height-200,BLACK);
                centerTeam = new TeamPage(current_user,current_league);//(current_user);
                centerLeaderboards = new MyPanel(250, 100, Utils.width - 250, Utils.height - 200,WHITE);
                //gli passo current user e current_league e se
                centerProfile = new ProfilePage(current_user);
                centerRules = new RulesPage();//MyPanel(250, 100, Utils.width - 250, Utils.height - 200,ORANGE);
                centerSettings = new SettingsPage(current_user);

                //centerPanel.add(centerHome, "home");
                centerPanel.add(centerTeam,"team");
                centerPanel.add(centerLeaderboards, "leaderboards");
                centerPanel.add(centerProfile, "profile");
                centerPanel.add(centerRules, "rules");
                centerPanel.add(centerSettings, "settings");
                //centerPanel.add(centerLogout, "logout");


                this.add(centerPanel);
                this.add(downPanel);
                this.add(leftpanel);





        }

        @Override
        public void actionPerformed(ActionEvent e) {
               /* if (e.getSource() == homeButton) {
                        cl.show(centerPanel, "home");
                }*/
                if (e.getSource() == teamButton) {
                        cl.show(centerPanel, "team");
                }
                if (e.getSource() == leaderboardButton) {
                        cl.show(centerPanel, "leaderboards");
                }
                if (e.getSource() == profileButton) {
                        cl.show(centerPanel, "profile");
                }
                if (e.getSource() == rulesButton) {
                        cl.show(centerPanel, "rules");
                }
                if (e.getSource() == settingsButton) {
                        cl.show(centerPanel, "settings");
                }
                if (e.getSource() == logoutButton) {
                        new LoginPage();
                        SwingUtilities.getWindowAncestor(this).dispose();
                }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                ar=new ArrayList<MyButton>();
               // ar.add(homeButton);
                ar.add(teamButton);
                ar.add(leaderboardButton);
                ar.add(profileButton);
                ar.add(rulesButton);
                ar.add(settingsButton);
                ar.add(logoutButton);
                if(e.getSource() instanceof MyButton){
                        ((MyButton) e.getSource()).setBackground(new Color(69,73,74));
                        for(MyButton mb : ar){
                                if(mb!=e.getSource()){
                                        mb.setBackground(new Color(19,19,31,255));
                                }
                        }


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
}
