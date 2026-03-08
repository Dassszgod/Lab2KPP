package ui.constants;

public class ButtonConstants {
    public enum ButtonType {
        TIME("Time"),
        MASS("Mass"),
        SPEED("Speed"),
        LENGTH("Length"),
        TEMPERATURE("Temperature"),
        ENERGY("Energy"),
        VOLUME("Volume"),
        AREA("Area"),
        PRESSURE("Pressure");

        private final String label;

        ButtonType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}