
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container firstContainer = new Container();
        Container secondContainer = new Container();

        while (true) {
            System.out.println("First: " + firstContainer);
            System.out.println("Second:" + secondContainer);
            System.out.print("> ");

            String input = scan.nextLine();
            String[] arguments = input.split(" ");
            if (arguments[0].equals("quit")) {
                break;
            }
            
            int amount = Integer.valueOf(arguments[1]);
            
            if (arguments[0].equals("add")) {
                firstContainer.add(amount);
            }
            
            if (arguments[0].equals("move")) {
                if (firstContainer.contains() >= amount) {
                    if (secondContainer.contains() + amount > 100) {
                        secondContainer.add(100);
                    } else {
                        secondContainer.add(amount);
                        firstContainer.remove(amount);
                    }
                } else if (firstContainer.contains() < amount) {
                    secondContainer.add(firstContainer.contains());
                    firstContainer.remove(100);
                } 
            }
            
            if (arguments[0].equals("remove")) {
                secondContainer.remove(amount);
            }

        }
    }

}
