
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file:");
        String fileName = scanner.nextLine();

        try {
            Scanner fileScanner = new Scanner(Paths.get(fileName));
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String name = parts[0];
                String age = parts[1];
                if (age.equals("1")) {
                    System.out.println(name + ", age: " + age + " year");
                } else {
                    System.out.println(name + ", age: " + age + " years");
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
