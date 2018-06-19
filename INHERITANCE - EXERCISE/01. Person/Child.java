public class Child extends Person {

    private static final String AGE_MUST_BE_LESS_THAN_FIFTEEN_EXCEPTION_MESSAGE = "Child's age must be lesser than 15!";

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public void setAge(int age) {
         if (age > 15) {
            throw new IllegalArgumentException(AGE_MUST_BE_LESS_THAN_FIFTEEN_EXCEPTION_MESSAGE);
        }

        super.setAge(age);
    }
}
