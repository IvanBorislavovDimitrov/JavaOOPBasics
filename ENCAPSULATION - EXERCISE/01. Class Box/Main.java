import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(input.readLine());
        double width = Double.parseDouble(input.readLine());
        double height = Double.parseDouble(input.readLine());

        Box box = new Box(length, width, height);
        System.out.println(String.format("Surface Area - %.2f", box.surfaceArea()));
        System.out.println(String.format("Lateral Surface Area - %.2f", box.lateralSurfaceArea()));
        System.out.println(String.format("Volume - %.2f", box.volume()));
    }
}