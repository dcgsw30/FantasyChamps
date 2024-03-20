package ui;

import model.PlayerProfile;
import model.TeamRoster;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainMenu extends JFrame {

    private static final String JSON_STORE = "./data/myTeam.json";
    private JsonWriter jsonWriter;
    private TeamRoster currentRoster;
    private JPanel pointsPanel;
    private JLabel pointLabel;
    private JPanel playerPanel;
    private JTextArea playerTextArea;
    private JScrollPane scrollPane;
    private JPanel buttonsPanel;
    private JButton addNewPlayerButton;
    private JButton viewRosterButton;
    private JButton getPointsThisWeek;
    private JButton saveRosterButton;

    public MainMenu(TeamRoster currentRoster) {

        this.currentRoster = currentRoster;
        jsonWriter = new JsonWriter(JSON_STORE);

        setFrame();
        initializePointsPanel();
        initializePlayerPanel();
        initializeButtonsPanel();
        initializeAddNewPlayerButton(currentRoster);
        initializeViewRosterButton(currentRoster);
        initializeGetPointsButton(currentRoster);
        initializeSaveRosterButton();
        addButtons();
        addPanels();
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds panel to frame
    private void addPanels() {
        add(pointsPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    //EFFECTS: Adds buttons to buttonsPanel
    private void addButtons() {
        buttonsPanel.add(addNewPlayerButton);
        buttonsPanel.add(viewRosterButton);
        buttonsPanel.add(getPointsThisWeek);
        buttonsPanel.add(saveRosterButton);
    }

    //EFFECTS: Sets the button that saves roster
    private void initializeSaveRosterButton() {
        saveRosterButton = new JButton("Save Roster");
        saveRosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSaveRoster();
            }
        });
    }

    //EFFECTS: Sets the button that gets points
    private void initializeGetPointsButton(TeamRoster currentRoster) {
        getPointsThisWeek = new JButton("Get Points this Week");
        getPointsThisWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalScore = currentRoster.sumFantasyPoints();
                pointLabel.setText("Your Team Will Generate: " + totalScore + " Fantasy Points");
            }
        });
    }

    //EFFECTS: Sets the button that views roster
    private void initializeViewRosterButton(TeamRoster currentRoster) {
        viewRosterButton = new JButton("View Team Roster");
        viewRosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllPlayerDetails(currentRoster.getTeam());
            }
        });
    }

    //EFFECTS: Sets the button that adds new player
    private void initializeAddNewPlayerButton(TeamRoster currentRoster) {
        addNewPlayerButton = new JButton("Add New Player");
        addNewPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddScreen addPlayerScreen = new AddScreen(currentRoster);
                addPlayerScreen.setVisible(true);
            }
        });
    }

    //EFFECTS: Sets the panel that displays all buttons
    private void initializeButtonsPanel() {
        buttonsPanel = new JPanel(new GridLayout(2,2));
        buttonsPanel.setPreferredSize(new Dimension(600, 100));
    }

    //EFFECTS: Sets the panel that displays players
    private void initializePlayerPanel() {
        playerPanel = new JPanel(new BorderLayout());
        playerTextArea = new JTextArea(10, 40);
        scrollPane = new JScrollPane(playerTextArea);
        playerTextArea.setLineWrap(true);
        playerTextArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        playerPanel.add(scrollPane, BorderLayout.CENTER);
    }


    //EFFECTS: Sets the points panel
    private void initializePointsPanel() {
        pointsPanel = new JPanel();
        pointsPanel.setBackground(Color.LIGHT_GRAY);
        pointsPanel.setPreferredSize(new Dimension(600,75));
        pointLabel = new JLabel("Your Team Will generate: ");
        pointsPanel.add(pointLabel);
    }

    //MODIFIES: This
    //EFFECTS: Sets the frame of the application
    private void setFrame() {
        setTitle("FantasyChamps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 900);
    }

    //MODIFIES: This
    //EFFECTS: saves the roster to file
    private void actionSaveRoster() {
        try {
            jsonWriter.open();
            jsonWriter.write(currentRoster);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //EFFECTS: Displays all statistics of each player in the roster
    private void displayAllPlayerDetails(ArrayList<PlayerProfile> players) {
        for (PlayerProfile player : players) {
            playerTextArea.append(player.toString() + "\n\n");
        }
    }

}
