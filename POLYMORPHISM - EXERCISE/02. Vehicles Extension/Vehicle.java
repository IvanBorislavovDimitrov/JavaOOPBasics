public abstract class Vehicle {

    protected static final String INVALID_REFUEL_MESSAGE = "Fuel must be a positive number";

    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException(INVALID_REFUEL_MESSAGE);
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionInLitersPerKm() {
        return this.fuelConsumptionInLitersPerKm;
    }

    public void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        if (tankCapacity <= 0) {
            throw new IllegalArgumentException(INVALID_REFUEL_MESSAGE);
        }
        this.tankCapacity = tankCapacity;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
