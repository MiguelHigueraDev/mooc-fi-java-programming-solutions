
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
public class VehicleRegistry {

    private HashMap<LicensePlate, String> owners;

    public VehicleRegistry() {
        this.owners = new HashMap();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.owners.containsKey(licensePlate)) {
            return false;
        } else {
            this.owners.put(licensePlate, owner);
            return true;
        }

    }

    public String get(LicensePlate licensePlate) {
        return this.owners.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!this.owners.containsKey(licensePlate)) {
            return false;
        }

        this.owners.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        for (LicensePlate plate : this.owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> checkedOwners = new ArrayList();
        for (String owner : this.owners.values()) {
            if (checkedOwners.contains(owner)) {
                continue;
            }
            checkedOwners.add(owner);
            System.out.println(owner);
        }
    }
}
