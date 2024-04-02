
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Bird {
    private String name;
    private String latinName;
    private int observations;
    
    public Bird(String name) {
        this.name = name;
        this.latinName = "";
        this.observations = 0;
    }
    
    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.observations = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }
    
    public void addObservation() {
        this.observations++;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bird other = (Bird) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return this.name + " (" + this.latinName + "): " + this.observations + " observations";
    }
    
    
    
    
    
    
}
