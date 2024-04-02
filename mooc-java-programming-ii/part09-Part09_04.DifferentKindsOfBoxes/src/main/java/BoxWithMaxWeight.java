
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
public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    @Override
    public void add(Item item) {
        if (this.capacity - item.getWeight() >= 0) {
            this.items.add(item);
            this.capacity -= item.getWeight();
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
    
    
}
