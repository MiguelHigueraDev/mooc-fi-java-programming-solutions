
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
public class Suitcase {
    private int maxWeight;
    private ArrayList<Item> items;
    
    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList();
    }
    
    public void addItem(Item item) {
        if (item.getWeight() + this.totalWeight() <= maxWeight) {
            this.items.add(item);
        }
    }
    
    public int totalWeight() {
        int sum = 0;
        
        for (Item item: this.items) {
            sum += item.getWeight();
        }
        
        return sum;
    }
    
    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        
        Item heaviest = this.items.get(0);
        
        for (Item it: this.items) {
            if (it.getWeight() > heaviest.getWeight()) {
                heaviest = it;
            }
        }
        
        return heaviest;
    }
    
    public void printItems() {
        for (Item item: this.items) {
            System.out.println(item.getName() + " (" + item.getWeight() + " kg)");
        }
    }
    
    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "no items (" + this.totalWeight() + " kg)"; 
        } else if (items.size() == 1) {
            return items.size() + " item (" + this.totalWeight() + " kg)";
        } else {
            return items.size() + " items (" + this.totalWeight() + " kg)";
        }

    }
}
