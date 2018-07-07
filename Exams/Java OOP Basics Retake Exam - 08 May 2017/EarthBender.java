public class EarthBender extends Bender {

    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    public double getGroundSaturation() {
        return this.groundSaturation;
    }

    public void setGroundSaturation(double groundSaturation) {
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return this.getPower() * this.getGroundSaturation();
    }

    @Override
    public String toString() {
        return String.format("Earth Bender: %s, Power: %d, Ground Saturation: %.2f",
                 this.getName(), this.getPower(), this.getGroundSaturation());
    }
}
