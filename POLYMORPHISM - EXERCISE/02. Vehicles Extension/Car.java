public class Car extends Vehicle {

    private static final double INCREASED_FUEL_CONSUMPTION = 0.9;
    private static final String NOT_ENOUGH_FUEL_MESSAGE = "Car needs refueling";
    private static final String TOO_MUCH_FUEL_MESSAGE = "Cannot fit fuel in tank";

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
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
        if (liters <= 0) {
            throw new IllegalArgumentException(INVALID_REFUEL_MESSAGE);
        }
        double totalFuel = this.getFuelQuantity() + liters;
        if (totalFuel > this.getTankCapacity()) {
            throw new IllegalArgumentException(TOO_MUCH_FUEL_MESSAGE);
        }
        this.setFuelQuantity(totalFuel);
    }
}