
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        System.out.println("Input numbers, type \"end\" to stop.");
        List<String> inputs = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            inputs.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        double average = 0;
        if (choice.equals("p")) {
            average = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(s -> s > 0)
                .average()
                .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        } else {
            average = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(s -> s < 0)
                .average()
                .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        }
        
    }
}
