package graphics;
import database.Data;
import database.DataUser;
import domain_classes.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
public class RegisterPage extends JFrame implements MouseListener, KeyListener {
    private JLabel jLabel1;
    private JLabel incorrectfield;
    private JLabel passworderror;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel15;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel finishbutton;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPasswordField passwordfield;
    private JTextField namefield;
    private JTextField mailfield;
    private JTextField surnamefield;
    private JTextField usernamefield;
    public RegisterPage() {
        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        namefield = new JTextField();
        jLabel3 = new JLabel();
        jPanel4 = new JPanel();
        finishbutton = new JLabel();
        jLabel7 = new JLabel();
        jLabel5 = new JLabel();
        jLabel12 = new JLabel();
        mailfield = new JTextField();
        surnamefield = new JTextField();
        jLabel13 = new JLabel();
        passwordfield = new JPasswordField();
        usernamefield = new JTextField();
        jLabel15 = new JLabel();
        jPanel2 = new JPanel();
        incorrectfield = new JLabel();
        passworderror = new JLabel();
        jLabel9 = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBackground(new java.awt.Color(19, 19, 31));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setBackground(new java.awt.Color(60, 63, 65));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sign Up");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Name");
        namefield.setBackground(new java.awt.Color(69, 73, 74));
        namefield.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        namefield.setForeground(new java.awt.Color(153, 153, 153));
        namefield.setHorizontalAlignment(JTextField.CENTER);
        namefield.setBorder(null);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Create your F1 account");
        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel4.setForeground(new java.awt.Color(240, 240, 240));
        finishbutton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        finishbutton.setForeground(new java.awt.Color(255, 255, 255));
        finishbutton.setText("             Sign Up");
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 141, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(finishbutton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(finishbutton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setIcon(new ImageIcon(getClass().getResource("/icons/cars.png"))); // NOI18N
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Surname");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Username");
        mailfield.setBackground(new java.awt.Color(69, 73, 74));
        mailfield.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        mailfield.setForeground(new java.awt.Color(153, 153, 153));
        mailfield.setHorizontalAlignment(JTextField.CENTER);
        mailfield.setBorder(null);
        surnamefield.setBackground(new java.awt.Color(69, 73, 74));
        surnamefield.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        surnamefield.setForeground(new java.awt.Color(153, 153, 153));
        surnamefield.setHorizontalAlignment(JTextField.CENTER);
        surnamefield.setBorder(null);
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Password");
        passwordfield.setBackground(new java.awt.Color(69, 74, 74));
        passwordfield.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        passwordfield.setForeground(new java.awt.Color(153, 153, 153));
        passwordfield.setHorizontalAlignment(JTextField.CENTER);
        passwordfield.setBorder(null);
        usernamefield.setBackground(new java.awt.Color(69, 73, 74));
        usernamefield.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        usernamefield.setForeground(new java.awt.Color(153, 153, 153));
        usernamefield.setHorizontalAlignment(JTextField.CENTER);
        usernamefield.setBorder(null);
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Email");
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
        incorrectfield.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        incorrectfield.setForeground(new java.awt.Color(255, 0, 0));
        incorrectfield.setText("All fields are required!");
        passworderror.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passworderror.setForeground(new java.awt.Color(255, 0, 0));
        passworderror.setText("Password must be long at least 8 characters!");
        finishbutton.addMouseListener(this);
        jLabel9.addMouseListener(this);
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(namefield, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(mailfield, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(surnamefield, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordfield)
                                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(usernamefield)
                                                .addComponent(incorrectfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(passworderror, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(88, Short.MAX_VALUE))
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namefield, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surnamefield, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernamefield, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(1, 1, 1)
                                .addComponent(mailfield, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordfield, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(incorrectfield, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passworderror, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
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
                                .addGap(78, 78, 78))
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
                                .addContainerGap(42, Short.MAX_VALUE))
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
        incorrectfield.setVisible(false);
        passworderror.setVisible(false);
        this.setBounds(400, 50, 550, 580);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
        namefield.addKeyListener(this);
        surnamefield.addKeyListener(this);
        mailfield.addKeyListener(this);
        usernamefield.addKeyListener(this);
        passwordfield.addKeyListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == jLabel9) {
            this.setVisible(false);
            dispose();
            //System.exit(0);
        }
        if (e.getSource() == finishbutton) {
            incorrectfield.setVisible(false);
            passworderror.setVisible(false);
            if (namefield.getText().length() == 0 || surnamefield.getText().length() == 0 || passwordfield.getPassword().length == 0
                    || mailfield.getText().length() == 0 || usernamefield.getText().length() == 0) {
                incorrectfield.setText("All fields are required!");
                incorrectfield.setVisible(true);
            } else {
                if (passwordfield.getPassword().length < 8) {
                    incorrectfield.setVisible(false);
                    passworderror.setVisible(true);
                } else {
                    if (User.sameUser(usernamefield.getText())) {
                        incorrectfield.setText("This username already exist, more fantasy please!");
                        incorrectfield.setVisible(true);
                        passworderror.setVisible(false);
                    } else {
                        incorrectfield.setText("Sign up correctly!");
                        incorrectfield.setVisible(true);
                        passworderror.setVisible(false);
                        new User(namefield.getText(), surnamefield.getText(), mailfield.getText(), usernamefield.getText(), new String(passwordfield.getPassword()));
                        EventQueue.invokeLater(() -> new Frame("Fanta F1", namefield.getText()));
                    }
                }
            }
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
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            incorrectfield.setVisible(false);
            passworderror.setVisible(false);
            if (namefield.getText().length() == 0 || surnamefield.getText().length() == 0 || passwordfield.getPassword().length == 0
                    || mailfield.getText().length() == 0 || usernamefield.getText().length() == 0) {
                incorrectfield.setText("All fields are required!");
                incorrectfield.setVisible(true);
            } else {
                if (passwordfield.getPassword().length < 8) {
                    incorrectfield.setVisible(false);
                    passworderror.setVisible(true);
                } else {
                    if (User.sameUser(usernamefield.getText())) {
                        incorrectfield.setText("This username already exist, more fantasy please!");
                        incorrectfield.setVisible(true);
                        passworderror.setVisible(false);
                    } else {
                        incorrectfield.setText("Sign up correctly!");
                        incorrectfield.setVisible(true);
                        passworderror.setVisible(false);
                        new User(namefield.getText(), surnamefield.getText(), mailfield.getText(), usernamefield.getText(), new String(passwordfield.getPassword()));
                    }
                }

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setVisible(false);
            dispose();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }}