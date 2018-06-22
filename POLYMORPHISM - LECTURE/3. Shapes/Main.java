import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Shape circle = new Circle(5);
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

        Shape rectangle = new Rectangle(5, 10);
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}
