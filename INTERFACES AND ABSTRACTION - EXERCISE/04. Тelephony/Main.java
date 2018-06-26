import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = input.readLine().split("\\s+");
        String[] urls = input.readLine().split("\\s+");

        MySmarthpone smarthpone = new MySmarthpone();
        for (String phoneNumber : phoneNumbers) {
            try {
                System.out.println(smarthpone.call(phoneNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String url : urls) {
            try {
                System.out.println(smarthpone.browseInInternet(url));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
