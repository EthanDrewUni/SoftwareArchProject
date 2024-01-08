package View;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class CompetitorListPanel extends JPanel {
    private JButton viewDetailsButton;
    private JList<String> competitorList;
    private ListSelectionListener listSelectionListener;

    public CompetitorListPanel() {
        viewDetailsButton = new JButton("View Details");
        competitorList = new JList<>();

        JScrollPane scrollPane = new JScrollPane(competitorList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1100, 400));

        add(viewDetailsButton);
        add(scrollPane);

        competitorList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && listSelectionListener != null) {
                listSelectionListener.valueChanged(e);
            }
        });
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

    public void setListSelectionListener(ListSelectionListener listener) {
        this.listSelectionListener = listener;
    }

    public int getSelectedCompetitorIndex() {
        return competitorList.getSelectedIndex();
    }
}