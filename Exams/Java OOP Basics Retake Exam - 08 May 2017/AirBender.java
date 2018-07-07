public class AirBender extends Bender {

    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    public double getAerialIntegrity() {
        return this.aerialIntegrity;
    }

    public void setAerialIntegrity(double aerialIntegrity) {
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return this.getPower() * this.getAerialIntegrity();
    }

    @Override
    public String toString() {
        return String.format("Air Bender: %s, Power: %d, Aerial Integrity: %.2f",
                this.getName(), this.getPower(), this.getAerialIntegrity());
    }
}
