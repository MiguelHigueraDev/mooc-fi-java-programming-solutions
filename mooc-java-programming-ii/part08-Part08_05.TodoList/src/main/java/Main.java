
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Here you can try out the combined functionality of your classes
        // IndexOutOfBoundsException: Index 3 out of bounds for length 3, in call remove(2). An error occurred while removing. Try the code:
        TodoList list = new TodoList();
        list.add("read the course material");
        list.add("watch the latest fool us");
        list.add("take it easy");
        list.print();
        list.remove(2);
        list.print();
        list.add("buy raisins");
        list.print();
        list.remove(1);
        list.remove(1);
        list.print();

    }
}
