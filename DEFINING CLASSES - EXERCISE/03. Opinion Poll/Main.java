import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(input.readLine());
        Set<Person> people = new HashSet<>();
        for (int i = 0; i < peopleCount; i++) {
            String[] personInfo = input.readLine().split("\\s+");
            String personName = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(personName, age);
            people.add(person);
        }

        people.stream().filter(p -> p.getAge() > 30)
                .sorted()
                .forEach(System.out::println);
    }

}
