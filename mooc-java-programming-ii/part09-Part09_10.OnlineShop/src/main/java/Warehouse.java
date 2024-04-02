
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Warehouse {
    private Map<String, Integer> productPrices;
    private Map<String, Integer> productStocks;
    
    public Warehouse() {
        this.productPrices = new HashMap<>();
        this.productStocks = new HashMap<>();
    }
    
    public Warehouse(Map map) {
        this.productPrices = map;
        this.productStocks = map;
    }
    
    public void addProduct(String product, int price, int stock) {
        this.productPrices.put(product, price);
        this.productStocks.put(product, stock);
    }
    
    public int price(String product) {
        if (this.productPrices.containsKey(product)) {
            return this.productPrices.get(product);
        }
        
        return -99;
    }
    
    public int stock(String product) {
        if (this.productStocks.containsKey(product)) {
            return this.productStocks.get(product);
        }
        
        return 0;
    }
    
    public boolean take(String product) {
        if (!this.productStocks.containsKey(product)) {
            return false;
        }
        
        if (this.productStocks.get(product) > 0) {
            this.productStocks.put(product, this.productStocks.get(product) - 1);
            return true;
        }
        
        return false;
    }
    
    public Set<String> products() {
        return this.productStocks.keySet();
    }
}
