public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostForKilometer;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostForKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKilometer = fuelCostForKilometer;
    }

    public void drive(int kilometres) {
        double neededFuel = kilometres * this.getFuelCostForKilometer();

        this.setFuelAmount(this.getFuelAmount() - neededFuel);
        this.setDistanceTravelled(this.getDistanceTravelled() + kilometres);
    }

    public boolean isThereEnoughFuelToRun(int kilometres) {
        return this.kilometresLeft() >= kilometres;
    }

    public double kilometresLeft() {
        return this.getFuelAmount() / this.getFuelCostForKilometer();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostForKilometer() {
        return fuelCostForKilometer;
    }

    public void setFuelCostForKilometer(double fuelCostForKilometer) {
        this.fuelCostForKilometer = fuelCostForKilometer;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getModel(), this.getFuelAmount(), this.getDistanceTravelled());
    }
}
