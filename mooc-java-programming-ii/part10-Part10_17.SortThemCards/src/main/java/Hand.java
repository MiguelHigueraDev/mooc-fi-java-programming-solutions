
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        this.cards.stream()
            .forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        this.cards.sort(Card::compareTo);
    }
    
    public void sortBySuit() {
        this.cards.sort(new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand hand) {
        return this.cards.stream()
                .mapToInt(Card::getValue)
                .sum() -
                hand.cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }
}
