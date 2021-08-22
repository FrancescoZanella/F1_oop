package graphics;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InitialFrame extends JFrame {
        private final MyButton loginButton;
        private MyButton registerButton;


        public InitialFrame(String title) throws HeadlessException {
                super(title);

               //this.setLayout(null);

                BackroundPanel upPanel=new BackroundPanel("src/resources/background/banner.JPG");
                JPanel downPanel=new JPanel();
                loginButton=new MyButton("Login");
                registerButton=new MyButton("Register");

                //downPanel.setLayout(null);
                upPanel.setLayout(null);

                upPanel.add(loginButton);
                upPanel.add(registerButton);


                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();

                upPanel.setBounds(0,0,(int) width,(int)height/5);
                downPanel.setBounds(0,(int)height/5+1,(int)width,(int)(height-(height/5)));
                loginButton.setBounds(upPanel.getX()+(int)width/8*6,upPanel.getY()+(int)height/10,100,20);
                loginButton.setBackground(Color.RED);
                loginButton.setForeground(Color.WHITE);

                registerButton.setBounds(upPanel.getX()+(int)width/8*7,upPanel.getY()+(int) height/10,100,20);
                registerButton.setBackground(Color.BLACK);
                registerButton.setForeground(Color.WHITE);
                this.add(upPanel);
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


                this.setIconImages(listImage);
                this.setSize((int)width,(int)height);
                this.setResizable(false);
                this.setVisible(true);



        }

        public static void main(String[] args) {
                new InitialFrame("Prova");
        }


}
