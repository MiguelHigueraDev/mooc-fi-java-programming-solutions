
import java.util.Scanner;

public class AverageOfNumbers {

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

            numbersEntered += 1;
            sum += number;
        }
        
        System.out.println("Average of the numbers: " + ((sum * 1.0) / numbersEntered));

    }
}
