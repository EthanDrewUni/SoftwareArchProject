package View;

import javax.swing.*;
import java.util.Arrays;
import java.awt.event.ActionListener;

import Model.Sprinter;
import Model.Name;

public class CompetitorEditPanel extends JPanel {
    private JTextField firstNameField;
    private JTextField surameField;
    private JTextField countryField;
    private JTextField ageField;
    private JTextField levelField;
    private JTextArea scoresField;
    private JButton backButton;
    private JButton saveButton;

    public CompetitorEditPanel() {
        firstNameField = new JTextField(10);
        surameField = new JTextField(10);
        countryField = new JTextField(10);
        ageField = new JTextField(5);
        levelField = new JTextField(5);
        scoresField = new JTextArea(5, 20);
        backButton = new JButton("Back");
        saveButton = new JButton("Save");

        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(surameField);
        add(new JLabel("Country:"));
        add(countryField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Level:"));
        add(levelField);
        add(new JLabel("Scores (comma-separated):"));
        add(new JScrollPane(scoresField));
        add(saveButton);
        add(backButton);
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void saveButton(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    // Display competitor details
    public void displayCompetitorDetails(Sprinter sprinter) {
        firstNameField.setText(sprinter.getName().getFirstName());
        surameField.setText(sprinter.getName().getSurname());
        countryField.setText(sprinter.getCountry());
        ageField.setText(String.valueOf(sprinter.getAge()));
        levelField.setText(String.valueOf(sprinter.getLevel()));
        scoresField.setText(Arrays.toString(sprinter.getScoreArray()));
    }

    // Retrieve the modified details
    public Sprinter getModifiedDetails(int competitorNumber) {
        String firstName = firstNameField.getText();
        String surname = surameField.getText();
        String country = countryField.getText();

        int age;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (Exception e) {
            age = 0;
        }

        int level;
        try {
            level = Integer.parseInt(levelField.getText());
        } catch (Exception e) {
            level = 0;
        }

        String[] scoresArray = scoresField.getText().split(",");
        int[] scores = new int[scoresArray.length];

        for (int i = 0; i < scoresArray.length; i++) {
            try {
                scores[i] = Integer.parseInt(scoresArray[i].trim());
            } catch (Exception e) {
                scores[i] = 0;
            }
        }

        Sprinter modifiedSprinter = new Sprinter(new Name(firstName, surname), "Gender", country, age, level);
        modifiedSprinter.setScores(Arrays.copyOf(scores, scores.length));

        return modifiedSprinter;
    }
}