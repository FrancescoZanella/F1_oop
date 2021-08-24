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

public class LoginPage extends JFrame implements ActionListener {

    private JLabel username, password, login_error;
    private MyTextField user_field;
    private MyPasswordField password_field;
    private MyButton enter_button, register_button;

    public LoginPage(){
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

        this.username = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.username.setFont(new Font("bold", Font.BOLD, 16));
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.username, gbc);

        this.user_field = new MyTextField("", 20);
        this.user_field.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.user_field, gbc);

        this.password = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        this.password.setFont(new Font("bold", Font.BOLD, 16));
        gbc.anchor = GridBagConstraints.LINE_END;
        downPanel.add(this.password, gbc);

        this.password_field = new MyPasswordField("", 20);
        this.password_field.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        downPanel.add(this.password_field, gbc);


        this.login_error = new JLabel("Username or Password incorrect!");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        login_error.setVisible(false);
        login_error.setForeground(Color.RED);
        downPanel.add(this.login_error, gbc);

        this.enter_button = new MyButton("Enter");
        enter_button.setBounds(new Rectangle(100, 20));
        enter_button.setForeground(Color.WHITE);
        enter_button.setBackground(Color.RED);
        buttonPanel.add(this.enter_button);

        this.register_button = new MyButton("Register");
        register_button.setBounds(new Rectangle(100, 20));
        register_button.setForeground(Color.WHITE);
        register_button.setBackground(Color.BLACK);
        buttonPanel.add(this.register_button);

        enter_button.addActionListener(this);
        register_button.addActionListener(this);

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
    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Register"))
            EventQueue.invokeLater(RegisterPage::new);

        if(e.getActionCommand().equals("Enter")){
            if(password_field.getPassword().length < 8 || user_field.getText().length() == 0)
                login_error.setVisible(true);
            else
                EventQueue.invokeLater(RegisterPage::new);
        }
    }

    public static void main(String[] args){
        LoginPage lp = new LoginPage();
    }
}
