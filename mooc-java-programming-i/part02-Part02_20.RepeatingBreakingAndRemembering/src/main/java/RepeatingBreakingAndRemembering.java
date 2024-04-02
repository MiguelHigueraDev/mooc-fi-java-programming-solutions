
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {

        // This exercise is worth five exercise points, and it is 
        // gradually extended part by part.
        // If you want, you can send this exercise to the server
        // when it's just partially done. In that case the server will complain about 
        // the parts you haven't done, but you'll get points for the finished parts.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give numbers:");
        int sum = 0;
        int numberAmount = 0;
        int oddNumbers = 0;
        int evenNumbers = 0;
        while (true) {
            int number = scanner.nextInt();

            if (number == -1) {
                break;
            }
            
            if (number % 2 == 0) {
                evenNumbers++;
            } else {
                oddNumbers++;
            }
            
            sum += number;
            numberAmount++;
        }
        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numberAmount);
        System.out.println("Average: " + (sum * 1.0) / numberAmount);
        System.out.println("Even: " + evenNumbers);
        System.out.println("Odd: " + oddNumbers);
    }
}
