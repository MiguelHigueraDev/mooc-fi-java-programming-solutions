
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
    private Scanner scanner;
    private TodoList list;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.scanner = scanner;
        this.list = list;
    }
    
    public void start() {
        
        while (true) {
            String input = this.scanner.nextLine();
            
            if (input.equals("stop")) {
                break;
            }
            
            if (input.equals("add")) {
                String task = this.scanner.nextLine();
                this.list.add(task);
            }
            
            if (input.equals("list")) {
                this.list.print();
            }
            
            if (input.equals("remove")) {
                int number = Integer.valueOf(this.scanner.nextLine());
                this.list.remove(number);
            }
            
        }
    }
}
