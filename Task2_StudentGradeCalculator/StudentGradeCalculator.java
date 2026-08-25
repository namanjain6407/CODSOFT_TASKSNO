package Task2_StudentGradeCalculator;
import java.util.*;
class StudentGradeCalculator {
    public static void main (String args[]) {
      Scanner sc = new Scanner(System.in);
      
        System.out.print("Enter Number of the Subjects: ");
        int subjects =  sc.nextInt();

        int totalMarks = 0;

        for(int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for  Subjects: " + i + " (out of 100): ");
            int marks = sc.nextInt();

            if(marks < 0 || marks > 100) {
                System.out.print("Invalid mark! Please enter a value between 0 and 100.");
                i--;
                continue;
            }
            
            totalMarks += marks; 
        }
    
        double average = (double) totalMarks / subjects;    
    
        String grade;
        if(average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else {
             grade = "D";
        }    


        System.out.println("\n--- Result ---");
        System.out.println("Total Marks = " + totalMarks);
        System.out.println("Average Percentage  = " + String.format("%.2f", average) + "%");
        System.out.println("Grade = " + grade);
        
        sc.close();
    }
}     