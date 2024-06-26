
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
public class Hideout<T> {

    private T hidden;

    public Hideout() {
        this.hidden = null;
    }

    public void putIntoHideout(T toHide) {
        this.hidden = toHide;
    }

    public T takeFromHideout() {
        T item = this.hidden;
        this.hidden = null;
        return item;
    }

    public boolean isInHideout() {
        if (this.hidden == null) {
            return false;
        }

        return true;
    }
}
