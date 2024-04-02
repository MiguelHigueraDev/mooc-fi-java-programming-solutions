
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
public class BirdWatcher {

    private ArrayList<Bird> birds;

    public BirdWatcher() {
        this.birds = new ArrayList();
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    public void setBirds(ArrayList<Bird> birds) {
        this.birds = birds;
    }
    

    public void addBird(Bird bird) {
        if (!this.birds.contains(bird))  {
            this.birds.add(bird);
        }
    }
    
    public Bird getBird(String name) {
        for (Bird bird: this.birds) {
            if (bird.getName().equalsIgnoreCase(name)) {
                return bird;
            }
        }
        return null;
    }
}
