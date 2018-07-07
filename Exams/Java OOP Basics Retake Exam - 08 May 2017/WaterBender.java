public class WaterBender extends Bender {

    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    public double getWaterClarity() {
        return this.waterClarity;
    }

    public void setWaterClarity(double waterClarity) {
        this.waterClarity = waterClarity;
    }

    @Override
    public double getTotalPower() {
        return this.getPower() * this.getWaterClarity();
    }

    @Override
    public String toString() {
        return String.format("Water Bender: %s, Power: %d, Water Clarity: %.2f",
            this.getName(), this.getPower(), this.getWaterClarity());
    }
}
