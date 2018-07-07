package app.animals;

public class Cat extends Animal {

    private int intelligenceCoefficient;

    public Cat(String name, int age, String adoptionCenterName, int intelligenceCoefficient) {
        super(name, age, adoptionCenterName);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public int getIntelligenceCoefficient() {
        return this.intelligenceCoefficient;
    }

    public void setIntelligenceCoefficient(int intelligenceCoefficient) {
        this.intelligenceCoefficient = intelligenceCoefficient;
    }
}
