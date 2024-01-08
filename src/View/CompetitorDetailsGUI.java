package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CompetitorDetailsGUI extends JPanel {
    private JButton backButton;

    public CompetitorDetailsGUI() {
        // Initialize components, set layout, etc.
        backButton = new JButton("Back");
        add(backButton);
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}