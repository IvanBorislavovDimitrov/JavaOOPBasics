public class Car extends Vehicle {

    private static final double INCREASED_FUEL_CONSUMPTION = 0.9;
    private static final String NOT_ENOUGH_FUEL_MESSAGE = "Car needs refueling";

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    public void drive(double distance) {
        double fuelNeeded = (this.getFuelConsumptionInLitersPerKm() + INCREASED_FUEL_CONSUMPTION) * distance;
        if (fuelNeeded > this.getFuelQuantity()) {
            throw new IllegalArgumentException(NOT_ENOUGH_FUEL_MESSAGE);
        }

        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }
}
