import java.util.Date;
public class Competitor extends Person{
    private int competitorNumber;
    private String category;
    private String level;

    public Competitor(Name name, String email, String country, int age, int cn, String c, String l)
    {
        super(name, email, country, age);
        competitorNumber = cn;
        category = c;
        level = l;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }
    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return level;
    }
    public double getOverallScore() {
        return 5;
    }
    public String getFullDetails(){
        return "Competitor number " + competitorNumber + ", Name " + getName().getFullName() + ", Country " + getCountry() +
                ", Email " + getEmail() + ", " + getName().getFirstName() + " is a " + level;
    }

}
