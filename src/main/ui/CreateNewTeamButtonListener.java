package ui;

import model.TeamRoster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewTeamButtonListener implements ActionListener {

    private SplashScreen splashScreen;
    private TeamRoster roster;

    public CreateNewTeamButtonListener(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        splashScreen.setVisible(false);
        roster = new TeamRoster();
        MainMenu nextScreen = new MainMenu(roster);
        nextScreen.setVisible(true);
    }
}
