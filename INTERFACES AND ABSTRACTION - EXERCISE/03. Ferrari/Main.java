import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {

    public static void main(String[] args) throws IOException, IllegalClassFormatException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String driverName = input.readLine();

        Car ferrri = new Ferrari(driverName);

        System.out.println(ferrri);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

    }
}
