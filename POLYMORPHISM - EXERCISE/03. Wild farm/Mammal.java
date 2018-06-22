import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected static final DecimalFormat format = new DecimalFormat("#.##");

    private String livingRegion;

    public Mammal() {
    }

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public Mammal(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        String animalType = this.getClass().getSimpleName();
        return String.format("%s[%s, %s, %s, %d]", animalType, this.getAnimalName(),
                format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
