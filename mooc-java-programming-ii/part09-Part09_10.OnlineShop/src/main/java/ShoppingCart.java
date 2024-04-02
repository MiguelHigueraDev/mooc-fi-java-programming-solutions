
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class ShoppingCart {
    private Map<String, Item> items;
    
    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public ShoppingCart(Map map) {
        this.items = map;
    }
    
    public void add(String product, int price) {
        // Check first if product is already stored
        Item check = this.items.get(product);
        Item item = null;
        
        if (check == null) {
            item = new Item(product, 1, price);
        } else {
            check.increaseQuantity();
            item = check;
        }

        this.items.put(product, item);
    }
    
    public int price() {
        int sum = 0;
        for (Item item: this.items.values()) {
            sum += item.price();
        }
        return sum;
    }
    
    public void print() {
        for (Item item: this.items.values()) {
            System.out.println(item);
        }
    }
}
