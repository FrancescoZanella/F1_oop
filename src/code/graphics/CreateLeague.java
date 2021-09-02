package graphics;

import database.DataLeague;
import database.DataUser;
import domain_classes.League;
import domain_classes.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class CreateLeague extends JFrame implements MouseListener, KeyListener {
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSlider jSlider1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    DataLeague d;

    public CreateLeague() {
        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jPanel4 = new JPanel();
        jLabel4 = new JLabel();
        jLabel7 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jPanel2 = new JPanel();
        jLabel10 = new JLabel();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jLabel5 = new JLabel();
        jCheckBox3 = new JCheckBox();
        jCheckBox4 = new JCheckBox();
        jCheckBox5 = new JCheckBox();
        jLabel6 = new JLabel();
        jSlider1 = new JSlider();
        jTextField2 = new JTextField();
        jLabel9 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(19, 19, 31));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(60, 63, 65));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Create a new League");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("League Name");

        jTextField1.setBackground(new java.awt.Color(69, 73, 74));
        jTextField1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setBorder(null);


        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Create and share with your friends your League");

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel4.setForeground(new java.awt.Color(240, 240, 240));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("               Create");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/icons/cars.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Maximum Teams per Player");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Invitation Code");

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Invitation Code already used, change it!");

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Private");
        jCheckBox1.setContentAreaFilled(false);


        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox2.setText("3");
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.setEnabled(false);


        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("League Type");

        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox3.setText("Public");
        jCheckBox3.setContentAreaFilled(false);
        jCheckBox3.setEnabled(false);


        jCheckBox4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox4.setText("2");
        jCheckBox4.setContentAreaFilled(false);
        jCheckBox4.setEnabled(false);


        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(204, 204, 204));
        jCheckBox5.setSelected(true);
        jCheckBox5.setText("1");
        jCheckBox5.setContentAreaFilled(false);


        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("League Lenght");

        jSlider1.setBackground(new java.awt.Color(19, 19, 31));
        jSlider1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jSlider1.setForeground(new java.awt.Color(204, 204, 204));
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(20);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(0);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jSlider1.setPreferredSize(new java.awt.Dimension(200, 30));

        jTextField2.setBackground(new java.awt.Color(69, 73, 74));
        jTextField2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setBorder(null);


        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jCheckBox3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jCheckBox5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jCheckBox4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jCheckBox2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextField1, GroupLayout.Alignment.LEADING)
                                                .addComponent(jSlider1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jCheckBox1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox4)
                                        .addComponent(jCheckBox5)
                                        .addComponent(jCheckBox2))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel9.setBackground(new java.awt.Color(60, 63, 65));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel9.setText("X");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(106, 106, 106))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jTextField1.addKeyListener(this);
        jCheckBox1.addKeyListener(this);
        jCheckBox2.addKeyListener(this);
        jCheckBox3.addKeyListener(this);
        jCheckBox4.addKeyListener(this);
        jCheckBox5.addKeyListener(this);
        jSlider1.addKeyListener(this);
        jTextField2.addKeyListener(this);
        jLabel9.addMouseListener(this);
        jLabel4.addMouseListener(this);

        jLabel9.addKeyListener(this);

        jLabel10.setVisible(false);
        this.setBounds(400, 30, 578, 666);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);

        try {
            d = new DataLeague();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            //nel caso di invio: controllo che tutti i campi siano completi e che league e invitation non esistano gia
            jLabel10.setVisible(false);
            if (jTextField1.getText().length() == 0 || !jCheckBox1.isSelected() || !jCheckBox5.isSelected() || jSlider1.getValue() == 0 || jTextField2.getText().length() == 0) {
                jLabel10.setText("All fields are required");
                jLabel10.setVisible(true);
            } else {
                if (jTextField2.getText().length() < 8) {
                    jLabel10.setText("Invitation code must be long at least 8 characters!");
                    jLabel10.setVisible(true);
                } else {
                    if (d.sameLeague(jTextField2.getText())) {
                        jLabel10.setText("This username already exist, more fantasy please!");
                        jLabel10.setVisible(true);
                    } else {
                        jLabel10.setText("League created correctly!!");
                        jLabel10.setVisible(true);
                        d.insertNewLeague(new League(jTextField1.getText(), jTextField2.getText(), false, jSlider1.getValue()));
                    }
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setVisible(false);

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == jLabel4) {
            jLabel10.setVisible(false);
            if (jTextField1.getText().length() == 0 || !jCheckBox1.isSelected() || !jCheckBox5.isSelected() || jSlider1.getValue() == 0 || jTextField2.getText().length() == 0) {
                jLabel10.setText("All fields are required");
                jLabel10.setVisible(true);
            } else {
                if (jTextField2.getText().length() < 8) {
                    jLabel10.setText("Invitation code must be long at least 8 characters!");
                    jLabel10.setVisible(true);
                } else {
                    if (d.sameLeague(jTextField2.getText())) {
                        jLabel10.setText("This code already exist, more fantasy please!");
                        jLabel10.setVisible(true);
                    } else {
                        jLabel10.setText("League created correctly!!");
                        jLabel10.setVisible(true);
                        d.insertNewLeague(new League(jTextField1.getText(), jTextField2.getText(), false, jSlider1.getValue()));
                    }
                }
            }

        }
        if (e.getSource() == jLabel9) {
            this.setVisible(false);
            dispose();

        }

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
