package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPlayerProfile {

    PlayerProfile Lebron;
    PlayerProfile Stephen;

    @BeforeEach
    void runBefore() {
        Lebron = new PlayerProfile("Lebron James", "Lakers", 29.3, 7.7,
                6.1, 1.0, 0.8, 2.9, 4);
        Stephen = new PlayerProfile("Stephen Curry", "Warriors", 35.3, 4.3,
                7.3, 1.2, 0.1, 3.9, 3);
    }

    @Test
    void testToString() {
        assertEquals("Name: Lebron James, Team: Lakers, Avg Points: 29.3, Avg Rebounds: 7.7, Avg Assists: 6.1"+
                ", Avg Steals: 1.0, Avg Blocks: 0.8, Avg TO: 2.9, Games: 4, Projected Points: 215.0", Lebron.toString());
    }

    @Test
    void testGetName() {
        assertEquals("Lebron James", Lebron.getName());
    }

    @Test
    void testGetTeam() {
        assertEquals("Lakers", Lebron.getTeam());
    }

    @Test
    void testGetAveragePoint() {
        assertEquals(29.3, Lebron.getAveragePoints());
    }

    @Test
    void testGetAverageRebounds() {
        assertEquals(7.7, Lebron.getAverageRebounds());
    }

    @Test
    void testGetAverageAssists() {
        assertEquals(6.1, Lebron.getAverageAssists());
    }

    @Test
    void testGetAverageSteals() {
        assertEquals(1.0, Lebron.getAverageSteals());
    }

    @Test
    void testGetAverageBlocks() {
        assertEquals(0.8, Lebron.getAverageBlocks());
    }

    @Test
    void testGetAverageTurnovers() {
        assertEquals(2.9, Lebron.getAverageTurnovers());
    }

    @Test
    void testGetGamesThisWeek() {
        assertEquals(4, Lebron.getGamesThisWeek());
    }

    @Test
    void testGetProjectedPoints() {
        assertEquals(215, Lebron.getProjectedPoints());
        assertEquals(167, Stephen.getProjectedPoints());
    }
}