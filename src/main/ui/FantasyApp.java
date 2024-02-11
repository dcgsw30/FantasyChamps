package ui;

import model.PlayerProfile;
import model.TeamRoster;

import java.util.ArrayList;
import java.util.Scanner;

public class FantasyApp {
    private TeamRoster myTeam;
    private Scanner input;

    //EFFECTS: runs the fantasy app
    public FantasyApp() {
        runFantasy();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    //NOTE: Code adapted from the example "AccountNotRobust" files, provided by the course
    private void runFantasy() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();
        }
        System.out.println("\nGoodbye!");
    }

    void processCommand(String str) {
        if (str.equals("a")) {
            actionAddPlayer();
        } else if (str.equals("v")) {
            actionViewRoster();
        } else if (str.equals("s")) {
            actionViewSelectPlayer();
        } else if (str.equals("r")) {
            actionRemovePlayer();
        } else if (str.equals("c")) {
            actionViewCumulativePoints();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes team
    private void init() {
        myTeam = new TeamRoster();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add player");
        System.out.println("\tv -> view roster");
        System.out.println("\ts -> search for player");
        System.out.println("\tr -> remove player");
        System.out.println("\tc -> get cumulative roster fantasy points");
        String selection = input.next();
        processCommand(selection);
    }

    //MODIFIES: this
    //EFFECTS: conducts an add player action
    private void actionAddPlayer() {
        System.out.println("Enter name");
        String name = input.next();
        System.out.println("Enter team");
        String team = input.next();
        System.out.println("Enter average points");
        double averagePoints = Double.parseDouble(input.next());
        System.out.println("Enter average rebounds");
        double averageRebounds = Double.parseDouble(input.next());
        System.out.println("Enter average assists");
        double averageAssists = Double.parseDouble(input.next());
        System.out.println("Enter average steals");
        double averageSteals = Double.parseDouble(input.next());
        System.out.println("Enter average blocks");
        double averageBlocks = Double.parseDouble(input.next());
        System.out.println("Enter average turnovers");
        double averageTurnovers = Double.parseDouble(input.next());
        System.out.println("Enter games this week");
        int gamesThisWeek = Integer.parseInt(input.next());
        PlayerProfile createdPlayer = new PlayerProfile(name, team, averagePoints, averageRebounds, averageAssists,
                averageSteals, averageBlocks, averageTurnovers, gamesThisWeek);
        myTeam.addPlayer(createdPlayer);
        System.out.println("Player created");
    }

    //EFFECTS: displays entire roster
    private void actionViewRoster() {
        printAllPlayerDetails(myTeam.getTeam());
    }

    //EFFECTS: displays select player
    private void actionViewSelectPlayer() {
        System.out.println("Enter name of player");
        String nameQuery = input.next();
        printPlayerDetails(myTeam.getPlayerByName(nameQuery));
    }

    //EFFECTS: removes player from roster
    private void actionRemovePlayer() {
        System.out.println("Enter name of player that you want to remove");
        String nameQuery = input.next();
        myTeam.removePlayer(nameQuery);
        System.out.println("Player " + nameQuery + " has been removed");
    }

    //EFFECTS: prints total projected fantasy points
    private void actionViewCumulativePoints() {
        System.out.println("Your team will generate " + myTeam.sumFantasyPoints() + " points this week");
    }

    //EFFECTS: prints all details of a single player
    private void printPlayerDetails(PlayerProfile player) {
        System.out.println(player.toString());
    }

    //EFFECTS: prints details of all players in a list
    private void printAllPlayerDetails(ArrayList<PlayerProfile> players) {
        for (PlayerProfile player : players) {
            printPlayerDetails(player);
        }
    }

}
