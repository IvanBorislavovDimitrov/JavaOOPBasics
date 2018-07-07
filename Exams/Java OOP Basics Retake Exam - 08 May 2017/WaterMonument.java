public class WaterMonument extends Monument {

    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    public int getWaterAffinity() {
        return this.waterAffinity;
    }

    public void setWaterAffinity(int waterAffinity) {
        this.waterAffinity = waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("Water Monument: %s, Water Affinity: %d",
                this.getName(), this.getWaterAffinity());
    }
}
