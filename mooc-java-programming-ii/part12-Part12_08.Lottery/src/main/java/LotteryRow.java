
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random random;

    public LotteryRow() {
        this.random = new Random();
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        while (this.numbers.size() < 7) {
            int number = random.nextInt(40) + 1;
            if (!containsNumber(number)) {
                this.numbers.add(number);
            }
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return this.numbers.stream()
                .filter(num -> num.equals(number))
                .count() > 0;
    }
}
