package codsoft_projects;

import java.util.*;
import java.io.*;

public class task2stugrdcal 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("   # TASK 2 - CODSOFT #    ");
        System.out.println("** STUDENT GRADE CALCULATOR **");
        System.out.println("===============================");
        // entering the total no. of subjects 
        System.out.print("Enter the total number of subjects taught : ");
        int numSubs = sc.nextInt();
        
        // entering valid no. of subjects
        if (numSubs <= 0) 
        {
            System.out.println("Number of Subjects cannot be 0 or less than 0. Please enter a VALID number ....");
            return;
        }
        
        String[] subNames = new String[numSubs];    // array for subject names
        double[] subMarks = new double[numSubs];    // array for subject marks
        double totMarks = 0.0;
        
        // entering subject wise marks
        System.out.println("Enter the Marks for each subject - ");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < numSubs; i++) 
        {
            System.out.print("Enter the name of subject " + (i+1) + ": ");
            subNames[i] = sc.next();
            
            System.out.print("Enter marks obtained in " + subNames[i] + ", out of 100 : ");
            double marks = sc.nextDouble();
            System.out.println();
            
            if (marks < 0 || marks > 100) 
            {
                System.out.println("Invalid marks. Marks should be between 0 and 100."); // checking for valid marks 
                return;
            }
            
            subMarks[i] = marks;
            totMarks += marks;      // total marks calculation..
        }
        System.out.println("====================================================");
        
        double avgPert = totMarks / numSubs;        // average percentage.
        
        // displaying subject wise marks 
        System.out.println("Subject-wise Marks Obtained :");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < numSubs; i++) 
        {
            System.out.println(subNames[i] + ": " + subMarks[i]);
        }
        System.out.println("====================================================");
        System.out.println("Total Marks Obtained : " + totMarks);
        System.out.println("Full Marks : "+ (numSubs * 100));
        System.out.println("Average Percentage Obtained : " + avgPert + "%");
        System.out.println("====================================================");
        
        // calling grade calculating function...
        String grade = calcGrade(avgPert);
        System.out.println("Grade : " + grade);
        System.out.println("====================================================");
    }
    
    // grade calculation function...
    public static String calcGrade(double pertg) 
    {
        if (pertg >= 90) 
        {
            return "A+ [ Excellent ]";
        } else if (pertg >= 80) 
        {
            return "A [ Very Good ]";
        } else if (pertg >= 70) 
        {
            return "B [ Good ]";
        } else if (pertg >= 60) 
        {
            return "C [ Poor, Can improve ]";
        } else if (pertg >= 50) 
        {
            return "D [ Very Poor ]";
        } else 
        {
            return "F [ Detained ]";
        }
    }
}
