public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getBrand()).append(" ").append(this.getModel()).append(" ")
                .append(this.getYearOfProduction()).append(System.lineSeparator());
        sb.append(String.format("%d HP, 100 m/h in %d s", this.getHorsePower(), this.getAcceleration()))
                .append(System.lineSeparator());
        sb.append(String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability()));

        return sb.toString();
    }
}
