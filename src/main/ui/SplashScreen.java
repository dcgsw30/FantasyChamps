package ui;

import model.TeamRoster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SplashScreen extends JFrame {

    private TeamRoster roster;

    public SplashScreen() throws FileNotFoundException {
        JPanel imagePanel = initializeImagePanel();
        JPanel buttonPanel = initializeButtonPanel();
        setFrame();
        add(imagePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    //MODIFIES: This
    //EFFECTS: Sets the frame of the application
    private void setFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 900);
        setTitle("FantasyChamps");
    }

    //MODIFIES: This
    //EFFECTS: Creates button panel and adds two buttons and their respective action listeners
    private JPanel initializeButtonPanel() {
        JButton createTeamButton = initializeCreateTeamButton();
        JButton loadTeamButton = initializeLoadTeamButton();
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setPreferredSize(new Dimension(600, 200));
        buttonPanel.add(createTeamButton);
        buttonPanel.add(loadTeamButton);
        return buttonPanel;
    }

    //MODIFIES: This
    //EFFECTS: Creates a load saved team button that activates the LoadTeamButtonListener
    private JButton initializeLoadTeamButton() {
        JButton loadTeamButton = new JButton("Load Saved Team");
        loadTeamButton.setPreferredSize(new Dimension(600, 100));
        loadTeamButton.addActionListener(new LoadTeamButtonListener(this));
        return loadTeamButton;
    }

    //MODIFIES: This
    //EFFECTS: Creates a create new team button that transfers page to main menu with new team
    private JButton initializeCreateTeamButton() {
        JButton createTeamButton = new JButton("Create New Team");
        createTeamButton.setPreferredSize(new Dimension(600, 100));
        createTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                roster = new TeamRoster();
                MainMenu nextScreen = new MainMenu(roster);
                nextScreen.setVisible(true);
            }
        });
        return createTeamButton;
    }

    //MODIFIES: this
    //EFFECTS: Creates image panel and adding an image to the panel
    private JPanel initializeImagePanel() {
        JLabel kobeLabel = new JLabel();
        kobeLabel.setIcon(new ImageIcon(getClass().getResource("./images/kobe2.jpg")));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setPreferredSize(new Dimension(600, 700));
        imagePanel.add(kobeLabel);
        return imagePanel;
    }
}
