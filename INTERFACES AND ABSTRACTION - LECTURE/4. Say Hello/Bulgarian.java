public class Bulgarian implements Person {

    private static final String HELLO_MESSAGE = "Здравей";

    private String name;

    public Bulgarian() {
    }

    public Bulgarian(String name) {
        this.name = name;
    }

    public void setName(String name) {
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
