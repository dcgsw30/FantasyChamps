package ui;

import model.PlayerProfile;
import model.TeamRoster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddScreen extends JFrame {

    TeamRoster currentRoster;

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public AddScreen(TeamRoster currentRoster) {

        this.currentRoster = currentRoster;


        //data Panel
        JPanel dataInput = new JPanel();
        dataInput.setLayout(new GridLayout(9, 2));

        JLabel name = new JLabel("Player name");
        JLabel team = new JLabel("Team");
        JLabel point = new JLabel("Average Points");
        JLabel rebound = new JLabel("Average Rebounds");
        JLabel assist = new JLabel("Average Assists");
        JLabel steals = new JLabel("Average Steals");
        JLabel blocks = new JLabel("Average Blocks");
        JLabel turnovers = new JLabel("Average Turnovers");
        JLabel games = new JLabel("Average Games");


        JTextField nameField = new JTextField(20);
        JTextField teamField = new JTextField(20);
        JTextField pointField = new JTextField(20);
        JTextField reboundField = new JTextField(20);
        JTextField assistField = new JTextField(20);
        JTextField stealField = new JTextField(20);
        JTextField blockField = new JTextField(20);
        JTextField toField = new JTextField(20);
        JTextField gpField = new JTextField(20);

        dataInput.add(name);
        dataInput.add(nameField);
        dataInput.add(team);
        dataInput.add(teamField);
        dataInput.add(point);
        dataInput.add(pointField);
        dataInput.add(rebound);
        dataInput.add(reboundField);
        dataInput.add(assist);
        dataInput.add(assistField);
        dataInput.add(steals);
        dataInput.add(stealField);
        dataInput.add(blocks);
        dataInput.add(blockField);
        dataInput.add(turnovers);
        dataInput.add(toField);
        dataInput.add(games);
        dataInput.add(gpField);

        //add player button
        JButton addPlayer = new JButton("Add To Roster");
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

        setFrame();
        // place panels
        add(dataInput, BorderLayout.NORTH);
        add(addPlayer, BorderLayout.SOUTH);
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

    //EFFECTS: converts text field value into a int
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
