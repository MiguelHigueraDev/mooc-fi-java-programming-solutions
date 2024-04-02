/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Counter {
    int count;
    
    public Counter (int startValue) {
        this.count = startValue;
    }
    
    public Counter() {
        this(0);
    }
    
    public int value() {
        return this.count;
    }
    
    public void increase() {
        this.count++;
    }
    
    public void increase(int increaseBy) {
        if (increaseBy < 0) return;
        this.count += increaseBy;
    }
    
    public void decrease() {
        this.count--;
    }
    
    public void decrease(int decreaseBy) {
        if (decreaseBy < 0) return;
        this.count -= decreaseBy;
    }
    
}
