package ui;

import model.TeamRoster;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MainMenu extends JFrame {

    private static final String JSON_STORE = "./data/myTeam.json";
    private JsonWriter jsonWriter;
    private TeamRoster currentRoster;

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public MainMenu(TeamRoster currentRoster) {

        this.currentRoster = currentRoster;
        jsonWriter = new JsonWriter(JSON_STORE);

        setTitle("FantasyChamps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 900);

        //cumulative points panel
        JPanel pointsPanel = new JPanel();
        pointsPanel.setBackground(Color.LIGHT_GRAY);
        pointsPanel.setPreferredSize(new Dimension(600,75));
        JLabel pointLabel = new JLabel("Your Team Will generate: ");
        pointsPanel.add(pointLabel);


        //player panel
        JPanel playerPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        playerPanel.add(scrollPane, BorderLayout.CENTER);

        //buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(2,2));

        //add player button and event listener
        JButton addNewPlayerButton = new JButton("Add New Player");
        addNewPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddScreen addPlayerScreen = new AddScreen(currentRoster);
                addPlayerScreen.setVisible(true);
            }
        });

        //view team roster and event listener
        JButton viewRosterButton = new JButton("View Team Roster");
        viewRosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        //display points on upper panel button
        JButton getPointsThisWeek = new JButton("Get Points this Week");
        getPointsThisWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalScore = currentRoster.sumFantasyPoints();
                pointLabel.setText("Your Team Will Generate: " + totalScore + " Fantasy Points");
            }
        });

        //save roster button
        JButton saveRosterButton = new JButton("Save Roster");
        saveRosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSaveRoster();
            }
        });


        buttonsPanel.setPreferredSize(new Dimension(600, 100));
        buttonsPanel.add(addNewPlayerButton);
        buttonsPanel.add(viewRosterButton);
        buttonsPanel.add(getPointsThisWeek);
        buttonsPanel.add(saveRosterButton);

        //add panels
        add(pointsPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // EFFECTS: saves the roster to file
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

}
