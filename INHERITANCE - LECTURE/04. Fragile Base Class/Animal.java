import java.util.ArrayList;

public class Animal {

    protected ArrayList<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        for (Food food : foods) {
            eat(food);
        }
    }
}
