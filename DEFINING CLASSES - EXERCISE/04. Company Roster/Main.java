import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<Employee>> departments = new HashMap<>();
        int countOfEmployees = Integer.parseInt(input.readLine());

        for (int i = 0; i < countOfEmployees; i++) {
            String[] employeeInfo = input.readLine().split("\\s+");
            addEmployee(employeeInfo, departments);
        }

        printMostPopularDepartment(departments);
    }

    private static void printMostPopularDepartment(Map<String, Set<Employee>> departments) {
        Map.Entry<String, Set<Employee>> department = getMostPaidDepartment(departments);
        if (department == null) {
            throw new IllegalArgumentException("No department found!");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Highest Average Salary: ");
        sb.append(department.getKey()).append(System.lineSeparator());
        department.getValue().forEach(x -> sb.append(x).append(System.lineSeparator()));

        System.out.println(sb);
    }

    private static Map.Entry<String, Set<Employee>> getMostPaidDepartment(Map<String, Set<Employee>> departments) {
        return departments.entrySet().stream().min((d1, d2) -> {
            double d1AverageSalary = d1.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0);
            double d2AverageSalary = d2.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0);

            return Double.compare(d2AverageSalary, d1AverageSalary);
        }).orElse(null);
    }

    private static void addEmployee(String[] employeeInfo, Map<String, Set<Employee>> departments) {
        String employeeName = employeeInfo[0];
        double salary = Double.parseDouble(employeeInfo[1]);
        String position = employeeInfo[2];
        String department = employeeInfo[3];
        String email = Employee.MISSING_EMAIL;
        int age = Employee.MISSING_AGE;

        if (employeeInfo.length == 6) {
            email = employeeInfo[4];
            age = Integer.parseInt(employeeInfo[5]);
        } else if (employeeInfo.length == 5) {
            try {
                age = Integer.parseInt(employeeInfo[4]);
            } catch (NumberFormatException e) {
                email = employeeInfo[4];
            }
        }

        Employee employee = new Employee(employeeName, salary, position, department, email, age);

        departments.putIfAbsent(department, new TreeSet<>());
        departments.get(department).add(employee);
    }
}
