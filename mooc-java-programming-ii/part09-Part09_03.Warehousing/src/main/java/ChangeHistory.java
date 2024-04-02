
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
public class ChangeHistory {

    private ArrayList<Double> changeHistory;

    public ChangeHistory() {
        this.changeHistory = new ArrayList<>();
    }

    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }

    @Override
    public String toString() {
        return this.changeHistory.toString();
    }

    public double maxValue() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        }

        double max = 0;
        for (double change : this.changeHistory) {
            if (change > max) {
                max = change;
            }
        }

        return max;
    }

    public double minValue() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        }

        double min = 9999999;
        for (double change : this.changeHistory) {
            if (change < min) {
                min = change;
            }
        }

        return min;
    }

    public double average() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double change : this.changeHistory) {
            sum += change;
        }

        return sum / this.changeHistory.size();
    }
}
