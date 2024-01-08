package Controller;

import Model.CompetitorList;
import View.CompetitorListPanel;
import View.CompetitorDetailsPanel;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorController {
    private CompetitorListPanel competitorListPanel;
    private CompetitorDetailsPanel competitorDetailsPanel;
    private CompetitorList competitorList;
    private CardLayout cardLayout;

    public CompetitorController(CompetitorListPanel listPanel, CompetitorDetailsPanel detailsPanel, CardLayout layout) {
        this.competitorListPanel = listPanel;
        this.competitorDetailsPanel = detailsPanel;
        this.competitorList = new CompetitorList();
        this.cardLayout = layout;

        // Initialize the competitor list
        competitorList.readCompetitorsFromExternalFile("RunCompetitor.csv");

        // Display competitors on the list panel
        competitorListPanel.displayCompetitors(competitorList.outputAllCompetitors());

        // Add action listeners
        this.competitorListPanel.viewDetailsButton(new ViewDetailsButtonListener());
        this.competitorDetailsPanel.searchButton(new SearchButtonListener());
        this.competitorDetailsPanel.backButton(new BackButtonListener());
    }

    private class ViewDetailsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Switch to the details panel
            cardLayout.show(competitorDetailsPanel.getParent(), "competitorDetails");
        }
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get competitor number from the view
            int competitorNumber = competitorDetailsPanel.getEnteredCompetitorNumber();

            // Get details for the competitor number
            String details = competitorList.getShortDetailsByCompetitorNumber(competitorNumber);

            // Display details
            JOptionPane.showMessageDialog(null, details, "Competitor Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the logic for going back
            // For example, switch to the list panel
            // You can add your own logic here

            // Show the competitor list panel
            cardLayout.show(competitorListPanel.getParent(), "competitorList");
        }
    }
}