package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTeamRoster {

    private TeamRoster team1;
    private PlayerProfile Lebron;
    private PlayerProfile Stephen;

    @BeforeEach
    void runBefore() {
        team1 =  new TeamRoster();
        Lebron = new PlayerProfile("Lebron James", "Lakers", 29.3, 7.7,
                6.1, 1.0, 0.8, 2.9, 4);
        Stephen = new PlayerProfile("Stephen Curry", "Warriors", 35.3, 4.3,
                7.3, 1.2, 0.1, 3.9, 3);
    }

    @Test
    void testAddPlayerToRoster() {
        assertEquals(null, team1.getPlayerByIndex(0));
        team1.addPlayerToRoster(Lebron);
        assertEquals(Lebron, team1.getPlayerByIndex(0));
        team1.addPlayerToRoster(Stephen);
        assertEquals(Lebron, team1.getPlayerByIndex(0));
        assertEquals(Stephen, team1.getPlayerByIndex(1));
        assertEquals(null, team1.getPlayerByIndex(2));
    }
}
