
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
public class JokeManager {
    private ArrayList<String> jokes;
    
    public JokeManager() {
        this.jokes = new ArrayList();
    }
    
    public void addJoke(String joke) {
        this.jokes.add(joke);
    }
    
    public String drawJoke() {
        if (jokes.isEmpty()) {
            return "Jokes are in short supply.";
        } else {
            // Get random joke
            int index = (int) (Math.random() * jokes.size());
            return this.jokes.get(index);
        }
    }
    
    public void printJokes() {
        for (String joke: this.jokes) {
            System.out.println(joke);
        }
    }
}
