package Controller;

import View.CompetitorListGUI;
import View.CompetitorDetailsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorController {
    private CompetitorListGUI competitorListPanel;
    private CompetitorDetailsGUI competitorDetailsPanel;

    public CompetitorController(CompetitorListGUI listPanel, CompetitorDetailsGUI detailsPanel) {
        this.competitorListPanel = listPanel;
        this.competitorDetailsPanel = detailsPanel;

        // Add action listeners
        this.competitorListPanel.viewDetailsButton(new ViewDetailsButtonListener());
        this.competitorDetailsPanel.backButton(new BackButtonListener());
    }

    private class ViewDetailsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the logic for viewing details
            // For example, switch to the details panel
            // You can add your own logic here
            System.out.println("View Competitor Details button clicked!");
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the logic for going back
            // For example, switch to the list panel
            // You can add your own logic here
            System.out.println("Back to Competitor List button clicked!");
        }
    }
}