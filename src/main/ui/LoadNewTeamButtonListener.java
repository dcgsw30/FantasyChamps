package ui;

import model.TeamRoster;
import persistence.JsonReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadNewTeamButtonListener implements ActionListener {

    private static final String JSON_STORE = "./data/myTeam.json";
    private SplashScreen splashScreen;
    private TeamRoster roster;
    private JsonReader jsonReader;

    public LoadNewTeamButtonListener(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
        jsonReader = new JsonReader(JSON_STORE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        splashScreen.setVisible(false);
        loadRoster();
        MainMenu nextScreen = new MainMenu(roster);
        nextScreen.setVisible(true);
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
