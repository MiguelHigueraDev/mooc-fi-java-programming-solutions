
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class StorageFacility {
    private HashMap<String, ArrayList<String>> facilities;
    
    public StorageFacility() {
        this.facilities = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        this.facilities.putIfAbsent(unit, new ArrayList<>());
        this.facilities.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        if (this.facilities.get(storageUnit) == null) {
            return new ArrayList<>();
        } else {
            return this.facilities.get(storageUnit);
        }
    }
    
    public void remove(String storageUnit, String item) {
        ArrayList<String> unit = this.facilities.get(storageUnit);
        unit.remove(item);
        
        if (unit.isEmpty()) {
            this.facilities.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> storages = new ArrayList<>(this.facilities.keySet());
        return storages;
    }
}
