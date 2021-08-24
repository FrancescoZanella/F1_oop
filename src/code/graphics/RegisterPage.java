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

public class RegisterPage extends JFrame /*implements ActionListener*/ {
    /*private MyButton finish_button, login_button;
    private MyTextField namefield, surnamefield, mailfield, usernamefield;
    private MyPasswordField passwordfield;
    private JLabel name, surname, mail, username, password, password_error, incorrect_field, password_constraints;
    static Font f = new Font("bold", Font.BOLD, 16);
    static Font answer = new Font("bold", Font.BOLD, 12);

    public RegisterPage(){
        BackroundPanel upPanel = new BackroundPanel("src/resources/background/banner.JPG");
        JPanel downPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        JPanel entirePanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints ent = new GridBagConstraints();

        entirePanel.setBackground(Color.WHITE);
        downPanel.setBackground(entirePanel.getBackground());
        buttonPanel.setBackground(entirePanel.getBackground());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        upPanel.setLayout(null);

        upPanel.setBounds(0,0,(int) width,(int)height/5);
        entirePanel.setBounds(0,(int)height/5+1,(int)width,(int)(height-(height/5)));

        this.name = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.name.setFont(f);
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.name, gbc);

        this.namefield = new MyTextField("", 20);
        this.namefield.setEditable(false);
        this.namefield.setFont(answer);
        this.namefield.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.namefield, gbc);

        this.surname = new JLabel("Surname:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        this.surname.setFont(f);
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.surname, gbc);

        this.surnamefield = new MyTextField("", 20);
        this.surnamefield.setEditable(false);
        this.surnamefield.setFont(answer);
        this.surnamefield.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.surnamefield, gbc);

        this.mail = new JLabel("Mail:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.mail.setFont(f);
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.mail, gbc);

        this.mailfield = new MyTextField("", 30);
        this.mailfield.setEditable(false);
        this.mailfield.setFont(answer);
        this.mailfield.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.mailfield, gbc);

        this.username = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.username.setFont(f);
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.username, gbc);

        this.usernamefield = new MyTextField("", 20);
        this.usernamefield.setEditable(false);
        this.usernamefield.setFont(answer);
        this.usernamefield.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.usernamefield, gbc);

        this.password = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 0, 0, 10);
        this.password.setFont(f);
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.password, gbc);

        this.passwordfield = new MyPasswordField("", 20);
        this.passwordfield.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.passwordfield, gbc);

        this.password_constraints = new JLabel("(the password shall contain at least 8 characters)");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        password_constraints.setForeground(Color.BLACK);
        downPanel.add(this.password_constraints, gbc);

        this.password_error = new JLabel("the password must contain at least 8 characacters!");
        gbc.gridx = 1;
        gbc.gridy = 6;
        password_error.setVisible(false);
        gbc.anchor = GridBagConstraints.LINE_START;
        password_error.setForeground(Color.RED);
        downPanel.add(this.password_error, gbc);

        this.incorrect_field = new JLabel("one or more fields are incorrect!");
        gbc.gridx = 1;
        gbc.gridy = 6;
        incorrect_field.setVisible(false);
        gbc.anchor = GridBagConstraints.LINE_START;
        incorrect_field.setForeground(Color.RED);
        downPanel.add(this.incorrect_field, gbc);

        this.finish_button = new MyButton("Done");
        finish_button.setBounds(new Rectangle(100, 20));
        finish_button.setForeground(Color.WHITE);
        finish_button.setBackground(Color.RED);
        buttonPanel.add(this.finish_button);

        this.login_button = new MyButton("Login");
        login_button.setBounds(new Rectangle(100, 20));
        login_button.setForeground(Color.WHITE);
        login_button.setBackground(Color.BLACK);
        buttonPanel.add(this.login_button);

        finish_button.addActionListener(this);
        login_button.addActionListener(this);


        ent.gridx = 0;
        ent.gridy = 0;
        entirePanel.add(downPanel, ent);
        ent.gridx = 0;
        ent.gridy = 1;
        entirePanel.add(buttonPanel, ent);

        this.add(upPanel);
        this.add(entirePanel);

        List<Image> listImage=new ArrayList<>();
        try {
            listImage.add(ImageIO.read(new File("src/resources/images/16x16.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/32x32.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/64x64.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/128x128.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setIconImages(listImage);
        this.setSize((int)width,(int)height);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Login"))
            EventQueue.invokeLater(LoginPage::new);

        if (e.getActionCommand().equals("Done")) {
            if(namefield.getText().length() == 0 || surnamefield.getText().length() == 0 || passwordfield.getPassword().length == 0
                    || mailfield.getText().length() == 0 || usernamefield.getText().length() == 0){
                incorrect_field.setVisible(true);
            } else {
                if(passwordfield.getPassword().length < 8)
                    password_error.setVisible(true);
                else
                    EventQueue.invokeLater(LoginPage::new);
            }
        }

    }

    public static void main(String[] args){
        RegisterPage rp = new RegisterPage();
    }*/
}
