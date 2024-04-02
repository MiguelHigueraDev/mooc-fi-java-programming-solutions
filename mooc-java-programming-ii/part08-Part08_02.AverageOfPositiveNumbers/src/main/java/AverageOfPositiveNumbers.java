
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int amount = 0;
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            if (number > 0) {
                sum += number;
                amount++;
            }

        }

        if (amount == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(sum * 1.0 / amount * 1.0);
        }
    }
}
