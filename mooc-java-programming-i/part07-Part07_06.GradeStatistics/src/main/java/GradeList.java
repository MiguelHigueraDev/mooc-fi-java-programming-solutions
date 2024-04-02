
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
public class GradeList {
    private ArrayList<Integer> grades;
    
    public GradeList() {
        this.grades = new ArrayList();
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }
    
    
    public void add(int grade) {
        if (grade < 0 || grade > 100) {
            return;
        }
        
        grades.add(grade);
    }
    
    public double pointAverageAll() {
        if (this.grades.isEmpty()) {
            return -1;
        }
        
        int sum = 0;
        
        for (int grade: this.grades) {
            sum += grade;
        }
        
        return 1.0 * sum / this.grades.size();
    }
    
    public double pointAveragePassing() {
        int sum = 0;
        int count = 0;
        
        for (int grade: this.grades) {
            if (grade >= 50) {
                sum += grade;
                count++;
            }
        }
        
        if (count == 0) {
            return -1;
        }
        
        return 1.0 * sum / count;
    }
    
    public double passPercentage() {
        int passing = 0;
        
        for (int grade: this.grades) {
            if (grade >= 50) {
                passing++;
            }
        }
        
        return 100 * (1.0 * passing) / this.grades.size();
    }
    
    
}
