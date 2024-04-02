
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        
        while (true) {
            String word = scanner.nextLine();
            if (word.isEmpty()) {
                break;
            }    
            words.add(word);
        }
        
        words.stream().forEach(word -> System.out.println(word));
        
    }
}
