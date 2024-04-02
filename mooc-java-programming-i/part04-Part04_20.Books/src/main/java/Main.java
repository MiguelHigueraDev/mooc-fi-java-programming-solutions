import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList();
        // implement here the program that allows the user to enter 
        // book information and to examine them
        while (true) {
            System.out.println("Title:");
            String title = scanner.nextLine();
            
            if (title.isEmpty()) {
                break;
            }
            
            System.out.println("Pages:");
            int pages = scanner.nextInt();
            
            System.out.println("Publication year:");
            int publicationYear = scanner.nextInt();
            scanner.nextLine();
            
            Book book = new Book(title, pages, publicationYear);
            books.add(book);
        }
        
        System.out.println("What information will be printed?");
        String response = scanner.nextLine();
        
        if (response.equals("everything")) {
            for (Book book: books) {
                System.out.println(book);
            }
        } else {
            for (Book book: books) {
                System.out.println(book.getTitle());
            }
        }
    }
}
