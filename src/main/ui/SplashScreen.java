package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class SplashScreen extends JFrame implements ActionListener {

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public SplashScreen() throws FileNotFoundException {

        //set image
        JLabel kobeLabel = new JLabel();
        kobeLabel.setIcon(new ImageIcon(getClass().getResource("./images/kobe2.jpg")));

        //image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setPreferredSize(new Dimension(600, 800));
        imagePanel.add(kobeLabel);

        //Button
        JButton startAppButton = new JButton("View Current Team");
        startAppButton.setPreferredSize(new Dimension(600, 100));
        startAppButton.addActionListener(this);

        //set frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 900);
        setTitle("FantasyChamps");

        //add components
        add(imagePanel, BorderLayout.NORTH);
        add(startAppButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    //EFFECTS: sets main menu visibility to false, opens new main menu screen containing all the loaded data
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        MainMenu nextScreen = new MainMenu();
        nextScreen.setVisible(true);
    }
}
