
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }
    
    public String toString() {
        String title;
        if (this.elements.isEmpty()) {
            title = "The collection " + this.name + " is empty.";
        } else if (this.elements.size() == 1) {
            title = "The collection " + this.name + " has " + this.elements.size() + " element:\n";
        } else {
            title = "The collection " + this.name + " has " + this.elements.size() + " elements:\n";
        }
        
        String elementString = "";
        for (int i = 0; i < elements.size(); i++) {
            if (i != elements.size() - 1) {
                elementString += elements.get(i) + "\n";
            } else {
                elementString += elements.get(i);
            }

        }
        
        return title + elementString;
    }
    
}
