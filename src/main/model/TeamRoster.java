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
        }
        return null;
    }

    // MODIFIES: This
    // EFFECTS: Adds PlayerProfile into the playerRoster
    public void addPlayerToRoster(PlayerProfile player) {
        playerRoster.add(player);
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
