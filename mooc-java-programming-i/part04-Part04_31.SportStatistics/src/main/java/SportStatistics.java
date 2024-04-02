
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("File:");
        String fileName = scan.nextLine();
        
        try {
            Scanner fileScanner = new Scanner(Paths.get(fileName));
            System.out.println("Team:");
            String team = scan.nextLine();
            
            int gameCount = 0;
            int losses = 0;
            int wins = 0;
            while (fileScanner.hasNextLine()) {
                String[] info = fileScanner.nextLine().split(",");
                String homeTeam = info[0];
                String visitingTeam = info[1];
                int homeTeamPoints = Integer.valueOf(info[2]);
                int visitingTeamPoints = Integer.valueOf(info[3]);
                
                // Get team status to check if they are the winner or loser
                String teamStatus = "home";
                if (visitingTeam.equals(team)) {
                    teamStatus = "visiting";
                }
                
                // Update game count regardless of team
                if (homeTeam.equals(team) || visitingTeam.equals(team)) {
                    gameCount += 1;
                    // Check if team won
                    if (checkIfTeamWon(homeTeamPoints, visitingTeamPoints, teamStatus)) {
                        wins += 1;
                    } else {
                        losses += 1;
                    }

                }
            }
            
            System.out.println("Games: " + gameCount);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: "  + losses);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static boolean checkIfTeamWon(int homeTeamPoints, int visitingTeamPoints, String teamStatus) {
        if (teamStatus.equals("home")) {
            if (homeTeamPoints > visitingTeamPoints) {
                return true;
            } else {
                return false;
            }
        } else {
            if (visitingTeamPoints > homeTeamPoints) {
                return true;
            } else {
                return false;
            }
        }
    }

}
