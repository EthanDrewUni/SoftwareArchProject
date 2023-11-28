import java.util.Arrays;

public class Sprinter extends Person{
    private static int competitorCounter = 1;
    private int competitorNumber;
    private int level;
    private int[] scores;
    public Sprinter(Name cName, String cEmail, String cCountry, int cAge , int cLevel, int[] cScores)
    {
        super(cName, cEmail, cCountry, cAge);
        competitorNumber = competitorCounter += 1;
        level = cLevel;
        scores = cScores;
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
    public double getOverallScore() {
        //This function calculates the overall average minus the highest and lowest value of the array
        //This works by looping through the array adding the scores starting at position 1 and ending at the arrays length - 1
        //This total is then divided by the length of the array
        if (scores.length < 5) {
            return 0.0;
        }

        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        int total = 0;
        for (int i = 1; i < scores.length - 1; i++) {
            total += sortedScores[i];
        }

        return (double) total / (scores.length - 2);
    }

    public double getScoreWeightedByLevel() {
        //This function calculates the overall average weighted by the competitors level
        //It first calculates the sum then divides it by the length of the array
        //It then times this by 1 + (0.1 x the level) which will increase the score by a higher amount depending on the level
        if (scores.length < 5) {
            return 0.0;
        }

        double sum = Arrays.stream(scores).sum();
        double average = sum / scores.length;
        return average * (1 + 0.1 * level);
    }
    public int[] getScoreArray() {
        return scores;
    }
    public String getFullDetails(){
        return "Competitor number " + competitorNumber + ", Name " + getName().getFullName() + ", Country " + getCountry() +
                ", Email " + getEmail() + ", " + getName().getFirstName() + " is a " + level;
    }
    public String getShortDetails(){
        return "CN " + competitorNumber + " (" + getName().getInitials() + ") has overall score " + getOverallScore();
    }
}