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

import static java.awt.Color.WHITE;

public class Frame extends JFrame {

    public Frame(String title) throws HeadlessException {
        super(title);
        List <Image> listImage=new ArrayList<>();
        try {
            listImage.add(ImageIO.read(new File("src/resources/images/16x16.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/32x32.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/64x64.png")));
            listImage.add(ImageIO.read(new File("src/resources/images/128x128.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        InitialPanel p=new InitialPanel();
        this.add(p);


        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImages(listImage);
        this.setResizable(false);
        this.setVisible(true);

    }



    }

