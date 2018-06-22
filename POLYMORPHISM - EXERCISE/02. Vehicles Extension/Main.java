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
        String[] busInfo = input.readLine().split("\\s+");
        double carLitres = Double.parseDouble(carInfo[1]);
        double carFuelConsumption = Double.parseDouble(carInfo[2]);
        double carTank = Double.parseDouble(carInfo[3]);

        double truckLitres = Double.parseDouble(truckInfo[1]);
        double truckFuelConsumption = Double.parseDouble(truckInfo[2]);
        double truckTank = Double.parseDouble(truckInfo[3]);

        double busLitres = Double.parseDouble(busInfo[1]);
        double busFuelConsumption = Double.parseDouble(busInfo[2]);
        double buskTank = Double.parseDouble(busInfo[3]);

        Vehicle car = new Car(carLitres, carFuelConsumption, carTank);
        Vehicle truck = new Truck(truckLitres, truckFuelConsumption, truckTank);
        BusVehicle bus = new Bus(busLitres, busFuelConsumption, buskTank);

        int commandsCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandInfo = input.readLine().split("\\s+");
            String commandLog = null;
            try {
                commandLog = executeCommand(car, truck, bus, commandInfo);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (commandLog != null) {
                System.out.println(commandLog);
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static String executeCommand(Vehicle car, Vehicle truck, BusVehicle bus, String[] commandInfo) {
        String command = commandInfo[0];
        String vehicleType = commandInfo[1];
        switch (command) {
            case "Drive":
                double distance = Double.parseDouble(commandInfo[2]);
                drive(car, truck, bus, vehicleType, distance);
                return String.format("%s travelled %s km", vehicleType, format.format(distance));
            case "Refuel":
                double litres = Double.parseDouble(commandInfo[2]);
                refuel(car, truck, bus, vehicleType, litres);
                return null;
            case "DriveEmpty":
                distance = Double.parseDouble(commandInfo[2]);
                driveBusEmpty(bus, distance);
                return String.format("%s travelled %s km", vehicleType, format.format(distance));
        }

        return null;
    }

    private static void driveBusEmpty(BusVehicle bus, double liters) {
        bus.driveEmpty(liters);
    }

    private static void refuel(Vehicle car, Vehicle truck, BusVehicle bus, String vehicleType, double liters) {
        switch (vehicleType) {
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
            case "Bus":
                bus.refuel(liters);
                break;
        }
    }

    private static void drive(Vehicle car, Vehicle truck, BusVehicle bus, String vehicleType, double distance) {
        switch (vehicleType) {
            case "Car":
                car.drive(distance);
                break;
            case "Truck":
                truck.drive(distance);
                break;
            case "Bus":
                bus.drive(distance);
                break;
        }
    }
}
