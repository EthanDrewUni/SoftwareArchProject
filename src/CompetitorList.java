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
            System.out.println("Overall Score: " + winner.getOverallScore());
        }
        else {
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

    // Provide the highest individual score
    public void getMaxScore() {
        int maxScore = sprinters.stream()
                .flatMapToInt(sprinter -> Arrays.stream(sprinter.getScoreArray()))
                .max()
                .orElse(0);

        System.out.println("Max Score: " + maxScore);
    }

    // Provide the lowest individual score
    public void getMinScore() {
        int minScore = sprinters.stream()
                .flatMapToInt(sprinter -> Arrays.stream(sprinter.getScoreArray()))
                .min()
                .orElse(0);

        System.out.println("Min Score: " + minScore);
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
    public void outputReport(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header
            writer.write("Name,Age,Level,Gender,Country,Score1,Score2,Score3,Score4,Score5,OverallScore\n");

            // Write data for each competitor
            for (Sprinter sprinter : sprinters) {
                writer.write(sprinter.getName().getFullName() + "," +
                        sprinter.getAge() + "," +
                        sprinter.getLevel() + "," +
                        sprinter.getGender() + "," +
                        sprinter.getCountry() + "," +
                        sprinter.getScoreArray()[0] + "," +
                        sprinter.getScoreArray()[1] + "," +
                        sprinter.getScoreArray()[2] + "," +
                        sprinter.getScoreArray()[3] + "," +
                        sprinter.getScoreArray()[4] + "," +
                        sprinter.getOverallScore() + "\n");
            }

            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Something went wrong creating the report");
            System.out.println(e.getMessage());
        }
    }
}