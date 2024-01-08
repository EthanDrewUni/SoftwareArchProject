package Controller;

import Model.CompetitorList;
import Model.Sprinter;
import View.CompetitorListPanel;
import View.CompetitorDetailsPanel;
import View.CompetitorEditPanel;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorController {
    private CompetitorListPanel competitorListPanel;
    private CompetitorDetailsPanel competitorDetailsPanel;
    private CompetitorEditPanel competitorEditPanel;
    private CompetitorList competitorList;
    private CardLayout cardLayout;

    public CompetitorController(CompetitorListPanel listPanel, CompetitorDetailsPanel detailsPanel, CompetitorEditPanel editPanel, CardLayout cardLayout) {
        this.competitorListPanel = listPanel;
        this.competitorDetailsPanel = detailsPanel;
        this.competitorEditPanel = editPanel;
        this.cardLayout = (CardLayout) listPanel.getParent().getLayout();

        competitorList = new CompetitorList();
        competitorList.readCompetitorsFromExternalFile("RunCompetitor.csv");

        competitorListPanel.displayCompetitors(competitorList.outputAllCompetitors());

        // Add action listeners
        this.competitorListPanel.viewDetailsButton(new ViewDetailsButtonListener());
        this.competitorDetailsPanel.searchButton(new SearchButtonListener());
        this.competitorDetailsPanel.editButton(new EditButtonListener());
        this.competitorEditPanel.backButton(new BackButtonListener());
        this.competitorEditPanel.saveButton(new SaveButtonListener());
    }

    private class ViewDetailsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(competitorListPanel.getParent(), "competitorDetails");
        }
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int competitorNumber = competitorDetailsPanel.getEnteredCompetitorNumber();
            String details = competitorList.getShortDetailsByCompetitorNumber(competitorNumber);
            JOptionPane.showMessageDialog(null, details, "Competitor Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get competitor number from the text box
            int competitorNumber = competitorDetailsPanel.getEnteredCompetitorNumber();

            Sprinter sprinter = competitorList.getCompetitorDetailsByCompetitorNumber(competitorNumber);

            if (sprinter != null) {
                competitorEditPanel.displayCompetitorDetails(sprinter);
                cardLayout.show(competitorListPanel.getParent(), "editCompetitor");
            }
            else {
                JOptionPane.showMessageDialog(null, "Competitor not found with number: " + competitorNumber,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get competitor number from the view
            int competitorNumber = competitorDetailsPanel.getEnteredCompetitorNumber();

            // Get modified details and update sprinter
            Sprinter modifiedSprinter = competitorEditPanel.getModifiedDetails(competitorNumber);
            boolean success = competitorList.updateSprinterDetails(competitorNumber, modifiedSprinter);

            //Update the score seperately
            competitorList.setSprinterScoresByCompNumber(competitorNumber, modifiedSprinter.getScoreArray());

            if (success) {
                JOptionPane.showMessageDialog(null, "Details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Something went wrong ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(competitorListPanel.getParent(), "competitorList");
        }
    }
}