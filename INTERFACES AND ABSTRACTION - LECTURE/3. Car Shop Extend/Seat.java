public class Seat implements Sellable {

    private String countryProduced;
    private String model;
    private String color;
    private Integer horsePower;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.getModel(), this.getCountryProduced(), Car.TIRES);
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
