package ui;

import model.TeamRoster;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SplashScreen extends JFrame {


    private static final String JSON_STORE = "./data/myTeam.json";
    private JsonReader jsonReader;
    private TeamRoster roster;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JButton createTeamButton;
    private JButton loadTeamButton;
    private JLabel kobeLabel;



    public SplashScreen() throws FileNotFoundException {
        jsonReader = new JsonReader(JSON_STORE);
        initializeImagePanel();
        initializeButtonPanel();
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
    private void initializeButtonPanel() {
        initializeCreateTeamButton();
        initializeLoadTeamButton();
        buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setPreferredSize(new Dimension(600, 200));
        buttonPanel.add(createTeamButton);
        buttonPanel.add(loadTeamButton);
    }

    //MODIFIES: This
    //EFFECTS: Creates a load saved team button that activates the corresponding listener
    private void initializeLoadTeamButton() {
        loadTeamButton = new JButton("Load Saved Team");
        loadTeamButton.setPreferredSize(new Dimension(600, 100));
        loadTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                loadRoster();
                MainMenu nextScreen = new MainMenu(roster);
                nextScreen.setVisible(true);
            }
        });
    }

    //MODIFIES: This
    //EFFECTS: Creates a create new team button that transfers page to main menu with new team
    private void initializeCreateTeamButton() {
        createTeamButton = new JButton("Create New Team");
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
    }

    //MODIFIES: this
    //EFFECTS: Creates image panel and adding an image to the panel
    private void initializeImagePanel() {
        kobeLabel = new JLabel();
        kobeLabel.setIcon(new ImageIcon(getClass().getResource("./images/kobe2.jpg")));
        imagePanel = new JPanel();
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setPreferredSize(new Dimension(600, 700));
        imagePanel.add(kobeLabel);
    }

    //MODIFIES: THIS
    //EFFECTS: Loads data from JSON_STORE
    private void loadRoster() {
        try {
            roster = jsonReader.read();
            System.out.println("Loaded roster from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
