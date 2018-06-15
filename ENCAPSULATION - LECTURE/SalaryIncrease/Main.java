import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        int peopleCount = Integer.parseInt(input.readLine());
        for (int i = 0; i < peopleCount; i++) {
            String[] personInfo = input.readLine().split("\\s+");
            String firstName = personInfo[0];
            String lastName = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            double salary = Double.parseDouble(personInfo[3]);
            people.add(new Person(firstName, lastName, age, salary));
        }

        double bonus = Double.parseDouble(input.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }


}