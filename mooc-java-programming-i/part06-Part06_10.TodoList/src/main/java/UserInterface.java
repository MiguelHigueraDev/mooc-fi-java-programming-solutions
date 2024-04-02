
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class UserInterface {
    private TodoList todos;
    private Scanner scanner;
    
    public UserInterface(TodoList todos, Scanner scanner) {
        this.todos = todos;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                System.out.print("To add: ");
                String todo = this.scanner.nextLine();
                this.todos.add(todo);
            } else if (command.equals("list")) {
                this.todos.print();
            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int number = Integer.valueOf(this.scanner.nextLine());
                this.todos.remove(number);
            }
        }
    }
}
