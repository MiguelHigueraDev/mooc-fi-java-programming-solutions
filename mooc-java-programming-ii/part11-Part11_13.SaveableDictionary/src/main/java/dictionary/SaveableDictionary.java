/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author misfit
 */
public class SaveableDictionary {

    private HashMap<String, String> words;
    private String file;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.words = new HashMap<>();
        this.file = file;
    }
    
    public boolean load() {
        try {
            Scanner scanner = new Scanner(Paths.get(this.file));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error loading dictionary from file");
            return false;
        }
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            for (Map.Entry<String,String> w: this.words.entrySet()) {
                writer.print(w.getKey());
                writer.print(":");
                writer.print(w.getValue());
                writer.println();
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error writing dictionary to file");
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!this.words.containsKey(word)) {
            this.words.put(word, translation);
        }
    }

    public String translate(String word) {
        if (this.words.containsKey(word)) {
            return this.words.get(word);
        } else if (this.words.containsValue(word)) {
            for (Map.Entry<String, String> w : this.words.entrySet()) {
                if (w.getValue().equals(word)) {
                    return w.getKey();
                }
            }
        }
        return null;
    }

    public void delete(String word) {
        // Remove using key
        if (this.words.containsKey(word)) {
            this.words.remove(word);
        }

        // Remove using value
        Iterator<Map.Entry<String, String>> iterator = this.words.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(word)) {
                this.words.remove(entry.getKey());
                break;
            }
        }
    }
}
