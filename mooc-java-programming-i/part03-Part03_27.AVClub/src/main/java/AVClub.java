
import java.util.Scanner;

public class AVClub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            
            if (str.equals("")) {
                break;
            }
            
            String[] strings = str.split(" ");
            for (String string : strings) {
                if (string.contains("av")) {
                    System.out.println(string);
                }
            }
        }
    }
}
