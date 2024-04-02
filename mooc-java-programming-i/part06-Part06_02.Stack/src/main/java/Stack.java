
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
public class Stack {
    private ArrayList<String> strings;
    
    public Stack() {
        this.strings = new ArrayList();
    }
    
    public boolean isEmpty() {
        return this.strings.isEmpty();
    }
    
    public void add(String value) {
        if (!this.strings.contains(value)) {
            this.strings.add(value);   
        }
    }
    
    public String take() {
        String value = this.strings.get(strings.size() - 1);
        this.strings.remove(value);
        return value;
    }
    
    public ArrayList<String> values() {
        return strings;
    }
    
    
    
}
