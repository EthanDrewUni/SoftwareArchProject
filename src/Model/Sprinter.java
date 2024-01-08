package Model;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Sprinter extends Person{
    private static int competitorCounter = 0;
    private int competitorNumber;
    private int level;
    private int maxScores = 5;
    private int[] scores = new int[maxScores];
    private int scoreIndex = 0;
    public Sprinter(Name cName, String cGender, String cCountry, int cAge , int cLevel)
    {
        super(cName, cGender, cCountry, cAge);
        competitorNumber = competitorCounter += 1;
        level = cLevel;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }
    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setScores(int[] scores) {
        if (scores.length <= maxScores) {
            this.scores = Arrays.copyOf(scores, scores.length);
            scoreIndex = scores.length;
        }
        else {
            System.out.println("Cannot set more scores than the maximum allowed.");
        }
    }
    public double getOverallScore() {
        // This function calculates the overall average minus the highest and lowest value of the array
        // This works by looping through the array adding the scores starting at position 1 and ending at the arrays length - 1
        // This total is then divided by the length of the array
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        int total = 0;
        for (int i = 1; i < scores.length - 1; i++) {
            total += sortedScores[i];
        }

        double overallScore = (double) total / (scores.length - 2);

        // Format the result to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(overallScore));
    }

    public double getScoreWeightedByLevel() {
        //This function calculates the overall average weighted by the competitors level
        //It first calculates the sum then divides it by the length of the array
        //It then times this by 1 + (0.1 x the level) which will increase the score by a higher amount depending on the level
        double sum = Arrays.stream(scores).sum();
        double average = sum / scores.length;
        return average * (1 + 0.1 * level);
    }
    public int[] getScoreArray() {
        return scores;
    }
    public void addScore(int newScore) {
        //Error handling
        if (newScore < 0) {
            System.out.println("Score cannot be under 0");
        }
        if (scoreIndex < maxScores) {
            System.out.println("Cannot add more scores. Maximum scores reached.");
        }

        scores[scoreIndex] = newScore;
        scoreIndex++; // Move to the next index so scores are not overwritten
        System.out.println("Score added successfully");
    }
    public String getFullDetails() {
        return "Competitor number " + competitorNumber + ", Name " + getName().getFullName() + ", Country " + getCountry() +
                ", Gender " + getGender() + ", " + getName().getFirstName() + " is a level " + level +
                " and received these scores: " + Arrays.toString(getScoreArray()) +
                ". This gives them an overall score of " + getOverallScore();
    }
    public String getShortDetails(){
        return "CN " + competitorNumber + " (" + getName().getInitials() + ") has overall score " + getOverallScore();
    }
}
