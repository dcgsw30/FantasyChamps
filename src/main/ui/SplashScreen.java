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
        imagePanel.setPreferredSize(new Dimension(600, 700));
        imagePanel.add(kobeLabel);

        //Create New Team Button
        JButton createTeamButton = new JButton("Create New Team");
        createTeamButton.setPreferredSize(new Dimension(600, 100));

        //Load Team Button
        JButton loadTeamButton = new JButton("Load Saved Team");
        loadTeamButton.setPreferredSize(new Dimension(600, 100));
        loadTeamButton.addActionListener(this);

        //button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setPreferredSize(new Dimension(600, 200));
        buttonPanel.add(createTeamButton);
        buttonPanel.add(loadTeamButton);

        //set frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 900);
        setTitle("FantasyChamps");

        //add components
        add(imagePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
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
