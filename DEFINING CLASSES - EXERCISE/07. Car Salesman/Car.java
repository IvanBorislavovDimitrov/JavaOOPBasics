public class Car {

    private String model;
    private Engine engine;
    private Integer weight;
    private String colour;

    public Car() {
    }

    public Car(String model, Engine engine, Integer weight, String colour) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        String carName = this.getModel();
        String engineName = this.getEngine().getModel();
        int enginePower = this.getEngine().getPower();
        Integer displacement = this.getEngine().getDisplacement();
        String efficiency = this.getEngine().getEfficiency();
        Integer carWeight = this.getWeight();
        String colour = this.getColour();

        return String.format("%s:\n" +
                "  %s:\n" +
                "    Power: %d\n" +
                "    Displacement: %s\n" +
                "    Efficiency: %s\n" +
                "  Weight: %s\n" +
                "  Color: %s", carName, engineName, enginePower, displacement == null ? "n/a" : displacement
                , efficiency == null ? "n/a" : efficiency, carWeight == null ? "n/a" : carWeight, colour == null ? "n/a" : colour);

    }
}
