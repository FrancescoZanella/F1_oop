package graphics;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Objects;

import static java.awt.Color.*;

public class InitialPanel extends JPanel implements ActionListener{
        private final JButton homeButton;
        private final JButton teamButton;
        private final JButton leaderboardButton;
        private final JButton profileButton;
        private final JButton rulesButton;
        private final JButton settingsButton;
        private final JButton logoutButton;
        MyPanel centerHome;
        MyPanel downPanel;
        MyPanel centerTeam;
        MyPanel centerLeaderboards;
        MyPanel centerProfile;
        MyPanel centerRules;
        MyPanel centerSettings;
        MyPanel centerLogout;
        MyPanel centerPanel;
        MyPanel leftpanel;
        MyPanel leftdownpanel;
        MyPanel leftuppanel;
        CardLayout cl = new CardLayout();





        public InitialPanel(){
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width=screenSize.width;
                int height=screenSize.height;

                this.setLayout(null);

                leftpanel = new MyPanel(0,100,250,height-100,new Color(19, 19, 31, 255),new FlowLayout());
                leftuppanel = new MyPanel(250,120,new Color(19, 19, 31, 255));
                leftpanel.add(leftuppanel);

                //HomeButton
                homeButton = new MyButton("Home", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_home_20px_7.png"))));
                homeButton.addActionListener(this);
                leftpanel.add(homeButton);

                //TeamButton
                teamButton = new MyButton("Team", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_crowd_20px.png"))));
                teamButton.addActionListener(this);
                leftpanel.add(teamButton);

                //leaderboards botton
                leaderboardButton = new MyButton("Leaderboards", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_leaderboard_20px.png"))));
                leaderboardButton.addActionListener(this);
                leftpanel.add(leaderboardButton);

                //profile botton
                profileButton = new MyButton("Profile", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/icons8_customer_20px.png"))));
                profileButton.addActionListener(this);
                leftpanel.add(profileButton);

                //rules botton
                rulesButton = new MyButton("Rules", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/regole.png"))));
                rulesButton.addActionListener(this);
                leftpanel.add(rulesButton);


                //leftdownpanel
                leftdownpanel = new MyPanel(250,150,new Color(19, 19, 31, 255));
                leftpanel.add(leftdownpanel);

                //barseparator
                JSeparator sep = new JSeparator();
                sep.setBackground(WHITE);
                sep.setForeground(WHITE);
                sep.setOrientation(SwingConstants.HORIZONTAL);
                sep.setPreferredSize(new Dimension(200, 10));
                leftdownpanel.add(sep);

                //settings button
                settingsButton = new MyButton("Settings", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/settings.png"))));
                settingsButton.addActionListener(this);
                leftpanel.add(settingsButton);

                //logout button
                logoutButton = new MyButton("Logout", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/logout.png"))));
                logoutButton.addActionListener(this);
                leftpanel.add(logoutButton);


                downPanel = new MyPanel(250,600,width-250,100, WHITE);
                centerPanel = new MyPanel(250,100,width-250,height-200,cl);
                centerHome = new MyPanel(250,100,width-250,height-200,BLACK);
                centerTeam = new MyPanel(250, 100, width - 250, height - 200,BLUE);
                centerLeaderboards = new MyPanel(250, 100, width - 250, height - 200,WHITE);
                centerProfile = new MyPanel(250, 100, width - 250, height - 200,GRAY);
                centerRules = new MyPanel(250, 100, width - 250, height - 200,ORANGE);
                centerSettings = new MyPanel(250, 100, width - 250, height - 200,BLACK);
                centerLogout = new MyPanel(250, 100, width - 250, height - 200,RED);

                centerPanel.add(centerHome, "home");
                centerPanel.add(centerTeam, "team");
                centerPanel.add(centerLeaderboards, "leaderboards");
                centerPanel.add(centerProfile, "profile");
                centerPanel.add(centerRules, "rules");
                centerPanel.add(centerSettings, "settings");
                centerPanel.add(centerLogout, "logout");


                this.add(centerPanel);
                this.add(downPanel);
                this.add(leftpanel);





        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == homeButton) {
                                cl.show(centerPanel, "home");
                }
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
                        cl.show(centerPanel, "logout");
                }










        }
}
