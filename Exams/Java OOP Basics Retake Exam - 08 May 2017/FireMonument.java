public class FireMonument extends Monument {

    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    public int getFireAffinity() {
        return this.fireAffinity;
    }

    public void setFireAffinity(int fireAffinity) {
        this.fireAffinity = fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("Fire Monument: %s, Fire Affinity: %d",
                this.getName(), this.getFireAffinity());
    }
}
