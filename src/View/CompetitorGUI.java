package View;

import Controller.CompetitorController;

import javax.swing.*;
import java.awt.*;

public class CompetitorGUI extends JFrame {
    private CardLayout cardLayout;
    private CompetitorListPanel competitorListPanel;
    private CompetitorDetailsPanel competitorDetailsGUI;

    public CompetitorGUI() {
        super("Competitor Management System");
        cardLayout = new CardLayout();
        competitorListPanel = new CompetitorListPanel();
        competitorDetailsGUI = new CompetitorDetailsPanel();
        setLayout(cardLayout);

        // Initialize competitor controller
        new CompetitorController(competitorListPanel, competitorDetailsGUI, cardLayout);

        // Add panels to card layout with unique constraints
        add(competitorListPanel, "competitorList");
        add(competitorDetailsGUI, "competitorDetails");

        // Switch view according to constraints on button click
        competitorListPanel.viewDetailsButton(e -> cardLayout.show(getContentPane(), "competitorDetails"));
        competitorDetailsGUI.backButton(e -> cardLayout.show(getContentPane(), "competitorList"));

        // Frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 600;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CompetitorGUI();
        });
    }
}