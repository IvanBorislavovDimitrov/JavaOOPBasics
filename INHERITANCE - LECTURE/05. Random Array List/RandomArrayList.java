import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private static final Random random = new Random();

    public RandomArrayList() {
        super();
    }

    public Object getRandomElement() {
        int index = random.nextInt(super.size());

        return super.remove(index);
    }
}
