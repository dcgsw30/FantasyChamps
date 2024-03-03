package persistence;

import model.PlayerProfile;
import model.TeamRoster;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//this test class is adapted from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TeamRoster tr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyRoster.json");
        try {
            TeamRoster tr = reader.read();
            assertEquals(0, tr.getTeamSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderFilledTwoPlayers() {
        JsonReader reader = new JsonReader("./data/testReaderFilledTwoPlayers.json");
        try {
            TeamRoster tr = reader.read();
            List<PlayerProfile> players = tr.getTeam();
            assertEquals(2, players.size());
            checkPlayerProfile("Lebron James", "Lakers", 29.3, 7.7,
                    6.1, 1.0, 0.8, 2.9, 4,
                    215.0, players.get(0));
            checkPlayerProfile("Stephen Curry", "Warriors", 35.3, 4.3,
                    7.3, 1.2, 0.1, 3.9, 3,
                    167.0, players.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
