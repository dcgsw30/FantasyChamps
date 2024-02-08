package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPlayerProfile {

    PlayerProfile Lebron;

    @BeforeEach
    void runBefore() {
        Lebron = new PlayerProfile("Lebron James", "Lakers", 29.3, 7.7,
                6.1, 1.0, 0.8, 2.9, 4);
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

    @Test //ASK TA HOW TO DEAL WITH DOUBLES
    void testGetSetProjectedPoints() {
        assertEquals(0, Lebron.getProjectedPoints());
        Lebron.setProjectedPoints();
        assertEquals(214, Lebron.getProjectedPoints());
    }
}