//import java.util.HashMap;
//import java.util.Scanner;
//
//public class OldLeaderBoardController {
//    /**
//     * Klasse LeaderBoardController
//     * Im Konstruktor:
//     * File instanzieren
//     * Methoden: Erstellen, Anzeigen, Bearbeiten
//     *
//     * Beim Ende: Bearbeiten Funktion nimmt den Spieler, sein Geld und den Tag.
//     * Rank
//     * Username
//     * Money
//     * Days
//     *
//     * In der Bearbeitenfunktion wird geranked. Die Liste wird so editiert, dass die Sortierung erfolgt und das CSV file dann so bearbeitet wird, wie die Sortierung erfolgt.
//     *
//     * Anzeigen: Jede Zeile und gestalten
//     */
//    static Scanner scanner = new Scanner(System.in);
//    private final HashMap<Integer, String> scores = new HashMap<>();
//    int scoreID = 1;
//
//    private int rank = 0;
//    private String username = "";
//    private int money = 0;
//    private int days = 0;
//    OldLeaderBoardController oldLeaderBoardController = new OldLeaderBoardController();
//
//    public OldLeaderBoardController() {
//        this.rank = rank;
//        this.username = username;
//        this.money = money;
//        this.days = days;
//    }
//
//    public void readFileStartup() {
//        boolean passTest = true;
//        String svnrInput = "";
//        while (passTest) {
//            System.out.print("Sozialversicherungsnummer: ");
//            svnrInput = scanner.nextLine();
//            if (scores.containsKey(svnrInput)) {
//                System.out.println("Person ist bereits vorhanden!");
//            } else {
//                passTest = false;
//            }
//        }
//
//        System.out.print("Name: ");
//        String nameInput = scanner.nextLine();
//        System.out.print("Adresse: ");
//        String adresseInput = scanner.nextLine();
//
//        person.put(svnrInput, newperson);
//    }
//
//    public void scoreboard() {
//       oldLeaderBoardController.getScore()
//    }
//
//    public <scoreID> void addScore(playerData, scoreID) {
//        scores.put(scoreID, playerData);
//    }
//
//    public String getScore(String player) {
//        return scores.get(player);
//    }
//
//    public void updateScore(String player, int score) {
//        scores.put(score, player);
//    }
//
//    public void displayScores() {
//        for (String player : scores.keySet()) {
//            System.out.println(player + ": " + scores.get(player));
//        }
//    }
//
//}
