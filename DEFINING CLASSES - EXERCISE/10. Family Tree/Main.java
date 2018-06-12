import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String searchedPersonInfo = input.readLine();
        Person person = createSearchedPerson(searchedPersonInfo);
        List<Person> tree = new ArrayList<>() {{
            add(person);
        }};

        String line;
        while (!"End".equals(line = input.readLine())) {
            parseCommand(tree, line);
        }

        printPerson(tree, searchedPersonInfo);
    }

    private static void printPerson(List<Person> tree, String personInfo) {
        if (!personInfo.contains("/")) {
            Person person = tree.stream().filter(x -> x.getName().equals(personInfo)).findFirst().get();
            System.out.println(person);
        } else {
            Person person = tree.stream().filter(x -> x.getBirthDate().equals(personInfo)).findFirst().get();
            System.out.println(person);
        }
    }

    private static void parseCommand(List<Person> tree, String command) {
        if (!command.contains("-")) {
            setPerson(tree, command);
        } else {
            String[] commandInfo = command.split("\\s*-\\s");
            executeCommand(tree, commandInfo);
        }
    }

    private static void executeCommand(List<Person> tree, String[] commandInfo) {
        if (!commandInfo[0].contains("/") && !commandInfo[1].contains("/")) { // 0 - name | 1 - name
            String parentName = commandInfo[0];
            String childName = commandInfo[1];
            Person parent = tree.stream().filter(p -> p.getName().equals(parentName)).findFirst().orElse(null);
            Person child = tree.stream().filter(c -> c.getName().equals(childName)).findFirst().orElse(null);
            if (parent == null) {
                parent = new Person();
                parent.setName(parentName);
                tree.add(parent);
            }
            if (child == null) {
                child = new Person();
                child.setName(childName);
                tree.add(child);
            }
            parent.getChildren().add(child);
            child.getParents().add(parent);
        } else if (!commandInfo[0].contains("/") && commandInfo[1].contains("/")) { // 0 name | 1 date
            String parentName = commandInfo[0];
            String childDate = commandInfo[1];
            Person parent = tree.stream().filter(p -> p.getName().equals(parentName)).findFirst().orElse(null);
            Person child = tree.stream().filter(c -> c.getBirthDate().equals(childDate)).findFirst().orElse(null);
            if (parent == null) {
                parent = new Person();
                parent.setName(parentName);
                tree.add(parent);
            }
            if (child == null) {
                child = new Person();
                child.setBirthDate(childDate);
                tree.add(child);
            }
            parent.getChildren().add(child);
            child.getParents().add(parent);
        } else if (commandInfo[0].contains("/") && !commandInfo[1].contains("/")) { // 0 date | 1 name
            String parentDate = commandInfo[0];
            String childName = commandInfo[1];
            Person parent = tree.stream().filter(p -> p.getBirthDate().equals(parentDate)).findFirst().orElse(null);
            Person child = tree.stream().filter(c -> c.getName().equals(childName)).findFirst().orElse(null);
            if (parent == null) {
                parent = new Person();
                parent.setBirthDate(parentDate);
                tree.add(parent);
            }
            if (child == null) {
                child = new Person();
                child.setName(childName);
                tree.add(child);
            }
            parent.getChildren().add(child);
            child.getParents().add(parent);
        } else { // 0 date | 1 date
            String parentDate = commandInfo[0];
            String childDate = commandInfo[1];
            Person parent = tree.stream().filter(p -> p.getBirthDate().equals(parentDate)).findFirst().orElse(null);
            Person child = tree.stream().filter(c -> c.getBirthDate().equals(childDate)).findFirst().orElse(null);
            if (parent == null) {
                parent = new Person();
                parent.setBirthDate(parentDate);
                tree.add(parent);
            }
            if (child == null) {
                child = new Person();
                child.setBirthDate(childDate);
                tree.add(child);
            }
            parent.getChildren().add(child);
            child.getParents().add(parent);
        }
    }

    private static void setPerson(List<Person> tree, String command) {
        String[] commandInfo = command.split("\\s+");
        String name = commandInfo[0] + " " + commandInfo[1];
        String birthDate = commandInfo[2];


        Person p1 = tree.stream().filter(x -> x.getName().equals(name) && x.getBirthDate().equals("")).findFirst().orElse(null);
        Person p2 = tree.stream().filter(x -> x.getBirthDate().equals(birthDate) && x.getName().equals("")).findFirst().orElse(null);

        if (p1 != null && p2 != null) {
            p1.setName(name);
            p1.setBirthDate(birthDate);
            p2.setName(name);
            p2.setBirthDate(birthDate);

            List<Person> p1Parents = new ArrayList<>(p1.getParents());
            List<Person> p1Children = new ArrayList<>(p1.getChildren());

            p1.getChildren().addAll(p2.getChildren());
            p1.getParents().addAll(p2.getParents());

            p2.getParents().addAll(p1Parents);
            p2.getChildren().addAll(p1Children);
        }


        Person person = tree.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);

        if (person == null) {

            person = tree.stream().filter(x -> x.getBirthDate().equals(birthDate)).findFirst().orElse(null);
            person.setName(name);
            Person sameNamePerson = tree
                    .stream()
                    .filter(x -> x.getName().equals(name) && x.getBirthDate().equals(""))
                    .findFirst()
                    .orElse(null);
            if (sameNamePerson != null && sameNamePerson != person) {
                person.getChildren().addAll(sameNamePerson.getChildren());
                person.getParents().addAll(sameNamePerson.getParents());
                tree.remove(sameNamePerson);
            }
        } else {

            Person sameDatePerson = tree
                    .stream()
                    .filter(x -> x.getBirthDate().equals(birthDate) && x.getName().equals(""))
                    .findFirst()
                    .orElse(null);
            if (sameDatePerson != null && sameDatePerson != person) {
                person.getChildren().addAll(sameDatePerson.getChildren());
                person.getParents().addAll(sameDatePerson.getParents());
                tree.remove(sameDatePerson);
            }
            person.setName(name);
            person.setBirthDate(birthDate);

        }
    }

    private static Person createSearchedPerson(String info) {
        if (info.contains("/")) {
            Person person = new Person();
            person.setBirthDate(info);
            return person;
        }

        Person person = new Person();
        person.setName(info);

        return person;
    }
}
