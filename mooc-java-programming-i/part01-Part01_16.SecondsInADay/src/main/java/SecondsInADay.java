
import java.util.Scanner;

public class SecondsInADay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("How many days would you like to convert to seconds?");
        int days = Integer.valueOf(scanner.nextLine());
        int hoursInADay = 24;
        int secondsInAnHour = 3600;
        System.out.println(days * hoursInADay * secondsInAnHour);

    }
}
