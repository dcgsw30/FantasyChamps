package model;

//Represents a profile of an individual player with the name, team, player statistics,games, and projected points
public class PlayerProfile {
    private String name;
    private String team;
    private double averagePoints;
    private double averageRebounds;
    private double averageAssists;
    private double averageSteals;
    private double averageBlocks;
    private double averageTurnovers;
    private int gamesThisWeek;
    private double projectedPoints;

    /*
    EFFECTS: Name, team, player statistics, and games this week set by corresponding parameters; projectedPoints
    is set by a simple calculation where average points are multiplied by 1, rebounds multiplied by 1, assists
    by 2, steals by 4, blocks by 4, turnovers by -1. The sum is multiplied by games in the week and rounded to nearest
    whole number
    */
    public PlayerProfile(String name, String team, double averagePoints, double averageRebounds, double averageAssists,
                         double averageSteals, double averageBlocks, double averageTurnovers, int gamesThisWeek) {
        this.name = name;
        this.team = team;
        this.averagePoints = averagePoints;
        this.averageRebounds = averageRebounds;
        this.averageAssists = averageAssists;
        this.averageSteals = averageSteals;
        this.averageBlocks = averageBlocks;
        this.averageTurnovers = averageTurnovers;
        this.gamesThisWeek = gamesThisWeek;
        this.projectedPoints = Math.ceil((((averagePoints * 1) + (averageRebounds * 1) + (averageAssists * 2)
                + (averageSteals * 4) + (averageBlocks * 4) + (averageTurnovers * -1)) * gamesThisWeek));
    }

    //EFFECTS: Converts each field in an object field into string for UI
    @Override
    public String toString() {
        return "Name: " + name
                + ", Team: " + team
                + ", Avg Points: " + averagePoints
                + ", Avg Rebounds: " + averageRebounds
                + ", Avg Assists: " + averageAssists
                + ", Avg Steals: " + averageSteals
                + ", Avg Blocks: " + averageBlocks
                + ", Avg TO: " + averageTurnovers
                + ", Games: " + gamesThisWeek
                + ", Projected Points: " + projectedPoints;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

    public double getAverageRebounds() {
        return averageRebounds;
    }

    public double getAverageAssists() {
        return averageAssists;
    }

    public double getAverageSteals() {
        return averageSteals;
    }

    public double getAverageBlocks() {
        return averageBlocks;
    }

    public double getAverageTurnovers() {
        return averageTurnovers;
    }

    public double getGamesThisWeek() {
        return gamesThisWeek;
    }

    public double getProjectedPoints() {
        return projectedPoints;
    }

}
