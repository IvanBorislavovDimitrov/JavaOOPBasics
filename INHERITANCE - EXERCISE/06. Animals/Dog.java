public class Dog extends Animal {

    private static final String SOUND_MESSAGE = "BauBau";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND_MESSAGE;
    }
}
