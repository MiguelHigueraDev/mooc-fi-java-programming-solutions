
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int recommendedAge = Integer.valueOf(scanner.nextLine());
            Book book = new Book(name, recommendedAge);

            books.add(book);
        }

        // Sort books
        Comparator<Book> comparator = Comparator.comparing(Book::getRecommendedAge).thenComparing(Book::getName);
        Collections.sort(books, comparator);

        System.out.println(books.size() + " books in total.");
        books.forEach(book -> System.out.println(book));
    }

}
