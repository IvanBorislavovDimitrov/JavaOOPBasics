public class Cat extends Animal {

    private static final String SOUND_MESSAGE = "MiauMiau";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND_MESSAGE;
    }
}
