import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        List<Engine> engines = new ArrayList<>();
        int enginesCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < enginesCount; i++) {
            String[] engineParts = input.readLine().split("\\s+");
            addEngine(engineParts, engines);
        }
        int carsCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < carsCount; i++) {
            String[] carParts = input.readLine().split("\\s+");
            addCar(carParts, cars, engines);
        }

        printCars(cars);
    }

    private static void printCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }

    private static void addCar(String[] carParts, List<Car> cars, List<Engine> engines) {
        String carName = carParts[0];
        String carEngineName = carParts[1];
        Integer weight = null;
        String colour = null;
        if (carParts.length == 3) {
            try {
                weight = Integer.parseInt(carParts[2]);
            } catch (NumberFormatException e) {
                colour = carParts[2];
            }
        } else if (carParts.length == 4) {
            weight = Integer.parseInt(carParts[2]);
            colour = carParts[3];
        }

        Engine engine = engines.stream().filter(x -> x.getModel().equals(carEngineName)).findFirst().get();
        Car car = new Car(carName, engine, weight, colour);
        cars.add(car);
    }

    private static void addEngine(String[] engineParts, List<Engine> engines) {
        String engineName = engineParts[0];
        int enginePower = Integer.parseInt(engineParts[1]);
        Integer displacement = null;
        String efficiency = null;
        if (engineParts.length == 3) {
            try {
                displacement = Integer.parseInt(engineParts[2]);
            } catch (NumberFormatException e) {
                efficiency = engineParts[2];
            }
         } else if (engineParts.length == 4) {
            displacement = Integer.parseInt(engineParts[2]);
            efficiency = engineParts[3];
        }
        Engine engine = new Engine(engineName, enginePower, displacement, efficiency);

        engines.add(engine);
    }
}
