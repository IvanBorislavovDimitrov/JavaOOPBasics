public class Chinese implements Person {

    private static final String HELLO_MESSAGE = "Djydjybydjy";

    private String name;

    public Chinese() {
    }

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return HELLO_MESSAGE;
    }
}
