import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Animal> animals = new ArrayList<>();
        while (!"End".equals(line = input.readLine())) {
            String[] mammalInfo = line.split("\\s+");
            String[] foodInfo = input.readLine().split("\\s+");
            String bio = feedAnimal(mammalInfo, foodInfo, animals);
            System.out.println(bio);
        }

        printAnimals(animals);
    }

    private static String feedAnimal(String[] mammalInfo, String[] foodInfo, List<Animal> animals) {
        String animalType = mammalInfo[0];
        String animalName = mammalInfo[1];
        double animalWeight = Double.parseDouble(mammalInfo[2]);
        String livingRegion = mammalInfo[3];
        String foodName = foodInfo[0];
        int foodQuantity = Integer.parseInt(foodInfo[1]);
        Food food = createFood(foodName, foodQuantity);
        switch (animalType) {
            case "Cat":
                String breed = mammalInfo[4];
                Cat cat = new Cat(breed);
                return createMammalInfo(animalName, animalType, animalWeight, livingRegion, cat, food, animals);
            case "Tiger":
                return createMammalInfo(animalName, animalType, animalWeight, livingRegion, new Tiger(), food, animals);
            case "Zebra":
                return createMammalInfo(animalName, animalType, animalWeight, livingRegion, new Zebra(), food, animals);
            case "Mouse":
                return createMammalInfo(animalName, animalType, animalWeight, livingRegion, new Mouse(), food, animals);
        }

        return null;
    }

    private static void printAnimals(List<Animal> animals) {
        animals.forEach(System.out::println);
    }

    private static String createMammalInfo(String animalName, String animalType,
                                           double animalWeight, String livingRegion, Mammal mammal, Food food, List<Animal> animals) {
        StringBuilder sb = new StringBuilder();
        mammal.setAnimalName(animalName);
        mammal.setAnimalType(animalType);
        mammal.setLivingRegion(livingRegion);
        mammal.setAnimalWeight(animalWeight);
        sb.append(mammal.makeSound()).append(System.lineSeparator());
        try {
            mammal.eat(food);
        } catch (IllegalArgumentException e) {
            sb.append(e.getMessage()).append(System.lineSeparator());
        }
        animals.add(mammal);
        return sb.toString().trim();
    }

    private static Food createFood(String foodName, int quantity) {
        switch (foodName) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
        }

        return null;
    }
}
