
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
public class Herd implements Movable {
    
    private ArrayList<Movable> movables;
    
    public Herd() {
        this.movables = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Movable movable: movables) {
            str += movable.toString() + "\n";
        }
        return str;
    }
    
    public void addToHerd(Movable movable) {
        this.movables.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable movable: movables) {
            movable.move(dx, dy);
        }
    }
    
}
