package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompetitorListPanel extends JPanel {
    private JButton viewDetailsButton;
    private JList<String> competitorList;

    public CompetitorListPanel() {
        // Initialize components, set layout, etc.
        viewDetailsButton = new JButton("Search");
        competitorList = new JList<>();

        JScrollPane scrollPane = new JScrollPane(competitorList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(1100, 400)); // Adjust the values as needed

        add(viewDetailsButton);
        add(scrollPane);
    }

    public void viewDetailsButton(ActionListener actionListener) {
        viewDetailsButton.addActionListener(actionListener);
    }

    public void setCompetitorList(String[] competitors) {
        competitorList.setListData(competitors);
    }

    public void displayCompetitors(String[] competitors) {
        setCompetitorList(competitors);
    }
}