package MainApp;

import View.CompetitorGUI;
import Model.Sprinter;
import Model.CompetitorList;
import Model.Person;
import Model.Manager;
import Model.Name;

public class Main {
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        competitorList.readCompetitorsFromExternalFile("RunCompetitor.csv");
        competitorList.generateFinalReport("finalReport.txt");
        new CompetitorGUI();
    }
}