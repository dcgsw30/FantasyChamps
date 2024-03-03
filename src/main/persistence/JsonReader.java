package persistence;

import model.PlayerProfile;
import model.TeamRoster;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//this class is adapted from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads TeamRoster from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TeamRoster read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTeamRoster(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses TeamRoster from JSON object and returns it
    private TeamRoster parseTeamRoster(JSONObject jsonObject) {
        TeamRoster tr = new TeamRoster();
        addPlayers(tr, jsonObject);
        return tr;
    }

    // MODIFIES: tr
    // EFFECTS: parses players from JSON object and adds them to workroom
    private void addPlayers(TeamRoster tr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(tr, nextPlayer);
        }
    }

    // MODIFIES: tr
    // EFFECTS: parses player from JSON object and adds it to teamroster
    private void addPlayer(TeamRoster tr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String team = jsonObject.getString("team");
        double averagePoints = jsonObject.getDouble("averagePoints");
        double averageRebounds = jsonObject.getDouble("averageRebounds");
        double averageAssists = jsonObject.getDouble("averageAssists");
        double averageSteals = jsonObject.getDouble("averageSteals");
        double averageBlocks = jsonObject.getDouble("averageBlocks");
        double averageTurnovers = jsonObject.getDouble("averageTurnovers");
        int gamesThisWeek = jsonObject.getInt("gamesThisWeek");

        PlayerProfile playerProfile = new PlayerProfile(name, team, averagePoints, averageRebounds, averageAssists,
                averageSteals, averageBlocks, averageTurnovers, gamesThisWeek);
        tr.addPlayer(playerProfile);
    }
}
