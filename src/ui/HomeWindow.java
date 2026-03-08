package ui;

import ui.constants.WindowConstants;
import ui.panels.MainPanel;
import ui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class HomeWindow {
    public void createHomeWindowGUI() {
        JFrame frame = new JFrame(WindowConstants.FrameLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowConstants.WIDTH, WindowConstants.HEIGHT);
        frame.setLayout(new BorderLayout());

        MainPanel mainPanel = new MainPanel();
        TopPanel topPanel = new TopPanel(mainPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}