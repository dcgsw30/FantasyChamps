package model;

import java.util.ArrayList;

public class TeamRoster {

    private ArrayList<PlayerProfile> playerRoster;

    public TeamRoster() {
        playerRoster = new ArrayList<>();
    }

    //REQUIRES: index must not be larger than array size
    //EFFECTS: gets Player at the position of provided index
    public PlayerProfile getPlayerByIndex(int index) {
        if (index < playerRoster.size()) {
            return playerRoster.get(index);
        } else {
            return null;
        }
    }

    //EFFECTS: Gets all players in roster
    public ArrayList<PlayerProfile> getTeam() {
        return playerRoster;
    }

    //EFFECTS: Gets number of players in team
    public int getTeamSize() {
        return playerRoster.size();
    }

    //REQUIRES: Same player in roster cannot be added twice
    //MODIFIES: This
    //EFFECTS: Adds PlayerProfile into the playerRoster
    public void addPlayer(PlayerProfile player) {
        playerRoster.add(player);
    }

    //MODIFIES: this
    //EFFECTS: Removes PlayerProfile from playerRoster, stops execution once found
    public void removePlayer(String playerName) {
        for (PlayerProfile player: playerRoster) {
            if (player.getName().equals(playerName)) {
                playerRoster.remove(player);
                return;
            }
        }
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
        double sum = 0;
        for (PlayerProfile player: playerRoster) {
            sum += player.getProjectedPoints();
        }
        return sum;
    }

}
