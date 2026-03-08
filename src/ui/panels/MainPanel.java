package ui.panels;

import services.CreateButtonListener;
import services.Values;
import ui.constants.ButtonConstants;
import ui.constants.WindowConstants;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainPanel extends JPanel {
    private final CardLayout cardLayout;
    private Map<ButtonConstants.ButtonType, JPanel> converterPanels;

    public MainPanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        converterPanels = new HashMap<>();

        for (ButtonConstants.ButtonType type : ButtonConstants.ButtonType.values()) {
            JPanel panel = createConverterPanel(type);
            converterPanels.put(type, panel);
            add(panel, type.name());
        }
    }

    private JPanel createConverterPanel(ButtonConstants.ButtonType type) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel(type.getLabel(), SwingConstants.CENTER);
        title.setFont(new Font(WindowConstants.Font, Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField inputField = new JTextField(15);
        JComboBox<String> unitFrom = new JComboBox<>();
        JComboBox<String> unitTo = new JComboBox<>();

        Values converter = new Values(unitFrom, unitTo);
        converter.assignValues(type);

        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(70, 130, 180));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        JLabel resultLabel = new JLabel("Result: ");

        gbc.gridx = 0; gbc.gridy = 0;
        centerPanel.add(new JLabel("Enter value:"), gbc);
        gbc.gridx = 1;
        centerPanel.add(inputField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        centerPanel.add(new JLabel("From:"), gbc);
        gbc.gridx = 1;
        centerPanel.add(unitFrom, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        centerPanel.add(new JLabel("To:"), gbc);
        gbc.gridx = 1;
        centerPanel.add(unitTo, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        centerPanel.add(convertButton, gbc);

        gbc.gridy = 4;
        centerPanel.add(resultLabel, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

        convertButton.addActionListener(e -> {
            try {
                double value = Double.parseDouble(inputField.getText());
                double result = CreateButtonListener.convert(
                        type,
                        value,
                        (String) unitFrom.getSelectedItem(),
                        (String) unitTo.getSelectedItem()
                );
                resultLabel.setText("Result: " + String.format("%.4f", result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number");
            }
        });

        return panel;
    }

    public void showConverter(ButtonConstants.ButtonType type) {
        cardLayout.show(this, type.name());
    }
}