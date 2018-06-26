public class European implements Person {

    private static final String HELLO_MESSAGE = "Hello";

    private String name;

    public European() {
    }

    public European(String name) {
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
