public class Audi implements Rentable {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Integer minRentDay;
    private Double pricePerDay;
    private Double price;

    public Audi(String model, String color, Integer horsePower, String countryProduced, int minRentDay, Double price) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.minRentDay = minRentDay;
        this.horsePower = horsePower;
        this.price = price;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
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
        return this.horsePower;
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

    public String getCountryProduced() {
        return this.countryProduced;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    public void setMinRentDay(Integer minRentDay) {
        this.minRentDay = minRentDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.getModel(), this.getCountryProduced(), Car.TIRES);
    }


}
