package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CompetitorListGUI extends JPanel {
    private JButton viewDetailsButton;

    public CompetitorListGUI() {
        // Initialize components, set layout, etc.
        viewDetailsButton = new JButton("View Details");
        add(viewDetailsButton);
    }

    public void viewDetailsButton(ActionListener actionListener) {
        viewDetailsButton.addActionListener(actionListener);
    }
}