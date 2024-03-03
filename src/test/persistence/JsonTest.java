package persistence;

import model.PlayerProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

//this test class is adapted from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
//tests the property of the PlayerProfile generated from JSON
public class JsonTest {
    protected void checkPlayerProfile(String name, String team, double averagePoints, double averageRebounds,
                                      double averageAssists, double averageSteals, double averageBlocks,
                                      double averageTurnovers, int gamesThisWeek,
                                      double projectedPoints, PlayerProfile playerProfile) {
        assertEquals(name, playerProfile.getName());
        assertEquals(team, playerProfile.getTeam());
        assertEquals(averagePoints, playerProfile.getAveragePoints());
        assertEquals(averageRebounds, playerProfile.getAverageRebounds());
        assertEquals(averageAssists, playerProfile.getAverageAssists());
        assertEquals(averageSteals, playerProfile.getAverageSteals());
        assertEquals(averageBlocks, playerProfile.getAverageBlocks());
        assertEquals(averageTurnovers, playerProfile.getAverageTurnovers());
        assertEquals(gamesThisWeek, playerProfile.getGamesThisWeek());
        assertEquals(projectedPoints, playerProfile.getProjectedPoints());
    }
}
