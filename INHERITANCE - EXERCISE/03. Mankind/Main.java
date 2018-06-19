import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] studentInfo = input.readLine().split("\\s+");
        String[] workerInfo = input.readLine().split("\\s+");

        String studentFirstName = studentInfo[0];
        String studentLastName = studentInfo[1];
        String studentFacultyNumber = studentInfo[2];

        String workerFirstName = workerInfo[0];
        String workerLastName = workerInfo[1];
        double workerWeekSalary = Double.parseDouble(workerInfo[2]);
        double workerWorkingHoursPerDay = Double.parseDouble(workerInfo[3]);

        try {
            Student student = new Student(studentFirstName, studentLastName, studentFacultyNumber);
            Worker worker = new Worker(workerFirstName, workerLastName, workerWeekSalary, workerWorkingHoursPerDay);

            System.out.println(student);
            System.out.println(worker);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }



    }
}
