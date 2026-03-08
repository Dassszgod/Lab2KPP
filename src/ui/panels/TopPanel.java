package ui.panels;

import ui.constants.ButtonConstants;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    public TopPanel(MainPanel mainPanel) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());

        for (ButtonConstants.ButtonType type : ButtonConstants.ButtonType.values()) {
            JButton button = new JButton(type.getLabel());
            button.addActionListener(e -> mainPanel.showConverter(type));
            add(button);
            add(Box.createRigidArea(new Dimension(10, 0)));
        }
        add(Box.createHorizontalGlue());
    }
}