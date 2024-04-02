/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Container {
    private int liquid;
    
    public Container() {
        this.liquid = 0;
    }
    
    public int contains() {
        return this.liquid;
    }
    
    public void add(int amount) {
        if (amount < 0) {
            return;
        }
        
        if (amount + this.liquid > 100) {
            this.liquid = 100;
        } else {
            this.liquid += amount;
        }
        
    }
    
    public void remove(int amount) {
        if (amount < 0) {
            return;
        }
        
        if (this.liquid - amount < 0) {
            this.liquid = 0;
        } else {
            this.liquid -= amount;
        }
    }
    
    public String toString() {
        return this.liquid + "/100";
    }
}
