public abstract class BusVehicle extends Vehicle {

    public BusVehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    public abstract void driveEmpty(double distance);

}
