package codsoft_projects;

import java.util.*;
import java.io.*;

public class task1numgame 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("           # TASK 1 - CODSOFT #        ");
        System.out.println("*** -: Welcome to the Number Guessing Game :- ***");
        System.out.println("=================================================");
        System.out.println();
        
        do 
        {
            System.out.println("===========================================================================");
            System.out.println("Round " + (rounds + 1) + ":");
            // User entering the max and min numbers for the range....
            System.out.println("Enter the Minimum Number you want to start the range from : ");
            int minRange = sc.nextInt();
            System.out.println("Enter the Maximum Number you want to end the range to : ");
            int maxRange = sc.nextInt();
            
            // Generating random number within a range specified by the user....
            int targetNumber = rnd.nextInt(maxRange - minRange + 1) + minRange; 
            int attempts = 0;

            System.out.println("===========================================================================");
            System.out.println(" LETS PLAY !!!!! ");
            System.out.println("Guess the number between : " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) 
            {
                System.out.print("Enter your guess : ");
                // User to enter their guessed number ....
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber)
                {
                    // user guessing the correct number in no. of attempts....
                    System.out.println("Congratulations...! You guessed the correct number in : " + attempts + " attempts.");
                    System.out.println();
                    score++;
                    break;
                } 
                else if (userGuess < targetNumber) 
                {
                    // if the input is smaller than the target number .... 
                    System.out.println("Too low. Try again.");
                    System.out.println();
                } 
                else 
                {
                    // if the input is higher than the target number ....
                    System.out.println("Too high. Try again.");
                    System.out.println();
                }
            }

            // limiting the no. of attempts.....
            if (attempts == maxAttempts) 
            {
                System.out.println("Sorry, you've reached the maximum number of attempts which was : "+ maxAttempts +". \n "
                        + "The correct number was - " + targetNumber + ".");
            }

            rounds++;

            // if the user want to play multiple rounds ....
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) 
            {
                System.out.println("===========================================================================");
                break;
            }
        } while (true);
        
        // displaying the score....
        System.out.println("GAME OVERR !!!! \n YOUR SCORE IS : YOU HAVE WON " + score + " ROUNDS.");
    }
}
