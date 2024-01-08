import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class CompetitorList {
    private List<Sprinter> sprinters;

    public CompetitorList() {
        this.sprinters = new ArrayList<>();
    }
    public void addSprinter(Sprinter sprinter) {
        sprinters.add(sprinter);
    }

    public List<Sprinter> getSprinters() {
        return sprinters;
    }

    public String[] outputAllCompetitors() {
        List<String> competitorsDetails = new ArrayList<>();

        for (Sprinter sprinter : sprinters) {
            competitorsDetails.add(sprinter.getFullDetails());
        }

        return competitorsDetails.toArray(new String[0]);
    }

    // Function to provide full details of the competitor with the highest overall score
    public String getWinner() {
        Sprinter winner = sprinters.stream()
                .max((s1, s2) -> Double.compare(s1.getOverallScore(), s2.getOverallScore()))
                .orElse(null);

        if (winner != null) {
            return "Winner: " + winner.getFullDetails();
        } else {
            return "No competitors found.";
        }
    }

    public String getTotals() {
        String result = "Total Scores:\n";
        for (Sprinter sprinter : sprinters) {
            result += sprinter.getCompetitorNumber() + ": " + sprinter.getOverallScore() + "\n";
        }
        return result;
    }
    public String getWeightedScores() {
        String result = "Weighted Scores:\n";
        for (Sprinter sprinter : sprinters) {
            result += sprinter.getCompetitorNumber() + ": " + sprinter.getScoreWeightedByLevel() + "\n";
        }
        return result;
    }
    public String getMaxScore() {
        int maxScore = sprinters.stream()
                .flatMapToInt(sprinter -> Arrays.stream(sprinter.getScoreArray()))
                .max()
                .orElse(0);

        return "Max Score: " + maxScore;
    }
    public String getMinScore() {
        int minScore = sprinters.stream()
                .flatMapToInt(sprinter -> Arrays.stream(sprinter.getScoreArray()))
                .min()
                .orElse(0);

        return "Min Score: " + minScore;
    }

    // Find short details by competitor number
    public int getShortDetailsByCompetitorNumber(int competitorNumber) {
        for (Sprinter sprinter : sprinters) {
            if (sprinter.getCompetitorNumber() == competitorNumber) {
                System.out.println(sprinter.getShortDetails());
                return 1;
            }
        }
        // If the loop completes without finding the competitor
        System.out.println("Competitor not found with number: " + competitorNumber);
        return 0;
    }

    //Read the competitors from the external file
    public void readCompetitorsFromExternalFile(String fileName) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //For each line in the file
            while ((line = br.readLine()) != null) {
                //Split the line into individual components
                String[] data = line.split(",");

                if (data.length < 7) {
                    // Skip this line if it doesn't have enough elements
                    System.out.println("Incorrect format. Skipping line: " + line);
                    continue;
                }

                //Store individual components in relevant variables
                String[] nameParts = data[0].split(" ");
                String firstName = nameParts[0];
                String surname = nameParts[nameParts.length - 1];
                int age = Integer.parseInt(data[1].replaceAll("[^0-9]", ""));
                int level = Integer.parseInt(data[2].replaceAll("[^0-9]", ""));
                String gender = data[3];
                String country = data[4];
                int[] scores = new int[data.length - 5];

                for (int i = 5; i < data.length; i++) {
                    scores[i - 5] = Integer.parseInt(data[i]);
                }

                //Create a sprinter object with the details read then add it to the array
                Sprinter sprinter = new Sprinter(new Name(firstName, surname), gender, country, age, level);
                for (int score : scores) {
                    sprinter.addScore(score);
                }
                addSprinter(sprinter);
            }
        }
        //Through exception if error occurs
        catch (Exception e) {
            System.out.println("Something went wrong when reading the file");
            System.out.println(e.getMessage());
        }
    }

    // Output report to a file
    // Function to generate the final report
    public void generateFinalReport(String fileName) {
        try {
            // Create FileWriter
            FileWriter writer = new FileWriter(fileName);

            // Table of competitors with full details
            writer.write(" All Competitors \n");
            String[] competitorsDetails = outputAllCompetitors();
            for (String details : competitorsDetails) {
                writer.write(details + "\n");
            }

            // Details of the competitor with the highest overall score
            writer.write("\n Summary Statistics \n");
            writer.write(getWinner() + "\n");
            writer.write(getTotals() + "\n");
            writer.write(getWeightedScores() + "\n");
            writer.write(getMaxScore() + "\n");
            writer.write(getMinScore() + "\n");


            writer.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong generating the final report");
            System.out.println(e.getMessage());
        }
    }
}