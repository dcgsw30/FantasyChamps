package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MainMenu extends JFrame {
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public MainMenu() {
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
        JPanel buttonsPanel = new JPanel(new GridLayout(3,2));
        JButton button1 = new JButton("Add New Player");
        JButton button2 = new JButton("Search Player");
        JButton button3 = new JButton("Remove Player");
        JButton button4 = new JButton("Get Points this Week");
        JButton button5 = new JButton("Save Roster");
        JButton button6 = new JButton("Back");
        buttonsPanel.setPreferredSize(new Dimension(600, 150));
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);

        //add panels
        add(pointsPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
