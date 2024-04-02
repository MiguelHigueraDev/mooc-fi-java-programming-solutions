
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oldest = 0;
        String oldestName = "";
        while (true) {
            String str = scanner.nextLine();

            if (str.equals("")) {
                break;
            }

            String[] strings = str.split(",");
            if (Integer.valueOf(strings[1]) > oldest) {
                oldest = Integer.valueOf(strings[1]);
                oldestName = strings[0];
            }
        }

        System.out.println("Name of the oldest: " + oldestName);
    }
}
