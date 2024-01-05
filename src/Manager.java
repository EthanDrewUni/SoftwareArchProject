public class Manager extends Person {
    private static int staffCounter = 1;
    private int staffId;
    private int accessLevel;

    public Manager(Name mName, String mEmail, String mCountry, int mAge, int mAccessLevel) {
        super(mName, mEmail, mCountry, mAge);
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
}