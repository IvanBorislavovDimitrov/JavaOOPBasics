
public class AirMonument extends Monument {

    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    public int getAirAffinity() {
        return this.airAffinity;
    }

    public void setAirAffinity(int airAffinity) {
        this.airAffinity = airAffinity;
    }

    @Override
    public String toString() {
        return String.format("Air Monument: %s, Air Affinity: %d",
                this.getName(), this.getAirAffinity());
    }
}
