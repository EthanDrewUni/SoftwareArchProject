import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Rest of the classes remain the same as before

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a list to store multiple competitors
        List<Sprinter> sprinters = new ArrayList<>();

        // Create competitors
        Name sprinter1Name = new Name("Alice", "Smith", "Johnson");
        int[] scores1 = {4, 3, 5, 2, 4};
        Sprinter sprinter1 = new Sprinter(sprinter1Name, "test@email", "Sprint", 18, 1, scores1, 5);

        Name sprinter2Name = new Name("Bob", "Thomas", "Williams");
        int[] scores2 = {1, 5, 5, 2, 4};
        Sprinter sprinter2 = new Sprinter(sprinter2Name, "tes2t@email", "Marathon", 20, 2, scores2, 5 );

        // Add competitors to the list
        sprinters.add(sprinter1);
        sprinters.add(sprinter2);

        // Test the getAllDetails method for all competitors
        System.out.println("### Full Details for All Competitors ###");
        for (Sprinter sprinter : sprinters) {
            System.out.println("Competitor ID: " + sprinter.getCompetitorNumber());
            System.out.println(sprinter.getFullDetails());
            System.out.println("array: " + Arrays.toString(sprinter.getScoreArray()));
            System.out.println("overall: " + sprinter.getOverallScore());
            System.out.println("weighted: " + sprinter.getScoreWeightedByLevel());
            System.out.println("-------------------------------");
        }

        // Test the getShortDetails method for all competitors
        System.out.println("### Short Details for All Competitors ###");
        for (Sprinter sprinter : sprinters) {
            System.out.println("Competitor ID: " + sprinter.getCompetitorNumber());
            System.out.println("Short Details: " + sprinter.getShortDetails());
            System.out.println("array: " + Arrays.toString(sprinter.getScoreArray()));
            System.out.println("overall: " + sprinter.getOverallScore());
            System.out.println("weighted: " + sprinter.getScoreWeightedByLevel());
            System.out.println("-------------------------------");
        }
    }
}