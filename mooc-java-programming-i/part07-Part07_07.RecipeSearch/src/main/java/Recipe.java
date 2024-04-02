
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
public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<Ingredient> ingredients;
    
    public Recipe(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    
    
    public void addIngredient(String ingredient) {
        Ingredient newIngredient = new Ingredient(ingredient);
        if (!this.ingredients.contains(newIngredient)) {
            this.ingredients.add(newIngredient);
        }
    }

    @Override
    public String toString() {
        return this.name + ", cooking time: " + this.cookingTime;
    }
    
    
    
}
