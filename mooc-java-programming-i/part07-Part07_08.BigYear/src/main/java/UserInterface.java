
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
    private BirdWatcher birdWatcher;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.birdWatcher = new BirdWatcher();
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String input = this.scanner.nextLine();

            if (input.equals("Quit")) {
                break;
            }

            if (input.equals("Add")) {
                this.addBirb();
            }

            if (input.equals("All")) {
                this.printBirds();
            }
            
            if (input.equals("One")) {
                this.printBirb();
            }
            
            if (input.equals("Observation")) {
                this.addObservation();
            }
        }
    }

    public void addBirb() {
        System.out.print("Name: ");
        String name = this.scanner.nextLine();
        System.out.print("Name in Latin: ");
        String latinName = this.scanner.nextLine();

        Bird bird = new Bird(name, latinName);
        this.birdWatcher.addBird(bird);
    }
    
    public void printBirds() {
        for (Bird birb: this.birdWatcher.getBirds()) {
            System.out.println(birb);
        }
    }
    
    public void printBirb() {
        System.out.print("Bird? ");
        String name = this.scanner.nextLine();
        Bird bird = birdWatcher.getBird(name);
        if (bird == null) {
            System.out.println("Not a bird!");
        } else {
            System.out.println(bird);
        }
    }
    
    public void addObservation() {
        System.out.print("Bird? ");
        String name = this.scanner.nextLine();
        Bird bird = birdWatcher.getBird(name);
        if (bird == null) {
            System.out.println("Not a bird!");
        } else {
            bird.addObservation();
        }
    }

}
