import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] food = input.readLine().split(" ");
        Gandalf gandalf = new Gandalf();
        gandalf.eatAll(food);
        System.out.println(gandalf.getPoints());
        System.out.println(gandalf.mood());
    }
}
