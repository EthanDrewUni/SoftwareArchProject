package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompetitorDetailsPanel extends JPanel {
    private JTextField competitorNumberField;
    private JButton searchButton;
    private JButton backButton;

    public CompetitorDetailsPanel() {
        // Initialize components, set layout, etc.
        competitorNumberField = new JTextField(10);
        searchButton = new JButton("Search");
        backButton = new JButton("Back");

        add(new JLabel("Enter Competitor Number:"));
        add(competitorNumberField);
        add(searchButton);
        add(backButton);
    }

    public void searchButton(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    // Method to get the entered competitor number
    public int getEnteredCompetitorNumber() {
        try {
            return Integer.parseInt(competitorNumberField.getText());
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            return -1; // You can choose an appropriate default value or handle it differently
        }
    }
}