package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    void testGetPlayerByIndex() {
        team1.addPlayer(Lebron);
        team1.addPlayer(Stephen);
        assertEquals(Lebron, team1.getPlayerByIndex(0));
        assertEquals(Stephen, team1.getPlayerByIndex(1));
        assertEquals(null, team1.getPlayerByIndex(2));
    }

    @Test
    void testGetTeam() {
        team1.addPlayer(Lebron);
        team1.addPlayer(Stephen);
        ArrayList<PlayerProfile> playerList = team1.getTeam();
        assertEquals(Lebron, playerList.get(0));
        assertEquals(Stephen, playerList.get(1));
    }

    @Test
    void testGetTeamSize() {
        team1.addPlayer(Lebron);
        assertEquals(1, team1.getTeamSize());
        team1.addPlayer(Stephen);
        assertEquals(2, team1.getTeamSize());
    }

    @Test
    void testAddPlayerToRoster() {
        assertEquals(null, team1.getPlayerByIndex(0));
        team1.addPlayer(Lebron);
        assertEquals(Lebron, team1.getPlayerByIndex(0));
        team1.addPlayer(Stephen);
        assertEquals(Lebron, team1.getPlayerByIndex(0));
        assertEquals(Stephen, team1.getPlayerByIndex(1));
        assertEquals(null, team1.getPlayerByIndex(2));
    }

    @Test
    void testRemovePlayerFromRoster() {
        team1.addPlayer(Lebron);
        team1.addPlayer(Stephen);
        team1.removePlayer("James Harden");
        assertEquals(Lebron, team1.getPlayerByIndex(0));
        assertEquals(Stephen, team1.getPlayerByIndex(1));
        team1.removePlayer("Lebron James");
        assertEquals(Stephen, team1.getPlayerByIndex(0));
        assertEquals(null, team1.getPlayerByName("Lebron James"));
        assertEquals(Stephen, team1.getPlayerByName("Stephen Curry"));
        team1.removePlayer("Stephen Curry");
        assertEquals(null, team1.getPlayerByName("Stephen Curry"));
    }

    @Test
    void testGetPlayerByName() {
        team1.addPlayer(Lebron);
        team1.addPlayer(Stephen);
        assertEquals(Lebron, team1.getPlayerByName("Lebron James"));
        assertEquals(Stephen, team1.getPlayerByName("Stephen Curry"));
        assertEquals(null, team1.getPlayerByName("James Harden"));
    }

    @Test
    void testSumFantasyPoints() {
        assertEquals(0, team1.sumFantasyPoints());
        team1.addPlayer(Lebron);
        assertEquals(215, team1.sumFantasyPoints());
        team1.addPlayer(Stephen);
        assertEquals(382, team1.sumFantasyPoints());
    }
}
