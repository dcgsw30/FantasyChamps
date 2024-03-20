package ui;

import model.PlayerProfile;
import model.TeamRoster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddScreen extends JFrame {

    private TeamRoster currentRoster;
    private JPanel dataInputPanel;
    private JPanel optionPanel;
    private JButton addPlayer;
    private JButton goBackMainMenu;
    private JLabel name;
    private JLabel team;
    private JLabel point;
    private JLabel rebound;
    private JLabel assist;
    private JLabel steals;
    private JLabel blocks;
    private JLabel turnovers;
    private JLabel games;
    private JTextField nameField;
    private JTextField teamField;
    private JTextField pointField;
    private JTextField reboundField;
    private JTextField assistField;
    private JTextField stealField;
    private JTextField blockField;
    private JTextField toField;
    private JTextField gpField;

    public AddScreen(TeamRoster currentRoster) {
        this.currentRoster = currentRoster;

        initializeDataInputPanel();
        initializeLabels();
        initializeTextFields();
        addLabelsFields(dataInputPanel);
        initializeButtonPanel();
        initializeAddPlayerButton(currentRoster);
        initializeBackMainMenuButton(currentRoster);
        addButtonsToPanel();
        setFrame();
        add(dataInputPanel, BorderLayout.NORTH);
        add(optionPanel, BorderLayout.SOUTH);
    }

    //EFFECTS: adds created buttons into button panel
    private void addButtonsToPanel() {
        optionPanel.add(addPlayer);
        optionPanel.add(goBackMainMenu);
    }

    //EFFECTS: Creates back to main menu button
    private void initializeBackMainMenuButton(TeamRoster currentRoster) {
        goBackMainMenu = new JButton("Back");
        goBackMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainMenu mainMenu = new MainMenu(currentRoster);
                mainMenu.setVisible(true);
            }
        });
    }

    //EFFECTS: Creates add player button
    private void initializeAddPlayerButton(TeamRoster currentRoster) {
        addPlayer = new JButton("Add To Roster");
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String team = teamField.getText();
                double averagePoints = convertTextFieldIntoDouble(pointField.getText());
                double averageRebounds = convertTextFieldIntoDouble(reboundField.getText());
                double averageAssists = convertTextFieldIntoDouble(assistField.getText());
                double averageSteals = convertTextFieldIntoDouble(stealField.getText());
                double averageBlocks = convertTextFieldIntoDouble(blockField.getText());
                double averageTo = convertTextFieldIntoInt(toField.getText());
                int gamesThisWeek = convertTextFieldIntoInt(gpField.getText());
                PlayerProfile newPlayer = new PlayerProfile(name, team, averagePoints, averageRebounds,
                        averageAssists, averageSteals, averageBlocks, averageTo, gamesThisWeek);
                currentRoster.addPlayer(newPlayer);
            }
        });
    }

    //EFFECTS: creates a panel to place
    private void initializeButtonPanel() {
        optionPanel = new JPanel(new GridLayout(1, 2));
        optionPanel.setPreferredSize(new Dimension(600, 100));
    }

    //EFFECTS: creates a panel to place labels and text fields
    private void initializeDataInputPanel() {
        dataInputPanel = new JPanel();
        dataInputPanel.setLayout(new GridLayout(9, 2));
    }

    //EFFECTS: adds labels and fields to screen panel
    private void addLabelsFields(JPanel dataInputPanel) {
        dataInputPanel.add(name);
        dataInputPanel.add(nameField);
        dataInputPanel.add(team);
        dataInputPanel.add(teamField);
        dataInputPanel.add(point);
        dataInputPanel.add(pointField);
        dataInputPanel.add(rebound);
        dataInputPanel.add(reboundField);
        dataInputPanel.add(assist);
        dataInputPanel.add(assistField);
        dataInputPanel.add(steals);
        dataInputPanel.add(stealField);
        dataInputPanel.add(blocks);
        dataInputPanel.add(blockField);
        dataInputPanel.add(turnovers);
        dataInputPanel.add(toField);
        dataInputPanel.add(games);
        dataInputPanel.add(gpField);
    }

    //EFFECTS: initialize text fields for add screen panel
    private void initializeTextFields() {
        nameField = new JTextField(20);
        teamField = new JTextField(20);
        pointField = new JTextField(20);
        reboundField = new JTextField(20);
        assistField = new JTextField(20);
        stealField = new JTextField(20);
        blockField = new JTextField(20);
        toField = new JTextField(20);
        gpField = new JTextField(20);
    }

    //EFFECTS: creates label for add screen panel
    private void initializeLabels() {
        name = new JLabel("Player name");
        team = new JLabel("Team");
        point = new JLabel("Average Points");
        rebound = new JLabel("Average Rebounds");
        assist = new JLabel("Average Assists");
        steals = new JLabel("Average Steals");
        blocks = new JLabel("Average Blocks");
        turnovers = new JLabel("Average Turnovers");
        games = new JLabel("Average Games");
    }


    //MODIFIES: This
    //EFFECTS: sets the frame structure
    private void setFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 900);
        setTitle("FantasyChamps");
    }

    //EFFECTS: converts text field value into a double
    private double convertTextFieldIntoDouble(String input) {
        double returnValue;
        try {
            returnValue = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            returnValue = 0.0;
        }
        return returnValue;
    }

    //EFFECTS: converts text field value into an int
    private int convertTextFieldIntoInt(String input) {
        int returnValue;
        try {
            returnValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            returnValue = 0;
        }
        return returnValue;
    }
}
