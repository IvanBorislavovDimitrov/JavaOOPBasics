public class Zebra extends Mammal {

    private static final String SOUND = "Zs";
    private static final String INVALID_FOOD = "Zebras are not eating that type of food!";

    public Zebra() {
    }

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public Zebra(String livingRegion) {
        super(livingRegion);
    }

    @Override
    public String makeSound() {
        return SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException(INVALID_FOOD);
        }
    }
}
