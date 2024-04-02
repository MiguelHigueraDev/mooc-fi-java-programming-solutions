
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int strCount = 0;
        String longestName = "";
        while (true) {
            String str = scanner.nextLine();

            if (str.equals("")) {
                break;
            }

            String[] strings = str.split(",");
            if (strings[0].length() > longestName.length()) {
                longestName = strings[0];
            }
            sum += Integer.valueOf(strings[1]);
            strCount++;
        }

        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + (sum * 1.0) / strCount);
    }
}
