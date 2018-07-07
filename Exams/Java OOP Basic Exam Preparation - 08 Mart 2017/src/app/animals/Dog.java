package app.animals;

public class Dog extends Animal {

    private int learntCommands;

    public Dog(String name, int age, String adoptionCenterName, int learntCommands) {
        super(name, age, adoptionCenterName);
        this.learntCommands = learntCommands;
    }

    public int getLearntCommands() {
        return this.learntCommands;
    }

    public void setLearntCommands(int learntCommands) {
        this.learntCommands = learntCommands;
    }
}
