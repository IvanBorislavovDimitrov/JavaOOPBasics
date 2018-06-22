public class Cat extends Felime {

    private static final String SOUND = "Meowwww";

    private String breed;

    public Cat() {
    }

    public Cat(String breed) {
        this.breed = breed;
    }

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public Cat(String livingRegion, String breed) {
        super(livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return SOUND;
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        String animalType = this.getClass().getSimpleName();
        return String.format("%s[%s, %s, %s, %s, %d]", animalType, this.getAnimalName(), this.getBreed(),
                format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
