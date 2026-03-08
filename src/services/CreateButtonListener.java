package services;

import ui.constants.ButtonConstants;

public class CreateButtonListener {
    public static double convert(ButtonConstants.ButtonType type, double value, String fromUnit, String toUnit) {
        if (fromUnit.equals(toUnit)) return value;

        switch (type) {
            case TIME:
                if (fromUnit.equals("Hours") && toUnit.equals("Minutes")) return value * 60;
                if (fromUnit.equals("Minutes") && toUnit.equals("Hours")) return value / 60;
                if (fromUnit.equals("Seconds") && toUnit.equals("Minutes")) return value / 60;
                if (fromUnit.equals("Minutes") && toUnit.equals("Seconds")) return value * 60;
                if (fromUnit.equals("Hours") && toUnit.equals("Seconds")) return value * 3600;
                if (fromUnit.equals("Seconds") && toUnit.equals("Hours")) return value / 3600;
                break;

            case MASS:
                if (fromUnit.equals("Kg") && toUnit.equals("Gram")) return value * 1000;
                if (fromUnit.equals("Gram") && toUnit.equals("Kg")) return value / 1000;
                break;

            case SPEED:
                if (fromUnit.equals("m/s") && toUnit.equals("km/h")) return value * 3.6;
                if (fromUnit.equals("km/h") && toUnit.equals("m/s")) return value / 3.6;
                break;

            case LENGTH:
                if (fromUnit.equals("m") && toUnit.equals("cm")) return value * 100;
                if (fromUnit.equals("cm") && toUnit.equals("m")) return value / 100;
                break;

            case TEMPERATURE:
                if (fromUnit.equals("C") && toUnit.equals("K")) return value + 273.15;
                if (fromUnit.equals("K") && toUnit.equals("C")) return value - 273.15;
                if (fromUnit.equals("C") && toUnit.equals("F")) return value * 9 / 5 + 32;
                if (fromUnit.equals("F") && toUnit.equals("C")) return (value - 32) * 5 / 9;
                if (fromUnit.equals("K") && toUnit.equals("F")) return (value - 273.15) * 9 / 5 + 32;
                if (fromUnit.equals("F") && toUnit.equals("K")) return (value - 32) * 5 / 9 + 273.15;
                break;

            case AREA:
                if (fromUnit.equals("m2") && toUnit.equals("cm2")) return value * 10000;
                if (fromUnit.equals("cm2") && toUnit.equals("m2")) return value / 10000;
                break;

            case VOLUME:
                if (fromUnit.equals("L") && toUnit.equals("ml")) return value * 1000;
                if (fromUnit.equals("ml") && toUnit.equals("L")) return value / 1000;
                break;

            case PRESSURE:
                if (fromUnit.equals("kPa") && toUnit.equals("Pa")) return value * 1000;
                if (fromUnit.equals("Pa") && toUnit.equals("kPa")) return value / 1000;
                break;

            case ENERGY:
                if (fromUnit.equals("kJ") && toUnit.equals("J")) return value * 1000;
                if (fromUnit.equals("J") && toUnit.equals("kJ")) return value / 1000;
                break;

            default:
                return value;
        }
        return value;
    }
}