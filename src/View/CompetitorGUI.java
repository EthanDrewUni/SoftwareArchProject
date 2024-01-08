package View;

import Controller.CompetitorController;

import javax.swing.*;
import java.awt.*;

public class CompetitorGUI extends JFrame {
    private CardLayout cardLayout;
    private CompetitorListPanel competitorListPanel;
    private CompetitorEditPanel competitorEditPanel;
    private CompetitorDetailsPanel competitorDetailsPanel;

    public CompetitorGUI() {
        //Create GUI
        super("Competitor Management System");
        cardLayout = new CardLayout();
        competitorListPanel = new CompetitorListPanel();
        competitorEditPanel = new CompetitorEditPanel();
        competitorDetailsPanel = new CompetitorDetailsPanel();
        setLayout(cardLayout);

        add(competitorListPanel, "competitorList");
        add(competitorEditPanel, "editCompetitor");
        add(competitorDetailsPanel, "competitorDetails");

        competitorListPanel.viewDetailsButton(e -> cardLayout.show(getContentPane(), "competitorDetails"));
        competitorEditPanel.backButton(e -> cardLayout.show(getContentPane(), "competitorList"));
        competitorDetailsPanel.backButton(e -> cardLayout.show(getContentPane(), "competitorList"));

        // Initialize competitor controller
        new CompetitorController(competitorListPanel, competitorDetailsPanel, competitorEditPanel, cardLayout);

        //Set GUI details
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 600;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CompetitorGUI();
        });
    }
}