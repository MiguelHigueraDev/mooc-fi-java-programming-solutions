
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author misfit
 */
public class UserInterface {

    private Scanner scanner;
    private ArrayList<Recipe> recipes;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.recipes = new ArrayList();
    }

    public void start() {
        // Read file
        System.out.print("File to read: ");
        String filename = this.scanner.nextLine();
        this.readRecipes(filename);

        // Print command help
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by name");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.print("Enter command: ");
            String input = this.scanner.nextLine();

            if (input.equals("stop")) {
                break;
            }

            if (input.equals("list")) {
                // Show message if no recipes found.
                if (this.recipes.isEmpty()) {
                    System.out.println("No recipes found.");
                }

                System.out.println("Recipes:");
                for (Recipe recipe : this.recipes) {
                    System.out.println(recipe);
                }
            }

            if (input.equals("find name")) {
                System.out.print("Searched word: ");
                String search = this.scanner.nextLine();
                ArrayList<Recipe> recipes = this.findRecipesByName(search);

                System.out.println("Recipes:");
                for (Recipe recipe : recipes) {
                    System.out.println(recipe);

                }
            }

            if (input.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int search = Integer.valueOf(this.scanner.nextLine());
                ArrayList<Recipe> recipes = this.findRecipesByMaxCookingTime(search);

                System.out.println("Recipes:");
                for (Recipe recipe : recipes) {
                    System.out.println(recipe);
                }
            }

            if (input.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String search = this.scanner.nextLine();
                ArrayList<Recipe> recipes = this.findRecipesByIngredient(search);

                System.out.println("Recipes:");
                for (Recipe recipe : recipes) {
                    System.out.println(recipe);
                }
            }
        }
    }

    public void readRecipes(String filename) {
        try {
            Scanner fileScanner = new Scanner(Paths.get(filename));
            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                if (nextLine.isEmpty()) {
                    break;
                }

                // First line has the recipe name
                String recipeName = nextLine;
                // Second line has the preparation time
                int prepTime = Integer.valueOf(fileScanner.nextLine());
                // Make recipe
                Recipe recipe = new Recipe(recipeName, prepTime);
                while (fileScanner.hasNextLine()) {
                    String ingredientLine = fileScanner.nextLine();
                    if (ingredientLine.isEmpty()) {
                        break;
                    }
                    // Third line and more have the ingredients
                    // Add ingredients to recipe until a line break is found, that marks the start of a new recipe
                    String ingredient = ingredientLine;
                    recipe.addIngredient(ingredient);
                }
                // Add the recipe to the list
                this.recipes.add(recipe);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    public ArrayList<Recipe> findRecipesByName(String name) {

        ArrayList<Recipe> recipes = new ArrayList();
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(name)) {
                recipes.add(recipe);
            }
        }

        return recipes;
    }

    public ArrayList<Recipe> findRecipesByMaxCookingTime(int cookingTime) {
        ArrayList<Recipe> recipes = new ArrayList();
        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= cookingTime) {
                recipes.add(recipe);
            }
        }

        return recipes;
    }

    public ArrayList<Recipe> findRecipesByIngredient(String ingredient) {

        ArrayList<Recipe> recipes = new ArrayList();
        Ingredient ingr = new Ingredient(ingredient);
        for (Recipe recipe : this.recipes) {
            if (recipe.getIngredients().contains(ingr)) {
                recipes.add(recipe);
            }
        }

        return recipes;
    }
}
