import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        int countOfCars = Integer.parseInt(input.readLine());
        for (int i = 0; i < countOfCars; i++) {
            String[] carInfo = input.readLine().split("\\s+");
            addCar(cars, carInfo);
        }

        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] carInfo = line.split("\\s+");
            drive(cars, carInfo);
        }

        printCars(cars);
    }

    private static void printCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }

    private static void drive(List<Car> cars, String[] carInfo) {
        String carName = carInfo[1];
        int distance = Integer.parseInt(carInfo[2]);
        Car car = cars.stream().filter(x -> x.getModel().equals(carName)).findFirst().orElse(null);
        if (car == null) {
            return;
        }

        if (car.isThereEnoughFuelToRun(distance)) {
            car.drive(distance);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    private static void addCar(List<Car> cars, String[] carInfo) {
        String model = carInfo[0];
        double fuelAmount = Double.parseDouble(carInfo[1]);
        double fuelCostPerKilometer = Double.parseDouble(carInfo[2]);

        Car car = new Car(model, fuelAmount, fuelCostPerKilometer);

        cars.add(car);
    }
}
