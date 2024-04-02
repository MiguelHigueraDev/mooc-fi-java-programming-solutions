
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
public class HashMap<K, V> {

    private ArrayList<Pair<K, V>> values;

    public HashMap() {
        this.values = new ArrayList<>();
    }

    public V get(K key) {
        for (Pair<K, V> pair : this.values) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return null;
    }

    public void add(K key, V value) {
        Pair<K, V> pair = new Pair(key, value);
        this.values.add(pair);
    }

    public void remove(K key) {
        for (Pair<K, V> pair : this.values) {
            if (pair.getKey() == key) {
                this.values.remove(pair);
            }
        }
    }
}
