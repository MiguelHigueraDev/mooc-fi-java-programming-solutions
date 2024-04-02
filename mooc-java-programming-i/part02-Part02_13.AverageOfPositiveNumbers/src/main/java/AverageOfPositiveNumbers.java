
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersEntered = 0;
        int sum = 0;

        while (true) {
            System.out.println("Give a number:");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (number > 0) {
                numbersEntered += 1;
                sum += number;
            }

        }

        if (numbersEntered > 0) {
            System.out.println(((sum * 1.0) / numbersEntered));
        } else {
            System.out.println("Cannot calculate the average");
        }

    }
}
