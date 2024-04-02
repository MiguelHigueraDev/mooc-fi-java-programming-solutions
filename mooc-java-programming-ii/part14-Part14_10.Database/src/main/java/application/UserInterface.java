package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            if (command.equals("1")) {
                list();
            }

            if (command.equals("2")) {
                add(scanner);
            }

            if (command.equals("3")) {
                markAsDone(scanner);
            }
            
            if (command.equals("4")) {
                remove(scanner);
            }
        }

        System.out.println("Thank you!");
    }

    private void list() throws SQLException {
        System.out.println("Listing the database contents");
        List<Todo> todos = database.list();
        todos.stream().forEach(todo -> System.out.println(todo));
    }

    private void add(Scanner scanner) throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter descrption");
        String description = scanner.nextLine();

        // Set it to false because its a new task
        Todo todo = new Todo(name, description, false);
        database.add(todo);
    }

    private void markAsDone(Scanner scanner) throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        database.markAsDone(id);
    }

    private void remove(Scanner scanner) throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        database.remove(id);
    }

}
