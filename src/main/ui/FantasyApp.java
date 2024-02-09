package ui;

import model.PlayerProfile;
import model.TeamRoster;

import java.util.Scanner;

public class FantasyApp {
    private TeamRoster myTeam;
    private Scanner input;

    //EFFECTS: runs the fantasy app
    public FantasyApp() {
        runFantasy();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
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

//    void processCommand(String str) {
//        if (str == "a") {
//
//        }
//    }

    // MODIFIES: this
    // EFFECTS: initializes team
    private void init() {
        myTeam = new TeamRoster();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add player");
        System.out.println("\tv -> view roster");
        System.out.println("\ts -> search for player");
        System.out.println("\tr -> remove player");
        System.out.println("\tc -> get cumulative roster fantasy points");
        System.out.println("\tq -> quit");
        String selection = input.next();
        //processCommand(selection);
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
    }

    //EFFECTS: displays entire roster
    private void actionViewRoster() {
        myTeam.getTeam();
    }

    //EFFECTS: displays select player
    private void actionViewSelectPlayer() {
        System.out.println("Enter name of player");
        String nameQuery = input.next();
        myTeam.getPlayerByName(nameQuery);
    }

    //EFFECTS: removes player from roster
    private void actionRemovePlayer() {
        System.out.println("Enter name of player that you want to remove");
        String nameQuery = input.next();
        myTeam.removePlayer(nameQuery);
    }

    //EFFECTS: prints total projected fantasy points
    private void actionViewProjectedPoints() {
        System.out.println(myTeam.sumFantasyPoints());
    }
}
