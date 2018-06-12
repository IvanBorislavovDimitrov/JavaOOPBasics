public class Car {

    private String name;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private Tyre[] tyres;

    public Car() {
    }

    public Car(String name, int engineSpeed, int enginePower, int cargoWeight, String cargoType, Tyre[] tyres) {
        this.name = name;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tyres = tyres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public Tyre[] getTyres() {
        return tyres;
    }

    public void setTyres(Tyre[] tyres) {
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
