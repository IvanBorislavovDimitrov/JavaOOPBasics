import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final DecimalFormat format = new DecimalFormat("####.##");

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = input.readLine().split("\\s+");
        String[] truckInfo = input.readLine().split("\\s+");
        double carLitres = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);
        double truckLitres = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);

        Vehicle car = new Car(carLitres, carFuelConsumption);
        Vehicle truck = new Truck(truckLitres, truckFuelConsumption);

        int commandsCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandInfo = input.readLine().split("\\s+");
            String commandLog = null;
            try {
                commandLog = executeCommand(car, truck, commandInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (commandLog != null) {
                System.out.println(commandLog);
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static String executeCommand(Vehicle car, Vehicle truck, String[] commandInfo) {
        String command = commandInfo[0];
        String vehicleType = commandInfo[1];
        switch (command) {
            case "Drive":
                double distance = Double.parseDouble(commandInfo[2]);
                drive(car, truck, vehicleType, distance);
                return String.format("%s travelled %s km", vehicleType, format.format(distance));
            case "Refuel":
                double litres = Double.parseDouble(commandInfo[2]);
                refuel(car, truck, vehicleType, litres);
        }

        return null;
    }

    private static void refuel(Vehicle car, Vehicle truck, String vehicleType, double liters) {
        switch (vehicleType) {
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
        }
    }

    private static void drive(Vehicle car, Vehicle truck, String vehicleType, double distance) {
        switch (vehicleType) {
            case "Car":
                car.drive(distance);
                break;
            case "Truck":
                truck.drive(distance);
                break;
        }
    }
}
