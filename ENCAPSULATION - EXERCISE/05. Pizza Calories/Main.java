import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaInfo = input.readLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int toppingsNumber = Integer.parseInt(pizzaInfo[2]);
        String[] doughInfo = input.readLine().split("\\s+");
        String doughName = doughInfo[1];
        String doughAddition = doughInfo[2];
        int doughWeight = Integer.parseInt(doughInfo[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, toppingsNumber);
            Dough dough = new Dough(doughName, doughAddition, doughWeight);
            pizza.setDough(dough);
            String line;
            while (!"END".equals(line = input.readLine())) {
                String[] toppingInfo = line.split("\\s+");
                String toppingName = toppingInfo[1];
                int weight = Integer.parseInt(toppingInfo[2]);
                Topping topping = new Topping(toppingName, weight);
                pizza.addTopping(topping);
            }

            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}