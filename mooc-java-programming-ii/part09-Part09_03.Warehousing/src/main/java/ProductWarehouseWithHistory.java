/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    
    private ChangeHistory changeHistory;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity, initialBalance);
        this.changeHistory = new ChangeHistory();
        this.changeHistory.add(initialBalance);
    }
    
    public String history() {
        return this.changeHistory.toString();
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.changeHistory.add(this.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        if (amount > this.getBalance()) {
            amount = this.getBalance();
        }
        
        super.takeFromWarehouse(amount);
        this.changeHistory.add(this.getBalance());
        return amount;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.changeHistory.maxValue());
        System.out.println("Smallest amount of product: " + this.changeHistory.minValue());
        System.out.println("Average: " + this.changeHistory.average());
    }
    
}
