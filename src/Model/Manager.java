package Model;
import Model.CompetitorList;
import View.CompetitorGUI;
public class Manager extends Person {
    private static int staffCounter = 1;
    private int staffId;
    private int accessLevel;

    public Manager(Name mName, String mGender, String mCountry, int mAge, int mAccessLevel) {
        super(mName, mGender, mCountry, mAge);
        staffId = staffCounter++;
        accessLevel = mAccessLevel;
    }
    public int getStaffId() {
        return staffId;
    }
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void addScoreToSprinter(Sprinter sprinter, int newScore) {
        sprinter.addScore(newScore);
    }

    public void printSprinterFullDetails(Sprinter sprinter) {
        System.out.println(sprinter.getFullDetails());
    }
    public void printSprinterShortDetails(Sprinter sprinter) {
        System.out.println(sprinter.getShortDetails());
    }
    public void openCompetitorGUI(CompetitorList competitorList) {
        CompetitorGUI competitorGUI = new CompetitorGUI();
        competitorList.generateFinalReport("finalReport.txt");
    }
}