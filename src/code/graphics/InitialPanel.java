package graphics;



import database.Utils;
import domain_classes.League;
import domain_classes.Team;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Objects;

import static java.awt.Color.*;

public class InitialPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
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
        LeaderBoardPage centerLeaderboards;
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

        String invitation_code;




        public InitialPanel(String current_user,String invitation_code){
                this.invitation_code=invitation_code;

                
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
                centerTeam = new TeamPage(current_user,invitation_code);//(current_user);
                centerLeaderboards = new LeaderBoardPage(current_user,invitation_code);


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
                leaderboardButton.addKeyListener(this);
                profileButton.addKeyListener(this);
                rulesButton.addKeyListener(this);
                teamButton.addKeyListener(this);





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

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        SwingUtilities.getWindowAncestor(this).dispose();

                }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
}
