
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author misfit
 */
public class Box implements Packable {

    private ArrayList<Packable> contents;
    private double maxWeight;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<>();
    }

    @Override
    public double weight() {
        double currentWeight = 0;
        for (Packable pack : this.contents) {
            currentWeight += pack.weight();
        }
        return currentWeight;
    }

    public void add(Packable packable) {
        if (this.weight() + packable.weight() <= this.maxWeight) {
            this.contents.add(packable);
        }
    }

    @Override
    public String toString() {
        return "Box: " + this.contents.size() + " items, total weight " + this.weight() + " kg";
    }

}
