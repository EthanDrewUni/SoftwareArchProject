package View;

import Controller.CompetitorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorGUI extends JFrame {
    private CardLayout cardLayout;
    private CompetitorListGUI competitorListGUI;
    private CompetitorDetailsGUI competitorDetailsGUI;

    public CompetitorGUI() {
        super("Competitor Management System");
        cardLayout = new CardLayout();
        competitorListGUI = new CompetitorListGUI();
        competitorDetailsGUI = new CompetitorDetailsGUI();
        setLayout(cardLayout);

        // Initialize competitor controller
        new CompetitorController(competitorListGUI, competitorDetailsGUI);

        // Add panels to card layout with unique constraints
        add(competitorListGUI, "competitorList");
        add(competitorDetailsGUI, "competitorDetails");

        // Switch view according to constraints on button click
        competitorListGUI.viewDetailsButton(e -> cardLayout.show(getContentPane(), "competitorDetails"));
        competitorDetailsGUI.backButton(e -> cardLayout.show(getContentPane(), "competitorList"));

        // Frame width & height
        int FRAME_WIDTH = 800;
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