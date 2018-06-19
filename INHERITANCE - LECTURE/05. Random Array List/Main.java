import java.util.Random;

public class Main {

    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("RAndon");
        randomArrayList.add("Gogo");
        randomArrayList.add("Pesho");
        randomArrayList.add("Kiuka");
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList);

    }
}
