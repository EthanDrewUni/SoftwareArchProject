import java.util.ArrayList;
import java.util.List;

public class CompetitorList {
    private List<Sprinter> sprinters;

    public CompetitorList() {
        this.sprinters = new ArrayList<>();
    }
    public void addSprinter(Sprinter sprinter) {
        sprinters.add(sprinter);
    }

    public void outputAllCompetitors() {
        for (Sprinter sprinter : sprinters) {
            System.out.println(sprinter.getFullDetails());
        }
    }

    // Function to provide full details of the competitor with the highest overall score
    public void getWinner() {
        Sprinter winner = sprinters.stream().max((s1, s2) -> Double.compare(s1.getOverallScore(), s2.getOverallScore()))
                .orElse(null);

        if (winner != null) {
            System.out.println("Winner:");
            System.out.println(winner.getFullDetails());
        } else {
            System.out.println("No competitors found.");
        }
    }

    // Provide all total scores
    public void getTotals() {
        System.out.println("Total Scores:");
        for (Sprinter sprinter : sprinters) {
            System.out.println(sprinter.getCompetitorNumber() + ": " + sprinter.getOverallScore());
        }
    }

    // Provide all weighted scores
    public void getWeightedScores() {
        System.out.println("Weighted Scores:");
        for (Sprinter sprinter : sprinters) {
            System.out.println(sprinter.getCompetitorNumber() + ": " + sprinter.getScoreWeightedByLevel());
        }
    }

    // Provide the highest total score
    public void getMaxScore() {
        Sprinter maxScoreSprinter = sprinters.stream()
                .max((s1, s2) -> Double.compare(s1.getOverallScore(), s2.getOverallScore()))
                .orElse(null);

        if (maxScoreSprinter != null) {
            System.out.println("Max Score:");
            System.out.println(maxScoreSprinter.getFullDetails() + " Score: " + maxScoreSprinter.getOverallScore());
        } else {
            System.out.println("No competitors found.");
        }
    }

    // Provide the lowest total score
    public void getMinScore() {
        Sprinter minScoreSprinter = sprinters.stream()
                .min((s1, s2) -> Double.compare(s1.getOverallScore(), s2.getOverallScore()))
                .orElse(null);

        if (minScoreSprinter != null) {
            System.out.println("Min Score:");
            System.out.println(minScoreSprinter.getFullDetails() + " Score: " + minScoreSprinter.getOverallScore());
        } else {
            System.out.println("No competitors found.");
        }
    }
}