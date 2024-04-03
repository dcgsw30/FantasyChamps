package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Represents a team roster that contains a list of PlayerProfiles
public class TeamRoster implements Writable {
    private ArrayList<PlayerProfile> playerRoster;

    //EFFECTS: new empty roster is set
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
        EventLog.getInstance().logEvent(new Event("Player " + player.getName()
                + " has been added to your roster!"));
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
        EventLog.getInstance().logEvent(new Event("Obtained total points!"));
        return sum;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("players", playersToJson());
        return json;
    }

    // EFFECTS: returns players in TeamRoster as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PlayerProfile p : playerRoster) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
