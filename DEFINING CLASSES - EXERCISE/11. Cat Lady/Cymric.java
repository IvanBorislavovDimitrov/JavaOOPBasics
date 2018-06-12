public class Cymric extends Cat {

    private double furLength;

    public Cymric() {
        super();
    }

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", this.getName(), this.getFurLength());
    }
}
