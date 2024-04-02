/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author misfit
 */
public class Timer {
    private ClockHand hundredthsOfASecond = new ClockHand(100);
    private ClockHand second = new ClockHand(60);
    
    public Timer() {
    }
    
    public String toString() {
        return this.second + ":" + this.hundredthsOfASecond;
    }
    
    public void advance() {
        this.hundredthsOfASecond.advance();
        if (this.hundredthsOfASecond.value() == 0) {
            this.second.advance();
        }
    }
}
