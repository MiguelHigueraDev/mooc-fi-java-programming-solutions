
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            String[] arguments = input.split(" ");
            if (arguments[0].equals("quit")) {
                break;
            }
            int amount = Integer.valueOf(arguments[1]);

            if (arguments[0].equals("add")) {
                if (amount <= 0) {
                    continue;
                }

                if (firstContainer + amount > 100) {
                    firstContainer = 100;
                } else {
                    firstContainer += amount;
                }
            }

            if (arguments[0].equals("move")) {
                if (amount <= 0) {
                    continue;
                }
                
                if (firstContainer >= amount) {
                    if (secondContainer + amount > 100) {
                        secondContainer = 100;
                    } else {
                        secondContainer += amount;
                        firstContainer -= amount;
                    }
                } else if (firstContainer < amount) {
                    secondContainer += firstContainer;
                    firstContainer = 0;
                }

            }

            if (arguments[0].equals("remove")) {
                if (secondContainer - amount < 0) {
                    secondContainer = 0;
                } else {
                    secondContainer -= amount;
                }
            }

        }
    }

}
