public class Ferrari implements Car {

    private static final String BREAKS_MESSAGE = "Brakes!";
    private static final String GAS_PEDAL_MESSAGE = "Zadu6avam sA!";
    private static final String MODEL = "488-Spider";

    private String driverName;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String useBreaks() {
        return BREAKS_MESSAGE;
    }

    @Override
    public String pushTheGasPedal() {
        return GAS_PEDAL_MESSAGE;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.useBreaks(), this.pushTheGasPedal(), this.driverName);
    }
}
