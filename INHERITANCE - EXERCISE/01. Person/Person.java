public class Person {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "Name's length should not be less than 3 symbols!";
    private static final String AGE_MUST_BE_POSITIVE_EXCEPTION_MESSAGE = "Age must be positive!";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException(AGE_MUST_BE_POSITIVE_EXCEPTION_MESSAGE);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
    }
}
