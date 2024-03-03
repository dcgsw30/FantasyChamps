package persistence;

import model.PlayerProfile;
import model.TeamRoster;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//this test class is adapted from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            TeamRoster tr = new TeamRoster();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyRoster() {
        try {
            TeamRoster tr = new TeamRoster();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyRoster.json");
            writer.open();
            writer.write(tr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyRoster.json");
            tr = reader.read();
            assertEquals(0, tr.getTeamSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterFillTwoPlayers() {
        try {
            TeamRoster tr = new TeamRoster();
            tr.addPlayer(new PlayerProfile("Lebron James", "Lakers", 29.3, 7.7,
                    6.1, 1.0, 0.8, 2.9, 4));
            tr.addPlayer(new PlayerProfile("Stephen Curry", "Warriors", 35.3, 4.3,
                    7.3, 1.2, 0.1, 3.9, 3));
            JsonWriter writer = new JsonWriter("./data/testWriterFilledTwoPlayers.json");
            writer.open();
            writer.write(tr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterFilledTwoPlayers.json");
            tr = reader.read();
            List<PlayerProfile> players = tr.getTeam();
            assertEquals(2, players.size());
            checkPlayerProfile("Lebron James", "Lakers", 29.3, 7.7,
                    6.1, 1.0, 0.8, 2.9, 4,
                    215.0, players.get(0));
            checkPlayerProfile("Stephen Curry", "Warriors", 35.3, 4.3,
                    7.3, 1.2, 0.1, 3.9, 3,
                    167.0, players.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
