package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddScreen extends JFrame implements ActionListener {

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public AddScreen() {

        //data Panel
        JPanel dataInput = new JPanel();
        dataInput.setLayout(new GridLayout(7, 2));

        JLabel point = new JLabel("Average Points");
        JLabel rebound = new JLabel("Average Rebounds");
        JLabel assist = new JLabel("Average Assists");
        JLabel steals = new JLabel("Average Steals");
        JLabel blocks = new JLabel("Average Blocks");
        JLabel turnovers = new JLabel("Average Turnovers");
        JLabel games = new JLabel("Average Games");

        JTextField tpoint = new JTextField(20);
        JTextField rpoint = new JTextField(20);
        JTextField apoint = new JTextField(20);
        JTextField spoint = new JTextField(20);
        JTextField bpoint = new JTextField(20);
        JTextField topoint = new JTextField(20);
        JTextField gpoint = new JTextField(20);

        dataInput.add(point);
        dataInput.add(tpoint);
        dataInput.add(rebound);
        dataInput.add(rpoint);
        dataInput.add(assist);
        dataInput.add(apoint);
        dataInput.add(steals);
        dataInput.add(spoint);
        dataInput.add(blocks);
        dataInput.add(bpoint);
        dataInput.add(turnovers);
        dataInput.add(topoint);
        dataInput.add(games);
        dataInput.add(gpoint);

        //add player button
        JButton addPlayer = new JButton("Add To Roster");

        // place panels
        add(dataInput, BorderLayout.NORTH);
        add(addPlayer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
