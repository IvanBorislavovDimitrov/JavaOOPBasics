public class Tiger extends Felime {

    private static final String SOUND = "ROAAR!!!";
    private static final String INVALID_FOOD = "Tigers are not eating that type of food!";

    public Tiger() {
    }

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public Tiger(String livingRegion) {
        super(livingRegion);
    }

    @Override
    public String makeSound() {
        return SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException(INVALID_FOOD);
        }
    }
}
