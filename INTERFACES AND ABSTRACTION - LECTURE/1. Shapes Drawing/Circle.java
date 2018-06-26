public class Circle implements Drawable {

    private double radius;

    public Circle() {
    }

    public Circle(double radius, double r1, double r2) {
        this.radius = radius;
    }


    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        double rIn = this.getRadius() - 0.4;
        double rOut = this.getRadius() + 0.4;

        for (double y = this.getRadius(); y >= -this.getRadius(); y--) {
            for (double x = -this.getRadius(); x < rOut; x += 0.5) {
                double value = x * x + y * y;
                if (value >= rIn * rIn && value <= rOut * rOut) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
