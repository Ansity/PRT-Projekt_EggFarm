import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

    public class LeaderboardController {
        public LeaderboardController() {
            File leaderboard = new File("data/datastore.csv");
            if (!leaderboard.exists()) {
                createLeaderboardFile();
            }
        }

        //create a empty csv file with just a heading
        private void createLeaderboardFile() {
            try {
                FileWriter writer = new FileWriter("data/datastore.csv");

                List<String> test = new ArrayList<>();
                test.add("Rank");
                test.add("Username");
                test.add("Money");
                test.add("Days");
                String collect = test.stream().collect(Collectors.joining(","));

                writer.write(collect);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        //simple display of csv file via BufferedReader, needs better styling
        public void showLeaderboard() {
            try {
                String line = "";
                BufferedReader br = new BufferedReader(new FileReader("data/datastore.csv"));
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //needs player data to create a new LeaderboardEntry, all entries will be sorted to add them in correct order by money
        public void addNewScoreEntry(String userName, int money, int day) {
            LeaderboardEntry newestEntry = new LeaderboardEntry(userName, money, day);
            List<LeaderboardEntry> currentLeaderboard = getAllEntries();
            currentLeaderboard.add(newestEntry);
            Collections.sort(currentLeaderboard, Comparator.comparingInt(LeaderboardEntry::getMoney).reversed());

            writeToCSV(currentLeaderboard);
        }

        //read all leaderboard entries from the vsc file and map them to LeaderboardEntry objects in a List
        public List<LeaderboardEntry> getAllEntries() {
            BufferedReader br = null;
            String line = "";
            List<LeaderboardEntry> entries = new ArrayList<>();
            try {
                br = new BufferedReader(new FileReader("data/datastore.csv"));
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    //don't add the first heading line
                    if (!Objects.equals(data[0], "Rank")) {
                        LeaderboardEntry singleEntry = new LeaderboardEntry(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                        entries.add(singleEntry);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return entries;
        }

        //erases the current csv file and overwrites it with the newly sorted entries
        public void writeToCSV(List<LeaderboardEntry> leaderboardEntries) {
            try {
                //overwrite previous leaderboard
                createLeaderboardFile();
                FileWriter writer = new FileWriter("data/datastore.csv", true);

                //every leaderboard entry will be formatted into csv line and added to the file
                for (int i =0; i < leaderboardEntries.size(); i++) {
                    List<String> data = new ArrayList<>();
                    data.add("\n" + (i+1));
                    data.add(leaderboardEntries.get(i).getUserName());
                    data.add(leaderboardEntries.get(i).getMoney() + "");
                    data.add(leaderboardEntries.get(i).getDays() + "");

                    String collect = String.join(",", data);

                    writer.write(collect);
                }

                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

