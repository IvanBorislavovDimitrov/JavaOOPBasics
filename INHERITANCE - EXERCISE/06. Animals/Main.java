import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"Beast!".equals(line = input.readLine())) {
            String[] animalInfo = input.readLine().split("\\s+");
            try {
                addAnimal(animalInfo, line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void addAnimal(String[] animalInfo, String type) throws Exception {
        String name = animalInfo[0];
        int age = Integer.parseInt(animalInfo[1]);
        String gender = animalInfo[2];

        switch (type) {
            case "Cat":
                Animal cat = new Cat(name, age, gender);
                System.out.println(cat);
                break;
            case "Dog":
                Animal dog = new Dog(name, age, gender);
                System.out.println(dog);
                break;
            case "Frog":
                Animal frog = new Frog(name, age, gender);
                System.out.println(frog);
                break;
            case "Kitten":
                Animal kitten = new Kitten(name, age, gender);
                System.out.println(kitten);
                break;
            case "Tomcat":
                Animal tomcat = new Tomcat(name, age, gender);
                System.out.println(tomcat);
                break;
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }
}
