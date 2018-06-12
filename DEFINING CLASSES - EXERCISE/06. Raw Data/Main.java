import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int countOfVehicles = Integer.parseInt(input.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < countOfVehicles; i++) {
            String[] carInfo = input.readLine().split("\\s+");
            addCar(cars, carInfo);
        }
        String type = input.readLine();
        printType(cars, type);
    }

    private static void printType(List<Car> cars, String type) {
        switch (type) {
            case "fragile":
                cars.stream().filter(x -> x.getCargoType().equals(type) &&
                        Arrays.stream(x.getTyres()).anyMatch(z -> z.getPressure() < 1))
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream().filter(x -> x.getEnginePower() > 250)
                        .forEach(System.out::println);
                break;
        }
    }

    private static void addCar(List<Car> cars, String[] carInfo) {
        String carName = carInfo[0];
        int engineSpeed = Integer.parseInt(carInfo[1]);
        int enginePower = Integer.parseInt(carInfo[2]);
        int cargoWeight = Integer.parseInt(carInfo[3]);
        String cargoType = carInfo[4];
        double tyre1Pressure = Double.parseDouble(carInfo[5]);
        int tyre1Age = Integer.parseInt(carInfo[6]);
        double tyre2Pressure = Double.parseDouble(carInfo[7]);
        int tyre2Age = Integer.parseInt(carInfo[8]);
        double tyre3Pressure = Double.parseDouble(carInfo[9]);
        int tyre3Age = Integer.parseInt(carInfo[10]);
        double tyre4Pressure = Double.parseDouble(carInfo[11]);
        int tyre4Age = Integer.parseInt(carInfo[12]);
        Tyre[] tyres = new Tyre[4];
        tyres[0] = new Tyre(tyre1Pressure, tyre1Age);
        tyres[1] = new Tyre(tyre2Pressure, tyre2Age);
        tyres[2] = new Tyre(tyre3Pressure, tyre3Age);
        tyres[3] = new Tyre(tyre4Pressure, tyre4Age);
        Car car = new Car(carName, engineSpeed, enginePower, cargoWeight, cargoType, tyres);
        cars.add(car);
    }
}
