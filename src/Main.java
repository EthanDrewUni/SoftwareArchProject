import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Rest of the classes remain the same as before

// Main class
public class Main {
    public static void main(String[] args) {

        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromExternalFile("RunCompetitor.csv");
        competitorList.generateFinalReport("finalReport.txt");

        // Test the outputAllCompetitors method for all competitors
        System.out.println("### Full Details for All Competitors ###");
        competitorList.outputAllCompetitors();

        // Test the getShortDetails method for all competitors
        System.out.println("### Short Details for All Competitors ###");
        for (Sprinter sprinter : competitorList.getSprinters()) {
            System.out.println("Competitor ID: " + sprinter.getCompetitorNumber());
            System.out.println("Short Details: " + sprinter.getShortDetails());
            System.out.println("array: " + Arrays.toString(sprinter.getScoreArray()));
            System.out.println("overall: " + sprinter.getOverallScore());
            System.out.println("weighted: " + sprinter.getScoreWeightedByLevel());
            System.out.println("-------------------------------");
        }

        //Test the getShort
        System.out.println("Get short details for competitor 7");
        competitorList.getShortDetailsByCompetitorNumber(7);

        // Test the summary functions
        System.out.println("### Summary Functions ###");
        System.out.println("List of compeitors: ");
        competitorList.outputAllCompetitors();
        System.out.println("Competitor with the highest overall score: ");
        competitorList.getWinner();
        System.out.println("Total scores for all competitors: ");
        competitorList.getTotals();
        System.out.println("Weighted scores for all competitors: ");
        competitorList.getWeightedScores();
        System.out.println("Maximum overall score: ");
        competitorList.getMaxScore();
        System.out.println("Minimum overall score: ");
        competitorList.getMinScore();
    }
}
