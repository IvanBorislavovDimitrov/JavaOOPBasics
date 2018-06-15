public class Chicken {

    private String name;
    private int age;

    Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private double productPerDay() {
        return this.getAge() < 6 ? 2 : this.getAge() < 12 ? 1 : 0.75;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %d eggs per day.", this.getName(), this.age, (int)this.productPerDay());
    }
}
