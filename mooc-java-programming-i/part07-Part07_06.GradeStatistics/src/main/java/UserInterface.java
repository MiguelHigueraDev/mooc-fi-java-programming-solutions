
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
    private GradeList grades;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.grades = new GradeList();
    }
    
    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            
            int grade = Integer.valueOf(scanner.nextLine());
            
            if (grade == -1) {
                break;
            }
            
            this.grades.add(grade);
        }
        
        System.out.println("Point average (all): " + this.grades.pointAverageAll());
        System.out.println("Point average (passing): " + this.grades.pointAveragePassing());
        System.out.println("Pass percentage: " + this.grades.passPercentage());
        this.printGradeDistribution(this.grades);
    }
    
    public void printGradeDistribution(GradeList gradeList) {
        int[] grades = {0, 0, 0, 0, 0, 0};
        
        for (int grade: gradeList.getGrades()) {
            if (grade < 50) {
                grades[0]++;
            } else if (grade < 60) {
                grades[1]++;
            } else if (grade < 70) {
                grades[2]++;
            } else if (grade < 80) {
                grades[3]++;
            } else if (grade < 90) {
                grades[4]++;
            } else if (grade >= 90 && grade <= 100) {
                grades[5]++;
            }
        }
        
        System.out.println("Grade distribution:");
        for (int i = grades.length - 1; i >= 0; i--) {
            System.out.print(i + ": ");
            for (int j = 0; j < grades[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
