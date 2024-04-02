
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
public class Pipe<T> {
    
    private ArrayList<T> contents;
    
    public Pipe() {
        this.contents = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.contents.add(value);
    }
    
    public T takeFromPipe() {
        if (this.contents.isEmpty()) {
            return null;
        }
        
        T item = this.contents.get(0);
        this.contents.remove(item);
        return item;
    }
    
    public boolean isInPipe() {
        if (this.contents.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
