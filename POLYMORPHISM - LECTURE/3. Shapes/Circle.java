public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.radius * 2 * Math.PI);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.radius * this.radius * Math.PI);
    }
}
