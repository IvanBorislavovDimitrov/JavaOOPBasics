import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private Topping[] toppings;
    private int toppingsIndex = 0;

    public Pizza(String name, int toppingsNumber) {
        this(name, null, new Topping[toppingsNumber]);
    }

    private Pizza(String name, Dough dough, Topping[] toppings) {
        this.setName(name);
        this.setDough(dough);
        this.setToppings(toppings);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public Dough getDough() {
        return this.dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Topping[] getToppings() {
        return this.toppings;
    }

    public void setToppings(Topping[] toppings) {
        if (toppings.length > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        this.toppings[this.toppingsIndex++] = topping;
    }

    public double calories() {
        double total = this.getDough().getTotalCalories();
        for (Topping topping : this.toppings) {
            if (topping != null) {
                total += topping.getCalories();
            }
        }

        return total;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.calories());
    }
}
