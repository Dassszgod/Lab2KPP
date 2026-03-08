package services;

import ui.constants.ButtonConstants;
import javax.swing.JComboBox;

public class Values {
    private JComboBox<String> unitFrom;
    private JComboBox<String> unitTo;

    public Values(JComboBox<String> unitFrom, JComboBox<String> unitTo) {
        this.unitFrom = unitFrom;
        this.unitTo = unitTo;
    }

    public void assignValues(ButtonConstants.ButtonType type) {
        String[] units;
        switch (type) {
            case TIME -> units = new String[]{"Seconds", "Minutes", "Hours"};
            case MASS -> units = new String[]{"Gram", "Kg"};
            case SPEED -> units = new String[]{"m/s", "km/h"};
            case LENGTH -> units = new String[]{"cm", "m"};
            case TEMPERATURE -> units = new String[]{"C", "F", "K"};
            case ENERGY -> units = new String[]{"J", "kJ"};
            case VOLUME -> units = new String[]{"ml", "L"};
            case AREA -> units = new String[]{"cm2", "m2"};
            case PRESSURE -> units = new String[]{"Pa", "kPa"};
            default -> units = new String[]{"Unit1", "Unit2"};
        }

        unitFrom.removeAllItems();
        unitTo.removeAllItems();
        for (String unit : units) {
            unitFrom.addItem(unit);
            unitTo.addItem(unit);
        }
    }
}