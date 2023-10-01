package codsoft_projects;

import java.util.*;
import java.io.*;

// Console based ui....

public class task5sms 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        System.out.println("\n *** TASK - 5 CODSOFT ***");
        System.out.println("\n ---------------------------------- ");
        System.out.println("\n -: STUDENT MANAGEMENT SYSTEM MENU :- ");

        while (true)            // options for the users....
        {
            System.out.println("1. Add Student ...");
            System.out.println("2. Remove Student ...");
            System.out.println("3. Search Student ...");
            System.out.println("4. Display All Students ...");
            System.out.println("5. Exit ... ");
            System.out.print("\n Enter your choice :- ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice)                         // inputs as per users choice... 
            {
                case 1:
                    System.out.print("Enter student name : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number : ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade : ");
                    char grade = scanner.next().charAt(0);
                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number to remove : ");
                    int removeRollNumber = scanner.nextInt();
                    system.removeStudent(removeRollNumber);
                    break;
                case 3:
                    System.out.print("Enter roll number to search : ");
                    int searchRollNumber = scanner.nextInt();
                    system.searchStudent(searchRollNumber);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("\n Thank you... Exiting Student Management System ....");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. !!!!!... Please enter a valid option.... ");
            }
        }
    }
}

// Class to represent individual student's information......
class Student 
{
    private String name;
    private int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() 
    {
        return name;
    }

    public int getRollNumber() 
    {
        return rollNumber;
    }

    public char getGrade() 
    {
        return grade;
    }

    @Override
    public String toString() 
    {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

// Class to perform all the other operations.... 
class StudentManagementSystem 
{
    private ArrayList<Student> students;

    public StudentManagementSystem() 
    {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) 
    {
        students.add(student);
        System.out.println("\n Student added successfully.");
    }

    public void removeStudent(int rollNumber) 
    {
        for (int i = 0; i < students.size(); i++) 
        {
            if (students.get(i).getRollNumber() == rollNumber) 
            {
                students.remove(i);
                System.out.println("\n Student removed successfully.");
                return;
            }
        }
        System.out.println("\n Student not found.");
    }

    public void searchStudent(int rollNumber) 
    {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) 
            {
                System.out.println("\n Student found : " + student);
                return;
            }
        }
        System.out.println("\n Student not found.");
    }

    public void displayAllStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("\n No students in the system.");
        } 
        else 
        {
            System.out.println("\n List of all students :");
            for (Student student : students) 
            {
                System.out.println(student);
            }
        }
    }
}
