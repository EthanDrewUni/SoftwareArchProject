package MainApp;

import View.CompetitorGUI;
import Model.CompetitorList;

public class Main {
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromExternalFile("RunCompetitor.csv");
        competitorList.generateFinalReport("finalReport.txt");
        new CompetitorGUI();
    }
}