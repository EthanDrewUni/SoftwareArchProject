package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CompetitorDetailsPanel extends JPanel {
    private JTextField competitorNumberField;
    private JButton searchButton;
    private JButton editButton;
    private JButton backButton;

    public CompetitorDetailsPanel() {
        competitorNumberField = new JTextField(5);
        searchButton = new JButton("Search");
        editButton = new JButton("Edit");
        backButton = new JButton("Back");

        add(new JLabel("Enter Competitor Number:"));
        add(competitorNumberField);
        add(searchButton);
        add(editButton);
        add(backButton);
    }

    public void searchButton(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void editButton(ActionListener actionListener) {
        editButton.addActionListener(actionListener);
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    // Method to get the entered competitor number
    public int getEnteredCompetitorNumber() {
        try {
            return Integer.parseInt(competitorNumberField.getText());
        }
        catch (Exception e) {
            return -1;
        }
    }
}