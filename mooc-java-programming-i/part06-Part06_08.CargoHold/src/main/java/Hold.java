
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
public class Hold {

    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList();
    }

    public int totalWeight() {
        int sum = 0;
        for (Suitcase su : this.suitcases) {
            sum += su.totalWeight();
        }
        return sum;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() + this.totalWeight() <= this.maxWeight) {
            this.suitcases.add(suitcase);
        }
    }
    
    public void printItems() {
        for (Suitcase su: this.suitcases) {
            su.printItems();
        }
    }
    
    @Override
    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}
