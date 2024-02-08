package model;

import java.util.ArrayList;

public class TeamRoster {

    private ArrayList<PlayerProfile> playerRoster;

    public TeamRoster() {
        playerRoster = new ArrayList<>();
    }

    public PlayerProfile getPlayerByIndex(int index) {
        if (index < playerRoster.size()) {
            return playerRoster.get(index);
        } else {
            return null;
        }
    }

    // MODIFIES: This
    // EFFECTS: Adds PlayerProfile into the playerRoster
    public void addPlayer(PlayerProfile player) {
        playerRoster.add(player);
    }

    //MODIFIES: this
    //EFFECTS: Removes PlayerProfile from playerRoster
    public void removePlayer(PlayerProfile player) {
        playerRoster.remove(player);
    }

    //EFFECTS: Searches for player by name
    public PlayerProfile getPlayerByName(String inputName) {
        for (PlayerProfile player: playerRoster) {
            if (player.getName().equals(inputName)) {
                return player;
            }
        }
        return null;
    }

    //MODIFIES: This
    //EFFECTS: Sums projected fantasy points of each player in the array
    public double sumFantasyPoints() {
        double sum = 0.0;
        for (PlayerProfile player: playerRoster) {
            sum += player.getProjectedPoints();
        }
        return sum;
    }

}
