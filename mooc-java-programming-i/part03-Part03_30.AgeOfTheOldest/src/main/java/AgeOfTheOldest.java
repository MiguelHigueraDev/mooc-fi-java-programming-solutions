
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oldest = 0;
        while (true) {
            String str = scanner.nextLine();

            if (str.equals("")) {
                break;
            }

            String[] strings = str.split(",");
            if (Integer.valueOf(strings[1]) > oldest) {
                oldest = Integer.valueOf(strings[1]);
            }
        }
        
        System.out.println("Age of the oldest: " + oldest);

    }
}
