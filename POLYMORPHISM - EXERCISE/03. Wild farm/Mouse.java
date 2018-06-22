public class Mouse extends Mammal {

    private static final String SOUND = "SQUEEEAAAK!";
    private static final String INVALID_FOOD = "Mice are not eating that type of food!";

    public Mouse() {
    }

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public Mouse(String livingRegion) {
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
