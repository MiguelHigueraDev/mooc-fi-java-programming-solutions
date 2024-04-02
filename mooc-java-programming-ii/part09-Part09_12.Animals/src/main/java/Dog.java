/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Dog extends Animal implements NoiseCapable {

    public Dog() {
        super("Dog");
    }

    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println(this.name + " barks");
    }

    @Override
    public void makeNoise() {
        this.bark();
    } 
    
}
