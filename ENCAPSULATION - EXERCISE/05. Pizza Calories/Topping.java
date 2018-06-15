public class Topping {

    private static final String AVAILABLE_TOPPINGS = "Meat Veggies Cheese Sauce";
    private static final double MEAT_CALORIES = 1.2;
    private static final double VEGGIES_CALORIES = 0.8;
    private static final double CHEESE_CALORIES = 1.1;
    private static final double SAUCE_CALORIES = 0.9;
    private static final double INITIAL_WEIGHT = 2;

    private String name;
    private int weight;

    public Topping(String name, int weight) {
        this.setName(name);
        this.setWeight(weight);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (!AVAILABLE_TOPPINGS.contains(name)) {
            String exc = String.format("Cannot place %s on top of your pizza.", name);
            throw new IllegalArgumentException(exc);
        }
        this.name = name;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            String exc = String.format("%s weight should be in the range [1..50].", this.getName());
            throw new IllegalArgumentException(exc);
        }
        this.weight = weight;
    }

    public double getCalories() {
        switch (this.getName()) {
            case "Meat":
                return MEAT_CALORIES * (this.getWeight() * INITIAL_WEIGHT);
            case "Veggies":
                return VEGGIES_CALORIES * (this.getWeight() * INITIAL_WEIGHT);
            case "Cheese":
                return CHEESE_CALORIES * (this.getWeight() * INITIAL_WEIGHT);
            case "Sauce":
                return SAUCE_CALORIES * (this.getWeight() * INITIAL_WEIGHT);
        }

        return -1;
    }
}
