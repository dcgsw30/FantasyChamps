package ui;

import model.TeamRoster;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MainMenu extends JFrame {

    TeamRoster currentRoster;

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public MainMenu(TeamRoster currentRoster) {

        this.currentRoster = currentRoster;

        setTitle("FantasyChamps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 900);

        //cumulative points panel
        JPanel pointsPanel = new JPanel();
        pointsPanel.setBackground(Color.LIGHT_GRAY);
        pointsPanel.setPreferredSize(new Dimension(600,75));

        //player panel
        JPanel playerPanel = new JPanel(new BorderLayout());
        playerPanel.setBackground(Color.YELLOW);
        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        playerPanel.add(scrollPane, BorderLayout.CENTER);

        //buttons panel
        JPanel buttonsPanel = new JPanel(new GridLayout(2,2));
        JButton button1 = new JButton("Add New Player");
        JButton button2 = new JButton("Get Points this Week");
        JButton button3 = new JButton("Save Roster");
        JButton button4 = new JButton("Back");
        buttonsPanel.setPreferredSize(new Dimension(600, 100));
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);

        //add panels
        add(pointsPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
