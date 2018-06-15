import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleInfo = input.readLine().split(";");
        String[] productsInfo = input.readLine().split(";");

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        if (!addPeople(peopleInfo, people)) {
            return;
        }

        if (!addProducts(productsInfo, products)) {
            return;
        }

        String line;
        while (!"END".equals(line = input.readLine())) {
            String[] lineInfo = line.split("\\s+");
            String personName = lineInfo[0];
            String productName = lineInfo[1];

            try {
                System.out.println(makePurchase(people, products, personName, productName));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        printPeople(people);
    }

    private static void printPeople(List<Person> people) {
        people.forEach(p -> {
            String products = String.join(", ", new ArrayList<>(p.getProducts().stream().map(Product::getName)
                    .collect(Collectors.toList())));
            System.out.println(String.format("%s - %s", p.getName(), products.equals("") ? "Nothing bought" : products));
        });
    }

    private static String makePurchase(List<Person> people, List<Product> products, String personName, String productName) {
        Person person = people.stream().filter(p -> p.getName().equals(personName)).findFirst().get();
        Product product = products.stream().filter(p -> p.getName().equals(productName)).findFirst().get();

        person.addProduct(product);

        return personName + " bought " + productName;
    }

    private static boolean addPeople(String[] peopleInfo, List<Person> people) {
        for (String person : peopleInfo) {
            String[] personInfo = person.split("=");
            String personName = personInfo[0];
            double personMoney = Double.parseDouble(personInfo[1]);
            try {
                Person personObject = new Person(personName, personMoney);
                people.add(personObject);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        return true;
    }

    private static boolean addProducts(String[] productsInfo, List<Product> products) {
        for (String product : productsInfo) {
            String[] productInfo = product.split("=");
            String productName = productInfo[0];
            double productCost = Double.parseDouble(productInfo[1]);
            try {
                Product productObject = new Product(productName, productCost);
                products.add(productObject);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        return true;
    }
}