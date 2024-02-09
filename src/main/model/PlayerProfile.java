package model;

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
