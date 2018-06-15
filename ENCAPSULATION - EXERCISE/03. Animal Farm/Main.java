import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String name = input.readLine();
        int age = Integer.parseInt(input.readLine());

        try {
            System.out.println(new Chicken(name, age));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}