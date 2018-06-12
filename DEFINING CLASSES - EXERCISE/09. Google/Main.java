import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<String> commands = new ArrayList<>();
        String line;
        while (!"End".equals(line = input.readLine())) {
            commands.add(line);
        }

        String personName = input.readLine();
        Person person = createPerson(commands, personName);
        System.out.println(person);
    }

    private static Person createPerson(List<String> commands, String personName) {
        Person person = new Person(personName);
        for (String command : commands) {
            String[] commandInfo = command.split("\\s+");
            String currentCommandPersonName = commandInfo[0];
            String thing = commandInfo[1];
            if (!personName.equals(currentCommandPersonName)) {
                continue;
            }

            switch (thing) {
                case "company":
                    String companyName = commandInfo[2];
                    String department = commandInfo[3];
                    double salary = Double.parseDouble(commandInfo[4]);
                    setCompany(person, companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = commandInfo[2];
                    String pokemonType = commandInfo[3];
                    addPokemon(person, pokemonName, pokemonType);
                    break;
                case "parents":
                    String parentName = commandInfo[2];
                    String parentBirthday = commandInfo[3];
                    addParent(person, parentName, parentBirthday);
                    break;
                case "children":
                    String childName = commandInfo[2];
                    String childBirthday = commandInfo[3];
                    addChild(person, childName, childBirthday);
                    break;
                case "car":
                    String carModel = commandInfo[2];
                    int carSpeed = Integer.parseInt(commandInfo[3]);
                    setCar(person, carModel, carSpeed);
                    break;
            }
        }

        return person;
    }

    private static void setCar(Person person, String carModel, int carSpeed) {
        Car car = new Car(carModel, carSpeed);
        person.setCar(car);
    }

    private static void addChild(Person person, String childName, String childBirthday) {
        Child child = new Child(childName, childBirthday);
        person.getChildren().add(child);
    }

    private static void addParent(Person person, String parentName, String parentBirthday) {
        Parent parent = new Parent(parentName, parentBirthday);
        person.getParents().add(parent);
    }

    private static void addPokemon(Person person, String pokemonName, String pokemonType) {
        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        person.getPokemons().add(pokemon);
    }

    private static void setCompany(Person person, String companyName, String department, double salary) {
        Company company = new Company(companyName, department, salary);
        person.setCompany(company);
    }
}
