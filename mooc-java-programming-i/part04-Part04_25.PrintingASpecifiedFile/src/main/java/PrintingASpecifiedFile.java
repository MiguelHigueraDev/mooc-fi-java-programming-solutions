
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which file should have its contents printed?");
        String fileName = scanner.nextLine();
        
        ArrayList<String> lines = new ArrayList<>();
        
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            while (file.hasNextLine()) {
                lines.add(file.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        for (String line: lines) {
            System.out.println(line);
        }
    }
}
