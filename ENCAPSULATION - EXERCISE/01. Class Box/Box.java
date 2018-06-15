public class Box {

    private double length;
    private double width;
    private double height;

    public Box() {
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double surfaceArea() {
        return 2 * this.length * this.width + 2 * this.width * this.height + 2 * this.length * this.height;
    }

    public double lateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double volume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.length, this.width, this.height);
    }
}
